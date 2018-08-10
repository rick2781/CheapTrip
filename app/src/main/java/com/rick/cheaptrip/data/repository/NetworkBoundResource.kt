package com.rick.cheaptrip.data.repository

import android.util.Log
import androidx.annotation.MainThread
import androidx.annotation.WorkerThread
import androidx.lifecycle.LiveData
import androidx.lifecycle.MediatorLiveData
import com.rick.cheaptrip.data.remote.ApiEmptyResponse
import com.rick.cheaptrip.data.remote.ApiErrorResponse
import com.rick.cheaptrip.data.remote.ApiResponse
import com.rick.cheaptrip.data.remote.ApiSuccessResponse
import com.rick.cheaptrip.utils.Resource
import com.rick.cheaptrip.utils.reactive.SchedulerProvider
import io.reactivex.Observable


abstract class NetworkBoundResource<ResultType, RequestType>
@MainThread constructor(private val schedulers: SchedulerProvider) {

    private val result = MediatorLiveData<Resource<ResultType>>()

    init {

        result.value = Resource.loading(null)

        @Suppress("LeakingThis")
        val dbSource = loadFromDb()

        result.addSource(dbSource) { data ->

            result.removeSource(dbSource)

            if (shouldFetch(data)) {
                fetchFromNetwork(dbSource)
            } else {
                result.addSource(dbSource) { newData ->

                    setValue(Resource.success(newData))
                }
            }
        }
    }

    private fun setValue(newValue: Resource<ResultType>) {

        if (result.value != newValue) {
            result.value = newValue
        }
    }

    private fun fetchFromNetwork(dbSource: LiveData<ResultType>) {

        val apiResponse = createCall()

        result.addSource(dbSource) {
            setValue(Resource.loading(it))
        }

        result.addSource(apiResponse) { response ->

            with(result) {
                removeSource(apiResponse)
                removeSource(dbSource)
            }

            when (response) {

                is ApiSuccessResponse -> {

                    Observable.fromCallable { saveCallResult(processResponse(response)) }
                            .subscribeOn(schedulers.io())
                            .observeOn(schedulers.ui())
                            .subscribe {

                                result.addSource(loadFromDb()) { newData ->

                                    setValue(Resource.success(newData))
                                }
                            }
                }

                is ApiEmptyResponse -> {

                    Observable.fromCallable {
                        result.addSource(loadFromDb()) {
                            setValue(Resource.success(it))
                        }
                    }
                }

                is ApiErrorResponse -> {

                    onFetchFailed()
                    result.addSource(dbSource) {
                        setValue(Resource.error(response.errorMessage, it))
                    }
                }
            }
        }
    }

    protected open fun onFetchFailed() {}

    @WorkerThread
    protected open fun processResponse(response: ApiSuccessResponse<RequestType>) = response.body

    @MainThread
    protected abstract fun loadFromDb(): LiveData<ResultType>

    @MainThread
    protected abstract fun shouldFetch(data: ResultType?): Boolean

    @MainThread
    protected abstract fun createCall(): LiveData<ApiResponse<RequestType>>

    @WorkerThread
    protected abstract fun saveCallResult(item: RequestType)

    fun asLiveData() = result as LiveData<Resource<ResultType>>
}