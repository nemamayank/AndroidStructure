package com.mayank.androidstructure.assignment

object AppLoggerSingleton {
    fun logger(message: String?) {
        if (message.isNullOrBlank()) return
        println("Logs >>>> $message")
    }
}