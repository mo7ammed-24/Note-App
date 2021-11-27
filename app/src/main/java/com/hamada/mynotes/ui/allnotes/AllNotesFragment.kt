package com.hamada.mynotes.ui.allnotes

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import com.hamada.mynotes.R
import com.hamada.mynotes.databinding.FragmentAllNotesBinding
class AllNotesFragment: Fragment() {
    val homeViewModel: AllNotesViewModel by viewModels()
    private lateinit var binding: FragmentAllNotesBinding

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = DataBindingUtil.inflate(inflater, R.layout.fragment_all_notes, container, false)
        return binding.root
    }

}