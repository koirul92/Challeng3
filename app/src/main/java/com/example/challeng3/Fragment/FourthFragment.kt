package com.example.challeng3.Fragment

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.fragment.findNavController
import androidx.navigation.fragment.navArgs
import com.example.challeng3.databinding.FragmentFourthBinding


class FourthFragment : Fragment() {
    private var _binding: FragmentFourthBinding? = null
    private val binding get() = _binding!!
    val args:FourthFragmentArgs by navArgs()


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        // Inflate the layout for this fragment
        _binding = FragmentFourthBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding.btnBackToScreen3.setOnClickListener {
            val name = args.name
            val result =
                (binding.etDieAge.text.toString().toInt()-binding.etRetiredAge.text.toString().toInt()) * binding.etOutcome.text.toString().toInt()
            val PersonData = DataPerson(
                name,
                result,
                binding.etRetiredAge.text.toString(),
                binding.etDieAge.text.toString(),
                binding.etOutcome.text.toString()
            )
            val FourthFragmentAction = FourthFragmentDirections.actionFourthFragmentToThirdFragment(PersonData)
            findNavController().navigate(FourthFragmentAction)
            }
        }

    override fun onDestroy() {
        super.onDestroy()
        _binding = null
    }
}