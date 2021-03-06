package com.hamada.mynotes.ui.nocategory

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import androidx.fragment.app.activityViewModels
import androidx.lifecycle.ViewModel
import com.hamada.mynotes.R
import com.hamada.mynotes.databinding.FragmentNoCategoryBinding
import com.hamada.mynotes.ui.allnotes.AllNotesViewModel
import com.hamada.mynotes.ui.allnotes.NotesAdapter
import com.hamada.personalnotesapp.ui.base.BaseFragment

class NoCategoryFragment:BaseFragment<FragmentNoCategoryBinding>(R.layout.fragment_no_category){
    override val viewModel by activityViewModels<AllNotesViewModel>()
    override val bindingInflater: (LayoutInflater, Int, ViewGroup?, Boolean) -> FragmentNoCategoryBinding
        get() =DataBindingUtil::inflate

    override fun setupView() {
        viewModel.getCategoryNotes("No Category")
        binding.recycler.adapter= NotesAdapter(mutableListOf(), viewModel)
    }

}