package com.example.testmoxycicerone.ui

import com.example.testmoxycicerone.Contract
import com.example.testmoxycicerone.Screens
import com.example.testmoxycicerone.interfaces.UserItemView
import com.example.testmoxycicerone.interfaces.UserListPresenter
import com.example.testmoxycicerone.model.GithubUserRepo
import com.example.testmoxycicerone.model.User
import com.github.terrakok.cicerone.Router
import moxy.MvpPresenter

class UsersPresenter(val userRepo: GithubUserRepo, val router: Router): MvpPresenter<Contract.View>() {

    class UsersListPresenter : UserListPresenter {
        val users = mutableListOf<User>()
        override var itemClickListener: ((UserItemView) -> Unit)? = null

        override fun bindView(view: UserItemView) {
            val user = users[view.pos]
            view.setLogin(user.login)
            user.url?.let { view.setUrl(it) }
        }

        override fun getCount(): Int {
            return users.size
        }
    }

    val usersListPresenter = UsersListPresenter()

    override fun onFirstViewAttach() {
        super.onFirstViewAttach()
        router.replaceScreen(Screens.usersScreen())
        viewState.init()
        loadData()
            //listen()
    }

    private fun listen() {
        val users = userRepo.getUsers()
        usersListPresenter.itemClickListener = { itemView -> router.navigateTo(Screens.userProfileScreen()) }
    }

    private fun loadData() {
        val users = userRepo.getUsers()
        usersListPresenter.users.addAll(users)
        viewState.updateList()
    }

    fun backPressed(): Boolean {
        router.exit()
        return true
    }
}


