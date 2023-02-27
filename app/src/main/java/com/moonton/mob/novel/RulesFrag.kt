package com.moonton.mob.novel

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.activity.OnBackPressedCallback
import androidx.navigation.fragment.findNavController
import com.moonton.mob.R
import com.moonton.mob.databinding.FragmentGamerMenuBinding
import com.moonton.mob.databinding.FragmentRulesBinding

class RulesFrag : Fragment() {

    lateinit var bindRules: FragmentRulesBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_rules, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val binding = FragmentRulesBinding.bind(view)
        bindRules = binding

        bindRules.okBtn.setOnClickListener {
            findNavController().navigate(R.id.action_rulesFrag_to_gamerMenu)
        }

        requireActivity()
            .onBackPressedDispatcher
            .addCallback(viewLifecycleOwner, object : OnBackPressedCallback(true) {
                override fun handleOnBackPressed() {
             findNavController().navigate(R.id.action_rulesFrag_to_gamerMenu)
                }
            }
            )
    }

}