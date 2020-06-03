package com.blitzware.brazukacarcleanuser.ui.activity

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.blitzware.brazukacarcleanuser.R
import com.blitzware.brazukacarcleanuser.network.dto.AddressDTO
import com.blitzware.brazukacarcleanuser.network.dto.UserCreationDTO
import com.google.gson.Gson
import kotlinx.android.synthetic.main.activity_address_register.*

class AddressRegisterActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_address_register)
        var user: UserCreationDTO =
            Gson().fromJson(intent.getStringExtra("USER_CREATION"), UserCreationDTO::class.java)
        btn_proximo.setOnClickListener {
            startActivity(
                Intent(
                    applicationContext,
                    CarRegisterAcitity::class.java
                ).putExtra("USER_CREATION", criaEndereco(user))
            )
        }
    }

    private fun criaEndereco(user: UserCreationDTO): String {
        var address = AddressDTO()
        address.cityName = et_city.text.toString()
        address.complement = et_complement.text.toString()
        address.number = et_number.text.toString().toInt()
        address.streetName = et_street.text.toString()
        address.zipCode = et_zipcode.text.toString()
        user.address = address
        return Gson().toJson(user);
    }
}