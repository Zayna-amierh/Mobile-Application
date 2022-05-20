package com.example.studentplanadvisor

import android.app.Activity
import android.content.Intent
import android.os.Bundle
import android.view.View
import android.widget.AdapterView
import android.widget.ArrayAdapter
import android.widget.RadioButton
import androidx.appcompat.app.AlertDialog
import androidx.appcompat.app.AppCompatActivity
import com.example.studentplanadvisor.dbhelper.DBHelper
import com.example.studentplanadvisor.model.Course
import kotlinx.android.synthetic.main.activity_filling.*

/**
This is the filling form activity where the users will enter in course information
 */
class FillingActivity : AppCompatActivity() {
    lateinit var db: DBHelper
    lateinit var sp1: String
    lateinit var sp2: String
    lateinit var sp3: String
    lateinit var sp4: String
    lateinit var sp5: String
    var sp: Int = 0
    var r: Int = 0
    lateinit var rb: String
    lateinit var rq: String

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_filling)
        var rb1 = findViewById<RadioButton>(R.id.rb1)
        var rb2 = findViewById<RadioButton>(R.id.rb2)
        var rb3 = findViewById<RadioButton>(R.id.rb3)
        var rb4 = findViewById<RadioButton>(R.id.rb4)


        db = DBHelper(this)
        // Spinner
        val courses = arrayOf(
            "Select",
            "English Pre-Intermediate",
            "English Upper Intermediate",
            "English Intermediate",
            "English Advanced",
            "Functional Math",
            "Functional Physics",
            "Fundamentals of Computing",
            "Soft Skills I",
            "Soft Skills II",
            "Work Shop I",
            "Networking",
            "Programming",
            "Professional Practice",
            "Database Design & Development",
            "STEM Lab I",
            "Managing a Successful Computing Project",
            "Entrepreneurship Bootcamp",
            "Data Structure and Algorithms",
            "Advanced Programming",
            "Leadership Camp",
            "Security",
            "Network Security",
            "Application Development",
            "Prototyping",
            "Computing Research Project",
            "Operating Systems",
            "Database Programming",
            "Business Intelligence",
            "Advanced Software Engineering",
            "IT Seminar",
            "Systems Programming",
            "Advanced Computer Architecture",
            "Compiler Design",
            "Electronic Commerce",
            "On-Job Training"
        )

        val arrAda = ArrayAdapter(
            this,
            android.R.layout.simple_spinner_item,
            courses
        )

        prespinner1.adapter = arrAda
        prespinner1.onItemSelectedListener = object :
            AdapterView.OnItemSelectedListener {
            override fun onItemSelected(
                parent: AdapterView<*>,
                view: View?,
                position: Int,
                id: Long
            ) {
                sp1 = parent.getItemAtPosition(position).toString()
                // Make sure the select returns nothing in the database.
                if (sp1 == "Select"){
                    sp1 =""
                }

            }

            override fun onNothingSelected(parent: AdapterView<*>?) {
            }

        }

        val arrAda2 = ArrayAdapter(
            this,
            android.R.layout.simple_spinner_item,
            courses
        )
        prespinner2.adapter = arrAda2
        prespinner2.onItemSelectedListener = object :
            AdapterView.OnItemSelectedListener {
            override fun onItemSelected(
                parent: AdapterView<*>,
                view: View?,
                position: Int,
                id: Long
            ) {
                sp2 = parent.getItemAtPosition(position).toString()
                if (sp2 == "Select"){
                    sp2 =""
                }
            }

            override fun onNothingSelected(parent: AdapterView<*>?) {
            }
        }
        val arrAda3 = ArrayAdapter(
            this,
            android.R.layout.simple_spinner_item,
            courses
        )
        prespinner3.adapter = arrAda3
        prespinner3.onItemSelectedListener = object :
            AdapterView.OnItemSelectedListener {
            override fun onItemSelected(
                parent: AdapterView<*>,
                view: View?,
                position: Int,
                id: Long
            ) {
                sp3 = parent.getItemAtPosition(position).toString()
                if (sp3 == "Select"){
                    sp3 =""
                }
            }

            override fun onNothingSelected(parent: AdapterView<*>?) {
            }
        }

        val semester = arrayOf(
            "Year(1), Fall Semester",
            "Year(1), Spring Semester",
            "Year(2), Fall Semester",
            "Year(2), Spring Semester",
            "Year(3), Fall Semester",
            "Year(3), Spring Semester",
            "Year(4), Fall Semester",
            "Year(4), Spring Semester",
            "Changeable"
        )
        val arrAda4 = ArrayAdapter(
            this,
            android.R.layout.simple_spinner_item,
            semester
        )
        prespinner.adapter = arrAda4
        prespinner.onItemSelectedListener = object :
            AdapterView.OnItemSelectedListener {
            override fun onItemSelected(
                parent: AdapterView<*>,
                view: View?,
                position: Int,
                id: Long
            ) {
                sp4 = parent.getItemAtPosition(position).toString()
            }

            override fun onNothingSelected(parent: AdapterView<*>?) {
            }
        }
        val department = arrayOf(
            "University",
            "Faculty",
            "Department",
            "HNC",
            "HND"
        )
        val arrAda5 = ArrayAdapter(
            this,
            android.R.layout.simple_spinner_item,
            department
        )
        prespinner4.adapter = arrAda5
        prespinner4.onItemSelectedListener = object :
            AdapterView.OnItemSelectedListener {
            override fun onItemSelected(
                parent: AdapterView<*>,
                view: View?,
                position: Int,
                id: Long
            ) {
                sp5 = parent.getItemAtPosition(position).toString()

            }

            override fun onNothingSelected(parent: AdapterView<*>?) {
            }
        }

        submitbtn.setOnClickListener {
            var id = idedt.text.toString()
            var name = nameedt.text.toString()
            var sp :Int = 0
            var r: Int = 0

            if(rb1.isChecked){
                rb = rb1.text.toString()
            } else if(rb2.isChecked){
                rb = rb2.text.toString()
            }

            if(rb3.isChecked){
                rq = rb3.text.toString()
            } else if(rb4.isChecked){
                rq = rb4.text.toString()
            }

            if(sp4 == "Year(1), Fall Semester"){
                sp = 1
            } else if (sp4 == "Year(1), Spring Semester"){
                sp = 2
            } else if (sp4 == "Year(2), Fall Semester"){
                sp = 3
            } else if (sp4 == "Year(2), Spring Semester"){
                sp = 4
            } else if (sp4 == "Year(3), Fall Semester"){
                sp = 5
            } else if (sp4 == "Year(3), Spring Semester"){
                sp = 6
            } else if (sp4 == "Year(4), Fall Semester"){
                sp = 7
            } else if (sp4 == "Year(4), Spring Semester"){
                sp = 8
            } else if (sp4 == "Changeable") {
                sp = 0
            }

            if(sp5 == "University"){
                r = 1
            } else if (sp5 == "Faculty"){
                r = 2
            } else if (sp5 == "Department"){
                r = 3
            } else if (sp5 == "HNC"){
                r = 4
            } else if (sp5 == "HND"){
                r = 5
            }
            var course = Course(id.toInt(), name, sp1, sp2, sp3, rb, rq, sp, r)

            val builder = AlertDialog.Builder(this)
            builder.setTitle("Confirmation")
            builder.setMessage("Are you sure you want to submit? This cannot be undone")

            builder.setPositiveButton(android.R.string.yes) { dialog, which ->
                db.addCourse(course)
                intent = Intent(this, FillShowActivity::class.java)
                setResult(Activity.RESULT_OK,intent)
                finish()
            }

            builder.setNegativeButton(android.R.string.no) { dialog, which ->
            }

            builder.show()

        }

    }
}

