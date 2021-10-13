package com.example.testmoxycicerone.ui

import android.os.Bundle
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.testmoxycicerone.App
import com.example.testmoxycicerone.Contract
import com.example.testmoxycicerone.databinding.FragmentUsersListBinding
import com.example.testmoxycicerone.interfaces.BackButtonListener
import com.example.testmoxycicerone.model.GithubUserRepo
import moxy.MvpAppCompatFragment
import moxy.ktx.moxyPresenter

class UsersListFragment : MvpAppCompatFragment(), Contract.View, BackButtonListener {
    companion object {
        fun newInstance() = UsersListFragment()
    }

    private lateinit var binding: FragmentUsersListBinding
    private val presenter by moxyPresenter { UsersPresenter(GithubUserRepo(), App.INSTANCE.router) }
    private lateinit var adapter: UsersRecyclerViewAdapter

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ) =
        FragmentUsersListBinding.inflate(inflater, container, false).also {
            binding = it
        }.root


    override fun init() {
        adapter = UsersRecyclerViewAdapter(presenter.usersListPresenter)
        binding.recyclerViewFragmentUsers.layoutManager = LinearLayoutManager(context)
        binding.recyclerViewFragmentUsers.adapter = adapter
    }

    override fun updateList() {
        adapter?.notifyDataSetChanged()
    }

    override fun backPressed(): Boolean {
        return presenter.backPressed()
    }
}