package com.example.testmoxycicerone.ui

import com.example.testmoxycicerone.App
import com.example.testmoxycicerone.interfaces.ProfileUserView
import com.github.terrakok.cicerone.Router
import moxy.MvpPresenter

class UserProfilePresenter(val userId: Int? = null,
    val router: Router) : MvpPresenter<ProfileUserView>() {

    override fun onFirstViewAttach() {
        val currentUser = App.userRepo.getUsers().firstOrNull { it.id == userId }
        currentUser?.let {
            viewState.setProfileData(it)
        }
    }

    fun backPressed(): Boolean {
        router.exit()
        return true
    }
}