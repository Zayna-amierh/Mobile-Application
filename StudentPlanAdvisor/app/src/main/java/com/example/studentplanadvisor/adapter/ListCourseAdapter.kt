package com.example.studentplanadvisor.adapter

import android.app.Activity
import android.content.Context
import android.content.Intent
import android.graphics.Color
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.BaseAdapter
import androidx.core.app.ActivityCompat
import com.example.studentplanadvisor.R
import com.example.studentplanadvisor.ShowDetailActivity
import com.example.studentplanadvisor.model.Course
import kotlinx.android.synthetic.main.raw_layout.view.*


/**
 * This is the adapter for the courses so we can deal with the lists and interact correctly
 */
class ListCourseAdapter(
    // These are the parameters that will be passed when creating an object of the class
    internal var activity: Activity,
    internal var listCourse: List<Course>

) : BaseAdapter() {
    internal var inflater: LayoutInflater
    var num1: Int = 0;
    var num2: Int = 0;
    var num3: Int = 0;
    // constructor to initiate the data member; We get the inflator in the constructor
    init {
        inflater =
            activity.getSystemService(Context.LAYOUT_INFLATER_SERVICE) as LayoutInflater
    }

    // creates a view to be used as a row in the list.
    // Here you define what information shows and where it sits within the ListView.
    override fun getView(position: Int, convertView: View?, parent: ViewGroup?): View {
        val rowView: View
        rowView = inflater.inflate(R.layout.raw_layout, null)
        rowView.txt_name.text = listCourse[position].name.toString()
        var colour =  listCourse[position].colour
        if (colour==1){
            rowView.txt_name.setBackgroundColor(Color.parseColor("#FFC000"));
            rowView.setBackgroundColor(Color.parseColor("#FFC000"));
        } else if (colour ==2){
            rowView.txt_name.setBackgroundColor(Color.parseColor("#CCFFFF"));
            rowView.setBackgroundColor(Color.parseColor("#CCFFFF"));
        } else if (colour ==3){
            rowView.txt_name.setBackgroundColor(Color.parseColor("#00FFCC"));
            rowView.setBackgroundColor(Color.parseColor("#00FFCC"));
        } else if (colour ==4){
            rowView.txt_name.setBackgroundColor(Color.parseColor("#FDEADA"));
            rowView.setBackgroundColor(Color.parseColor("#FDEADA"));
        }
        else if (colour==5){
            rowView.txt_name.setBackgroundColor(Color.parseColor("#FFFF00"));
            rowView.setBackgroundColor(Color.parseColor("#FFFF00"));
        } else {
            rowView.txt_name.setBackgroundColor(Color.parseColor("#FFFFFF"));
            rowView.setBackgroundColor(Color.parseColor("#FFFFFF"));
        }

        if (listCourse[position].prerequisites != "") {
            num1 = 1
        } else {
            num1 = 0
        }
        if (listCourse[position].prerequisites2 != "") {
            num2 = 1
        } else {
            num2 = 0
        }
        if (listCourse[position].prerequisites3 != "") {
            num3 = 1
        } else {
            num3 = 0
        }
        var num: Int = num1 + num2 + num3
        rowView.txt_pre.text = num.toString()

        rowView.setOnClickListener(object : View.OnClickListener {
            override fun onClick(v: View?) {
                var itemValue = listCourse[position].name

                    var int0 = Intent(activity, ShowDetailActivity::class.java)
                    int0.putExtra("item", itemValue)
                    ActivityCompat.startActivityForResult(activity,int0,1,null)
            }
        })


        return rowView
    }

    override fun getItem(position: Int): Any {
        return listCourse[position]
    }

    override fun getItemId(position: Int): Long {
        return listCourse[position].id.toLong()
    }

    override fun getCount(): Int {
        return listCourse.size
    }

}
