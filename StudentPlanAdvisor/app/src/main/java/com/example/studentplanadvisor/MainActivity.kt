package com.example.studentplanadvisor

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_main.*

/**
 * This is the main activity that will allow the user to select their major
 */
class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        ISbtn.setOnClickListener {
            intent = Intent(this, ComingSoonActivity::class.java)
            startActivityForResult(intent, 1)
        }

        CSbtn.setOnClickListener {
            intent = Intent(this, FillShowActivity::class.java)
            startActivityForResult(intent, 1)
        }
    }
}
