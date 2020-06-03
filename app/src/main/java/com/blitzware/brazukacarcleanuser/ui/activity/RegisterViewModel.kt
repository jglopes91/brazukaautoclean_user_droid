package com.blitzware.brazukacarcleanuser.ui.activity

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.blitzware.brazukacarcleanuser.network.RetrofitRequest
import com.blitzware.brazukacarcleanuser.network.dto.UserCreationDTO
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class RegisterViewModel: ViewModel() {
    var request = RetrofitRequest()

    fun newUser(user : UserCreationDTO) : LiveData<Int> {
        var userCreationMutableLiveData = MutableLiveData<Int>();

        request.services!!.registerNewUser(user).enqueue(object : Callback<Int> {
            override fun onFailure(call: Call<Int>, t: Throwable) {
                userCreationMutableLiveData.value = 0
            }

            override fun onResponse(
                call: Call<Int>,
                response: Response<Int>
            ) {
                userCreationMutableLiveData.value = response.code()
            }
        })
        return userCreationMutableLiveData
    }
}