package com.example.di_mvvm_data_binding.view.fragments

import android.Manifest
import android.content.pm.PackageManager
import android.os.Bundle
import android.os.Handler
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.app.ActivityCompat
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import com.example.di_mvvm_data_binding.R
import com.example.di_mvvm_data_binding.utils.AUTHORIZATION_TOKEN
import com.example.di_mvvm_data_binding.utils.SharedPrefUtil

class SplashFragment : Fragment() {
    private var mDelayHandler: Handler? = null
    private val SPLASH_DELAY: Long = 2000
    private var isFragmentVisible = false
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_splash, container, false)
    }

    override fun onResume() {
        isFragmentVisible = true
        super.onResume()
    }

    override fun onDestroyView() {
        super.onDestroyView()
        isFragmentVisible = false
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        try {
            isFragmentVisible = true
            checkPermissions()
            mDelayHandler = Handler()
            mDelayHandler!!.postDelayed(
                {
                    if (isFragmentVisible) {
                        if (!SharedPrefUtil.read(
                                AUTHORIZATION_TOKEN,
                                ""
                            ).equals("")
                        ) {
                            findNavController().navigate(R.id.action_splashFragment_to_landingActivity)
                            requireActivity().finish()
                        } else {
                            findNavController().navigate(R.id.action_splashFragment_to_loginFragment)
                        }
                    }


                }, SPLASH_DELAY
            )
        } catch (e: java.lang.Exception) {
            e.printStackTrace()
        }
    }

    private fun checkPermissions(): Boolean {
        return if (ActivityCompat.checkSelfPermission(
                requireActivity(),
                Manifest.permission.WRITE_EXTERNAL_STORAGE
            ) == PackageManager.PERMISSION_GRANTED
        ) {
            true
        } else {
            ActivityCompat.requestPermissions(
                requireActivity(),
                arrayOf(Manifest.permission.WRITE_EXTERNAL_STORAGE),
                100
            )
            false
        }
    }
}