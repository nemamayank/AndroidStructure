package com.mayank.androidstructure.assignment

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import com.mayank.androidstructure.R
import com.mayank.androidstructure.databinding.ActivityProgramsBinding

class JavaPrograms: AppCompatActivity() {

    private lateinit var binding: ActivityProgramsBinding

//    Create an interface Drawable with a method draw().
//    Define a base class Shape with a property size in constructor.
//    Create two subclasses of Shape, like Circle and Rectangle that implement the Drawable interface,
//    and have their own specific implementations of the draw() method.

    private var circle: Drawable = Circle(5)
    private var rectangle: Drawable = Rectangle(10)

    override fun onSaveInstanceState(outState: Bundle) {
        super.onSaveInstanceState(outState)
        setContentView(R.layout.activity_programs)
        binding = DataBindingUtil.setContentView(this, R.layout.activity_coroutines)

        binding.btnRunPrograms.setOnClickListener {
            println(circle.draw())
            println(rectangle.draw())

        }
    }


}