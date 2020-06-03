package com.blitzware.brazukacarcleanuser.network

import android.content.Context
import android.content.Intent
import com.blitzware.brazukacarcleanuser.BrazukaCarCleanApplication
import com.blitzware.brazukacarcleanuser.ui.activity.LoginActivity
import com.blitzware.brazukacarcleanuser.util.Util
import okhttp3.Interceptor
import okhttp3.OkHttpClient
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import java.util.concurrent.TimeUnit


open class RetrofitAPI {
    companion object {
        var retrofit: Retrofit? = null
        private const val BASE_URL = "http://192.168.0.10:8181/api/"
        private val client = OkHttpClient.Builder()
            .addInterceptor { chain: Interceptor.Chain ->
                var newRequest = chain.request()
                if (Util.apiToken != null) {
                    newRequest = chain.request().newBuilder()
                        .addHeader(
                            "Authorization",
                            "Bearer " + Util.apiToken
                        )
                        .build()
                }
                val resp = chain.proceed(newRequest)
                if (resp.code() == 401 ) {
                    resp.close()
                    val ctx: Context =
                        BrazukaCarCleanApplication.instance!!.applicationContext
                    val i = Intent(ctx, LoginActivity::class.java)
                    i.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK)
                    Util.apiToken = null
                    ctx.startActivity(i)
                }
                resp
            }.readTimeout(1, TimeUnit.MINUTES).build()
        val retrofitInstance: Retrofit?
            get() {
                if (retrofit == null) {
                    retrofit = Retrofit.Builder()
                        .baseUrl(BASE_URL)
                        .client(client)
                        .addConverterFactory(GsonConverterFactory.create())
                        .build()
                }
                return retrofit
            }
    }
}