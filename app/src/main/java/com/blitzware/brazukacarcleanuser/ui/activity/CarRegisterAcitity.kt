package com.blitzware.brazukacarcleanuser.ui.activity

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.blitzware.brazukacarcleanuser.R
import com.blitzware.brazukacarcleanuser.network.dto.CarDTO
import com.blitzware.brazukacarcleanuser.network.dto.UserCreationDTO
import com.google.gson.Gson
import kotlinx.android.synthetic.main.activity_car_register_acitity.*

class CarRegisterAcitity : AppCompatActivity() {
    lateinit var viewModel: RegisterViewModel
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_car_register_acitity)
        viewModel = ViewModelProvider(this).get(RegisterViewModel::class.java)
        var user =
            Gson().fromJson(intent.getStringExtra("USER_CREATION"), UserCreationDTO::class.java)
        btn_registrar.setOnClickListener {
            viewModel.newUser(criaCarro(user)).observe(this, Observer { data ->
                if (data == 201) {
                    startActivity(Intent(applicationContext, LoginActivity::class.java))
                } else if (data != 201) {
                    Toast.makeText(this, "E-Mail/CPF já cadastrado!", Toast.LENGTH_SHORT).show()
                }
                else if(data == 0) {
                    Toast.makeText(this, "Verifique a sua conexão com a internet.", Toast.LENGTH_SHORT).show()
                }
            })

        }
    }

    private fun criaCarro(user: UserCreationDTO): UserCreationDTO {
        var cars = ArrayList<CarDTO>()
        var car = CarDTO()
        car.manufactorer = et_manufacturer.text.toString()
        car.model = et_model.text.toString()
        car.plate = et_plate.text.toString()
        car.year = et_year.text.toString()
        cars.add(car)
        user.cars = cars;
        return user
    }
}