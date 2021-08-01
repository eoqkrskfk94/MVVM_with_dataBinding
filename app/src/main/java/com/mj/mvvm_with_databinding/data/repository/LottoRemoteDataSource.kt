package com.mj.mvvm_with_databinding.data.repository

import com.mj.mvvm_with_databinding.data.model.LottoEntity
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

/**
 * 로또 조회 API Remote DataSource
 */
object LottoRemoteDataSource {

    private val retrofit = Retrofit.Builder()
        .baseUrl("https://www.dhlottery.co.kr")
        .addConverterFactory(GsonConverterFactory.create())
        .build()

    private val lottoService = retrofit.create(LottoService::class.java)

    /**
     * 로또 당첨 정보 조회
     */
    fun getLottoInfo(drwNo: Int, callback: LottoRepository.GetDataCallBack<LottoEntity>) {

        lottoService.getLottoInfo(drwNo).enqueue(object: Callback<LottoEntity>{
            override fun onResponse(call: Call<LottoEntity>, response: Response<LottoEntity>) {
                if(response.isSuccessful) {
                    callback.onSuccess(response.body())
                }
            }

            override fun onFailure(call: Call<LottoEntity>, t: Throwable) {
                callback.onFailure(t)
            }

        })

    }

}