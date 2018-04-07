package id.co.imastudio.driverakbbontang.Service


import id.kompas.youtubeapikotlinadmob.model.ResponseYOUTUBE
import io.reactivex.Observable
import okhttp3.MultipartBody
import okhttp3.RequestBody
import retrofit2.Call
import retrofit2.http.*


/**
 * Created by nandoseptianhusni on 1/8/18.
 */
interface ApiService {


    @GET("youtube/v3/search")
    fun getyoutube(@Query("part")spinnet : String,
                   @Query("maxResults") max : String,
                   @Query("q") q : String,

                   @Query("regionCode")region : String,
                   @Query("key") key : String) : Observable<ResponseYOUTUBE>



}