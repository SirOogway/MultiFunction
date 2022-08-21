package com.innova.multifunction.extensions

import android.widget.EditText
import androidx.core.widget.addTextChangedListener

fun EditText.errorIsNumberExceededListener(maxNumber: Int, errorMessage: String) {
    this.addTextChangedListener {
        try {
            val numberString: String = this.text.toString()
            if (numberString.toLong() > maxNumber)
                this.error = errorMessage
        } catch (e: NumberFormatException) {
        }
    }
}

fun EditText.isNumberExceeded(maxNumber: Int): Boolean {
    val numberString = this.text.toString()
    val number: Long = try {
        numberString.toLong()
    } catch (e: NumberFormatException) {
        0
    }
    return number > maxNumber
}