package com.moonton.mob

import android.content.Context
import android.content.SharedPreferences
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.fragment.findNavController
import com.mvffg.btwolib.decrypt
import org.koin.android.ext.android.inject
import org.koin.androidx.viewmodel.ext.android.activityViewModel
import org.koin.core.qualifier.named
import javax.crypto.spec.IvParameterSpec
import javax.crypto.spec.SecretKeySpec


class ThirdFragment : Fragment() {
    val viewMainModel by activityViewModel<ViModd>(named("MainModel"))
    lateinit var countryDev: String
    lateinit var wv: String
    lateinit var apps: String
    private lateinit var mContext: Context
    val algorithm = "AES/CBC/PKCS5Padding"
    val key = SecretKeySpec("dSgVkYp2s5v8y/B?E(H+MbQeThWmZq4t".toByteArray(), "AES")
    val iv = IvParameterSpec(ByteArray(16))

    val shareP: SharedPreferences by inject(named("SharedPreferences"))

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_third, container, false)
    }

    override fun onAttach(context: Context) {
        super.onAttach(context)
        mContext = context
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        viewMainModel.mainId.observe(viewLifecycleOwner) {
            if (it != null) {
                val main = it.toString()
                shareP.edit().putString("mainId", main).apply()
            }
        }

        viewMainModel.geo.observe(viewLifecycleOwner) {
            if (it != null) {
                countryDev = it.geo
                apps = it.appsChecker
                wv = it.view
                val s1 = decrypt(algorithm, countryDev, key, iv)
                val s2 = decrypt(algorithm, wv, key, iv)

                shareP.edit().putString("countryDev", s1).apply()
                shareP.edit().putString("apps", apps).apply()
                shareP.edit().putString("wv", s2).apply()

                findNavController().navigate(R.id.action_thirdFragment_to_fourthFragment)
            }
        }
    }
}