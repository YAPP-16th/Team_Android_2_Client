/*
 * Created by Lee Oh Hyoung on 2020/05/01 .. 
 */
package kr.yapp.teamplay.util

import android.content.res.Resources
import java.text.NumberFormat
import java.util.*

/**
 * String 내의 값을 ,가 들어간 값으로 수정
 *
 * @param value 입력데이터
 * @return
 */
fun Int.convertPriceFormat(): String {
    val format = NumberFormat.getCurrencyInstance(Locale.KOREA)
    val sellPrice = format.format(this.toLong())
    return sellPrice.substring(1)
}

/**
 * Dp값을 PX로 변환
 */
fun Int.dpToPixel(): Int =
    (this * Resources.getSystem().displayMetrics.density).toInt()