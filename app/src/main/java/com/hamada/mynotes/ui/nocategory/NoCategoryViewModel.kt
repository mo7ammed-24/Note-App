package com.hamada.mynotes.ui.nocategory

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class NoCategoryViewModel:ViewModel(){
    private val _text = MutableLiveData<String>().apply {
        value = "This is No Category Fragment"
    }
    val text: LiveData<String> = _text
}