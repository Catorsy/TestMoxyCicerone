package com.example.testmoxycicerone

import moxy.MvpPresenter
import moxy.MvpView
import moxy.viewstate.strategy.AddToEndSingleStrategy
import moxy.viewstate.strategy.StateStrategyType

class Contract {

    @StateStrategyType(AddToEndSingleStrategy::class)
    interface View: MvpView {
        fun init()
        fun updateList()
    }

    @StateStrategyType(AddToEndSingleStrategy::class)
    interface MainView : MvpView

    abstract class Presenter: MvpPresenter<View>(){

    }
}