package com.sapient.learning.extensions

fun String.tail() = this.substring(1)
fun String.head() = this.substring(0, 1)

fun main() {
    println("abcde".head().equals("a"))
    println("abcde".tail().equals("bcde"))
}