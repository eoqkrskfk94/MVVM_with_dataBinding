package com.mj.mvvm_with_databinding.data.repository

import com.mj.mvvm_with_databinding.data.model.LottoEntity
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Query

/**
 * Retrofit Interface
 */
interface LottoService {

    /**
     * 로또 정보 조회
     */
    @GET("/common.do?method=getLottoNumber")
    fun getLottoInfo(@Query("drwNo") drwNo: Int): Call<LottoEntity>

}