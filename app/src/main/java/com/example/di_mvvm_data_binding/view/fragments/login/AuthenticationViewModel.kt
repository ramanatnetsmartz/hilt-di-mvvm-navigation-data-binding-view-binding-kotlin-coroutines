package com.example.di_mvvm_data_binding.view.fragments.login

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.di_mvvm_data_binding.network.ApiState
import com.example.di_mvvm_data_binding.repository.MainRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.catch
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class AuthenticationViewModel
@Inject
constructor(private val mainRepository: MainRepository) : ViewModel() {

    val postStateFlow: MutableStateFlow<ApiState> = MutableStateFlow(ApiState.Empty)

    fun login(mHashMap: HashMap<String, Any>) = viewModelScope.launch {
        postStateFlow.value = ApiState.Loading
        mainRepository.login(mHashMap)
            .catch { e ->
                postStateFlow.value = ApiState.Failure(e)
            }.collect { data ->
                postStateFlow.value = ApiState.Success(data)
            }
    }
}