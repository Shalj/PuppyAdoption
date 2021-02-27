package com.liangjun.puppyadoption.presentation.ui.puppy

import androidx.compose.runtime.MutableState
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.liangjun.puppyadoption.domain.model.Puppy
import com.liangjun.puppyadoption.repository.PuppyRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class PuppyViewModel @Inject constructor(
    private val repository: PuppyRepository
):ViewModel() {

    private var id = ""
    val puppy :MutableState<Puppy?> = mutableStateOf(null)

    fun init(id:String){
        this.id = id
        getPuppyById()
    }

    fun getPuppyById(){
        viewModelScope.launch {
            puppy.value = repository.getPuppyDetail(id)
        }
    }
}