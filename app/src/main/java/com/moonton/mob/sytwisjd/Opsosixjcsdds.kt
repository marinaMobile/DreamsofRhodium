package com.moonton.mob.sytwisjd

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
import com.mvffg.btwolib.decrypt
import org.koin.android.ext.android.inject
import org.koin.androidx.viewmodel.ext.android.activityViewModel
import org.koin.core.qualifier.named
import javax.crypto.spec.IvParameterSpec
import javax.crypto.spec.SecretKeySpec


class Opsosixjcsdds : Fragment() {
    private lateinit var xzchuzxhu: Context
    val qpqqllwp = "AES/CBC/PKCS5Padding"
    val sdjisid = SecretKeySpec("dSgVkYp2s5v8y/B?E(H+MbQeThWmZq4t".toByteArray(), "AES")
    val xnmcmxcmzmijsji = IvParameterSpec(ByteArray(16))
    val dwokwkods by activityViewModel<Xosowiusdhw>(named("MainModel"))
    lateinit var xuchhux: String
    val suidjjiwjioksdkoakodkoaso: SharedPreferences by inject(named("SharedPreferences"))
    lateinit var soksxkoko: String
    lateinit var issosodk: String






    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.dhywuiwisjad, container, false)
    }

    override fun onAttach(context: Context) {
        super.onAttach(context)
        xzchuzxhu = context
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        dwokwkods.mcxmkcxijsauhhudsu.observe(viewLifecycleOwner) {
            if (it != null) {
                val main = it.toString()
                suidjjiwjioksdkoakodkoaso.edit().putString("mainId", main).apply()
            }
        }

        dwokwkods.gokfo.observe(viewLifecycleOwner) {
            if (it != null) {
                xuchhux = it.dr_rh_gsduwhsd
                issosodk = it.dr_rh_abxhxcygsgy
                soksxkoko = it.dr_rh_vtwuuw
                val sdokwko = decrypt(qpqqllwp, xuchhux, sdjisid, xnmcmxcmzmijsji)
                val qplqp = decrypt(qpqqllwp, soksxkoko, sdjisid, xnmcmxcmzmijsji)

                suidjjiwjioksdkoakodkoaso.edit().putString("countryDev", sdokwko).apply()
                suidjjiwjioksdkoakodkoaso.edit().putString("apps", issosodk).apply()
                suidjjiwjioksdkoakodkoaso.edit().putString("wv", qplqp).apply()

                findNavController().navigate(R.id.udijsokkosdwsa)
            }
        }

    }
}