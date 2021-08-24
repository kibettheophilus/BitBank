package dev.kibet.bitbank.ui.home.fragments

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.LinearLayoutManager
import dagger.hilt.android.AndroidEntryPoint
import dev.kibet.bitbank.R
import dev.kibet.bitbank.databinding.FragmentHistoryBinding
import dev.kibet.bitbank.databinding.FragmentHomeBinding
import dev.kibet.bitbank.models.History
import dev.kibet.bitbank.ui.home.adapter.HistoryAdapter

@AndroidEntryPoint
class HistoryFragment : Fragment() {
    private lateinit var binding: FragmentHistoryBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        binding = FragmentHistoryBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val recyclerView = binding.recyclerview
        recyclerView.layoutManager = LinearLayoutManager(context)
        recyclerView.adapter = HistoryAdapter(history())
    }


    fun history(): List<History> {
        return listOf(
            History("Lunch","Ksh.1200"),
            History("Fare","Ksh.100"),
            History("Rent","Ksh.2200"),
            History("Lunch","Ksh.1200"),
            History("Lunch","Ksh.1200"),
            History("Fare","Ksh.100"),
            History("Rent","Ksh.2200"),
            History("Lunch","Ksh.1200")
        )
    }

}