package com.example.di_mvvm_data_binding.utils

import android.app.Activity
import android.content.Context
import android.content.SharedPreferences

val AUTHORIZATION_TOKEN = "AUTHORIZATION_TOKEN"
val EMAIL = "EMAIL"
val USERNAME = "USERNAME"
val FULLNAME = "FULLNAME"
val USER_ID = "USER_ID"
val COMPANY_NAME = "COMPANY_NAME"
val CITY = "CITY"
val PAIRING_CODE = "PAIRING_CODE"
val GENDER = "GENDER"
val DOB = "DOB"
val PHONE = "PHONE"
val USER_TYPE = "USER_TYPE"
val DELETE_POSITION = "DELETE_POSITION"
object SharedPrefUtil {
    private var mSharedPref: SharedPreferences? = null

    fun init(context: Context) {
        if (mSharedPref == null) mSharedPref =
            context.getSharedPreferences(context.packageName, Activity.MODE_PRIVATE)
    }

    fun read(key: String?, defValue: String?): String? {
        return mSharedPref!!.getString(key, defValue)
    }

    fun write(key: String?, value: String?) {
        val prefsEditor = mSharedPref!!.edit()
        prefsEditor.putString(key, value)
        prefsEditor.apply()
    }

    fun read(key: String?, defValue: Boolean): Boolean {
        return mSharedPref!!.getBoolean(key, defValue)
    }

    fun write(key: String?, value: Boolean) {
        val prefsEditor = mSharedPref!!.edit()
        prefsEditor.putBoolean(key, value)
        prefsEditor.apply()
    }

    fun read(key: String?, defValue: Int): Int {
        return mSharedPref!!.getInt(key, defValue)
    }

    fun write(key: String?, value: Int?) {
        val prefsEditor = mSharedPref!!.edit()
        prefsEditor.putInt(key, value!!).apply()
    }
}