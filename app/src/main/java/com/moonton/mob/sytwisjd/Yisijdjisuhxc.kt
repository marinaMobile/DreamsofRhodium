package com.moonton.mob.sytwisjd

import android.app.Application
import android.content.Context
import com.moonton.mob.foplplpcxp
import com.moonton.mob.vpplblnvbpl
import com.my.tracker.MyTracker
import com.onesignal.OneSignal
import org.koin.android.ext.koin.androidContext
import org.koin.android.ext.koin.androidLogger
import org.koin.core.context.GlobalContext
import org.koin.core.logger.Level

class Yisijdjisuhxc : Application() {

    override fun onCreate() {
        super.onCreate()
        OneSignal.initWithContext(this)
        OneSignal.setAppId("b82c204b-9ea3-4952-8537-cafc6445ba47")
        MyTracker.initTracker("17882311308645026632", this)

        val siodosdkoaskojixc = MyTracker.getTrackerConfig()
        siodosdkoaskojixc.isTrackingLaunchEnabled = true
        val cxiovjixcvi = MyTracker.getInstanceId(this)
        val soowplsdlp = getSharedPreferences("SHARED_PREF", Context.MODE_PRIVATE)
        soowplsdlp.edit().putString("instId", cxiovjixcvi).apply()

        GlobalContext.startKoin {
            androidLogger(Level.DEBUG)
            androidContext(this@Yisijdjisuhxc)
            modules(
                listOf(
                    foplplpcxp, vpplblnvbpl
                )
            )
        }
    }
}