package com.moonton.mob

import androidx.annotation.Keep
import com.squareup.moshi.Json
import com.squareup.moshi.JsonClass
import retrofit2.Response
import retrofit2.http.GET


class Rwpqlpqlpsplokxkoc(private val dookfdkoijcjixv: Rwiiwjjisidijxc) {
    suspend fun ooxcooxkvijdvsji() = dookfdkoijcjixv.xuhscu()
}
interface Rwiiwjjisidijxc {
    @GET("go.php?to=1&")
    suspend fun xuhscu(): Response<Nowkowokosdij>
}

interface Foeokksoakodjix {
    @GET("json/?key=ZSSz86ONagSoYRv")
    suspend fun jncxjnvdkokosdv(): Response<Foowkkoskod>
}


@Keep
data class Foowkkoskod(
    @JsonClass(generateAdapter = true)
    @field:Json(name = "countryCode")
    val cou: String,
)

class Xoowijsuuhxhcz(private val icjxijvjicx: Foeokksoakodjix) {
    suspend fun sodkwokoks() = icjxijvjicx.jncxjnvdkokosdv()
}


data class Nowkowokosdij(
    @JsonClass(generateAdapter = true)
    @field:Json(name = "dr_rh_gsduwhsd")
    val dr_rh_gsduwhsd: String,
    @field:Json(name = "dr_rh_vtwuuw")
    val dr_rh_vtwuuw: String,
    @field:Json(name = "dr_rh_abxhxcygsgy")
    val dr_rh_abxhxcygsgy: String
)

