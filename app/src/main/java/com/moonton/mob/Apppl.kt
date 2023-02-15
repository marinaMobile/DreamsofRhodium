package com.moonton.mob

import android.app.Application
import android.content.Context
import android.provider.Settings
import com.my.tracker.MyTracker
import com.onesignal.OneSignal
import org.koin.android.ext.koin.androidContext
import org.koin.android.ext.koin.androidLogger
import org.koin.core.context.GlobalContext
import org.koin.core.logger.Level

class Apppl : Application() {

    override fun onCreate() {
        super.onCreate()
        OneSignal.initWithContext(this)
        OneSignal.setAppId("b82c204b-9ea3-4952-8537-cafc6445ba47")
        MyTracker.initTracker("17882311308645026632", this)

        val trackerConfig = MyTracker.getTrackerConfig()
        trackerConfig.isTrackingLaunchEnabled = true
        val instID = MyTracker.getInstanceId(this)
        val shP = getSharedPreferences("SHARED_PREF", Context.MODE_PRIVATE)
        shP.edit().putString("instId", instID).apply()

        GlobalContext.startKoin {
            androidLogger(Level.DEBUG)
            androidContext(this@Apppl)
            modules(
                listOf(
                    appModule, viewModelModule
                )
            )
        }
    }
}