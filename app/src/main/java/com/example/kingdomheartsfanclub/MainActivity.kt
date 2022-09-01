package com.example.kingdomheartsfanclub

import android.content.Intent
import android.os.Bundle
import android.util.Log
import androidx.appcompat.app.AppCompatActivity
import com.example.kingdomheartsfanclub.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    private val binding by lazy{
        ActivityMainBinding.inflate(layoutInflater)
    }
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(binding.root)

    }

    override fun onResume() {
        super.onResume()
        Log.d("Main Activity", "Now")
        binding.SignUp.setOnClickListener{
            Log.d("Main Activity", "Button Pressed")
            Intent(baseContext, MainActivity2::class.java).apply{
                startActivity(this)
            }
        }

    }
}