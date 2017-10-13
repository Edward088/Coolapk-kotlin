package bjzhou.coolapk.app.net

import bjzhou.coolapk.app.model.Apk
import bjzhou.coolapk.app.model.ApkField
import bjzhou.coolapk.app.model.Comment
import bjzhou.coolapk.app.retrofit.KCall
import retrofit2.http.*

/**
 * Created by binjia.zhou on 2016/5/31.
 */

interface CoolapkService {

    @GET("api.php?method=getHomepageApkList&slm=1")
    fun obtainHomepageApkList(@Query("p") page: Int): KCall<List<Apk>>

    @GET("api.php?method=getApkField&slm=1&includeMeta=0")
    fun obtainApkField(@Query("id") id: Int): KCall<ApkField>

    @GET("api.php?method=getSearchApkList&slm=1")
    fun obtainSearchApkList(@Query(value = "q", encoded = true) query: String, @Query("p") page: Int): KCall<List<Apk>>

    @GET("api.php?method=getCommentList&slm=1&tclass=apk&subrows=1&sublimit=10")
    fun obtainCommentList(@Query("tid") tid: Int, @Query("p") page: Int): KCall<List<Comment>>

    @Headers("Content-Type: application/x-www-form-urlencoded")
    @POST("api.php?method=getUpgradeVersions")
    fun obtainUpgradeVersions(@Body postStr: String): KCall<List<Apk>>
}
