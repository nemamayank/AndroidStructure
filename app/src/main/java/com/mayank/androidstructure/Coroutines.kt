package com.mayank.androidstructure

import android.os.Bundle
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import com.mayank.androidstructure.databinding.ActivityCoroutinesBinding
import kotlinx.coroutines.CoroutineExceptionHandler
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.SupervisorJob
import kotlinx.coroutines.async
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext

class CoroutineActivity : AppCompatActivity() {

    private lateinit var binding: ActivityCoroutinesBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        binding = DataBindingUtil.setContentView(this, R.layout.activity_coroutines)

        binding.btnRunCoroutines.setOnClickListener {
            supervisorJobCoroutine()
        }
    }

    private fun callingSimpleCoroutines() {
        // Simple Coroutine
        val scope = CoroutineScope(Dispatchers.Default)

        scope.launch {
            println("Simple Coroutine Launched in: ${Thread.currentThread().name}.")
            val data = this@CoroutineActivity.getListAPI()
            println("Simple Coroutine: $data")
        }

        scope.launch {
            println("Async Coroutine Launched")

            val nameDeferred = async {
                delay(2000)
                println("Coroutine Launched in: ${Thread.currentThread().name}.")
                "Name is Coroutine"
            }

            val ageDeferred = async {
                delay(3000)
                " and Age is 20"
            }

            val result = nameDeferred.await() + ageDeferred.await()
            println(result)
        }
    }

    private fun callingTwoTaskCoroutines() {

        val scope = CoroutineScope(Dispatchers.Default)

        // Using suspend func
        scope.launch {
            println("Data Coroutine Launched in: ${Thread.currentThread().name}.")
            val deferredListApi = async { getListAPI() }
            val deferredImageApi = async { getImageAPI() }
            val result = deferredListApi.await() + deferredImageApi.await()
            println(result)
        }
    }

    private fun switchContextCoroutine() {

        val scope = CoroutineScope(Dispatchers.Default)

        scope.launch {
            println("Context Coroutine: In Default Scope: ${Thread.currentThread().name}")
            val resultFromDB = async { getDataFromDB() }
            println(resultFromDB.await())

            withContext(Dispatchers.Main) {
                Toast.makeText(
                    this@CoroutineActivity,
                    "Task Done! Value fetched now from DB",
                    Toast.LENGTH_SHORT
                ).show()
            }
        }
    }

    private fun supervisorJobCoroutine(){
        val job = SupervisorJob()
        val scope = CoroutineScope(Dispatchers.Default + job)

        scope.launch {
            val deferredTask01 = async { getListAPI() }
            val deferredTask02 = async { getImageAPI() }
            val result = deferredTask01.await() + deferredTask02.await()
            println(result)
        }

//        job.cancel()
    }

    private fun exceptionHandlingCoroutine() {
        val exceptions = CoroutineExceptionHandler { _, exception -> print("Exception: $exception") }
        val scope = CoroutineScope(Dispatchers.Default + exceptions)
        scope.launch {

        }
    }


    private suspend fun getDataFromDB() = withContext(Dispatchers.IO) {
        // Now in IO thread
        // Assume fetching values from DB
        println("In IO Scope: ${Thread.currentThread().name}")
        delay(2000)
        "Values fetched from database"
    }

    private suspend fun getListAPI(): String {
        // calling some APIs
        delay(2000)
        return "Fetching List Completed."
    }

    private suspend fun getImageAPI(): String {
        // calling some APIs
        delay(6000)
        return "Fetching Image Completed."
    }
}