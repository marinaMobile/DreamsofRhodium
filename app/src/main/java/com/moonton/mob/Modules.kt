package com.moonton.mob

import android.app.Application
import android.content.Context
import android.content.SharedPreferences
import com.squareup.moshi.Moshi
import org.koin.android.ext.koin.androidApplication
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.core.qualifier.named
import org.koin.dsl.module
import retrofit2.Retrofit
import retrofit2.converter.moshi.MoshiConverterFactory

val appModule = module {
    single<HostInterface>(named("HostInter")) {
        get<Retrofit>(named("RetroDev"))
            .create(HostInterface::class.java)
    }

    single <ApiInterface> (named("ApiInter")) {
        get<Retrofit>(named("RetroCountry"))
            .create(ApiInterface::class.java)
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
        DevRepo(get(named("HostInter")))
    }
    factory (named("CountryRep")) {
        CountryRepo(get(named("ApiInter")))
    }

    single {
        provideMoshi()
    }
    single(named("SharedPreferences")) {
        provideSharedPref(androidApplication())
    }

}
fun provideSharedPref(app: Application): SharedPreferences {
    return app.applicationContext.getSharedPreferences(
        "SHARED_PREF",
        Context.MODE_PRIVATE
    )
}

fun provideMoshi(): Moshi {
    return Moshi.Builder().build()
}

val viewModelModule = module {
    viewModel (named("MainModel")){
        ViModd(get(named("CountryRep")), get(named("DevRep")), get(named("SharedPreferences")), get())
    }
}