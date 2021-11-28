package com.hamada.mynotes.ui.details
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.AdapterView
import android.widget.ArrayAdapter
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.activityViewModels
import androidx.lifecycle.lifecycleScope
import com.hamada.mynotes.R
import com.hamada.mynotes.databinding.FragmentDetailsBinding
import com.hamada.mynotes.model.database.Notes
import com.hamada.personalnotesapp.ui.base.BaseFragment
import kotlinx.coroutines.launch
import java.util.*

class DetailsFragment:BaseFragment<FragmentDetailsBinding>(R.layout.fragment_details) {
    override val viewModel by activityViewModels<DetailsViewModel>()
    override val bindingInflater: (LayoutInflater, Int, ViewGroup?, Boolean) -> FragmentDetailsBinding
        get() =DataBindingUtil::inflate

    override fun setupView() {
            var category="No Category"
            val categoryList= listOf( "No Category", "Travel", "Personal", "Life", "Work")
            val adapter=ArrayAdapter(requireContext(), android.R.layout.simple_spinner_item, categoryList)
            binding.spinnerCategory.adapter=adapter
            binding.spinnerCategory.onItemSelectedListener=object :AdapterView.OnItemSelectedListener{
                override fun onItemSelected(p0: AdapterView<*>?, p1: View?, p2: Int, p3: Long) {
                    category=categoryList[p2]
                }

                override fun onNothingSelected(p0: AdapterView<*>?) {
                    category="No Category"
                }

            }
            binding.backArrow.setOnClickListener {
                requireActivity().supportFragmentManager.popBackStack()
            }
            binding.textTime.text=Date().toString().substring(0,20)
            binding.doneVector.setOnClickListener {
                lifecycleScope.launch {
                    viewModel.repo.insertNewNote(Notes(0,description = binding.inputNote.text.toString(), Date(), category = category))
                    requireActivity().supportFragmentManager.popBackStack()
                }
            }
    }
}