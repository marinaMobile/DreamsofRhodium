package com.moonton.mob.novel

enum class BoardSize(val numCards: Int) {
    EASY( 28) ;
    fun getWidth(): Int{
        return when(this){
            EASY -> 4
        }
    }
    fun getHeight(): Int {
        return numCards / getWidth()
    }
    fun getNumPairs(): Int{
        return numCards / 2;
    }
}