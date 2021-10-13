package com.example.testmoxycicerone.ui

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.os.bundleOf
import com.example.testmoxycicerone.App
import com.example.testmoxycicerone.databinding.UserProfileBinding
import com.example.testmoxycicerone.interfaces.BackButtonListener
import com.example.testmoxycicerone.interfaces.ProfileUserView
import com.example.testmoxycicerone.model.User
import moxy.MvpAppCompatFragment
import moxy.ktx.moxyPresenter

class ProfileUserFragment : MvpAppCompatFragment(), ProfileUserView, BackButtonListener {
    companion object {
        private const val MY_USER = "MY_USER_ID"
        private const val DEFAULT_INT = 0

        fun newInstance(userId: Int) =
            ProfileUserFragment().apply { arguments = bundleOf(MY_USER to userId) }
    }

    private val userId: Int? by lazy {
        arguments?.getInt(MY_USER, DEFAULT_INT)
    }

    private var binding: UserProfileBinding? = null

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?
    ): View? {
        binding = UserProfileBinding.inflate(inflater, container, false)
        return binding?.root
    }

    val presenter: UserProfilePresenter by moxyPresenter {
        UserProfilePresenter(userId, App.router)
    }

    override fun backPressed(): Boolean = presenter.backPressed()

    override fun setProfileData(user: User) = with(binding!!) {
        loginProfileTextView.text = user.login
        urlProfileTextView.text = user.url.toString()
        idProfileTextView.text = user.id.toString()
    }

    override fun onDestroyView() {
        binding = null
        super.onDestroyView()
    }
}

