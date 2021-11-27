package com.hamada.personalnotesapp.ui.base

import androidx.recyclerview.widget.DiffUtil

class NotesDiffUtils<T>(val movieOldList: List<T>, val movieNewList: List<T>) :
    DiffUtil.Callback() {
    override fun getOldListSize() = movieOldList.size

    override fun getNewListSize() = movieNewList.size

    override fun areItemsTheSame(oldItemPosition: Int, newItemPosition: Int) =movieOldList[oldItemPosition]?.equals(movieNewList[newItemPosition])==true

    override fun areContentsTheSame(oldItemPosition: Int, newItemPosition: Int) = true
}