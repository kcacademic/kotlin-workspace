package com.sapient.learning.coroutine

import kotlinx.coroutines.*
import kotlinx.coroutines.sync.*
import kotlin.system.*

suspend fun CoroutineScope.massiveSimpleRun(action: suspend () -> Unit) {
    val n = 100  // number of coroutines to launch
    val k = 1000 // times an action is repeated by each coroutine
    val time = measureTimeMillis {
        val jobs = List(n) {
            launch {
                repeat(k) { action() }
            }
        }
        jobs.forEach { it.join() }
    }
    println("Completed ${n * k} actions in $time ms")
}

val mutex = Mutex()
var counter = 0

fun main() = runBlocking<Unit> {
    //sampleStart
    GlobalScope.massiveSimpleRun { // run each coroutine in the single-threaded context
        mutex.withLock {
            counter++
        }
    }
    println("Counter = $counter")
//sampleEnd
}