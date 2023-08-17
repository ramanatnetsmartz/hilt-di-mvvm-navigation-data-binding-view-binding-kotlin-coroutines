package com.example.di_mvvm_data_binding.utils

import android.content.Context
import android.os.Build
import android.widget.Toast
import com.example.di_mvvm_data_binding.api.response_models.register.UserData
import java.util.Locale

object Utilities {
    fun showToast(context: Context, msg: String) {
        Toast.makeText(context, msg, Toast.LENGTH_SHORT).show()
    }

    fun getDeviceName(): String {
        val manufacturer = Build.MANUFACTURER
        val model = Build.MODEL
        return if (model.lowercase(Locale.ROOT).startsWith(manufacturer.lowercase(Locale.ROOT))) {
            capitalize(model)
        } else {
            capitalize(manufacturer) + " " + model
        }
    }

    private fun capitalize(s: String?): String {
        if (s == null || s.isEmpty()) {
            return ""
        }
        val first = s[0]
        return if (Character.isUpperCase(first)) {
            s
        } else {
            Character.toUpperCase(first) + s.substring(1)
        }
    }

    fun saveUserDataToStorage(userData: UserData) {
        if (userData.authorization_token != null) {
            SharedPrefUtil.write(
                AUTHORIZATION_TOKEN,
                userData.authorization_token
            )
        }

        if (userData.userID != null) {
            SharedPrefUtil.write(
                USER_ID,
                userData.userID.toString()
            )
        }

        if (userData.email != null) {
            SharedPrefUtil.write(
                EMAIL,
                userData.email
            )
        }

        if (userData.companyName != null) {
            SharedPrefUtil.write(
                COMPANY_NAME,
                userData.companyName
            )
        }
        if (userData.city != null) {
            SharedPrefUtil.write(
                CITY,
                userData.city
            )
        }
        if (userData.fullName != null) {
            SharedPrefUtil.write(
                FULLNAME,
                userData.fullName
            )
        }
        if (userData.phoneNumber != null) {
            SharedPrefUtil.write(
                PHONE,
                userData.phoneNumber
            )
        }
        if (userData.userType != null) {
            SharedPrefUtil.write(
                USER_TYPE,
                userData.userType
            )
        } else {
            SharedPrefUtil.write(
                USER_TYPE,
                ""
            )
        }
    }
}