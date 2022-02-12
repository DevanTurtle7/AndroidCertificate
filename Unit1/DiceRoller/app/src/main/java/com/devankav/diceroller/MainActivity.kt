package com.devankav.diceroller

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.ImageView
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

        // Roll the dice when the user first opens the app
        rollDice()
    }

    /**
     * Roll the dice and update the text with the result
     */
    private fun rollDice() {
        // Create and roll a new 6 sided dice
        val dice = Dice(6)
        val diceRoll = dice.roll()

        // Display the result
        val diceImage: ImageView = findViewById(R.id.imageView)

        // Determine which dice image to display based on the result
        val drawableResource = when (diceRoll) {
            1 -> R.drawable.dice_1
            2 -> R.drawable.dice_2
            3 -> R.drawable.dice_3
            4 -> R.drawable.dice_4
            5 -> R.drawable.dice_5
            6 -> R.drawable.dice_6
            else -> R.drawable.dice_6
        }

        // Update the dice image to match the result of the roll
        diceImage.setImageResource(drawableResource)

        // Update the content description
        diceImage.contentDescription = diceRoll.toString()
    }
}