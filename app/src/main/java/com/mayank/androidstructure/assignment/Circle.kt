package com.mayank.androidstructure.assignment

class Circle(size: Int): Shape(size) {
    override fun draw(): Int {
        println("Inside Circle")
        return size
    }
}