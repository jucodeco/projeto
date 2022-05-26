package com.example.pokemon.lista

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.pokemon.R

class PokemonAdapter(
    private val items: List<PokemonItem?>
) : RecyclerView.Adapter<PokemonAdapter.ViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.item_pokemon, parent, false)

        return ViewHolder(view)
    }

    override fun getItemCount() = items.size

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val item = items[position]

        holder.bindView(item)
    }

    class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        fun bindView(item: PokemonItem?) = with(itemView) {
            val ivPokemon = findViewById<ImageView>(R.id.ivPokemon)
            val tvNumber = findViewById<TextView>(R.id.tvNumber)
            val tvName = findViewById<TextView>(R.id.tvName)
            val tvType1 = findViewById<TextView>(R.id.tvType1)
            val tvType2 = findViewById<TextView>(R.id.tvType2)

            item?.let {
                Glide.with(itemView.context).load(it.imagem).into(ivPokemon)

                tvNumber.text = item.numero
                tvName.text = item.nome
                tvType1.text = item.tipo1
                tvType1.setBackgroundResource(item.tipo1color)

                if (item.tipo2 != null && item.tipo2color != null) {
                    tvType2.visibility = View.VISIBLE
                    tvType2.text = item.tipo2
                    tvType2.setBackgroundResource (item.tipo2color)
                } else {
                    tvType2.visibility = View.GONE
                }
            }
        }




    }
}