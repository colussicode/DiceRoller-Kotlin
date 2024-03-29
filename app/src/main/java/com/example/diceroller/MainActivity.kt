package com.example.diceroller

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.diceroller.databinding.ActivityMainBinding
class MainActivity : AppCompatActivity() {
    private val binding by lazy {
        ActivityMainBinding.inflate(layoutInflater)
    }
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(binding.root)

        binding.btnRoll.setOnClickListener { showResultOnScreen() }
    }
    private fun rollFirstDice() : Int {
        return Dice(6).roll()
    }

    private fun rollSecondDice() : Int {
        return Dice(6).roll()
    }

    private fun showResultOnScreen() {
        val resultFirstDice = when(rollFirstDice()) {
            1 -> R.drawable.dice_1
            2 -> R.drawable.dice_2
            3 -> R.drawable.dice_3
            4 -> R.drawable.dice_4
            5 -> R.drawable.dice_5
            else -> R.drawable.dice_6
        }

        val resultSecondDice = when(rollSecondDice()) {
            1 -> R.drawable.dice_1
            2 -> R.drawable.dice_2
            3 -> R.drawable.dice_3
            4 -> R.drawable.dice_4
            5 -> R.drawable.dice_5
            else -> R.drawable.dice_6
        }

        binding.imgFirstDice.setImageResource(resultFirstDice)
        binding.imgSecondDice.setImageResource(resultSecondDice)
    }
}
class Dice(private val numSides: Int) {
    fun roll(): Int {
        return (1..numSides).random()
    }
}