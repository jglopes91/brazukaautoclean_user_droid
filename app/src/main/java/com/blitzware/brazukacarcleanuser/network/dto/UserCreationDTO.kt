package com.blitzware.brazukacarcleanuser.network.dto

import com.google.gson.annotations.SerializedName
import java.io.Serializable
import java.time.LocalDate

class UserCreationDTO : Serializable {
    @SerializedName("id")
    var id: Long? = null
    @SerializedName("login")
    var login: LoginDTO? = null
    @SerializedName("phoneNumber")
    var phoneNumber: String? = null
    @SerializedName("cpf")
    var cpf: String? = null
    @SerializedName("birthDate")
    var birthDate: String? = null
    @SerializedName("address")
    var address: AddressDTO? = null
    @SerializedName("cars")
    var cars: List<CarDTO>? = null


}