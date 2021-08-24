package dev.kibet.bitbank.ui.home.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import dev.kibet.bitbank.R
import dev.kibet.bitbank.databinding.ItemRecyclerviewBinding
import dev.kibet.bitbank.models.History

class HistoryAdapter(private val history: List<History>) : RecyclerView.Adapter<HistoryAdapter.HistoryViewHolder>(){


    class HistoryViewHolder(private val binding:ItemRecyclerviewBinding): RecyclerView.ViewHolder(binding.root) {
//        val itemDesc: TextView = itemView.findViewById(R.id.item_desc)
//        val amount: TextView = itemView.findViewById(R.id.item_amount)
        fun bind(item: History){
            binding.apply{
                itemDesc.text = item.desc
                itemAmount.text = item.amount
            }
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int) : HistoryViewHolder {
        val binding = ItemRecyclerviewBinding.inflate(
            LayoutInflater.from(parent.context),
            parent,false)

        return HistoryViewHolder(binding)
    }

    override fun onBindViewHolder(holder: HistoryViewHolder, position: Int) {
        val item = history[position]

        holder.bind(item)
    }

    override fun getItemCount() : Int = history.size
}