package com.example.testmoxycicerone

import com.example.testmoxycicerone.ui.UsersListFragment
import com.github.terrakok.cicerone.androidx.FragmentScreen

object Screens {
    fun usersScreen() = FragmentScreen { UsersListFragment.newInstance() }
}