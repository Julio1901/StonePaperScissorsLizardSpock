package com.julio.stonepaperscissorslizardspock.ui


import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.julio.stonepaperscissorslizardspock.R

class GameViewModel (): ViewModel(){

    val yourMove = MutableLiveData<Int>()
    val computerMove = MutableLiveData<Int>()
    val playResult = MutableLiveData<String>()


    fun setUserPlay(choice : String){
        when(choice){
            "Spock" -> yourMove.value = R.drawable.spock
            "Lizard" -> yourMove.value = R.drawable.lizard
            "Scissors" -> yourMove.value = R.drawable.scissors
            "Paper" -> yourMove.value = R.drawable.paper
            "Rock" -> yourMove.value = R.drawable.rock
        }
    }


    fun setComputerPlay() : Int {

        var numberToReturn = 0
        when ((1..5).random()) {
            1 -> {
                 computerMove.value = R.drawable.spock
                numberToReturn = 1
            }
            2 -> {
                computerMove.value = R.drawable.lizard
                numberToReturn = 2
            }
            3 -> {
                computerMove.value = R.drawable.scissors
                numberToReturn = 3
            }
            4 -> {
                computerMove.value = R.drawable.paper
                numberToReturn = 4
            }
            5 -> {
                computerMove.value = R.drawable.rock
                numberToReturn = 5
            }
        }

        return numberToReturn
    }

    fun checkResult(yourMove : String, result : Int){

        when(yourMove){
            "Spock" -> {
                if (result == 3 || result == 5){
                    playResult.value = "Winner"
                }else if(result == 1){
                    playResult.value =  "Draw"
                }
                else{
                    playResult.value =  "Loser"
                }
            }
            "Lizard" -> {
                if (result == 1 || result == 4){
                    playResult.value = "Winner"
                }else if(result == 2){
                    playResult.value = "Draw"
                }
                else{
                    playResult.value =  "Loser"
                }
            }
            "Scissors" -> {
                if (result == 4 || result == 2){
                    playResult.value =  "Winner"
                }else if(result == 3){
                    playResult.value =  "Draw"
                }
                else{
                    playResult.value =  "Loser"
                }
            }
            "Papper" ->{
                if (result == 1 || result == 5 ){
                    playResult.value =  "Winner"
                }else if(result == 4){
                    playResult.value = "Draw"
                }
                else{
                    playResult.value =  "Loser"
                }
            }
            "Rock" ->{
                if (result == 2 || result == 3){
                    playResult.value =  "Winner"
                }else if(result == 5){
                    playResult.value =  "Draw"
                }
                else {
                    playResult.value = "Loser"
                }
            }
        }

    }

}