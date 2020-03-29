package kr.yapp.teamplay.data

import io.reactivex.Single
import kr.yapp.teamplay.data.Comment

/**
 * Created by Lee Oh Hyoung on 2020/03/29.
 */
interface MainRepository {

    fun getComments(): Single<List<Comment>>

}
