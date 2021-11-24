package com.julio.stonepaperscissorslizardspock.ui


import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.julio.stonepaperscissorslizardspock.R

class GameViewModel (): ViewModel(){

    val yourMove = MutableLiveData<Int>()
    val computerMove = MutableLiveData<Int>()
    val playResult = MutableLiveData<String>()
    val listOfResults = mutableListOf<String>()
    var gameNumber =  MutableLiveData<Int>(1)



    fun restartGameValues(){
       //blank
        yourMove.value = 0
        computerMove.value =0
        playResult.value = ""
        listOfResults.clear()
        gameNumber.value = 1
    }


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
        //TODO:Refactor this
        when(yourMove){
            "Spock" -> {
                if (result == 3 || result == 5){
                    playResult.value = "Winner"
                    addResultToHistory(gameNumber.value!!,"Winner")


                    gameNumber.value = gameNumber.value!! +1
                }else if(result == 1){
                    playResult.value =  "Draw"
                    addResultToHistory(gameNumber.value!!," Draw")
                    gameNumber.value = gameNumber.value!! +1
                }
                else{
                    playResult.value =  "Loser"
                    addResultToHistory(gameNumber.value!!,"Loser")
                    gameNumber.value = gameNumber.value!! +1
                }
            }
            "Lizard" -> {
                if (result == 1 || result == 4){
                    playResult.value = "Winner"
                    addResultToHistory(gameNumber.value!!," Winner")
                    gameNumber.value = gameNumber.value!! +1
                }else if(result == 2){
                    playResult.value = "Draw"
                    addResultToHistory(gameNumber.value!!,"Draw")
                    gameNumber.value = gameNumber.value!! +1
                }
                else{
                    playResult.value =  "Loser"
                    addResultToHistory(gameNumber.value!!," Loser")
                    gameNumber.value = gameNumber.value!! +1
                }
            }
            "Scissors" -> {
                if (result == 4 || result == 2){
                    playResult.value =  "Winner"
                    addResultToHistory(gameNumber.value!!," Winner")
                    gameNumber.value = gameNumber.value!! +1
                }else if(result == 3){
                    playResult.value =  "Draw"
                    addResultToHistory(gameNumber.value!!," Draw")
                    gameNumber.value = gameNumber.value!! +1
                }
                else{
                    playResult.value =  "Loser"
                    addResultToHistory(gameNumber.value!!," Loser")
                    gameNumber.value = gameNumber.value!! +1
                }
            }
            "Papper" ->{
                if (result == 1 || result == 5 ){
                    playResult.value =  "Winner"
                    addResultToHistory(gameNumber.value!!," Winner")
                    gameNumber.value = gameNumber.value!! +1
                }else if(result == 4){
                    playResult.value = "Draw"
                    addResultToHistory(gameNumber.value!!,"Draw")
                    gameNumber.value = gameNumber.value!! +1
                }
                else{
                    playResult.value =  "Loser"
                    addResultToHistory(gameNumber.value!!,"Loser")
                    gameNumber.value = gameNumber.value!! +1
                }
            }
            "Rock" ->{
                if (result == 2 || result == 3){
                    playResult.value =  "Winner"
                    addResultToHistory(gameNumber.value!!," Winner")
                    gameNumber.value = gameNumber.value!! +1
                }else if(result == 5){
                    playResult.value =  "Draw"
                    addResultToHistory(gameNumber.value!!,"Draw")
                    gameNumber.value = gameNumber.value!! +1
                }
                else {
                    playResult.value = "Loser"
                    addResultToHistory(gameNumber.value!!,"Loser")
                    gameNumber.value = gameNumber.value!! +1
                }
            }
        }

    }

    //Use this later
    fun addResultToHistory( gameNumber : Int, result: String){
        listOfResults.add("Result of match number $gameNumber: Player $result ")
    }



}