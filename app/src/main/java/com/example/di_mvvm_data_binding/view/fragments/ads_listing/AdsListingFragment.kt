package com.example.di_mvvm_data_binding.view.fragments.ads_listing

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.viewModels
import androidx.lifecycle.lifecycleScope
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.di_mvvm_data_binding.network.ApiState
import com.example.di_mvvm_data_binding.api.response_models.ads_listing.OtherAdsResponse
import com.example.di_mvvm_data_binding.base.BaseFragment
import com.example.di_mvvm_data_binding.databinding.FragmentAdsListingBinding
import com.example.di_mvvm_data_binding.utils.app_constants.Cons
import com.example.di_mvvm_data_binding.view.fragments.ads_listing.adapter.AdsListingAdapter
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class AdsListingFragment : BaseFragment() {
    private var _binding: FragmentAdsListingBinding? = null
    private var adapter:AdsListingAdapter? = null
    private val binding get() = _binding
    private val adsListingViewModel: AdsListingViewModel by viewModels()
    override fun provideYourFragmentView(
        inflater: LayoutInflater,
        parent: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentAdsListingBinding.inflate(inflater, parent, false)

        getAdsListing()
        return binding!!.root
    }

    private fun initViews() {
        adapter= AdsListingAdapter(adsListingViewModel.adsList.value,requireContext())
        binding!!.adsRecyclerView.layoutManager = LinearLayoutManager(requireContext(), LinearLayoutManager.VERTICAL, false)
        binding!!.adsRecyclerView.setHasFixedSize(true)
        binding!!.adsRecyclerView.adapter = adapter
    }

    private fun getAdsListing() {
        val mHashMap = HashMap<String, Any>()
        mHashMap["authorization_token"] = getAccessToken()!!
        mHashMap["itemName"] = ""
        mHashMap["city"] = ""
        mHashMap["firebaseToken"] = ""
        mHashMap["itemCategory"] = ""
        adsListingViewModel.adsListing(mHashMap)
        lifecycleScope.launchWhenStarted {
            // do your work here
            adsListingViewModel.postStateFlow.collect {
                when (it) {
                    is ApiState.Loading -> {
                    }

                    is ApiState.Failure -> {
                        showToast(it.msg.toString())
                    }

                    is ApiState.Success<*> -> {
                        val result = it.result as OtherAdsResponse
                        if (result.status_code == Cons.successStatus) {
                            adsListingViewModel.adsList.value=result.allOtherAds
                            initViews()
                            adapter.let {
                                it!!.notifyDataSetChanged()
                            }

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