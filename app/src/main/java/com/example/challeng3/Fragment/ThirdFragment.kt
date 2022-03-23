package com.example.challeng3.Fragment

import android.annotation.SuppressLint
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.fragment.findNavController
import androidx.navigation.fragment.navArgs
import com.example.challeng3.R
import com.example.challeng3.databinding.FragmentThirdBinding


class ThirdFragment : Fragment() {
    private var _binding: FragmentThirdBinding? = null
    private val binding get() = _binding!!

    val args: ThirdFragmentArgs by navArgs()
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        // Inflate the layout for this fragment
        _binding = FragmentThirdBinding.inflate(inflater, container, false)
        return binding.root
    }

    @SuppressLint("SetTextI18n")
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val name = args.result?.name.toString()
        binding.tvName.text = name

        binding.btnGoToScreen4.setOnClickListener {
            val ThirdFragmentAction =
                ThirdFragmentDirections.actionThirdFragmentToFourthFragment(name)
            findNavController().navigate(ThirdFragmentAction)
        }

        val result = args.result?.result
        val retired = args.result?.retiredAge
        val die = args.result?.dieAge
        val outcome = args.result?.outcome


        if (result != null) {
            binding.tvRetiredAge.text = "$retired"
            binding.tvDieAge.text = "$die cm"
            binding.tvOutcome.text = "$outcome cm"
            binding.tvResult.text =
                "Bapak/Ibu $name, Jumlah uang yang anda butuhkan sebesar Rp.$result"
            binding.tvName.text = null
            binding.btnGoToScreen4.visibility = View.GONE
        } else {
            binding.tvName.text = "Selamat Datang $name"
            binding.tvResult.visibility = View.GONE
            binding.tvOutcome.visibility = View.GONE
            binding.tvDieAge.visibility = View.GONE
            binding.tvRetiredAge.visibility = View.GONE
        }
    }

    override fun onDestroy() {
        super.onDestroy()
        _binding = null
    }
}