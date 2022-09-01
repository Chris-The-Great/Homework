package com.example.kingdomheartsfanclub

import android.content.Context
import android.content.SharedPreferences
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.Parcel
import android.os.Parcelable
import android.util.Log
import android.util.Patterns
import android.view.View
import android.widget.Toast
import com.example.kingdomheartsfanclub.databinding.ActivityMain2Binding
import kotlinx.parcelize.Parceler
import java.util.regex.Pattern
import kotlinx.parcelize.Parcelize

class MainActivity2 : AppCompatActivity() {
    private val binding by lazy{
        ActivityMain2Binding.inflate(layoutInflater)
    }
    private val sharedPreferences by lazy{
        getSharedPreferences("SP", MODE_PRIVATE)
    }


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(binding.root)

    }
    private fun onSave()
    {
        val es = sharedPreferences.getString("Name", null)
        sharedPreferences.edit().apply(){

            this.putString("Name",binding.email.text.toString())

        }.apply()

        val toast = Toast.makeText(applicationContext,"Saved",Toast.LENGTH_LONG).show()

    }

    override fun onUserInteraction() {
        super.onUserInteraction()
        check()
    }

    override fun onResume() {
        super.onResume()
        binding.button2.setOnClickListener {
            onSave()
        }
    }


    private fun boolean(): Boolean {

        val name  = sharedPreferences.getString("Name",null)
        Log.d("Name", name.toString())
        return android.util.Patterns.EMAIL_ADDRESS.matcher(binding.email.text.toString()).matches() &&
                name != binding.email.text.toString()
    }
    private fun PasswordCheck() : Boolean{
        return binding.PT.text.toString().matches(".*[A-Z].*".toRegex()) && binding.PT.text.toString().matches(".*[a-z].*".toRegex())
        }

    private fun PassToPass(): Boolean
    {
        return binding.ConfirmPasswordText.text.toString().matches(".*[A-Z].*".toRegex()) && binding.ConfirmPasswordText.text.toString().matches(".*[a-z].*".toRegex()) &&
                binding.ConfirmPasswordText.text.toString().equals(binding.PT.text.toString())
    }

    private fun check()
    {
        var email : Boolean = boolean()
        var pass : Boolean = PasswordCheck()
        var CPass : Boolean = PassToPass()
        email = boolean();
        if(email)
        {
            binding.rightwrong.setImageResource(R.drawable.check)
            binding.EmailBackgroundNormal.setImageResource(R.drawable.greenbox)
        }
        else
        {
            binding.rightwrong.setImageResource(R.drawable.x)
            binding.EmailBackgroundNormal.setImageResource(R.drawable.redbox)
        }
        pass = PasswordCheck()
        if(pass)
        {
            binding.rightwrongPassword.setImageResource(R.drawable.check)
            binding.PasswordBackgroundNormal.setImageResource(R.drawable.greenbox)

        }
        else
        {
            binding.rightwrongPassword.setImageResource(R.drawable.x)
            binding.PasswordBackgroundNormal.setImageResource(R.drawable.redbox)
            binding.Passwordontwork.text = "Password is invaild"
        }
        CPass = PassToPass()
        if(CPass)
        {
            binding.CPassword.setImageResource(R.drawable.check)
            binding.ConfirmPasswordBackgroundNormal.setImageResource(R.drawable.greenbox)
            binding.Passwordontwork.text =""
        }
        else
        {
            binding.CPassword.setImageResource(R.drawable.x)
            binding.ConfirmPasswordBackgroundNormal.setImageResource(R.drawable.redbox)
            binding.Passwordontwork.text = "Passwords don't match/Password is invaild"
        }
    }

    }

