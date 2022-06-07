package com.example.rickandmorty.main.ui.adapters

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.rickandmorty.R
import com.example.rickandmorty.main.model.Results

class MainAdapter(val onClick: (Results) -> Unit) : RecyclerView.Adapter<MainAdapter.MyViewHolder>() {
    private val data = mutableListOf<Results>()

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolder {
        val itemView =
            LayoutInflater.from(parent.context).inflate(R.layout.item_main, parent, false)
        return MyViewHolder(itemView)
    }

    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {
        val listItem = data[position]
        holder.bind(listItem)
    }

    override fun getItemCount() = data.size

    fun setItems(new: ArrayList<Results>){
        val old = ArrayList(data)
        data.clear()
        data.addAll(new)
        DiffUtil.calculateDiff(getDiffCallback(old, data)).dispatchUpdatesTo(this)
    }

    private fun getDiffCallback(
        oldlist: List<Results>,
        newlist: List<Results>
    ) = object : DiffUtil.Callback(){
        override fun getOldListSize(): Int = oldlist.size

        override fun getNewListSize(): Int = newlist.size

        override fun areItemsTheSame(oldItemPosition: Int, newItemPosition: Int): Boolean {
            val oldItem = oldlist[oldItemPosition]
            val newItem = newlist[newItemPosition]
            return when (oldItem){
                is Results -> newItem is Results && oldItem.id == newItem.id
                else -> throw IllegalArgumentException("Items aren`t same")
            }
        }

        override fun areContentsTheSame(oldItemPosition: Int, newItemPosition: Int): Boolean {
            val oldItem = oldlist[oldItemPosition]
            val newItem = newlist[newItemPosition]
            return when(oldItem){
                is Results -> newItem is Results &&
                        oldItem.id == newItem.id &&
                        oldItem.name == newItem.name &&
                        oldItem.status == newItem.status &&
                        oldItem.image == newItem.image &&
                        oldItem.gender == newItem.gender

                else -> throw IllegalArgumentException("Contents aren`t same")
            }
        }

    }

    inner class MyViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        private val imageView: ImageView = itemView.findViewById(R.id.item_image)
        private val text: TextView = itemView.findViewById(R.id.text)
        private val textDescription: TextView = itemView.findViewById(R.id.text_description)
        private val dot:ImageView = itemView.findViewById(R.id.dot)
        private val isAliveText: TextView = itemView.findViewById(R.id.is_alive_text)
        private val characterType: TextView = itemView.findViewById(R.id.character_type)
        fun bind(results: Results) {
            Glide.with(itemView.context).load(results.image).into(imageView)
            text.text = results.name
            textDescription.text = results.species
            isAliveText.text = results.status
            characterType.text = results.type
            when(results.status){
                "Alive" -> dot.setImageResource(R.drawable.green_dot1)
                "unknown" -> dot.setImageResource(R.drawable.grey_dot)
                "Dead" -> dot.setImageResource(R.drawable.red_dot)
            }
            itemView.setOnClickListener { onClick.invoke(results) }
        }
    }
}