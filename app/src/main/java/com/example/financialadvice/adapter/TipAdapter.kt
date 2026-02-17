package com.example.financialadvice.adapter

import android.content.Intent
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.financialadvice.DetailActivity
import com.example.financialadvice.R
import com.example.financialadvice.model.Tip
import android.widget.ImageView
import android.widget.TextView

class TipAdapter(private val tips: List<Tip>) :
    RecyclerView.Adapter<TipAdapter.TipViewHolder>() {

    class TipViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val dayText: TextView = itemView.findViewById(R.id.dayText)
        val fullText: TextView = itemView.findViewById(R.id.fullText)
        val descText: TextView = itemView.findViewById(R.id.descText)
        val imageView: ImageView = itemView.findViewById(R.id.imageView)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): TipViewHolder {
        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.item_tip, parent, false)
        return TipViewHolder(view)
    }

    override fun onBindViewHolder(holder: TipViewHolder, position: Int) {
        val tip = tips[position]

        holder.dayText.text =
            holder.itemView.context.getString(R.string.day_format, tip.day)
        holder.fullText.setText(tip.fullDescResId)
        holder.descText.setText(tip.shortDescResId)
        holder.imageView.setImageResource(tip.imageResId)

        holder.itemView.setOnClickListener {
            val intent = Intent(holder.itemView.context, DetailActivity::class.java)
            intent.putExtra("TIP_INDEX", position)
            holder.itemView.context.startActivity(intent)
        }
    }

    override fun getItemCount(): Int = tips.size
}