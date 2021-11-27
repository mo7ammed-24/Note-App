package com.hamada.mynotes.ui.allnotes

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import com.hamada.mynotes.databinding.FragmentAllNotesBinding
import com.hamada.mynotes.databinding.FragmentHomeBinding
import com.hamada.mynotes.ui.home.HomeViewModel

class AllNotesFragment: Fragment() {
    private lateinit var homeViewModel: AllNotesViewModel
    private var _binding: FragmentAllNotesBinding? = null

    // This property is only valid between onCreateView and
    // onDestroyView.
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        homeViewModel =
            ViewModelProvider(this).get(AllNotesViewModel::class.java)

        _binding = FragmentAllNotesBinding.inflate(inflater, container, false)
        val root: View = binding.root

        val textView: TextView = binding.textGallery
        homeViewModel.text.observe(viewLifecycleOwner, Observer {
            textView.text = it
        })
        return root
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}