package com.hamada.mynotes.ui.allnotes

import androidx.core.content.ContextCompat
import com.hamada.mynotes.R
import com.hamada.mynotes.model.database.Notes
import com.hamada.mynotes.ui.base.BaseAdapter

class NotesAdapter(val item:List<Notes>, val listener:NotesInteractionListener):
    BaseAdapter<Notes>(item, listener){
    override val layoutId: Int= R.layout.item_note

}