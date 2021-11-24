package com.julio.stonepaperscissorslizardspock

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import androidx.fragment.app.activityViewModels
import androidx.fragment.app.viewModels
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.RecyclerView
import com.julio.stonepaperscissorslizardspock.ui.GameViewModel


class ResultFragment : Fragment() {

    val gameViewModel : GameViewModel by activityViewModels()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        return inflater.inflate(R.layout.fragment_result, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)


        val recyclerView = view.findViewById<RecyclerView>(R.id.recyclerView_result)
        val listResults = gameViewModel.listOfResults

        val btnPlayAgain = view.findViewById<Button>(R.id.btn_play_again)


        recyclerView.adapter = ResultAdapter(this.requireContext(), listResults)
        recyclerView.setHasFixedSize(true)

        btnPlayAgain.setOnClickListener {
            gameViewModel.restartGameValues()
            val action = ResultFragmentDirections.actionResultoToGameAgain()
            findNavController().navigate(action)
        }


    }





}