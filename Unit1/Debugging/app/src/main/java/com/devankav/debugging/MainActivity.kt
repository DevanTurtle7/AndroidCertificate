package com.devankav.debugging

import android.os.Bundle
import android.util.Log
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity

private const val TAG = "MainActivity"

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        val helloTextView: TextView = findViewById(R.id.division_textview)
        helloTextView.text = "Hello, debugging!"
        setContentView(R.layout.activity_main)
        division()
    }

     fun division() {
         val numerator = 60
         var denominator = 4

         repeat(5) {
             Thread.sleep(1)
             Log.v(TAG, "${numerator / denominator}")
             denominator--
         }
     }

    fun logging() {
        Log.e(TAG, "ERROR: A serious error like an app crash")
        Log.w(TAG, "WARN: warns about the potential for serious errors")
        Log.i(TAG, "INFO: reporting technical information, such as an operation succeeding")
        Log.d(TAG, "DEBUG: reporting technical information useful for debugging")
        Log.v(TAG, "VERBOSE: more verbose than DEBUG logs")
    }
}