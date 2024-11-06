package com.example.homeworkzukavanishvili

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.example.homeworkzukavanishvili.databinding.ActivityMain2Binding

class MainActivity2 : AppCompatActivity() {

    private lateinit var binding: ActivityMain2Binding
    private lateinit var intentToStart: Intent
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMain2Binding.inflate(layoutInflater)
        setContentView(binding.root)


        val number = intent.getStringExtra("email")
        val message = intent.getStringExtra("message")
        setData(number, message)

        binding.clear.setOnClickListener {
            binding.emailtext.text = ""
            binding.messagetext.text = ""
        }
    }


    private fun setData(number: String?, message: String?) {
        if (!number.isNullOrEmpty() && !message.isNullOrEmpty()) {

            binding.emailtext.text = number
            binding.messagetext.text = message

        } else {
            return
        }
    }
}