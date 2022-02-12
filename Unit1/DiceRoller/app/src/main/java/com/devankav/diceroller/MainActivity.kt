package com.devankav.diceroller

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import android.widget.Toast

class Dice(private val numSides: Int) {
    fun roll(): Int {
        return (1..numSides).random()
    }
}

/**
 * Allows the button to roll a dice and view the result
 */
class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val rollButton: Button = findViewById(R.id.button);
        rollButton.setOnClickListener { rollDice() }
    }

    /**
     * Roll the dice and update the text with the result
     */
    private fun rollDice() {
        // Create and roll a new 6 sided dice
        val dice = Dice(6)
        val diceRoll = dice.roll()

        // Display the result
        val resultTextView: TextView = findViewById(R.id.textView)
        resultTextView.text = diceRoll.toString()
    }
}