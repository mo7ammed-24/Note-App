package com.hamada.mynotes.model.database

import androidx.room.Entity
import androidx.room.PrimaryKey
import java.util.*

@Entity(tableName = "NOTES_TABLE")
data class Notes (
        @PrimaryKey(autoGenerate = true)val id:Long,
        val title:String,
        val description:String,
        val date: Date,
        val category:String,
)