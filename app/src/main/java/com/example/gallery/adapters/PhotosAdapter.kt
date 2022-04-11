package com.example.gallery.adapters

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.gallery.R
import com.example.gallery.models.Resultt

class PhotosAdapter : RecyclerView.Adapter<PhotosAdapter.MyHolder>() {
    private var list = ArrayList<Resultt>()
    private var listener: ((Resultt) -> Unit)? = null
    inner class MyHolder(view: View) : RecyclerView.ViewHolder(view) {
        fun bind(resultt: Resultt) {
            val image = itemView.findViewById<ImageView>(R.id.imager)
            Glide.with(itemView).load(resultt.urls.small).into(image)
            itemView.setOnClickListener {
                listener?.invoke(list[adapterPosition])
            }
        }


    }

    fun setOytimClickListener(l: (Resultt) -> Unit) {
        listener = l
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.image_items, parent, false)
        return MyHolder(view)
    }


    fun submitItem(item: List<Resultt>) {
        val util = DifUtill(item, list)
        val diff = DiffUtil.calculateDiff(util)
        list.clear()
        list.addAll(item)
        diff.dispatchUpdatesTo(this)
    }

    override fun onBindViewHolder(holder: MyHolder, position: Int) = holder.bind(list[position])


    override fun getItemCount(): Int = list.size
}

class DifUtill(var new: List<Resultt>, var old: List<Resultt>) : DiffUtil.Callback() {
    override fun getOldListSize(): Int {
        return old.size
    }

    override fun getNewListSize(): Int {
        return new.size
    }

    override fun areItemsTheSame(oldItemPosition: Int, newItemPosition: Int): Boolean {
        return old[oldItemPosition] == new[oldItemPosition]
    }

    override fun areContentsTheSame(oldItemPosition: Int, newItemPosition: Int): Boolean {
        return old[oldItemPosition].id == new[oldItemPosition].id
    }

}