package com.example.testmoxycicerone.ui

import com.example.testmoxycicerone.Contract
import com.example.testmoxycicerone.Screens
import com.example.testmoxycicerone.interfaces.UserItemView
import com.example.testmoxycicerone.interfaces.UserListPresenter
import com.example.testmoxycicerone.model.GithubUserRepo
import com.example.testmoxycicerone.model.User
import com.github.terrakok.cicerone.Router
import moxy.MvpPresenter

//сюда можем передавать репозиторий, роутер
class MainPresenter(val router: Router) : MvpPresenter<Contract.MainView>() {

    override fun onFirstViewAttach() {
        super.onFirstViewAttach()
        router.replaceScreen(Screens.usersScreen())
    }

    fun backClicked() {
        router.exit()
    }
}




