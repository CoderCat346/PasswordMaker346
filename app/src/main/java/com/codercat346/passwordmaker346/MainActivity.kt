package com.codercat346.passwordmaker346

import android.content.ClipData
import android.content.ClipboardManager
import android.content.Context
import android.os.Bundle
import android.widget.*
import androidx.appcompat.app.AppCompatActivity

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        // Get UI elements by ID
        val passwordLengthInput = findViewById<EditText>(R.id.passwordLengthInput)
        val uppercaseCheckBox = findViewById<CheckBox>(R.id.uppercaseCheckBox)
        val numbersCheckBox = findViewById<CheckBox>(R.id.numbersCheckBox)
        val symbolsCheckBox = findViewById<CheckBox>(R.id.symbolsCheckBox)
        val generateButton = findViewById<Button>(R.id.generateButton)
        val passwordOutput = findViewById<TextView>(R.id.passwordOutput)
        val copyButton = findViewById<Button>(R.id.copyButton)

        // When user clicks "Generate Password"
        generateButton.setOnClickListener {
            val length = passwordLengthInput.text.toString().toIntOrNull()

            // ✅ Error handling: if input is invalid or empty
            if (length == null || length <= 0) {
                Toast.makeText(this, "Please enter a valid positive number!", Toast.LENGTH_SHORT).show()
                return@setOnClickListener
            }

            // Build character pool based on checkboxes
            var chars = "abcdefghijklmnopqrstuvwxyz"

            if (uppercaseCheckBox.isChecked) {
                chars += "ABCDEFGHIJKLMNOPQRSTUVWXYZ"
            }
            if (numbersCheckBox.isChecked) {
                chars += "0123456789"
            }
            if (symbolsCheckBox.isChecked) {
                chars += "!@#\$%^&*()"
            }

            // Ensure at least one character type is selected
            if (chars.isEmpty()) {
                Toast.makeText(this, "Please select at least one character type!", Toast.LENGTH_SHORT).show()
                return@setOnClickListener
            }

            // Generate password
            val password = (1..length)
                .map { chars.random() }
                .joinToString("")

            passwordOutput.text = password
        }

        // When user clicks "Copy to Clipboard"
        copyButton.setOnClickListener {
            val password = passwordOutput.text.toString()
            if (password.isNotBlank()) {
                val clipboard = getSystemService(Context.CLIPBOARD_SERVICE) as ClipboardManager
                val clip = ClipData.newPlainText("Generated Password", password)
                clipboard.setPrimaryClip(clip)
                Toast.makeText(this, "Password copied to clipboard!", Toast.LENGTH_SHORT).show()
            } else {
                Toast.makeText(this, "Nothing to copy!", Toast.LENGTH_SHORT).show()
            }
        }
    }
}
