package com.blitzware.brazukacarcleanuser.network.response

import com.blitzware.brazukacarcleanuser.network.dto.AddressDTO
import com.google.gson.annotations.SerializedName

class CompaniesHomeResponse {
    @SerializedName("fantasyName")
    val fantasyName: String? = null
    @SerializedName("logo")
    val logo: String? = null
    @SerializedName("address")
    val address: AddressDTO? = null
}