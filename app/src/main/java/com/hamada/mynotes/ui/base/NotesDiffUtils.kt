package com.hamada.mynotes.ui.base

import androidx.recyclerview.widget.DiffUtil

class NotesDiffUtils<T>(val notesOldList: List<T>, val notesNewList: List<T>) :
    DiffUtil.Callback() {
    override fun getOldListSize() = notesOldList.size

    override fun getNewListSize() = notesNewList.size

    override fun areItemsTheSame(oldItemPosition: Int, newItemPosition: Int) =notesOldList[oldItemPosition]==notesNewList[newItemPosition]

    override fun areContentsTheSame(oldItemPosition: Int, newItemPosition: Int) = true
}