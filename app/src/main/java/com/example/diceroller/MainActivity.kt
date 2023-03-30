package com.example.diceroller

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import com.example.diceroller.databinding.ActivityMainBinding
class MainActivity : AppCompatActivity() {
    private val binding by lazy {
        ActivityMainBinding.inflate(layoutInflater)
    }
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(binding.root)

        binding.buttonRoll.setOnClickListener {
            showResultOnScreen()
            Toast.makeText(this, "Dice Rolled!", Toast.LENGTH_SHORT).show()
        }
    }
    private fun rollFirstDice() : Int {
        return Dice(6).roll()
    }
    private fun rollSecondDice(): Int {
        return Dice(10).roll()
    }

    private fun showResultOnScreen() {
        val firstDiceResult = rollFirstDice()
        val secondDiceResult = rollSecondDice()

        binding.textViewFirst.text = firstDiceResult.toString()
        binding.textViewSecond.text = secondDiceResult.toString()
    }
}
class Dice(private val numSides: Int) {
    fun roll(): Int {
        return (1..numSides).random()
    }
}