package com.julio.stonepaperscissorslizardspock

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.ImageButton
import android.widget.ImageView
import android.widget.TextView
import com.julio.stonepaperscissorslizardspock.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        val binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val textResult : TextView = binding.textViewTextResult
        val imageViewYourMove: ImageView = binding.imageViewYourMove
        val imageViewComputerMove: ImageView = binding.imageViewComputerMove
        var numberResult : Int

        binding.btnSpock.setOnClickListener{
            imageViewYourMove.setImageResource(R.drawable.spock)
            computerPlay(imageViewComputerMove)
            numberResult = computerPlay(imageViewComputerMove)
            textResult.text = checkResult("Spock", numberResult)
        }

        binding.btnLizard.setOnClickListener {
            imageViewYourMove.setImageResource(R.drawable.lizard)
            computerPlay(imageViewComputerMove)
            numberResult = computerPlay(imageViewComputerMove)
            textResult.text = checkResult("Lizard", numberResult)
        }

       binding.btnScissors.setOnClickListener {
            imageViewYourMove.setImageResource(R.drawable.scissors)
            computerPlay(imageViewComputerMove)
            numberResult = computerPlay(imageViewComputerMove)
            textResult.text = checkResult("Scissors", numberResult)
        }

        binding.btnPaper.setOnClickListener {
            imageViewYourMove.setImageResource(R.drawable.paper)
            computerPlay(imageViewComputerMove)
            numberResult = computerPlay(imageViewComputerMove)
            textResult.text = checkResult("Papper", numberResult)
        }

        binding.btnRock.setOnClickListener {
            imageViewYourMove.setImageResource(R.drawable.rock)
            computerPlay(imageViewComputerMove)
            numberResult = computerPlay(imageViewComputerMove)
            textResult.text = checkResult("Rock", numberResult)
        }
    }

    fun computerPlay(imageViewComputerMove: ImageView) : Int {

        var numberToReturn = 0
        when ((1..5).random()) {
            1 -> {
                imageViewComputerMove.setImageResource(R.drawable.spock)
                numberToReturn = 1
            }
            2 -> {
                imageViewComputerMove.setImageResource(R.drawable.lizard)
                numberToReturn = 2
            }
            3 -> {
                imageViewComputerMove.setImageResource(R.drawable.scissors)
                numberToReturn = 3
            }
            4 -> {
                imageViewComputerMove.setImageResource(R.drawable.paper)
                numberToReturn = 4
            }
            5 -> {
                imageViewComputerMove.setImageResource(R.drawable.rock)
                numberToReturn = 5
            }
        }
        return numberToReturn
    }

    fun checkResult(yourMove : String, result : Int) : String{

        var message = ""

        when(yourMove){
            "Spock" -> {
                if (result == 3 || result == 5){
                    message = "Winner"
                }else if(result == 1){
                    message = "Draw"
                }
                else{
                    message = "Loser"
                }
            }
            "Lizard" -> {
                if (result == 1 || result == 4){
                    message = "Winner"
                }else if(result == 2){
                    message = "Draw"
                }
                else{
                    message = "Loser"
                }
            }
            "Scissors" -> {
                if (result == 4 || result == 2){
                    message = "Winner"
                }else if(result == 3){
                    message = "Draw"
                }
                else{
                    message = "Loser"
                }
            }
            "Papper" ->{
                if (result == 1 || result == 5 ){
                    message = "Winner"
                }else if(result == 4){
                    message = "Draw"
                }
                else{
                    message = "Loser"
                }
            }
            "Rock" ->{
                if (result == 2 || result == 3){
                    message = "Winner"
                }else if(result == 5){
                    message = "Draw"
                }
                else {
                    message = "Loser"
                }
            }
        }
        return message
    }
}