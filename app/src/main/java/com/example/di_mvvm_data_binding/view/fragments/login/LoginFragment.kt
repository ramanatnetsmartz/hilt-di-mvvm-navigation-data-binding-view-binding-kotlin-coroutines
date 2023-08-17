package com.example.di_mvvm_data_binding.view.fragments.login

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.viewModels
import androidx.lifecycle.lifecycleScope
import androidx.navigation.fragment.findNavController
import com.example.di_mvvm_data_binding.network.ApiState
import com.example.di_mvvm_data_binding.R
import com.example.di_mvvm_data_binding.api.response_models.register.RegisterResponse
import com.example.di_mvvm_data_binding.base.BaseFragment
import com.example.di_mvvm_data_binding.databinding.FragmentLoginBinding
import com.example.di_mvvm_data_binding.utils.Utilities.getDeviceName
import com.example.di_mvvm_data_binding.utils.Utilities.saveUserDataToStorage
import com.example.di_mvvm_data_binding.utils.app_constants.Cons.successStatus
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class LoginFragment : BaseFragment() {
    private var _binding: FragmentLoginBinding? = null
    private val binding get() = _binding!!
    private val mainViewModel: AuthenticationViewModel by viewModels()

    override fun provideYourFragmentView(
        inflater: LayoutInflater,
        parent: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentLoginBinding.inflate(inflater, parent, false)
        initializeListeners()
        return binding.root
    }

    private fun initializeListeners() {
        _binding?.let {
            it.tvLoginButton.setOnClickListener {
                _validations();
            }
        }
    }

    private fun _validations() {
        if (binding.etEmail.text.toString().trim().equals("")) {
            binding.textFielEmail.error = getString(R.string.email_is_empty)
            return
        }
        binding.textFielEmail.error = null
        if (binding.etPassword.text.toString().trim().equals("")) {
            binding.textFielPassword.error = getString(R.string.password_is_empty)
            return
        }
        binding.textFielPassword.error = null
        hideKeyboard(requireActivity())
        loginAPI()
    }

    private fun loginAPI() {
        val mHashMap = HashMap<String, Any>()
        mHashMap["email"] = binding.etEmail.text.toString().trim()
        mHashMap["password"] = binding.etPassword.text.toString().trim()
        mHashMap["deviceModal"] = getDeviceName()
        mHashMap["firebaseToken"] = "hjbdjvgvagsvd"
        mainViewModel.login(mHashMap)
        lifecycleScope.launchWhenStarted {
            // do your work here
            mainViewModel.postStateFlow.collect {
                when (it) {
                    is ApiState.Loading -> {
                    }

                    is ApiState.Failure -> {
                        showToast(it.msg.toString())
                    }

                    is ApiState.Success<*> -> {
                        val result = it.result as RegisterResponse
                        if (result.status_code == successStatus) {
                            saveUserDataToStorage(result.userData)
                            findNavController().navigate(R.id.action_loginFragment_to_landingActivity)
                            requireActivity().finish()
                        } else {
                            showToast(result.message)
                        }
                        print("Result" + result.toString())

                    }

                    is ApiState.Empty -> {

                    }
                }
            }
        }


    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}