
package com.mayank.androidstructure

import android.content.Intent
import android.os.Bundle
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.annotation.MainThread
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.mayank.androidstructure.databinding.ActivityMainBinding
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.async
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext
import java.util.LinkedList
import java.util.Queue
import kotlin.random.Random.Default.nextInt

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding

    // iterated or remove the duplicate element from the list
    private var arrElements = mutableListOf(1,2,5,5,6,7,2)

    // late init
    private lateinit var lateInitNames:MutableList<String>

    // Null able types
    private var nullNumbersList: MutableList<Int>? = null
    val squaring = MutableList(2) { it * 2 }

    val queue: Queue<String> = LinkedList()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()

        // Inflate binding and set content view
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        // Apply insets
        ViewCompat.setOnApplyWindowInsetsListener(binding.main) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        binding.btnRun.setOnClickListener {
            Toast.makeText(this, "Button clicked", Toast.LENGTH_SHORT).show()
        }

        binding.btnNextScreen.setOnClickListener {
            startActivity(Intent(this@MainActivity, CoroutineActivity::class.java))
        }
    }

    private fun setupTryError() {
        lateInitNames = mutableListOf()

        lateInitNames.add("3")

        nullNumbersList?.add(8)

//        removeDuplicateElements()

//        someOutput()
    }

    private fun removeDuplicateElements(){

        // let
        val newArray = arrElements.let {
            // it will give you non-null object
            arrElements.add(100)
            println(arrElements.toString())
        }

        arrElements.removeLastOrNull()

        println("after all process outside coroutine")
    }

    private fun someOutput(){
        val charPool: List<Char> = ('a'..'z') + ('A'..'Z') + ('1'..'9')

        val result = (1..8) // The range represents the number of iterations we will perform to generate random characters
            .map { nextInt(nextInt(0, charPool.size)) } // For each number in the range (1..8),
            // this map function generates a random integer between 0 and charPool.size - 1 (i.e. 60-1 = 59, 26 lowercase, 26 uppercase, 9 digits).
            .map(charPool::get) //each random index produced in the previous step is passed to charPool::get, which retrieves the character at that index from charPool.
            .joinToString("")

        println(result)
    }
}