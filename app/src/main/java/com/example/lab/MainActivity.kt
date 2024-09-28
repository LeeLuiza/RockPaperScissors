package com.example.lab

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import kotlin.random.Random

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        ChoicePlayer()
    }

    private fun ChoicePlayer(){
        val rockButton: Button = findViewById(R.id.buttonRock)
        val scissorsButton: Button = findViewById(R.id.buttonScissors)
        val paperButton: Button = findViewById(R.id.buttonPaper)

        rockButton.setOnClickListener {
            ChoiceRobot("Камень")
        }
        scissorsButton.setOnClickListener {
            ChoiceRobot("Ножницы")
        }
        paperButton.setOnClickListener {
            ChoiceRobot("Бумага")
        }
    }

    private fun ChoiceRobot(playerChoice: String) {
        val options = arrayOf("Камень", "Ножницы", "Бумага")
        val robotChoice = options[Random.nextInt(options.size)]

        val intent = Intent(this, SecondActivity::class.java)
        intent.putExtra("playerChoice", playerChoice)
        intent.putExtra("robotChoice", robotChoice)
        startActivity(intent)
    }
}