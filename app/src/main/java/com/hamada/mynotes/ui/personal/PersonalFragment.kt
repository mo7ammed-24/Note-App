package com.hamada.mynotes.ui.personal

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.activityViewModels
import com.hamada.mynotes.R
import com.hamada.mynotes.databinding.FragmentPersonalBinding
import com.hamada.mynotes.ui.allnotes.AllNotesViewModel
import com.hamada.mynotes.ui.allnotes.NotesAdapter
import com.hamada.personalnotesapp.ui.base.BaseFragment

class PersonalFragment : BaseFragment<FragmentPersonalBinding>(R.layout.fragment_personal){
    override val viewModel by activityViewModels<AllNotesViewModel>()
    override val bindingInflater: (LayoutInflater, Int, ViewGroup?, Boolean) -> FragmentPersonalBinding
        get() = DataBindingUtil::inflate

    override fun setupView() {
        viewModel.getCategoryNotes("Personal")
        binding.recycler.adapter= NotesAdapter(mutableListOf(), viewModel)

    }
}