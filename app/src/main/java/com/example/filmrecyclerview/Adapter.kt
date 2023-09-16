package com.example.filmrecyclerview

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.ImageView
import android.widget.TextView
import android.widget.Toast
import androidx.recyclerview.widget.RecyclerView

class Adapter(private var mContext:Context, private var dataSet:List<Film>)
    : RecyclerView.Adapter<Adapter.CardViewHolder>()
{

    inner class CardViewHolder(view:View) : RecyclerView.ViewHolder(view){
        var filmImage : ImageView
        var filmName : TextView
        var filmPrice : TextView
        var buttonAddToCart : Button

        init {
            filmImage = view.findViewById(R.id.imageViewFilmImage)
            filmName = view.findViewById(R.id.textViewFilmName)
            filmPrice = view.findViewById(R.id.textViewPrice)
            buttonAddToCart = view.findViewById(R.id.buttonAddToCard)
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CardViewHolder {
        val design = LayoutInflater.from(mContext).inflate(R.layout.card_design, parent, false)
        return CardViewHolder(design)
    }

    override fun getItemCount(): Int {
        return dataSet.size
    }

    override fun onBindViewHolder(holder: CardViewHolder, position: Int) {
        val film = dataSet[position]

        holder.filmName.text = film.filmName
        val filmPrice = "${film.filmPrice} TL"
        holder.filmPrice.text = filmPrice

        holder.filmImage.setImageResource(mContext.resources.getIdentifier(
            film.filmImageName, "drawable", mContext.packageName
        ))

        holder.buttonAddToCart.setOnClickListener {
            Toast.makeText(mContext, "${film.filmName} added to cart", Toast.LENGTH_SHORT).show()
        }
    }
}