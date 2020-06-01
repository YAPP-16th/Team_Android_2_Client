package kr.yapp.teamplay.presentation.matchresultinput

import android.widget.Spinner
import androidx.databinding.BindingAdapter
import kr.yapp.teamplay.presentation.matchresultinput.SpinnerExtensions.setSpinnerEntries
import kr.yapp.teamplay.presentation.matchresultinput.SpinnerExtensions.setSpinnerItemSelectedListener
import kr.yapp.teamplay.presentation.matchresultinput.SpinnerExtensions.setSpinnerValue

class SpinnerBindings {

    @BindingAdapter("entries")
    fun Spinner.setEntries(entries: List<Any>?) {
        setSpinnerEntries(entries)
    }

    @BindingAdapter("onItemSelected")
    fun Spinner.setItemSelectedListener(itemSelectedListener: SpinnerExtensions.ItemSelectedListener?) {
        setSpinnerItemSelectedListener(itemSelectedListener)
    }

    @BindingAdapter("newValue")
    fun Spinner.setNewValue(newValue: Any?) {
        setSpinnerValue(newValue)
    }
}
