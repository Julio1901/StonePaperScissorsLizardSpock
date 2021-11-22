package com.julio.stonepaperscissorslizardspock

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageButton
import android.widget.ImageView
import android.widget.TextView
import androidx.navigation.fragment.findNavController
import com.julio.stonepaperscissorslizardspock.databinding.ActivityMainBinding
import com.julio.stonepaperscissorslizardspock.databinding.FragmentGameBinding


class GameFragment : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        return inflater.inflate(R.layout.fragment_game, container, false)
    }


    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

       //val binding = FragmentGameBinding.inflate(layoutInflater)

        val textResult : TextView =  view.findViewById(R.id.textView_text_result)
        val imageViewYourMove: ImageView = view.findViewById(R.id.imageView_your_move)
        val imageViewComputerMove: ImageView = view.findViewById(R.id.imageView_computer_move)
        var numberResult : Int

        val btnSpock = view.findViewById<ImageButton>(R.id.btn_spock)
        val btnLizard = view.findViewById<ImageButton>(R.id.btn_lizard)
        val btnScissors = view.findViewById<ImageButton>(R.id.btn_scissors)
        val btnPaper = view.findViewById<ImageButton>(R.id.btn_paper)
        val btnRock = view.findViewById<ImageButton>(R.id.btn_rock)


        btnSpock.setOnClickListener{
            imageViewYourMove.setImageResource(R.drawable.spock)
            computerPlay(imageViewComputerMove)
            numberResult = computerPlay(imageViewComputerMove)
            textResult.text = checkResult("Spock", numberResult)

        }

        btnLizard.setOnClickListener {
            imageViewYourMove.setImageResource(R.drawable.lizard)
            computerPlay(imageViewComputerMove)
            numberResult = computerPlay(imageViewComputerMove)
            textResult.text = checkResult("Lizard", numberResult)
        }

        btnScissors.setOnClickListener {
            imageViewYourMove.setImageResource(R.drawable.scissors)
            computerPlay(imageViewComputerMove)
            numberResult = computerPlay(imageViewComputerMove)
            textResult.text = checkResult("Scissors", numberResult)
        }

        btnPaper.setOnClickListener {
            imageViewYourMove.setImageResource(R.drawable.paper)
            computerPlay(imageViewComputerMove)
            numberResult = computerPlay(imageViewComputerMove)
            textResult.text = checkResult("Papper", numberResult)
        }

        btnRock.setOnClickListener {
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

