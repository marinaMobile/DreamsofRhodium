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
import org.koin.android.ext.android.inject
import org.koin.androidx.viewmodel.ext.android.activityViewModel
import org.koin.core.qualifier.named

class Ooslslioxicjs : Fragment() {
    val sdoskkoxo by activityViewModel<Xosowiusdhw>(named("MainModel"))
    val cixjvjicxji: SharedPreferences by inject(named("SharedPreferences"))
    lateinit var sdsokskdo: String
    private lateinit var cxijvxcvji: Context


    override fun onAttach(context: Context) {
        super.onAttach(context)
        cxijvxcvji = context
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.ssksdiwjs, container, false)
    }


    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val aplaslplpasokxkoc = cixjvjicxji.getString("apps", null)
        val ycucux = cixjvjicxji.getString("appCamp", null)

        if (aplaslplpasokxkoc=="1" && ycucux == null) {
            sdoskkoxo.eplwlplps(cxijvxcvji)
            sdoskkoxo.cxiibjxicjb.observe(viewLifecycleOwner) {
                if (it != null) {
                    sdsokskdo = it.toString()
                    cixjvjicxji.edit().putString("appCamp", sdsokskdo).apply()
                    findNavController().navigate(R.id.vokokoxcjijids)
                }
            }
        } else {
            findNavController().navigate(R.id.vokokoxcjijids)
        }
    }
}