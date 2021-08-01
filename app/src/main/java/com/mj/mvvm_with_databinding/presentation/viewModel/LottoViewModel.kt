package com.mj.mvvm_with_databinding.presentation.viewModel

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.mj.mvvm_with_databinding.data.model.LottoEntity
import com.mj.mvvm_with_databinding.data.repository.LottoRepository

class LottoViewModel: ViewModel() {

    val lottoInfo = MutableLiveData<String>()
    val drwNoString = MutableLiveData<String>()

    /**
     * 로또 정보 조회
     * @param drwNo 회차
     */
    fun getLotto(){
        LottoRepository.getLottoInfo(drwNoString.value!!.toInt(), object : LottoRepository.GetDataCallBack<LottoEntity>{
            override fun onSuccess(data: LottoEntity?) {
                data?.let {
                    val results = "${it.drwNo}회차 당첨번호 : " +
                            "${it.drwtNo1}, ${it.drwtNo2}, ${it.drwtNo3}, ${it.drwtNo4}, ${it.drwtNo5}, ${it.drwtNo6} + ${it.bnusNo}"

                    println(drwNoString.value)
                    lottoInfo.value = results
                }
            }

            override fun onFailure(throwable: Throwable) {
                throwable.printStackTrace()
            }

        })
    }

}