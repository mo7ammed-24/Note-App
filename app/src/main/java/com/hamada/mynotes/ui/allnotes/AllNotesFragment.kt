package com.hamada.mynotes.ui.allnotes

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.activityViewModels
import androidx.navigation.ActionOnlyNavDirections
import com.hamada.mynotes.R
import com.hamada.mynotes.databinding.FragmentAllNotesBinding
import com.hamada.personalnotesapp.ui.base.BaseFragment

class AllNotesFragment: BaseFragment<FragmentAllNotesBinding>(R.layout.fragment_all_notes) {
    override val viewModel by activityViewModels<AllNotesViewModel>()
    override val bindingInflater: (LayoutInflater, Int, ViewGroup?, Boolean) -> FragmentAllNotesBinding
        get() =DataBindingUtil::inflate

    override fun setupView() {
        viewModel.loadNotes()
        binding.recycler.adapter=NotesAdapter(mutableListOf(), viewModel)
    }

}