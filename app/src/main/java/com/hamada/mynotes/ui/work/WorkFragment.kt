package com.hamada.mynotes.ui.work

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.activityViewModels
import com.hamada.mynotes.R
import com.hamada.mynotes.databinding.FragmentWorkBinding
import com.hamada.mynotes.ui.allnotes.AllNotesViewModel
import com.hamada.mynotes.ui.allnotes.NotesAdapter
import com.hamada.personalnotesapp.ui.base.BaseFragment


class WorkFragment: BaseFragment<FragmentWorkBinding>(R.layout.fragment_work){
    override val viewModel by activityViewModels<AllNotesViewModel>()
    override val bindingInflater: (LayoutInflater, Int, ViewGroup?, Boolean) -> FragmentWorkBinding
        get() = DataBindingUtil::inflate

    override fun setupView() {
        viewModel.getCategoryNotes("Work")
        binding.recycler.adapter= NotesAdapter(mutableListOf(), viewModel)
    }

}