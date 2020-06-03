package com.blitzware.brazukacarcleanuser.network.dto

import com.google.gson.annotations.SerializedName

class LoginResponseDTO {
    @SerializedName("token")
    var token: String? = null
    @SerializedName("role")
    var role: String? = null
}