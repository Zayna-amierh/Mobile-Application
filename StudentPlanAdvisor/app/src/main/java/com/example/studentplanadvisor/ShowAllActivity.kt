package com.example.studentplanadvisor

import android.content.Intent
import android.os.Bundle
import android.view.View
import android.widget.AdapterView
import android.widget.ArrayAdapter
import android.widget.ListView
import androidx.appcompat.app.AppCompatActivity
import kotlinx.android.synthetic.main.activity_show_all.*

/**
 * This is the show activity where the user selects their year they want to view or select the elective item
 * selecting on one item will redirect them to the activity showing the courses for each semester of that year
 * For the electives, the activity will show all the courses that must be taken.
 */
class ShowAllActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_show_all)


        var courses1 = arrayOf(
            "Year(1)",
            "Year(2)",
            "Year(3)",
            "Year(4)",
            "Electives"
        )
        var yearListView = findViewById<ListView>(R.id.yearListView)
        val arrayAdapter =
            ArrayAdapter(this, android.R.layout.simple_expandable_list_item_1, courses1)
        yearListView.adapter = arrayAdapter

        yearListView.onItemClickListener = object : AdapterView.OnItemClickListener {
            override fun onItemClick(parent: AdapterView<*>, view: View, position: Int, id: Long) {


                if (position === 0) {
                    val int0 = Intent(applicationContext, ShowAllActivity1::class.java)
                    startActivity(int0)
                } else if (position === 1) {
                    val int1 = Intent(applicationContext, ShowAllActivity2::class.java)
                    startActivity(int1)
                } else if (position === 2) {
                    val int2 = Intent(applicationContext, ShowAllActivity3::class.java)
                    startActivity(int2)
                } else if (position === 3) {
                    val int3 = Intent(
                        applicationContext,
                        ShowAllActivity4::class.java
                    )
                    startActivity(int3)
                }else if (position === 4) {
                    val int4 = Intent(
                        applicationContext,
                        ShowAllActivity5::class.java
                    )
                    startActivity(int4)
                }
            }
        }


        backbtn.setOnClickListener {
            intent = Intent(this, FillShowActivity::class.java)
            startActivityForResult(intent,1)
        }


    }
    }

