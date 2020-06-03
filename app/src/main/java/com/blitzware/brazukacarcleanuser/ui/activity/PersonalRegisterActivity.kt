package com.blitzware.brazukacarcleanuser.ui.activity

import android.app.DatePickerDialog
import android.content.Intent
import android.os.Bundle
import android.text.InputType
import androidx.appcompat.app.AppCompatActivity
import com.blitzware.brazukacarcleanuser.R
import com.blitzware.brazukacarcleanuser.network.dto.LoginDTO
import com.blitzware.brazukacarcleanuser.network.dto.UserCreationDTO
import com.google.gson.Gson
import kotlinx.android.synthetic.main.activity_register.*
import java.util.*


class PersonalRegisterActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_register)
        btn_proximo.setOnClickListener {
            startActivity(Intent(applicationContext,AddressRegisterActivity::class.java).putExtra("USER_CREATION",criaDadosCadastrais()))
        }
    }
    private fun criaDadosCadastrais() : String {
        var user = UserCreationDTO()
        var login = LoginDTO()
        login.email = et_email.text.toString()
        login.password = et_password.text.toString()
        user.cpf = et_cpf.text.toString()
        user.phoneNumber = et_phone_number.text.toString()
        user.birthDate = et_birthdate.text.toString()
        user.login = login
        return Gson().toJson(user);
    }
}