package com.mayank.androidstructure.assignment

open class Shape (var size: Int): Drawable {
    override fun draw(): Int {
        return size
    }
}