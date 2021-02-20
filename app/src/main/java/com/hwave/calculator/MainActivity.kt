package com.hwave.calculator

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
    }

    var isNewOp = true
    fun buNumberEvent(view: View) {
        if (isNewOp) {
            tvShowNumber.text = ""
        }
        isNewOp = false
        var tvNumer: String = tvShowNumber.text.toString()
        var buSelect = view as Button
        when (buSelect.id) {
            bu0.id -> {
                tvNumer += "0"
            }
            bu1.id -> {
                tvNumer += "1"
            }
            bu2.id -> {
                tvNumer += "2"
            }
            bu3.id -> {
                tvNumer += "3"
            }
            bu4.id -> {
                tvNumer += "4"
            }
            bu5.id -> {
                tvNumer += "5"
            }
            bu6.id -> {
                tvNumer += "6"
            }
            bu7.id -> {
                tvNumer += "7"
            }
            bu8.id -> {
                tvNumer += "8"
            }
            bu9.id -> {
                tvNumer += "9"
            }
            buDot.id -> {
                tvNumer += "."
            }
            buSign.id -> {
                tvNumer = "-" + tvNumer
            }
        }

        tvShowNumber.text = tvNumer
    }

    var oldNumber = ""
    var oP = "+"
    fun buOperation(view: View) {
        oldNumber = tvShowNumber.text.toString()
        isNewOp = true
        val buSelect = view as Button
        when (buSelect.id) {
            buAdd.id -> {
                oP = "+"
            }
            buSub.id -> {
                oP = "-"
            }
            buMul.id -> {
                oP = "*"
            }
            buDiv.id -> {
                oP = "/"
            }
        }
    }

    fun buEqualEvent(view: View) {
        val newNumber = tvShowNumber.text.toString()
        var finalNumber: Double? = null
        when (oP) {
            "/" -> {
                finalNumber = oldNumber.toDouble() / newNumber.toDouble()
            }
            "*" -> {
                finalNumber = oldNumber.toDouble() * newNumber.toDouble()
            }
            "-" -> {
                finalNumber = oldNumber.toDouble() - newNumber.toDouble()
            }
            "+" -> {
                finalNumber = oldNumber.toDouble() + newNumber.toDouble()
            }
        }
        tvShowNumber.text = finalNumber.toString()
        isNewOp = true
    }
}