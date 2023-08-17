package com.example.di_mvvm_data_binding.base

import android.app.Activity
import android.content.Context
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.view.WindowManager
import android.view.inputmethod.InputMethodManager
import android.widget.Toast
import androidx.fragment.app.Fragment
import com.example.di_mvvm_data_binding.utils.AUTHORIZATION_TOKEN
import com.example.di_mvvm_data_binding.utils.SharedPrefUtil
import com.example.di_mvvm_data_binding.utils.USER_ID
import com.example.di_mvvm_data_binding.utils.USER_TYPE


/**
 * A simple [Fragment] subclass.
 */
abstract class BaseFragment : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater,
        parent: ViewGroup?,
        savedInstanseState: Bundle?
    ): View? {
        return provideYourFragmentView(inflater, parent, savedInstanseState)
    }

    fun showLoading(show: Boolean?) {
        if (show!!) showLoading() else hideLoading()
    }

    fun showToast(msg: CharSequence) {
        Toast.makeText(activity, msg, Toast.LENGTH_SHORT).show()
    }

    fun hideKeyboard(activity: Activity) {
        val inputMethodManager =
            activity.getSystemService(Context.INPUT_METHOD_SERVICE) as InputMethodManager

        // Check if no view has focus
        val currentFocusedView = activity.currentFocus
        currentFocusedView?.let {
            inputMethodManager.hideSoftInputFromWindow(
                currentFocusedView.windowToken, InputMethodManager.HIDE_NOT_ALWAYS
            )
        }
    }

    fun hideKeyboard() {
        requireActivity().getWindow()
            .setSoftInputMode(WindowManager.LayoutParams.SOFT_INPUT_STATE_ALWAYS_HIDDEN)

    }

    protected fun showLoading() {
        //CallProgressWheel.showLoadingDialog(requireActivity())
        // spotsDialog!!.show()
    }

    protected fun hideLoading() {
        // CallProgressWheel.dismissLoadingDialog()
//        if (spotsDialog != null) {
//            spotsDialog!!.dismiss()
//        }
    }

    abstract fun provideYourFragmentView(
        inflater: LayoutInflater,
        parent: ViewGroup?,
        savedInstanceState: Bundle?
    ): View

    fun getAccessToken(): String? {
        return SharedPrefUtil.read(
            AUTHORIZATION_TOKEN,
            ""
        )
    }

    fun getUserId(): String? {
        return SharedPrefUtil.read(
            USER_ID,
            ""
        )
    }

    fun getUserType(): String? {
        return SharedPrefUtil.read(
            USER_TYPE,
            ""
        )
    }
}
