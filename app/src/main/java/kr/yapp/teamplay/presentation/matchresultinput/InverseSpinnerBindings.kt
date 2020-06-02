package kr.yapp.teamplay.presentation.matchresultinput

import android.widget.Spinner
import androidx.databinding.BindingAdapter
import androidx.databinding.InverseBindingAdapter
import androidx.databinding.InverseBindingListener
import kr.yapp.teamplay.presentation.matchresultinput.SpinnerExtensions.getSpinnerValue
import kr.yapp.teamplay.presentation.matchresultinput.SpinnerExtensions.setSpinnerInverseBindingListener
import kr.yapp.teamplay.presentation.matchresultinput.SpinnerExtensions.setSpinnerValue

class InverseSpinnerBindings {

    @BindingAdapter("selectedValue")
    fun Spinner.setSelectedValue(selectedValue: Any?) {
        setSpinnerValue(selectedValue)
    }

    @BindingAdapter("selectedValueAttrChanged")
    fun Spinner.setInverseBindingListener(inverseBindingListener: InverseBindingListener?) {
        setSpinnerInverseBindingListener(inverseBindingListener)
    }

    companion object InverseSpinnerBindings {

        @JvmStatic
        @InverseBindingAdapter(attribute = "selectedValue", event = "selectedValueAttrChanged")
        fun Spinner.getSelectedValue(): Any? {
            return getSpinnerValue()
        }
    }
}