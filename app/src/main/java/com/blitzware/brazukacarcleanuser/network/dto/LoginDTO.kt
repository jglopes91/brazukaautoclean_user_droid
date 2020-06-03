package com.blitzware.brazukacarcleanuser.network.dto

import com.google.gson.annotations.SerializedName

class LoginDTO {
    @SerializedName("email")
    var email: String? = null
    @SerializedName("password")
    var password: String? = null
}