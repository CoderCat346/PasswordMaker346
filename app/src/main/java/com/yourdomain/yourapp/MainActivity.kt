package com.yourdomain.yourapp

import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import kotlin.random.Random

class MainActivity : AppCompatActivity() {

    // This function runs when the activity is created (app starts)
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        // Connect this Activity to the layout file: res/layout/activity_main.xml
        setContentView(R.layout.activity_main)

        // Get references to the views defined in the XML
        val passwordLengthInput = findViewById<EditText>(R.id.passwordLengthInput)
        val generateButton = findViewById<Button>(R.id.generateButton)
        val passwordOutput = findViewById<TextView>(R.id.passwordOutput)

        // Set a click listener on the button
        generateButton.setOnClickListener {
            // Read the length input by the user, convert to Int or default to 8 if blank/invalid
            val length = passwordLengthInput.text.toString().toIntOrNull() ?: 8

            // Call the function to generate a random password
            val password = generatePassword(length)

            // Show the generated password in the TextView
            passwordOutput.text = password
        }
    }

    // This function builds a random password of the given length
    private fun generatePassword(length: Int): String {
        // Allowed characters: uppercase, lowercase, digits, special chars
        val chars = "ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz0123456789!@#\$%^&*()"

        // Repeat for the given length: pick a random character each time, then join them together
        return (1..length)
            .map { chars.random() } // Pick a random char from 'chars'
            .joinToString("")       // Combine all chars into a single String
    }
}
