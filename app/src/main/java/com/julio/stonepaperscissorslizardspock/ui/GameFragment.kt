package com.julio.stonepaperscissorslizardspock.ui

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageButton
import android.widget.ImageView
import android.widget.TextView
import androidx.fragment.app.activityViewModels
import androidx.fragment.app.viewModels
import androidx.lifecycle.Observer
import androidx.navigation.fragment.findNavController
import com.julio.stonepaperscissorslizardspock.R
import com.julio.stonepaperscissorslizardspock.StartFragmentDirections


class GameFragment : Fragment() {

    val gameViewModel : GameViewModel by activityViewModels()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        return inflater.inflate(R.layout.fragment_game, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val textResult : TextView =  view.findViewById(R.id.textView_text_result)
        val imageViewYourMove: ImageView = view.findViewById(R.id.imageView_your_move)
        val imageViewComputerMove: ImageView = view.findViewById(R.id.imageView_computer_move)
        var numberResult : Int

        val btnSpock = view.findViewById<ImageButton>(R.id.btn_spock)
        val btnLizard = view.findViewById<ImageButton>(R.id.btn_lizard)
        val btnScissors = view.findViewById<ImageButton>(R.id.btn_scissors)
        val btnPaper = view.findViewById<ImageButton>(R.id.btn_paper)
        val btnRock = view.findViewById<ImageButton>(R.id.btn_rock)

        btnSpock.setOnClickListener {
            gameViewModel.setUserPlay("Spock")
            numberResult = gameViewModel.setComputerPlay()
            gameViewModel.checkResult("Spock", numberResult)
        }

        btnLizard.setOnClickListener {
            gameViewModel.setUserPlay("Lizard")
            numberResult = gameViewModel.setComputerPlay()
            gameViewModel.checkResult("Lizard", numberResult)
        }

        btnScissors.setOnClickListener {
            gameViewModel.setUserPlay("Scissors")
            numberResult = gameViewModel.setComputerPlay()
            gameViewModel.checkResult("Scissors", numberResult)
        }

        btnPaper.setOnClickListener {
            gameViewModel.setUserPlay("Paper")
            numberResult = gameViewModel.setComputerPlay()
            gameViewModel.checkResult("Papper", numberResult)
        }

        btnRock.setOnClickListener {
            gameViewModel.setUserPlay("Rock")
            gameViewModel.setComputerPlay()
            numberResult = gameViewModel.setComputerPlay()
            gameViewModel.checkResult("Rock", numberResult)
        }

        gameViewModel.yourMove.observe(viewLifecycleOwner, Observer {
            imageViewYourMove.setImageResource(it)
        })

        gameViewModel.computerMove.observe(viewLifecycleOwner, Observer {
            imageViewComputerMove.setImageResource(it)
        })

        gameViewModel.playResult.observe(viewLifecycleOwner, Observer {
            textResult.text = it
        })


        //TODO: Pegar informação da lista do model
        gameViewModel.gameNumber.observe(viewLifecycleOwner, Observer {
            if (it > 3){
                val action = GameFragmentDirections.actionGameToResult()
                findNavController().navigate(action)
            }
        })
    }
 }

