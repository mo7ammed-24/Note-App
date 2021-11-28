package com.hamada.mynotes.model.repository

import com.hamada.mynotes.model.database.Notes
import com.hamada.mynotes.model.database.NotesDatabase


class NoteRepository {

    val dao= NotesDatabase.getInstanceWithoutContext().noteDao()

    suspend fun insertNewNote(note: Notes){
        return dao.insertNote(note)
    }

    fun getAllNotes()=dao.getAllNotes()

    suspend fun getFilteredNotes(searchTerm:String)=dao.getFilteredNotes("%$searchTerm%")

    suspend fun getCategoryNotes(categoryTerm:String)=dao.getCategoryNotes(categoryTerm)

}