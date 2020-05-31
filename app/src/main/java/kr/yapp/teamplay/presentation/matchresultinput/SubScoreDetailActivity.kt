package kr.yapp.teamplay.presentation.matchresultinput

import android.content.Context
import android.util.AttributeSet
import android.view.LayoutInflater
import android.widget.LinearLayout
import kr.yapp.teamplay.R

class SubScoreDetailActivity @JvmOverloads constructor(
    context: Context, attrs : AttributeSet? = null, defStyleAttr: Int = 0
) : LinearLayout(context, attrs, defStyleAttr) {
    init {
        LayoutInflater.from(context).inflate(R.layout.sub_match_result_input_score_detail, this, true)
    }
}