package com.rick.cheaptrip.api

import com.rick.cheaptrip.data.remote.ApiErrorResponse
import com.rick.cheaptrip.data.remote.ApiResponse
import com.rick.cheaptrip.data.remote.ApiSuccessResponse
import okhttp3.MediaType
import okhttp3.ResponseBody
import org.hamcrest.CoreMatchers.`is`
import org.hamcrest.MatcherAssert.assertThat
import org.junit.Test
import org.junit.runner.RunWith
import org.junit.runners.JUnit4
import retrofit2.Response

@RunWith(JUnit4::class)
class ApiResponseTest {

    @Test
    fun raiseException() {

        val exception = Exception("error")
        val errorMessage = ApiResponse.create<String>(exception)

        assertThat<String>(errorMessage.errorMessage, `is`("error"))
    }

    @Test
    fun success() {

        val apiResponse = ApiResponse.create<String>(Response.success("success")) as ApiSuccessResponse<String>

        assertThat(apiResponse.body, `is`("success"))
    }

    @Test
    fun error() {

        val errorResponse = Response.error<String>(
                400,
                ResponseBody.create(MediaType.parse("app/txt"), "test"))

        val errorMessage = ApiResponse.create<String>(errorResponse) as ApiErrorResponse<String>

        assertThat(errorMessage.errorMessage, `is`("test"))
    }
}