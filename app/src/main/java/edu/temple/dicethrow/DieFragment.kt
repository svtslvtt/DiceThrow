package edu.temple.dicethrow

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.annotation.Size
import androidx.core.os.bundleOf
import kotlin.random.Random


const val DICE_ROLL = "DICEROLL"

class DieFragment : Fragment() {


    val DIESIDE = "sidenumber"

    lateinit var dieTextView: TextView

    var dieSides: Int = 6
    var dieRoll: Int = -1

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        arguments?.let {
            it.getInt(DIESIDE).run {
                dieSides = this
            }
        }
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_die, container, false).apply {
            dieTextView = findViewById(R.id.dieTextView)
        }
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        savedInstanceState?.run {
            dieRoll = getInt(DICE_ROLL)
        }
        if (dieRoll == -1){
            throwDie()
        }
        else {
            dieTextView.text = dieRoll.toString()
        }
        throwDie()
        view.setOnClickListener{
            throwDie()
        }
    }

    fun throwDie() {
        dieRoll = Random.nextInt(dieSides) + 1
        dieTextView.text = dieRoll.toString()
    }

    override fun onSaveInstanceState(outState: Bundle) {
        super.onSaveInstanceState(outState)
        outState.getInt(DICE_ROLL, dieRoll)

    }

    companion object {

    fun newInstance(size: Int) = DieFragment().apply {
        arguments = Bundle().apply {
            putInt(DIESIDE, dieSides)
        }
    }




    }

}