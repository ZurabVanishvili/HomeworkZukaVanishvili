package com.example.homeworkzukavanishvili

import android.content.Intent
import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.example.homeworkzukavanishvili.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding
    private lateinit var intentToStart: Intent

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        intentToStart = Intent(this, MainActivity2::class.java)

        binding.send.setOnClickListener {
            if (isFormValid()) {
                startActivity(intentToStart)
            }
        }
    }

    private fun isFormValid(): Boolean {
        val email = binding.email.text?.toString()
        val message = binding.message.text?.toString()

        return when {
            email.isNullOrEmpty() || message.isNullOrEmpty() -> {
                Toast.makeText(this, "Fill out the form!", Toast.LENGTH_SHORT).show()
                false
            }
            !email.contains("@") -> {
                Toast.makeText(this, "Invalid email!", Toast.LENGTH_SHORT).show()
                false
            }
            else -> {
                intentToStart.putExtra("email", email)
                intentToStart.putExtra("message", message)
                true
            }
        }
    }


}
