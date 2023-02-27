package com.moonton.mob.asx

import android.annotation.SuppressLint
import android.content.Context
import android.os.Bundle
import android.os.CountDownTimer
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.activity.OnBackPressedCallback
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.moonton.mob.R
import com.moonton.mob.databinding.FragmentPlayGameBinding
import com.moonton.mob.gdfge.AdapterForGame
import com.moonton.mob.gdfge.BoardSize
import com.moonton.mob.gdfge.Gamer


class Wpaplsokxcijs : Fragment() {
    private lateinit var adapter: AdapterForGame
    private  lateinit var rvBoard: RecyclerView
    private lateinit var game: Gamer
    private var boardSize: BoardSize = BoardSize.EASY
    private var bindGame: FragmentPlayGameBinding? = null
    private lateinit var mContext: Context
    lateinit var timer: CountDownTimer


    override fun onAttach(context: Context) {
        super.onAttach(context)
        mContext=context
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_play_game, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val binding = FragmentPlayGameBinding.bind(view)
        bindGame = binding
        rvBoard = bindGame!!.rvBoard
        setUpBoard()

        timer = object: CountDownTimer(60000, 1000) {
            override fun onTick(millisUntilFinished: Long) {
                var diff = millisUntilFinished
                val secondsInMilli: Long = 1000
                val elapsedSeconds = diff / secondsInMilli
                bindGame!!.titleGame.text = elapsedSeconds.toString()
            }

            override fun onFinish() {
                timer.cancel()
                Toast.makeText(mContext, "You lose!", Toast.LENGTH_SHORT).show()
                findNavController().navigate(R.id.action_playGame_to_gamerMenu)
            }
        }
        timer.start()

        requireActivity()
            .onBackPressedDispatcher
            .addCallback(viewLifecycleOwner, object : OnBackPressedCallback(true) {
                override fun handleOnBackPressed() {
                    Toast.makeText(mContext, "You can't go back! Your task is at work!", Toast.LENGTH_SHORT).show()
                }
            }
            )
    }


    private fun setUpBoard() {


        game = Gamer(boardSize)

        adapter =  AdapterForGame(mContext, boardSize, game.cards, object : AdapterForGame.CardClickListener {
            override fun onCardClicked(position: Int) {
                updateGameWithFlip(position)
            }

        })
        rvBoard.adapter = adapter
        rvBoard.setHasFixedSize(true);
        rvBoard.layoutManager = GridLayoutManager(mContext, boardSize.getWidth())

    }

    @SuppressLint("NotifyDataSetChanged")
    private fun updateGameWithFlip(position: Int) {

        if(game.flipperCard(position)){

            if(game.winGame()){
                Toast.makeText(mContext, "You win!", Toast.LENGTH_SHORT).show()
                findNavController().navigate(R.id.action_playGame_to_gamerMenu)
            }
        }
        adapter.notifyDataSetChanged()

    }

}