package com.moonton.mob.sytwisjd

import android.content.Intent
import android.content.SharedPreferences
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.mvffg.btwolib.BTwoLib
import org.koin.android.ext.android.inject
import org.koin.core.qualifier.named

class Daozkijsuhsd : AppCompatActivity() {

    lateinit var rpokfkodok: BTwoLib
    val xcjizjzoxko: SharedPreferences by inject(named("SharedPreferences"))
    private fun gokkoekookskoakosd(): String {
        val dokeok = getSharedPreferences("SP_WEBVIEW_PREFS", MODE_PRIVATE)
        val apalssakooask = xcjizjzoxko.getString("link", null)
        dokeok.edit().putString("SAVED_URL", apalssakooask).apply()
        return dokeok.getString("SAVED_URL", apalssakooask).toString()
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        rpokfkodok = BTwoLib(this@Daozkijsuhsd)
        setContentView(rpokfkodok)
        rpokfkodok.profiter(gokkoekookskoakosd())
    }
    override fun onActivityResult(fokdkosok: Int, sokwokso: Int, ycxvhuvc: Intent?) {
        super.onActivityResult(fokdkosok, sokwokso, ycxvhuvc)
        if (ycxvhuvc != null) {
            rpokfkodok.onActivityResult(fokdkosok, sokwokso, ycxvhuvc)
        }
    }

    override fun onBackPressed() {
        if (!rpokfkodok.onBackPressed()) {
            return
        }
        super.onBackPressed()
    }


}