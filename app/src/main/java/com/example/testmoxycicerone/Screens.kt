package com.example.testmoxycicerone

import com.example.testmoxycicerone.model.User
import com.example.testmoxycicerone.ui.ProfileUserFragment
import com.example.testmoxycicerone.ui.UsersListFragment
import com.github.terrakok.cicerone.androidx.FragmentScreen

object Screens {
    fun usersScreen() = FragmentScreen { UsersListFragment.newInstance() }
    fun userProfileScreen(userId: Int) = FragmentScreen { ProfileUserFragment.newInstance(userId) }

}