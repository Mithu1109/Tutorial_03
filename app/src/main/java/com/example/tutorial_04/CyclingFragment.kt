package com.example.tutorial_04

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import androidx.fragment.app.Fragment

class CyclingFragment : Fragment() {

    var toggle = 0

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val rootView = inflater.inflate(R.layout.fragment_cycling, container, false)
        val changeButton: Button = rootView.findViewById(R.id.btnChangeColor)
        val constraintLayout: ViewGroup = rootView.findViewById(R.id.cyclingLayout)

        // Set initial color based on current toggle state
        if (toggle == 1) {
            constraintLayout.setBackgroundResource(R.color.color1)
        } else {
            constraintLayout.setBackgroundResource(R.color.color2)
        }

        changeButton.setOnClickListener {
            if (toggle == 0) {
                toggle = 1
                constraintLayout.setBackgroundResource(R.color.color1)
            } else {
                toggle = 0
                constraintLayout.setBackgroundResource(R.color.color2)
            }
        }
        return rootView
    }
}