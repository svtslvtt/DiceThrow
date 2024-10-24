package edu.temple.dicethrow

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button


class ButtonFragmnet : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_button_fragmnet, container, false).apply {
            findViewById<Button>(R.id.button).setOnClickListener {
                (requireActivity() as ButtonInterface).buttonClicked()
            }

        }
    }

        interface ButtonInterface {
            fun buttonClicked()
        }


    }



