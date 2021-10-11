package com.example.testmoxycicerone.ui

import com.example.testmoxycicerone.interfaces.ProfileUserView
import com.example.testmoxycicerone.model.User
import com.github.terrakok.cicerone.Router
import moxy.MvpPresenter

abstract class UserProfilePresenter(val router: Router) : MvpPresenter<ProfileUserView>() {
        abstract fun onUserProfile(user: User)
}