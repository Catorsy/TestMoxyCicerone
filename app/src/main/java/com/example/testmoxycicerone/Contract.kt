package com.example.testmoxycicerone

import moxy.MvpPresenter
import moxy.MvpView
import moxy.viewstate.strategy.AddToEndSingleStrategy
import moxy.viewstate.strategy.StateStrategyType

class Contract {

    @StateStrategyType(AddToEndSingleStrategy::class)
    interface View: MvpView {
        fun setButtonOneText(text: String)
        fun setButtonTwoText(text: String)
        fun setButtonThreeText(text: String)
    }

    abstract class Presenter: MvpPresenter<View>(){

    }
}