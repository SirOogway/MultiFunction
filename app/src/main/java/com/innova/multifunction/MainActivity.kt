package com.innova.multifunction

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import android.widget.Toast

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
    }

    override fun onCreateOptionsMenu(menu: Menu): Boolean {
        menuInflater.inflate(R.menu.main_menu, menu)
        return true
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        when (item.itemId){
            R.id.is_prime_number_action -> Toast.makeText(this, "hola", Toast.LENGTH_SHORT).show()
            R.id.is_perfect_number_action -> TODO()
            R.id.is_palindrome_number_action -> TODO()
            else -> Toast.makeText(this, "chao", Toast.LENGTH_SHORT).show()
        }
        return true
    }
}