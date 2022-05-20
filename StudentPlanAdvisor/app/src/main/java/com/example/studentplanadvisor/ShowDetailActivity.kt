package com.example.studentplanadvisor

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.example.studentplanadvisor.adapter.ListCourseAdapter
import com.example.studentplanadvisor.dbhelper.DBHelper
import kotlinx.android.synthetic.main.activity_show_detail.*

/**
 * This activity will show all the information of the specific course chosen from the listview
 */
class ShowDetailActivity : AppCompatActivity() {
    internal lateinit var db: DBHelper
    internal lateinit var adapter: ListCourseAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_show_detail)
        db = DBHelper(this)

        var title: String = ""
        title = intent.getStringExtra("item")

        var c = db.getAllCourseItems(title)
        var name = c[0]
        var id = c[1]
        var pre1 = c[2]
        var pre2 = c[3]
        var pre3 = c[4]
        var cat = c[5]
        var req = c[6]
        var sem = c[7]
        nametv2.text = name
        idtv2.text = id


        if(sem =="1"){
            sem = "Year(1), Fall Semester"
        } else if (sem =="2"){
            sem = "Year(1), Spring Semester"
        } else if (sem =="3"){
            sem = "Year(2), Fall Semester"
        } else if (sem =="4"){
            sem = "Year(2), Spring Semester"
        } else if (sem =="5"){
            sem = "Year(3), Fall Semester"
        } else if (sem =="6"){
            sem = "Year(3), Spring Semester"
        } else if (sem =="7"){
            sem = "Year(4), Fall Semester"
        } else if (sem =="8"){
            sem = "Year(4), Spring Semester"
        } else if (sem=="0"){
            sem = "Changeable"
        }

        if(pre1 == "" && pre2 == "" && pre3 ==""){
            pretv2.text = "No Pre-requsites"
        } else if (pre1 == "" && pre2 == "" && pre3!=""){
            pretv2.text = "- " +pre3
        }else if (pre1 != "" && pre2 == "" && pre3==""){
            pretv2.text = "- " +pre1
        } else if (pre1 == "" && pre2 != "" && pre3==""){
            pretv2.text = "- " +pre2
        }
        else if (pre1 != "" && pre2 == "" && pre3!=""){
            pretv2.text = "- " +pre1+ "\n" +"- " + pre3
        }
        else if (pre1 != "" && pre2 != "" && pre3==""){
            pretv2.text = "- " +pre1+ "\n" +"- " + pre2
        }
        else if (pre1 != "" && pre2 == "" && pre3!=""){
            pretv2.text = "- " +pre1+ "\n" +"- " + pre3
        } else {
            pretv2.text = "- " + pre1+ "\n" +"- " + pre2 + "\n" +"- " + pre3
        }
        category2.text = cat
        requirementtv2.text = req
        semestertv2.text = sem


        backbtn.setOnClickListener {
            finish()
        }


    }
}
