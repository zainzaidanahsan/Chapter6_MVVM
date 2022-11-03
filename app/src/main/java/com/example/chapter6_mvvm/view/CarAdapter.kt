package com.example.chapter6_mvvm.view

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.chapter6_mvvm.databinding.ItemCarBinding
import com.example.chapter6_mvvm.model.DataCarItem

class CarAdapter(var listCar: List<DataCarItem>): RecyclerView.Adapter<CarAdapter.ViewHolder>() {

    class ViewHolder(var binding : ItemCarBinding): RecyclerView.ViewHolder(binding.root) {

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        var view = ItemCarBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return ViewHolder(view)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val id = listCar[position].id.toString()
        val nama = listCar[position].name
        val cat = listCar[position].category
        val price = listCar[position].price.toString()
        val img = listCar[position].image

        holder.binding.textIdCar.text = id
        holder.binding.textNamecar.text = nama
        holder.binding.textCategory.text = cat
        holder.binding.textHarga.text = "Rp."+ price
        Glide.with(holder.itemView).load(img).into(holder.binding.carImage)
    }

    override fun getItemCount(): Int {
        return listCar.size
    }
}