package dev.kibet.bitbank.ui

import android.os.Bundle
import android.os.Handler
import android.os.Looper
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.Observer
import androidx.navigation.fragment.findNavController
import dev.kibet.bitbank.R
import dev.kibet.bitbank.databinding.FragmentSplashBinding
import dev.kibet.bitbank.ui.home.viewmodel.SplashViewModel


class SplashFragment : Fragment() {
    private lateinit var binding: FragmentSplashBinding
    private lateinit var splashViewModel: SplashViewModel

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        binding = FragmentSplashBinding.inflate(inflater, container, false)

        splashViewModel = SplashViewModel(requireContext())

        splashViewModel.setSplashTimeout(true)

        splashViewModel.getSplashTimeout()?.observe(requireActivity(), {
            findNavController().navigate(R.id.action_splashFragment_to_loginFragment)
        })
        return binding.root
    }
}