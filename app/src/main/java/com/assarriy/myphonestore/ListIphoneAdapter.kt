package com.assarriy.myphonestore

import android.content.Intent
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import android.widget.Toast
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide

class ListIphoneAdapter(private val listIphone: ArrayList<Phone>) :
    RecyclerView.Adapter<ListIphoneAdapter.ListViewHolder>() {
    class ListViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val imgPhone: ImageView = itemView.findViewById(R.id.img_item_product)
        val tvName: TextView = itemView.findViewById(R.id.tv_item_name)
        val tvPrice: TextView = itemView.findViewById(R.id.tv_item_price)
        val tvDescription: TextView = itemView.findViewById(R.id.tv_item_description)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ListViewHolder {
        val view: View =
            LayoutInflater.from(parent.context).inflate(R.layout.item_row_product, parent, false)
        return ListViewHolder(view)
    }

    override fun getItemCount(): Int {
        return listIphone.size
    }

    override fun onBindViewHolder(holder: ListViewHolder, position: Int) {
        val iphone = listIphone[position]
        holder.tvName.text = iphone.name
        holder.tvPrice.text = iphone.price
        holder.tvDescription.text = iphone.name
        Glide.with(holder.itemView)
            .load(iphone.photo)
            .into(holder.imgPhone)

        holder.itemView.setOnClickListener {
            Toast.makeText(holder.itemView.context, "Kamu memilih " + listIphone[holder.adapterPosition].name, Toast.LENGTH_SHORT).show()
            val intet  = Intent(it.context, DetailIphoneActivity::class.java)
            intet.putExtra(DetailIphoneActivity.EXTRA_IPHONE, iphone)
            it.context.startActivity(intet)
        }
    }

}