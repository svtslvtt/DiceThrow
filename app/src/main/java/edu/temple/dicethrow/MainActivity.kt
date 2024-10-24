package edu.temple.dicethrow

import android.os.Bundle
import android.widget.Button
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class MainActivity : AppCompatActivity(), ButtonFragmnet.ButtonInterface {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)



        val fragment = DieFragment.newInstance(100)

        supportFragmentManager
            .beginTransaction()
            .add(R.id.dieContainer, fragment)
            .commit()


    }

    override fun buttonClicked() {
        (supportFragmentManager
            .findFragmentById(R.id.dieContainer) as DieFragment).throwDie()

    }
}