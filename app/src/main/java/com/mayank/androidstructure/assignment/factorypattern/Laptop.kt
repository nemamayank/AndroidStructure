package com.mayank.androidstructure.assignment.factorypattern

class Laptop(name: String, brand: String, price: Int) {

    object Factory {
        private var instanceLaptop: Laptop? = null

        fun create(name: String, brand: String, price: Int): Laptop {
            if (instanceLaptop == null){
                instanceLaptop = Laptop(name, brand, price)
            }
            return instanceLaptop!!
        }
    }

    val mInstance = Factory.create("Think Pad", "Lenovo", 30000)
}