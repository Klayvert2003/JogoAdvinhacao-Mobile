package com.fatec.jogoadvinhacao

import android.os.Bundle
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import android.widget.Button
import android.widget.EditText
import android.widget.ImageView
import android.widget.TextView
import android.widget.Toast
import kotlin.random.Random

class MainActivity : AppCompatActivity() {
    private var randomNumber = 0

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val numText = findViewById<TextView>(R.id.result_text)
        val generateButton = findViewById<Button>(R.id.btn_result)
        val userGuessEditText = findViewById<EditText>(R.id.input_num)
        val imgAcerto = findViewById<ImageView>(R.id.img_acerto)
        val imgErro = findViewById<ImageView>(R.id.img_erro)

        generateButton.setOnClickListener {
            val userInput = userGuessEditText.text.toString()
            if (userInput.isNotEmpty()) {
                randomNumber = Random.nextInt(10, 100)

                numText.text = randomNumber.toString()
                numText.visibility = View.VISIBLE

                val userGuess = userInput.toInt()
                compareValues(userGuess, imgAcerto, imgErro)

                numText.postDelayed({
                    numText.visibility = View.GONE
                }, 2500)
            } else {
                Toast.makeText(this, "Digite um número", Toast.LENGTH_SHORT).show()
            }
        }
    }

    private fun compareValues(userGuess: Int, imgAcerto: ImageView, imgErro: ImageView) {
        if (userGuess == randomNumber) {
            imgAcerto.visibility = View.VISIBLE
            imgErro.visibility = View.GONE
            imgAcerto.postDelayed({
                imgAcerto.visibility = View.GONE
            }, 2500)
            //Toast.makeText(this, "Parabéns, você acertou!!!", Toast.LENGTH_SHORT).show()
        } else {
            imgAcerto.visibility = View.GONE
            imgErro.visibility = View.VISIBLE
            imgErro.postDelayed({
                imgErro.visibility = View.GONE
            }, 2500)
            //Toast.makeText(this, "Você errou, tente novamente", Toast.LENGTH_SHORT).show()
        }
    }
}
