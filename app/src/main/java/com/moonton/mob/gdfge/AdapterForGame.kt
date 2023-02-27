package com.moonton.mob.gdfge

import android.annotation.SuppressLint
import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageButton
import androidx.cardview.widget.CardView
import androidx.core.content.ContextCompat
import androidx.core.view.ViewCompat
import androidx.recyclerview.widget.RecyclerView
import com.moonton.mob.R
import com.moonton.mob.xzoosidh.DataCard
import java.lang.Integer.min

class AdapterForGame(val context: Context, val boardSize: BoardSize, val cards: List<DataCard>, val cardClickListener: CardClickListener): RecyclerView.Adapter<AdapterForGame.ViewHolder>() {

    companion object{
        var MARGIN_SIZE: Int = 2
    }
    interface  CardClickListener {
        fun onCardClicked(position: Int)
    }

    inner class ViewHolder(ItemView: View) : RecyclerView.ViewHolder(ItemView) {
        private  val imageButton =  itemView.findViewById<ImageButton>(R.id.imageButton)

        fun bind(position: Int) {
            val memoryCard = cards[position]
            imageButton.setImageResource(if (cards[position].isFaceUp) cards[position].identifier else R.drawable.siz)
            val colorStateList =  if(memoryCard.isMatched) ContextCompat.getColorStateList(context,
                R.color.light_blue
            ) else null
            ViewCompat.setBackgroundTintList(imageButton, colorStateList)
            imageButton.setOnClickListener{
                cardClickListener.onCardClicked(position)
            }
        }
    }

    @SuppressLint("MissingInflatedId")
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val cardWidth = parent.width / boardSize.getWidth() - (2 * MARGIN_SIZE)
        val cardHeight = parent.height / boardSize.getHeight() - (2 * MARGIN_SIZE)
        val cardSideLength = min(cardWidth, cardHeight)
        val view =  LayoutInflater.from(context).inflate(R.layout.card, parent, false)
        val layoutParams  =  view.findViewById<CardView>(R.id.cardView).layoutParams as ViewGroup.MarginLayoutParams
        layoutParams.width = cardSideLength
        layoutParams.height = cardSideLength
        layoutParams.setMargins(MARGIN_SIZE, MARGIN_SIZE, MARGIN_SIZE, MARGIN_SIZE)
        return ViewHolder(view)
    }

    override fun getItemCount() = boardSize.numCards

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.bind(position)
    }


}