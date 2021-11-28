package com.hamada.mynotes.ui.details

import androidx.lifecycle.ViewModel
import com.hamada.mynotes.model.repository.NoteRepository

class DetailsViewModel:ViewModel() {
    val repo=NoteRepository()
}