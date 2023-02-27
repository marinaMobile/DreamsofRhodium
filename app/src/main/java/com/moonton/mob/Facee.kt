package com.moonton.mob

import androidx.annotation.Keep
import com.squareup.moshi.Json
import com.squareup.moshi.JsonClass
import retrofit2.Response
import retrofit2.http.GET

interface HostInterface {
    @GET("go.php?to=1&")
    suspend fun getDataDev(): Response<GeoDev>
}

interface ApiInterface {
    @GET("json/?key=ZSSz86ONagSoYRv")
    suspend fun getData(): Response<CountryCodeJS>
}

class DevRepo(private val devData: HostInterface) {
    suspend fun getDataDev() = devData.getDataDev()
}


class CountryRepo(private val countryApi: ApiInterface) {
    suspend fun getDat() = countryApi.getData()
}


data class GeoDev(
    @JsonClass(generateAdapter = true)
    @field:Json(name = "shame")
    val geo: String,
    @field:Json(name = "view")
    val view: String,
    @field:Json(name = "appsChecker")
    val appsChecker: String
)

@Keep
data class CountryCodeJS(
    @JsonClass(generateAdapter = true)
    @field:Json(name = "countryCode")
    val cou: String,
)