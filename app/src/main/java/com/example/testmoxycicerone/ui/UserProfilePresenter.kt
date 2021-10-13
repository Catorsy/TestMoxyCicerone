package com.example.testmoxycicerone.ui

import com.example.testmoxycicerone.interfaces.ProfileUserView
import com.example.testmoxycicerone.model.GithubUserRepo
import com.example.testmoxycicerone.model.User
import com.github.terrakok.cicerone.Router
import moxy.MvpPresenter

class UserProfilePresenter(val userId: Int? = null,
    private val githubUsersRepo: GithubUserRepo,
    val router: Router) : MvpPresenter<ProfileUserView>() {

    override fun onFirstViewAttach() {
        val currentUser = githubUsersRepo.getUsers().firstOrNull { it.id == userId }
        currentUser?.let {
            viewState.setProfileData(it)
        }
    }

    fun backPressed(): Boolean {
        router.exit()
        return true
    }
}