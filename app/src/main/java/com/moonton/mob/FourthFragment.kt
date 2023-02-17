package com.moonton.mob

import android.content.Context
import android.content.SharedPreferences
import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.navigation.fragment.findNavController
import org.koin.android.ext.android.inject
import org.koin.androidx.viewmodel.ext.android.activityViewModel
import org.koin.core.qualifier.named

class FourthFragment : Fragment() {
    val viewMainModel by activityViewModel<ViModd>(named("MainModel"))
    val shareP: SharedPreferences by inject(named("SharedPreferences"))
    lateinit var appCamp: String
    private lateinit var mContecxt: Context


    override fun onAttach(context: Context) {
        super.onAttach(context)
        mContecxt = context
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_fourth, container, false)
    }

//    override fun onStart() {
//        super.onStart()
//
//
//    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val checkFly = shareP.getString("apps", null)
        val appsCamp = shareP.getString("appCamp", null)

        if (checkFly=="1" && appsCamp == null) {
            viewMainModel.convers(mContecxt)
            viewMainModel.appsData.observe(viewLifecycleOwner) {
                if (it != null) {
                    appCamp = it.toString()
                    shareP.edit().putString("appCamp", appCamp).apply()
                    findNavController().navigate(R.id.action_fourthFragment_to_fifthFragment)
                }
            }
        } else {
            findNavController().navigate(R.id.action_fourthFragment_to_fifthFragment)
        }
    }
}