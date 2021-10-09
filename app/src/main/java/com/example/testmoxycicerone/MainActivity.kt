package com.example.testmoxycicerone

import android.os.Bundle
import com.example.testmoxycicerone.databinding.ActivityMainBinding
import com.example.testmoxycicerone.ui.MainPresenter
import moxy.MvpAppCompatActivity
import moxy.ktx.moxyPresenter

class MainActivity : MvpAppCompatActivity(), Contract.View {
    private lateinit var binding: ActivityMainBinding
    private val presenter by moxyPresenter { MainPresenter(app.router) }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        initView()
    }

    private fun initView(){
    }

    override fun setButtonOneText(text: String) {

    }

    override fun setButtonTwoText(text: String) {

    }

    override fun setButtonThreeText(text: String) {

    }

}