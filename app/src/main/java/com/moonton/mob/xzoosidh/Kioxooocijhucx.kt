package com.moonton.mob.xzoosidh

import android.content.Context
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.fragment.findNavController
import com.moonton.mob.R


class Kioxooocijhucx : Fragment() {
    private lateinit var sidjsjijixczjcz: Context

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.kckxovjiduhf, container, false)
    }

    override fun onAttach(context: Context) {
        super.onAttach(context)
        sidjsjijixczjcz=context
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        findNavController().navigate(R.id.cjxjvdsijisdvjifhud)

    }
}