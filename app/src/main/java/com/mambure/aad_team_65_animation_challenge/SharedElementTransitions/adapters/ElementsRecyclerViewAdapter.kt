package com.mambure.aad_team_65_animation_challenge.SharedElementTransitions.adapters

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.mambure.aad_team_65_animation_challenge.R
import com.mambure.aad_team_65_animation_challenge.SharedElementTransitions.listeners.ElementClickListener
import com.mambure.aad_team_65_animation_challenge.SharedElementTransitions.model.ElementModel

class ElementsRecyclerViewAdapter(private val listener: ElementClickListener)
    : RecyclerView.Adapter<ElementsRecyclerViewAdapter.ItemHolder>() {

    private val data = listOf(
            ElementModel("Smoke + Mirrors", R.drawable.smoke),
            ElementModel("Night  Visions", R.drawable.night),
            ElementModel("Farewell Starlite!", R.drawable.cover)
    )

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ItemHolder {
        return ItemHolder(LayoutInflater.from(parent.context)
                .inflate(R.layout.item_shared_element, parent, false))
    }

    override fun getItemCount(): Int = data.size

    override fun onBindViewHolder(holder: ItemHolder, position: Int) {
        val element = data[position]
        holder.bind(element)

        holder.itemView.setOnClickListener {
            listener.onElementClick(holder.image, element)
        }
    }

    inner class ItemHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        internal val image: ImageView = itemView.findViewById(R.id.image)
        private val title: TextView = itemView.findViewById(R.id.title)

        fun bind(item: ElementModel) {
            Glide.with(itemView.context)
                    .load(item.image)
                    .fitCenter()
                    .into(image)

            title.text = item.title
        }
    }
}