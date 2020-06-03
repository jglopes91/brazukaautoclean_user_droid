package com.blitzware.brazukacarcleanuser.ui.home

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.blitzware.brazukacarcleanuser.network.RetrofitRequest
import com.blitzware.brazukacarcleanuser.network.response.CompaniesHomeResponse
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class HomeViewModel : ViewModel() {
    var request = RetrofitRequest()
    fun getComapanies(lat: Double, lng: Double): LiveData<List<CompaniesHomeResponse>> {
        var mutableLiveData = MutableLiveData<List<CompaniesHomeResponse>>()
        request.services?.getCompaniesNearBy(lat, lng)?.enqueue(object :
            Callback<List<CompaniesHomeResponse>> {
            override fun onFailure(call: Call<List<CompaniesHomeResponse>>, t: Throwable) {
                mutableLiveData.value = null
            }

            override fun onResponse(
                call: Call<List<CompaniesHomeResponse>>,
                response: Response<List<CompaniesHomeResponse>>
            ) {
                if (response.isSuccessful) {
                    mutableLiveData.value = response.body()
                } else {
                    mutableLiveData.value = null
                }
            }

        })
        return mutableLiveData
    }
}