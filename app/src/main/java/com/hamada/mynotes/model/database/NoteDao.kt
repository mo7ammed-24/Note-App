package com.hamada.mynotes.model.database

import androidx.room.*
import kotlinx.coroutines.flow.Flow

@Dao
interface NoteDao {

    @Insert(onConflict = OnConflictStrategy.IGNORE)
    suspend fun insertNote(note:Notes)

    @Delete
    suspend fun deleteNote(note:Notes)

    @Update
    suspend fun updateNote(note:Notes)

    @Query("SELECT * FROM NOTES_TABLE ORDER BY id DESC")
    fun getAllNotes(): Flow<List<Notes>>

    @Query("SELECT * FROM NOTES_TABLE WHERE description LIKE :searchTerm ORDER BY id DESC")
    suspend fun getGFiltered(searchTerm:String):List<Notes>

}