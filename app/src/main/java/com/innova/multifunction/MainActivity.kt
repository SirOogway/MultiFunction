package com.innova.multifunction

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast
import com.innova.multifunction.extensions.*

class MainActivity : AppCompatActivity() {
    private lateinit var operation: Operation

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val tvResult: TextView = findViewById(R.id.tvResult)
        val etNumber: EditText = findViewById(R.id.etNumber)
        val btnValidate: Button = findViewById(R.id.btnValidate)
        val maxNumber = 1073741823

        etNumber.errorIsNumberExceededListener(maxNumber, "Number is very large")

        btnValidate.setOnClickListener {
            try {
                val number: Int = etNumber.text.toString().toInt()
                tvResult.text = when (operation) {
                    Operation.IsPrimeNumber -> if (number.isPrimeNumber()) "Is prime number"
                    else "Isn't prime number"

                    Operation.IsPerfectNumber -> if (number.isPerfectNumber()) "is perfect number"
                    else "isn't perfect number"

                    Operation.IsPalindromeNumber -> if (number.isPalindrome()) "Is palindrome"
                    else "Isn't palindrome"
                }
            } catch (e: UninitializedPropertyAccessException) {
                Toast.makeText(this, "select a menu option", Toast.LENGTH_SHORT).show()
            } catch (e: NumberFormatException) {
                if (!etNumber.isNumberExceeded(maxNumber))
                    Toast.makeText(this, "Enter a number", Toast.LENGTH_SHORT)
                        .show()
            }
        }
    }


    override fun onCreateOptionsMenu(menu: Menu): Boolean {
        menuInflater.inflate(R.menu.main_menu, menu)
        return true
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        operation = when (item.itemId) {
            R.id.is_perfect_number_action -> Operation.IsPerfectNumber
            R.id.is_palindrome_number_action -> Operation.IsPalindromeNumber
            else -> Operation.IsPrimeNumber
        }
        operationToTag()
        return true
    }

    private fun operationToTag() {
        val tvTagFunctionSelected: TextView = findViewById(R.id.tvTagFunctionSelected)
        tvTagFunctionSelected.text = "Validate " + when (operation) {
            Operation.IsPerfectNumber -> "perfect number"
            Operation.IsPalindromeNumber -> "palindrome number"
            Operation.IsPrimeNumber -> "prime number"
        }
    }
}