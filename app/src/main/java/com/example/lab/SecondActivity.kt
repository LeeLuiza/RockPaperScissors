package com.example.lab

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class SecondActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_second)

        determineWinner()
    }

    private fun determineWinner(){

        val playerChoice = intent.getStringExtra("playerChoice")
        val robotChoice = intent.getStringExtra("robotChoice")

        val resultTextView: TextView = findViewById(R.id.resultTextView)
        val buttonRestart: Button = findViewById(R.id.buttonRestart)

        buttonRestart.setOnClickListener {
            this.finish()
        }

        val result = resultGame(playerChoice, robotChoice)
        resultTextView.text = "Вы выбрали: $playerChoice\nРобот выбрал: $robotChoice\n$result"
    }

    private fun resultGame(player: String?, robot: String?): String {
        return when {
            player == robot -> "Ничья!"
            (player == "Камень" && robot == "Ножницы") ||
                    (player == "Ножницы" && robot == "Бумага") ||
                    (player == "Бумага" && robot == "Камень") -> "Вы выиграли!"
            else -> "Вы проиграли!"
        }
    }
}