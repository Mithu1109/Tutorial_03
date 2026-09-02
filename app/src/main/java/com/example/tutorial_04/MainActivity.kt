package com.example.tutorial_04

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider

class MainActivity : AppCompatActivity() {

    val menuFragment = MenuFragment()
    val walkingFragment = WalkingFragment()
    val cyclingFragment = CyclingFragment()
    val drivingFragment = DrivingFragment()

    private lateinit var viewModel: MainActivityData

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        // 1. Load the MenuFragment at the top
        loadMenu()

        // 2. Initialize ViewModel and observe value updates
        viewModel = ViewModelProvider(this).get(MainActivityData::class.java)
        viewModel.clickedvalue.observe(this, Observer { value ->
            when (value) {
                1 -> walk()
                2 -> cycle()
                3 -> drive()
            }
        })
    }

    private fun loadMenu() {
        val fragment = supportFragmentManager.findFragmentById(R.id.fragment_menu)
        if (fragment == null) {
            supportFragmentManager.beginTransaction()
                .add(R.id.fragment_menu, menuFragment).commit()
        }
    }

    private fun walk() {
        supportFragmentManager.beginTransaction()
            .replace(R.id.fragment_container, walkingFragment)
            .addToBackStack(null)
            .commit()
    }

    private fun cycle() {
        supportFragmentManager.beginTransaction()
            .replace(R.id.fragment_container, cyclingFragment)
            .addToBackStack(null)
            .commit()
    }

    private fun drive() {
        supportFragmentManager.beginTransaction()
            .replace(R.id.fragment_container, drivingFragment)
            .addToBackStack(null)
            .commit()
    }
}