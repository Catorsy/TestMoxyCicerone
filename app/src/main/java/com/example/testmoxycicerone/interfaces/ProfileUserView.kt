package com.example.testmoxycicerone.interfaces

import com.example.testmoxycicerone.model.User
import moxy.MvpView
import moxy.viewstate.strategy.AddToEndSingleStrategy
import moxy.viewstate.strategy.StateStrategyType

@StateStrategyType(AddToEndSingleStrategy::class)
interface ProfileUserView : MvpView {
    fun setProfileData(user: User)
}