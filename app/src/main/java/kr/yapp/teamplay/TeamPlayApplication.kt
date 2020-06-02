package kr.yapp.teamplay

import android.app.Application
import androidx.databinding.DataBindingUtil
import kr.yapp.teamplay.presentation.matchresultinput.BindingComponent

/**
 * Created by Lee Oh Hyoung on 2020/03/29.
 */
class TeamPlayApplication : Application() {

    override fun onCreate() {
        super.onCreate()
        DataBindingUtil.setDefaultComponent(BindingComponent())
    }

}
