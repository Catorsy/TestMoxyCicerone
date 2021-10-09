package com.example.testmoxycicerone.ui

import com.example.testmoxycicerone.Contract
import com.github.terrakok.cicerone.Router
import moxy.MvpPresenter

//сюда можем передавать либо репозиторий, либо роутер
class MainPresenter(private val router: Router): MvpPresenter<Contract.View>() {
    override fun onFirstViewAttach() {
        super.onFirstViewAttach()

    }
}