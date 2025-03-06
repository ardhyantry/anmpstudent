package com.ubaya.studentproject.view

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.ubaya.studentproject.R
import com.ubaya.studentproject.databinding.FragmentStudentListBinding
import com.ubaya.studentproject.viewmodel.ListViewModel
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import com.ubaya.studentproject.databinding.FragmentStudentDetailBinding
import com.ubaya.studentproject.viewmodel.DetailViewModel


/**
 * A simple [Fragment] subclass.
 * Use the [StudentDetailFragment.newInstance] factory method to
 * create an instance of this fragment.
 */
class StudentDetailFragment : Fragment() {
    private lateinit var viewModel: DetailViewModel
    private lateinit var binding: FragmentStudentDetailBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentStudentDetailBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        viewModel = ViewModelProvider(this)[DetailViewModel::class.java]

        val id = StudentDetailFragmentArgs.fromBundle(requireArguments()).id
        viewModel.fetch(id) // Fetch student data

        observeViewModel()
    }

    private fun observeViewModel() {
        viewModel.studentLD.observe(viewLifecycleOwner, Observer { student ->
            student?.let {
                binding.txtID.setText(it.id)
                binding.txtName.setText(it.name)
                binding.txtBod.setText(it.bod)
                binding.txtPhone.setText(it.phone)
            }
        })
    }
}

