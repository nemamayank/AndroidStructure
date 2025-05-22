package com.mayank.androidstructure.assignment

import android.os.Bundle
import android.view.View
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import com.mayank.androidstructure.R
import com.mayank.androidstructure.assignment.factorypattern.Employee
import com.mayank.androidstructure.assignment.factorypattern.Laptop
import com.mayank.androidstructure.databinding.ActivityProgramsBinding

class JavaPrograms : AppCompatActivity(){
    private lateinit var binding: ActivityProgramsBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        binding = DataBindingUtil.setContentView(this, R.layout.activity_programs)
        binding.btnRunPrograms.setOnClickListener {
            val text = findMaxMinFromList(arrayOf(-2,5,5,5,89,6,600,200))
            binding.tvOutputCoroutines.text = text
        }
    }

    private fun circleRectangle() {
        //  Create an interface Drawable with a method draw().
        //  Define a base class Shape with a property size in constructor.
        //  Create two subclasses of Shape, like Circle and Rectangle that implement the Drawable interface,
        //  and have their own specific implementations of the draw() method.

        val circle: Drawable = Circle(5)
        val rectangle: Drawable = Rectangle(10)

        println(circle.draw())
        println(rectangle.draw())
    }

    private fun factoryPattern() {
        // Factory Pattern Question:
        // Create a class Laptop with properties name, brand, and price (Int).
        // Create a singleton class called Factory inside that class.
        // And provides a method create in that which takes the name, brand and price as parameters and returns an instance of Laptop.

        Laptop.create("ThinkPad", "Dell", 40000)
    }

    private fun createEmployeeList() {
        // Write a Data class Employee with id, name and sal
        // Create list of 5 Employees with different values
        // Find the total/sum of salary of all 5 Employees.
        val employeeList: MutableList<Employee> = mutableListOf()
        employeeList.add(Employee(1, "Bob", 6000))
        employeeList.add(Employee(2, "Sam", 5000))
        employeeList.add(Employee(3, "James", 8000))
        employeeList.add(Employee(4, "Mike", 1000))
        employeeList.add(Employee(5, "Stanley", 2000))

        // First way
        val salary = employeeList.sumOf { it.salary }
        println("Sum Salary: $salary")

        // Second way
        var salarySum = 0
        for (item in employeeList) {
            salarySum += item.salary
        }
        println("All Employees Salary is: $salarySum")
    }

    private fun checkIfElementExists2Times() {
        // Write a code to check element exists exactly two times in list of integer.
        val numberList = listOf(1, 2, 8, 8, 2, 1, 9, 9)
        val operationList = numberList.groupingBy { it }.eachCount().all { it.value == 2 }
        println(operationList)
    }

    private fun removeElementFromMap() {
        // Write a program to remove the element from Map by Value
        val mapList = mapOf(1 to "apple", 2 to "ball", 3 to "cat")
        val removedElement = mapList.filter { it.value != "ball" }
        println(removedElement)
    }

    private fun findMostRepeatedChar(): Char {
        // Write a code to find most repeated char in String.
        val str = "kotlinnnnnprogramming"
        var mostRepeatedChar = str[0]
        var maxCount = 0

        for (ch in str) {
            val count = str.count { it == ch }
            if (count > maxCount) {
                maxCount = count
                mostRepeatedChar = ch
            }
        }
        println("Most repeated char in string is: $mostRepeatedChar")
        return mostRepeatedChar
    }

    private fun findMaxMinFromList(inputList: Array<Int>?): String {
        // Write a method that takes an integer "array" parameter and print the highest and lowest value
        // Add check for null and emptyList
        if (inputList.isNullOrEmpty()) return "N/A"
        var max = inputList[0]
        var min = inputList[0]
        for (item in inputList) {
            if (item > max) {
                max = item
            }
            if (item < min) {
                min = item
            }
        }
        AppLoggerSingleton.logger("Max is: $max")
        AppLoggerSingleton.logger("Max is: $min")
        println("By in-build Min is: ${inputList.minOrNull()}")
        println("By in-build Max is: ${inputList.maxOrNull()}")

        return "Max number is: $max, Minimum number is: $min"
    }
}