package com.example.testmoxycicerone

import android.app.Application
import com.example.testmoxycicerone.model.GithubUserRepo
import com.github.terrakok.cicerone.Cicerone

class App : Application() {

    companion object {
        internal lateinit var INSTANCE: App
            private set
        val userRepo = GithubUserRepo()
        private val cicerone = Cicerone.create()
        val router get() = cicerone.router
        val navigatorHolder get() = cicerone.getNavigatorHolder() //это чтобы с фрагментами работать можно было
    }
}