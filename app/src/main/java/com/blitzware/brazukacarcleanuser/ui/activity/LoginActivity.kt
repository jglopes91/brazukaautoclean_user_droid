package com.blitzware.brazukacarcleanuser.ui.activity

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import com.blitzware.brazukacarcleanuser.R
import com.blitzware.brazukacarcleanuser.network.dto.LoginDTO
import com.blitzware.brazukacarcleanuser.util.Util
import kotlinx.android.synthetic.main.activity_login.*
import kotlinx.android.synthetic.main.activity_login.et_password

class LoginActivity : AppCompatActivity() {
    lateinit var viewModel: LoginViewModel
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login)
        viewModel = ViewModelProvider(this).get(LoginViewModel::class.java)
        if(null != Util.apiToken ) {
            startActivity(Intent(this, MainActivity::class.java))
            finishAffinity()
        }
        btn_login.setOnClickListener {
            var login = LoginDTO()
            login.email = et_email.text.toString()
            login.password = et_password.text.toString()
            viewModel.doLogin(login).observe(this, Observer { data ->
                if(null != data) {
                    Util.apiToken = data.token
                    startActivity(Intent(this, MainActivity::class.java))
                    finishAffinity()
                }
                else {
                    Toast.makeText(this,"Usuário ou senha inválidos!",Toast.LENGTH_SHORT).show()
                }
            })
        }
        tv_cadastrar.setOnClickListener {
            startActivity(Intent(this,PersonalRegisterActivity::class.java))
        }
    }

}