package com.ahmadsodik.universitasterbaik

import android.content.Intent
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import android.widget.Toast
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.bumptech.glide.request.RequestOptions

@Suppress("DEPRECATION")
class ListUniversitasAdapter(private val listUniversitas: ArrayList<Universitas>) : RecyclerView.Adapter<ListUniversitasAdapter.ListViewHolder>() {

    override fun onCreateViewHolder(viewGroup: ViewGroup, viewType: Int): ListViewHolder {
        val view: View = LayoutInflater
            .from(viewGroup.context)
            .inflate(R.layout.list_universitas, viewGroup,false )
        return ListViewHolder(view)
    }

    override fun onBindViewHolder(holder: ListViewHolder, position: Int) {
        val (name, detail, lokasi, photo) = listUniversitas[position]

        Glide.with(holder.itemView.context)
            .load(photo)
            .apply(RequestOptions())
            .into(holder.imgPhoto)

        holder.tvName.text = name
        holder.tvLokasi.text = lokasi

        val mContext = holder.itemView.context


    holder.itemView.setOnClickListener { Toast.makeText(holder.itemView.context, "Kamu memilih " + listUniversitas[holder.adapterPosition].name, Toast.LENGTH_SHORT).show()
            val moveDetail = Intent(mContext, DetailUniversitas::class.java)
            moveDetail.putExtra(DetailUniversitas.EXTRA_NAME, name)
            moveDetail.putExtra(DetailUniversitas.EXTRA_DETAIL, detail)
            moveDetail.putExtra(DetailUniversitas.EXTRA_LOKASI, lokasi)
            moveDetail.putExtra(DetailUniversitas.EXTRA_PHOTO, photo)
            mContext.startActivity(moveDetail)
        }
    }

    override fun getItemCount(): Int {
        return listUniversitas.size
    }

    inner class ListViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        var tvName: TextView = itemView.findViewById(R.id.tv_item_name)
        var imgPhoto: ImageView = itemView.findViewById(R.id.img_item_photo)
        var tvLokasi: TextView = itemView.findViewById(R.id.tv_item_lokasi)
    }

}