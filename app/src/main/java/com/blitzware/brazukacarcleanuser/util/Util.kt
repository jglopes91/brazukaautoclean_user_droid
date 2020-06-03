package com.blitzware.brazukacarcleanuser.util

import android.content.Context
import android.content.SharedPreferences
import com.blitzware.brazukacarcleanuser.BrazukaCarCleanApplication
object Util {
private val sessionPreferences: SharedPreferences
    private get() {
        val ctx = BrazukaCarCleanApplication.instance
        return ctx!!.getSharedPreferences("SESSION_PREFERENCES", Context.MODE_PRIVATE)
    }
    @JvmStatic
    var apiToken: String?
    get() = sessionPreferences
        .getString("API_TOKEN", null)
    set(token) {
        val mPreferences =
            sessionPreferences
        val editor = mPreferences.edit()
        editor.putString("API_TOKEN", token)
        editor.apply()
    }
}