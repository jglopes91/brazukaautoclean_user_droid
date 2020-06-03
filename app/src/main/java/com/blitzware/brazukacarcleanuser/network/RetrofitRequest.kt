package com.blitzware.brazukacarcleanuser.network

class RetrofitRequest : RetrofitAPI() {
    val services: RemoteService?
        get() = retrofit?.create(RemoteService::class.java)
    init {
        retrofitInstance
    }
}