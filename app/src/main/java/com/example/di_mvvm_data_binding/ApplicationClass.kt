package com.example.di_mvvm_data_binding

import android.app.Application
import android.content.Context
import com.example.di_mvvm_data_binding.utils.SharedPrefUtil
import dagger.hilt.android.HiltAndroidApp

@HiltAndroidApp
class ApplicationClass :Application() {
    override fun onCreate() {
        super.onCreate()
        mContext = applicationContext
        SharedPrefUtil.init(this)
        val apiKey = getString(R.string.api_key)
        /**
         * Initialize Places. For simplicity, the API key is hard-coded. In a production
         * environment we recommend using a secure mechanism to manage API keys.
         */
        /**
         * Initialize Places. For simplicity, the API key is hard-coded. In a production
         * environment we recommend using a secure mechanism to manage API keys.
         */
       /* if (!Places.isInitialized()) {
            Places.initialize(applicationContext, apiKey)
        }*/
    }

    var mContext: Context? = null

    companion object AppContext {
        lateinit var instance: Application
        fun getContext(): Context {
            return instance
        }
    }

    init {
        instance = this
    }
}