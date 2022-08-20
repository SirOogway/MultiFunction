package com.innova.multifunction.extensions

fun Int.isPrimeNumber(): Boolean {
    val lastDivider: Int = Math.floorDiv(this, 2)

    for (divider in 2..lastDivider) {
        if (this % divider == 0) return false
    }
    return true
}

fun Int.isPerfectNumber(): Boolean {
    val dividers = this.getDividers()
    if (dividers.sum() != this) return false
    return true
}

fun Int.getDividers(): List<Int> {
    val size: Int = Math.floorDiv(this, 2)
    val dividers = ArrayDeque<Int>()
    for (i in 1..size) {
        if (this % i == 0) dividers.add(i)
    }
    return dividers
}

fun Int.isPalindrome(): Boolean {
    val numberString = this.toString()
    val middleIndex = numberString.getMiddleIndexOf()
    val firstHalf: String = numberString.slice(0..middleIndex)

    firstHalf.forEachIndexed { index, c ->
        if (c != numberString[numberString.lastIndex - index]) return false
    }
    return true
}