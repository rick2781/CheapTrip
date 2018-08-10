package com.rick.cheaptrip.utils.reactive

import io.reactivex.Scheduler

interface SchedulerProvider {

    fun computation(): Scheduler
    fun io(): Scheduler
    fun ui(): Scheduler
}