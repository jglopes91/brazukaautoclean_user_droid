package com.blitzware.brazukacarcleanuser.network.dto

import com.google.gson.annotations.SerializedName

class AddressDTO {
    @SerializedName("id")
    var id: Long? = null

    @SerializedName("streetName")
    var streetName: String? = null

    @SerializedName("cityName")
    var cityName: String? = null

    @SerializedName("zipCode")
    var zipCode: String? = null

    @SerializedName("number")
    var number: Int? = null

    @SerializedName("complement")
    var complement: String? = null

    @SerializedName("latitude")
    var latitude: Double? = null

    @SerializedName("longitude")
    var longitude: Double? = null
}