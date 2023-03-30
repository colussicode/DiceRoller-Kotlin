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

        binding.buttonRoll.setOnClickListener { rollDice() }
    }
    private fun rollDice() {
        val dice = Dice(6)
        val secondDice = Dice(10)

        val secondDiceRollResult = secondDice.roll()
        val firstDiceRollResult = dice.roll()

        binding.textViewSecond.text = secondDiceRollResult.toString()
        binding.textViewFirst.text = firstDiceRollResult.toString()
    }
}
class Dice(private val numSides: Int) {
    fun roll(): Int {
        return (1..numSides).random()
    }
}