package kr.yapp.teamplay.presentation.matchresultinput

import android.content.Context
import android.util.AttributeSet
import android.view.LayoutInflater
import android.view.View
import android.widget.LinearLayout
import kr.yapp.teamplay.R

class SubPersonalRecordActivity @JvmOverloads constructor(
    context: Context, attrs: AttributeSet? = null, defStyleAttr: Int = 0
) : LinearLayout(context, attrs, defStyleAttr){
    init {
        LayoutInflater.from(context).inflate(R.layout.sub_match_result_input_personal_record, this, true)
    }
}