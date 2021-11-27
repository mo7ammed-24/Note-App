package com.hamada.personalnotesapp.model.NotesDatabase

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import androidx.room.TypeConverters
import com.hamada.mynotes.model.database.Converters
import com.hamada.mynotes.model.database.NoteDao
import com.hamada.mynotes.model.database.Notes

@Database(entities =[Notes::class], version = 1)
@TypeConverters(Converters::class)
abstract class NotesDatabase:RoomDatabase(){
    abstract fun noteDao(): NoteDao

    companion object{

        const val DATABASE_NAME="My_Notes_Database"

        @Volatile private var instance:NotesDatabase? = null

        fun getInstance(context: Context):NotesDatabase{
            return instance ?: synchronized(this) {buildDatabase(context).also { instance=it }}
        }

        fun getInstanceWithoutContext():NotesDatabase{
            return instance!!
        }

        private fun buildDatabase(context:Context):NotesDatabase{
           return Room.databaseBuilder(context, NotesDatabase::class.java, DATABASE_NAME).build()
        }
    }
}