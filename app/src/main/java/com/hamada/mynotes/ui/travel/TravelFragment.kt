package com.hamada.mynotes.ui.travel

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.activityViewModels
import com.hamada.mynotes.R
import com.hamada.mynotes.databinding.FragmentPersonalBinding
import com.hamada.mynotes.databinding.FragmentTravelBinding
import com.hamada.mynotes.ui.allnotes.AllNotesViewModel
import com.hamada.mynotes.ui.allnotes.NotesAdapter
import com.hamada.personalnotesapp.ui.base.BaseFragment


class TravelFragment : BaseFragment<FragmentTravelBinding>(R.layout.fragment_travel){
    override val viewModel by activityViewModels<AllNotesViewModel>()
    override val bindingInflater: (LayoutInflater, Int, ViewGroup?, Boolean) -> FragmentTravelBinding
        get() = DataBindingUtil::inflate

    override fun setupView() {
        viewModel.getCategoryNotes("Travel")
        binding.recycler.adapter= NotesAdapter(mutableListOf(), viewModel)
    }

}