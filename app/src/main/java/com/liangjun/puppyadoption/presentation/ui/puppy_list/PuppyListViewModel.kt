package com.liangjun.puppyadoption.presentation.ui.puppy_list

import androidx.compose.runtime.MutableState
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.liangjun.puppyadoption.domain.model.Puppy
import com.liangjun.puppyadoption.repository.PuppyRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class PuppyListViewModel @Inject constructor(
    private val repository: PuppyRepository
) : ViewModel() {

    val puppies: MutableState<List<Puppy>> = mutableStateOf(listOf())

    val loading = mutableStateOf(false)

    init {
        getPuppies()
    }

    fun getPuppies() {
        viewModelScope.launch {
            loading.value = true

            puppies.value = repository.getList()

            delay(2000)
            loading.value = false
        }
    }
}