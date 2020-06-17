package kr.yapp.teamplay.presentation.matchresultinput

import androidx.databinding.DataBindingComponent

class BindingComponent : DataBindingComponent {
    override fun getSpinnerBindings(): SpinnerBindings {
        return SpinnerBindings()
    }

    override fun getInverseSpinnerBindings(): InverseSpinnerBindings {
        return InverseSpinnerBindings()
    }
}
