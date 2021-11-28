package com.hamada.mynotes.ui.allnotes

import android.util.Log
import androidx.lifecycle.*
import com.hamada.mynotes.model.database.Notes
import com.hamada.mynotes.model.repository.NoteRepository
import io.reactivex.rxjava3.android.schedulers.AndroidSchedulers
import io.reactivex.rxjava3.schedulers.Schedulers
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.collect
import kotlinx.coroutines.flow.debounce
import kotlinx.coroutines.launch
class AllNotesViewModel: ViewModel(), NotesInteractionListener {

    private val repository= NoteRepository()
    val notes = MutableLiveData<List<Notes>>()

    val searchText= MutableStateFlow("")
    init {
        loadNotes()
        viewModelScope.launch {
            searchText.debounce(1000).collect {
                notes.postValue(repository.getFilteredNotes(it))
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

    fun getCategoryNotes(category:String){
        viewModelScope.launch {
            notes.postValue(repository.getCategoryNotes(category))
        }
    }

     fun loadNotes(){
        repository.getAllNotes()
            .subscribeOn(Schedulers.io())
            .observeOn(AndroidSchedulers.mainThread())
            .subscribe(
                this::onGetNotes,
                this::onNotesFail
            )
    }

    private fun onGetNotes(list:List<Notes>){

        Log.i("Hamada","success")
        notes.postValue(list)
    }

    private fun onNotesFail(e:Throwable){
        Log.i("Hamada", e.message.toString())
    }
}