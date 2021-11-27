package com.hamada.mynotes.ui.allnotes

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.hamada.mynotes.model.database.Notes
import com.hamada.mynotes.model.repository.NoteRepository
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.collect
import kotlinx.coroutines.flow.debounce
import kotlinx.coroutines.launch
import java.util.*

class AllNotesViewModel:ViewModel() {

    val newNoteText=MutableLiveData<String>()

    val repository= NoteRepository()
    private val _notes=MutableLiveData<List<Notes>>()
    val notes: LiveData<List<Notes>> =_notes

    val searchText= MutableStateFlow("")

    fun addNotes(){
        viewModelScope.launch {
            newNoteText.value?.let {
                repository.insertNewNote(Notes(0, "work",it, Date(),"Ggggg"))
            }
        }
    }
    init {
        loadNotes()
        viewModelScope.launch {
            searchText.debounce(1000).collect {
                _notes.postValue(repository.getFilteredNotes(it))
            }
        }
    }
//    fun addNotes(){
//        newNoteText.value?.let {
//            repository.insertNewNote(Notes(0, "work",it, "fffff","Ggggg"))
//                .subscribeOn(Schedulers.io())
//                .subscribe()
//            newNoteText.postValue("")
//        }
//    }

    fun loadNotes(){
        viewModelScope.launch {
            repository.getAllNotes().collect {
                _notes.postValue(it)
            }
        }
    }
}