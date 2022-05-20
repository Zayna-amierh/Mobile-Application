package com.example.studentplanadvisor

import android.content.Intent
import android.os.Bundle
import android.widget.ListView
import androidx.appcompat.app.AppCompatActivity
import com.example.studentplanadvisor.adapter.ListCourseAdapter
import com.example.studentplanadvisor.dbhelper.DBHelper
import com.example.studentplanadvisor.model.Course
import kotlinx.android.synthetic.main.activity_show_all1.*

/**
 * This activity will show all the courses for each semester of the year
 */
class ShowAllActivity1 : AppCompatActivity() {
    internal lateinit var db: DBHelper
    internal var listCourse: List<Course> = ArrayList<Course>() as List<Course>
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_show_all1)
        db = DBHelper(this)

        backbtn.setOnClickListener {
            intent = Intent(this, ShowAllActivity::class.java)
            startActivityForResult(intent, 1)
        }

        listCourse = db.getAllCourses(1)

        var year1ListView = findViewById<ListView>(R.id.yearListView)

        val adapterA = ListCourseAdapter(this, listCourse)
        year1ListView.adapter = adapterA


        // ==============================================================

        listCourse = db.getAllCourses(2)
        var year1ListView2 = findViewById<ListView>(R.id.year1ListView2)


        val adapterB = ListCourseAdapter(this, listCourse)
        year1ListView2.adapter = adapterB

    }
}
