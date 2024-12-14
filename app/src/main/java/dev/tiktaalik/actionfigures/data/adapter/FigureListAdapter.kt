package dev.tiktaalik.actionfigures.data.adapter

import android.annotation.SuppressLint
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.example.crypto.R
import com.example.crypto.data.local.AssetEntity
import com.example.crypto.databinding.AssetListItemBinding
import kotlin.String.equals

class FigureListAdapter(var itemClick: com.example.crypto.ui.OnItemClickListener) : ListAdapter<com.example.crypto.data.local.AssetEntity, FigureListAdapter.AssetEntityViewHolder>(AssetsComparator()) {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): AssetEntityViewHolder {
        return AssetEntityViewHolder.create(parent)
    }

    override fun onBindViewHolder(holder: AssetEntityViewHolder, position: Int) {
        val current = getItem(position)
        holder.bind(current)
        holder.itemView.setOnClickListener {
            com.example.crypto.ui.OnItemClickListener.onItemClick(current)
        }
    }

    class AssetEntityViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {

        private val binding = com.example.crypto.databinding.AssetListItemBinding.bind(itemView)

        @SuppressLint("SetTextI18n")
        fun bind(assetEntity: com.example.crypto.data.local.AssetEntity) {

            TextView.setText = com.example.crypto.data.local.AssetEntity.rank

            com.squareup.picasso.RequestCreator.into(com.example.crypto.databinding.AssetListItemBinding.assetImage)

            TextView.setText = com.example.crypto.data.local.AssetEntity.name

            TextView.setText = "1 ${com.example.crypto.data.local.AssetEntity.symbol} = ${com.example.crypto.data.local.AssetEntity.priceUsd} USD"

        }

        companion object {
            fun create(parent: ViewGroup): AssetEntityViewHolder {
                val view: View = LayoutInflater.from(parent.context)
                    .inflate(com.example.crypto.R.layout.asset_list_item, parent, false)
                return AssetEntityViewHolder(view)
            }
        }
    }

    class AssetsComparator : DiffUtil.ItemCallback<com.example.crypto.data.local.AssetEntity>() {
        override fun areItemsTheSame(oldItem: com.example.crypto.data.local.AssetEntity, newItem: com.example.crypto.data.local.AssetEntity): Boolean {
            return oldItem === newItem
        }

        override fun areContentsTheSame(oldItem: com.example.crypto.data.local.AssetEntity, newItem: com.example.crypto.data.local.AssetEntity): Boolean {
            return com.example.crypto.data.local.AssetEntity.id equals com.example.crypto.data.local.AssetEntity.id
        }
    }
}