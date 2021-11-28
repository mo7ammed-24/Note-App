package com.hamada.mynotes.util

import android.util.Log
import androidx.cardview.widget.CardView
import androidx.core.content.ContextCompat
import androidx.databinding.BindingAdapter
import androidx.recyclerview.widget.RecyclerView
import com.hamada.mynotes.R
import com.hamada.mynotes.ui.base.BaseAdapter


@BindingAdapter(value = ["app:items"])
fun <T> setRecyclerItems(view: RecyclerView, items: List<T>?) {
    if (items != null) {
        (view.adapter as BaseAdapter<T>?)?.setItems(items)
    } else {
        Log.i("Hamada", "inside items ${items}")
        (view.adapter as BaseAdapter<T>?)?.setItems(emptyList())
    }
}

@BindingAdapter(value=["app:cardColor"])
fun <T> setCardColor(view: CardView, category:String){
    when(category){
        "Work" ->view.setCardBackgroundColor(ContextCompat.getColor(view.context, R.color.red))
        "Travel" ->view.setCardBackgroundColor(ContextCompat.getColor(view.context, R.color.yellow))
        "Personal" ->view.setCardBackgroundColor(ContextCompat.getColor(view.context, R.color.blue))
        "Life" ->view.setCardBackgroundColor(ContextCompat.getColor(view.context, R.color.green))
        else ->view.setCardBackgroundColor(ContextCompat.getColor(view.context, R.color.white))

    }
}
