package com.innova.multifunction.extensions

import kotlin.math.roundToInt

fun String.getMiddleIndexOf(): Int {
    val lastIndex: Int = this.lastIndex
    if (this.length % 2 == 0) return (lastIndex / 2).toDouble()
        .roundToInt()
    return Math.floorDiv(lastIndex, 2) - 1
}