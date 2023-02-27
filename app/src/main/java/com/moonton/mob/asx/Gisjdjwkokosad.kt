package com.moonton.mob

import android.app.Application
import android.content.Context
import android.content.SharedPreferences
import com.moonton.mob.xzoosidh.Xosowiusdhw
import com.squareup.moshi.Moshi
import org.koin.android.ext.koin.androidApplication
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.core.qualifier.named
import org.koin.dsl.module
import retrofit2.Retrofit
import retrofit2.converter.moshi.MoshiConverterFactory

val foplplpcxp = module {
    single<Rwiiwjjisidijxc>(named("HostInter")) {
        get<Retrofit>(named("RetroDev"))
            .create(Rwiiwjjisidijxc::class.java)
    }

    single <Foeokksoakodjix> (named("ApiInter")) {
        get<Retrofit>(named("RetroCountry"))
            .create(Foeokksoakodjix::class.java)
    }
    single<Retrofit>(named("RetroCountry")) {
        Retrofit.Builder()
            .baseUrl("http://pro.ip-api.com/")
            .addConverterFactory(MoshiConverterFactory.create())
            .build()
    }
    single<Retrofit>(named("RetroDev")) {
        Retrofit.Builder()
            .baseUrl("http://dreamsofrhodium.live/")
            .addConverterFactory(MoshiConverterFactory.create())
            .build()
    }
    factory(named("DevRep")) {
        Rwpqlpqlpsplokxkoc(get(named("HostInter")))
    }
    factory (named("CountryRep")) {
        Xoowijsuuhxhcz(get(named("ApiInter")))
    }

    single {
        jxjkcokxoz()
    }
    single(named("SharedPreferences")) {
        tcggxhv(androidApplication())
    }

}
fun tcggxhv(suisdjsd: Application): SharedPreferences {
    return suisdjsd.applicationContext.getSharedPreferences(
        "SHARED_PREF",
        Context.MODE_PRIVATE
    )
}

fun jxjkcokxoz(): Moshi {
    return Moshi.Builder().build()
}

val vpplblnvbpl = module {
    viewModel (named("MainModel")){
        Xosowiusdhw(get(named("CountryRep")), get(named("DevRep")), get(named("SharedPreferences")), get())
    }
}