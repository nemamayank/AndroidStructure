package com.mayank.androidstructure.assignment

class Rectangle(size: Int): Shape(size) {
    override fun draw(): Int {
        println("Inside Rectangle")
        return size * size
    }
}