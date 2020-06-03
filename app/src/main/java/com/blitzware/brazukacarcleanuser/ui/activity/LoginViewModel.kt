package com.blitzware.brazukacarcleanuser.ui.activity

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.blitzware.brazukacarcleanuser.network.RetrofitRequest
import com.blitzware.brazukacarcleanuser.network.dto.LoginDTO
import com.blitzware.brazukacarcleanuser.network.dto.LoginResponseDTO
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class LoginViewModel : ViewModel() {
    var request = RetrofitRequest()

    fun doLogin(dto: LoginDTO) : LiveData<LoginResponseDTO> {
        var mutableLiveLoginResponse = MutableLiveData<LoginResponseDTO>()
        request.services!!.novoLogin(dto).enqueue(object : Callback<LoginResponseDTO> {
            override fun onFailure(call: Call<LoginResponseDTO>, t: Throwable) {
                mutableLiveLoginResponse.value = null
            }

            override fun onResponse(
                call: Call<LoginResponseDTO>,
                response: Response<LoginResponseDTO>
            ) {
                if(response.isSuccessful) {
                    mutableLiveLoginResponse.value = response.body()
                }
                else {
                    mutableLiveLoginResponse.value = null
                }
            }

        })
        return mutableLiveLoginResponse
    }
}