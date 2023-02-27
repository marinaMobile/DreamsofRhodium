package com.moonton.mob.novel

import android.app.AlertDialog
import android.content.Context
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.fragment.findNavController
import com.moonton.mob.R
import com.moonton.mob.databinding.FragmentGamerMenuBinding


class GamerMenu : Fragment() {

    private var bindMenu: FragmentGamerMenuBinding? = null
    private lateinit var mCont: Context


    override fun onAttach(context: Context) {
        super.onAttach(context)
        mCont = context
    }


    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val binding = FragmentGamerMenuBinding.bind(view)
        bindMenu = binding
        bindMenu!!.startGameBtn.setOnClickListener {
            findNavController().navigate(R.id.action_gamerMenu_to_playGame)
        }
        bindMenu!!.rulesGameBtn.setOnClickListener {
            findNavController().navigate(R.id.action_gamerMenu_to_rulesFrag)
        }
        bindMenu!!.exitGameBtn.setOnClickListener {
            val builder = AlertDialog.Builder(activity)
            //set title for alert dialog
            builder.setTitle("Are you sure?")
            //set message for alert dialog
            builder.setMessage("Are you sure you want to exit the game?")
            builder.setIcon(android.R.drawable.ic_dialog_info)

            //performing positive action
            builder.setPositiveButton("Yes"){dialogInterface, which ->
                requireActivity().finish()
                System.out.close()
            }

            builder.setNegativeButton("No"){dialogInterface, which ->

            }

            // Create the AlertDialog
            val alertDialog: AlertDialog = builder.create()
            // Set other dialog properties
            alertDialog.setCancelable(true)
            alertDialog.show()
        }
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_gamer_menu, container, false)
    }

    override fun onDestroyView() {
        // Consider not storing the binding instance in a field
        // if not needed.
        bindMenu = null
        super.onDestroyView()
    }
}