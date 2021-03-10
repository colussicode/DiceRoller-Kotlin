package com.example.diceroller

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.TextView

/*This activity allows the user to click in the button and see the dice rolling*/
class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val rollButton: Button = findViewById(R.id.button2)
        rollButton.setOnClickListener { rollDice() }
    }
/*This is a function that rolls the sides of the dice and shows the result on viewText*/
    private fun rollDice() {
        val dice = Dice(6)
        val secondDice = Dice(10)

        val secondDiceRoll = secondDice.roll()
        val diceRoll = dice.roll()

        val resultTextView: TextView = findViewById(R.id.textView)
        val resultSecondTextView: TextView = findViewById(R.id.textView2)

        resultTextView.text = secondDiceRoll.toString()
        resultSecondTextView.text = diceRoll.toString()
    }
}

/*That's the dice class, it has the number of sides as a property and a
method that returns a random number between 1 and the variable "numSides"
 */
class Dice(private val numSides: Int) {
    fun roll(): Int {
        return (1..numSides).random()
    }
}