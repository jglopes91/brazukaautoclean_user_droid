package com.blitzware.brazukacarcleanuser.network

import com.blitzware.brazukacarcleanuser.network.dto.LoginDTO
import com.blitzware.brazukacarcleanuser.network.dto.LoginResponseDTO
import com.blitzware.brazukacarcleanuser.network.dto.UserCreationDTO
import com.blitzware.brazukacarcleanuser.network.response.CompaniesHomeResponse
import retrofit2.Call
import retrofit2.http.*

interface RemoteService {
    @Headers("Content-Type: application/json")
    @POST("user/register")
    fun registerNewUser(@Body dto: UserCreationDTO): Call<Int>

    @Headers("Content-Type: application/json")
    @POST("auth/login")
    fun novoLogin(@Body dto: LoginDTO): Call<LoginResponseDTO>

    @Headers("Content-Type: application/json")
    @GET("company/nearby/{latitude}/{longitude}")
    fun getCompaniesNearBy(
        @Path("latitude") lat: Double,
        @Path("longitude") lng: Double
    ): Call<List<CompaniesHomeResponse>>

}