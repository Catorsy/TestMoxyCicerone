package com.example.testmoxycicerone.ui

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.testmoxycicerone.App
import com.example.testmoxycicerone.databinding.UserProfileBinding
import com.example.testmoxycicerone.interfaces.ProfileUserView
import com.example.testmoxycicerone.model.User
import com.github.terrakok.cicerone.Router
import moxy.MvpAppCompatFragment
import moxy.ktx.moxyPresenter

class ProfileUserFragment : MvpAppCompatFragment(), ProfileUserView {
    companion object {
        fun newInstance() = ProfileUserFragment()
    }

    private lateinit var binding: UserProfileBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?
    ): View? {
        binding = UserProfileBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun setUserData(user: User) = with(binding){
        loginProfileTextView.text = user.login
        urlProfileTextView.text = user?.url
        idProfileTextView.text = user.id?.toString()
    }
}

