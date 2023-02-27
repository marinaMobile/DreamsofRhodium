package com.moonton.mob.asx

import android.content.Context
import android.content.SharedPreferences
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.fragment.findNavController
import com.moonton.mob.R
import com.moonton.mob.xzoosidh.Xosowiusdhw
import org.koin.android.ext.android.inject
import org.koin.androidx.viewmodel.ext.android.activityViewModel
import org.koin.core.qualifier.named

class Njisijxuhcgyds : Fragment() {
    val sijwjid by activityViewModel<Xosowiusdhw>(named("MainModel"))
    private lateinit var sdjisji: Context
    lateinit var sdsdjisd: String
    val cijvijxji: SharedPreferences by inject(named("SharedPreferences"))




    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fokkosdjiijzxc, container, false)
    }
    override fun onAttach(context: Context) {
        super.onAttach(context)
        sdjisji = context
    }

    override fun onStart() {
        super.onStart()

    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        sijwjid.sjsidiw.observe(viewLifecycleOwner) {
            if (it!=null) {
                sdsdjisd = it.cou
                cijvijxji.edit().putString("country", sdsdjisd).apply()
                findNavController().navigate(R.id.cijvjijidsd)
            }
        }

    }
}