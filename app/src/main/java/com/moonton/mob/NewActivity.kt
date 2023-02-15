package com.moonton.mob

import android.content.Intent
import android.content.SharedPreferences
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.mvffg.btwolib.BTwoLib
import com.onesignal.OneSignal
import org.json.JSONException
import org.json.JSONObject
import org.koin.android.ext.android.inject
import org.koin.core.qualifier.named

class NewActivity : AppCompatActivity() {

    lateinit var webbb: BTwoLib
    val shareP: SharedPreferences by inject(named("SharedPreferences"))


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        webbb = BTwoLib(this@NewActivity)
        setContentView(webbb)
        webbb.profiter(urlBuilder())
    }
    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        super.onActivityResult(requestCode, resultCode, data)
        if (data != null) {
            webbb.onActivityResult(requestCode, resultCode, data)
        }
    }

    override fun onBackPressed() {
        if (!webbb.onBackPressed()) {
            return
        }
        super.onBackPressed()
    }

    private fun urlBuilder(): String {
        val spoon = getSharedPreferences("SP_WEBVIEW_PREFS", MODE_PRIVATE)
        val link = shareP.getString("link", null)
        spoon.edit().putString("SAVED_URL", link).apply()
        return spoon.getString("SAVED_URL", link).toString()
    }
}