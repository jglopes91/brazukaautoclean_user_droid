package com.blitzware.brazukacarcleanuser.network.dto

import com.google.gson.annotations.SerializedName

class CarDTO {
    @SerializedName("id")
    var id: Long? = null
    @SerializedName("manufactorer")
    var manufactorer: String? = null
    @SerializedName("model")
    var model: String? = null
    @SerializedName("year")
    var year: String? = null
    @SerializedName("plate")
    var plate: String? = null
}