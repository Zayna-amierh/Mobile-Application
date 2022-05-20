package com.example.studentplanadvisor

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ListView
import com.example.studentplanadvisor.adapter.ListCourseAdapter
import com.example.studentplanadvisor.dbhelper.DBHelper
import com.example.studentplanadvisor.model.Course
import kotlinx.android.synthetic.main.activity_show_all.backbtn

/**
 * This activity will show all the courses for each semester of the year
 */
class ShowAllActivity2 : AppCompatActivity() {
    internal lateinit var db: DBHelper
    internal var listCourse: List<Course> = ArrayList<Course>() as List<Course>
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_show_all2)

        db = DBHelper(this)

        backbtn.setOnClickListener {
            intent = Intent(this, ShowAllActivity::class.java)
            startActivityForResult(intent, 1)
        }
        listCourse = db.getAllCourses(3)

        var year1ListView = findViewById<ListView>(R.id.yearListView)

        val adapterA = ListCourseAdapter(this, listCourse)
        year1ListView.adapter = adapterA

        // ==============================================================

        listCourse = db.getAllCourses(4)
        var year1ListView2 = findViewById<ListView>(R.id.year1ListView2)

        val adapterB = ListCourseAdapter(this, listCourse)
        year1ListView2.adapter = adapterB

    }
}