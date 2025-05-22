package com.mayank.androidstructure.assignment.factorypattern

class Laptop private constructor(
    val name: String,
    val model: String,
    val price: Int
) {
    companion object Factory {
        private var laptopInstance: Laptop? = null
        fun create(
            name: String,
            model: String,
            price: Int
        ): Laptop {
            if (laptopInstance == null) {
                laptopInstance = Laptop(name, model, price)
            }
            return laptopInstance!!
        }
    }
}