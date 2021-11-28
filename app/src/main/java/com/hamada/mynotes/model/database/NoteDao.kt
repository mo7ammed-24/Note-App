package com.hamada.mynotes.model.database

import androidx.room.*
import io.reactivex.rxjava3.core.Observable

import java.util.*
import java.util.concurrent.Flow

@Dao
interface NoteDao {

    @Insert(onConflict = OnConflictStrategy.IGNORE)
    suspend fun insertNote(note:Notes)

    @Delete
    suspend fun deleteNote(note:Notes)

    @Update
    suspend fun updateNote(note:Notes)

    @Query("SELECT * FROM NOTES_TABLE ORDER BY id DESC")
    fun getAllNotes():Observable<List<Notes>>

    @Query("SELECT * FROM NOTES_TABLE WHERE description LIKE :searchTerm ORDER BY id DESC")
    suspend fun getFilteredNotes(searchTerm:String):List<Notes>


    @Query("SELECT * FROM NOTES_TABLE WHERE category LIKE :categoryTerm ORDER BY id DESC")
    suspend fun getCategoryNotes(categoryTerm:String):List<Notes>

}