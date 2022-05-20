package com.example.studentplanadvisor

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.appcompat.app.AlertDialog
import kotlinx.android.synthetic.main.activity_fill_show.*

/**
 * This allow users to go to the filling activity or show activity
 * Clicking on the HTU logo will allow the user to go to the main activity
 */
class FillShowActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_fill_show)

        fillbtn.setOnClickListener {
            intent = Intent(this, FillingActivity::class.java)
            startActivityForResult(intent, 1)
        }

        showbtn.setOnClickListener{
            intent = Intent(this, ShowAllActivity::class.java)
            startActivityForResult(intent, 1)
        }

        imageView.setOnClickListener {
            intent = Intent(this, MainActivity::class.java)
            startActivityForResult(intent, 1)
        }


    }
    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        super.onActivityResult(requestCode, resultCode, data)
        if (requestCode == 1 && resultCode == RESULT_OK) {
            val builder = AlertDialog.Builder(this)
            builder.setTitle("Confirmation")
            builder.setMessage("Course has been successfully added")

            builder.setPositiveButton(android.R.string.yes) { dialog, which ->
            }

            builder.show()

        }
    }
}
