package com.example.appfordisplaying.view.adapters

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.bumptech.glide.load.model.GlideUrl
import com.bumptech.glide.load.model.LazyHeaders
import com.example.appfordisplaying.R
import com.example.appfordisplaying.databinding.ItemBinding
import com.example.appfordisplaying.view.models.Item

class ListItemsAdapter(): ListAdapter<Item, ListItemsAdapter.ItemViewHolder>(object : DiffUtil.ItemCallback<Item>() {
        override fun areItemsTheSame(oldItem: Item, newItem: Item): Boolean =
            oldItem.id == newItem.id

        override fun areContentsTheSame(oldItem: Item, newItem: Item): Boolean = oldItem == newItem
    }) {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ItemViewHolder {
        val layoutInflater = LayoutInflater.from(parent.context)
        val binding = ItemBinding.inflate(layoutInflater, parent, false)

        return ItemViewHolder(binding)
    }

    override fun onBindViewHolder(holder: ItemViewHolder, position: Int) {
        holder.bind(getItem(position))
    }

    inner class ItemViewHolder(binding123: ItemBinding) : RecyclerView.ViewHolder(binding123.root) {
        private var binding: ItemBinding? = null

        init {
            binding = binding123
        }

        fun bind(item: Item) {
            val url = GlideUrl(
                item.url, LazyHeaders.Builder()
                    .addHeader("Item", "Android")
                    .build()
            )

            with(binding) {
                Glide.with(this!!.imageItem.context)
                    .load(url)
                    .error(R.drawable.ic_launcher_foreground)
                    .into(imageItem)

                descriptionItem.text = item.description
            }
        }
    }
}