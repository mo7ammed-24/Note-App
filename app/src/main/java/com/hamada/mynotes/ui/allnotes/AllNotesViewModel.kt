package com.hamada.mynotes.ui.allnotes

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class AllNotesViewModel:ViewModel() {

    private val _text = MutableLiveData<String>().apply {
        value = "This is All Notes Fragment"
    }
    val text: LiveData<String> = _text
}