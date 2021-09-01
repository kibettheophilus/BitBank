package dev.kibet.bitbank.ui.home.fragments

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.fragment.findNavController
import dagger.hilt.android.AndroidEntryPoint
import dev.kibet.bitbank.R
import dev.kibet.bitbank.databinding.FragmentHistoryBinding
import dev.kibet.bitbank.databinding.FragmentHomeBinding

class HomeFragment : Fragment() {
private lateinit var binding: FragmentHomeBinding
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        binding = FragmentHomeBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding.sendCard.setOnClickListener {
            findNavController().navigate(R.id.action_homeFragment_to_sendFragment)
        }

        binding.addCard.setOnClickListener {
            findNavController().navigate(R.id.action_homeFragment_to_addFragment)
        }

        binding.payCard.setOnClickListener {
            findNavController().navigate(R.id.action_homeFragment_to_payFragment)
        }

        binding.withdrawCard.setOnClickListener {
            findNavController().navigate(R.id.action_homeFragment_to_withdrawFragment)
        }
    }
}