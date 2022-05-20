package com.example.studentplanadvisor.dbhelper

import android.content.ContentValues
import android.content.Context
import android.database.sqlite.SQLiteDatabase
import android.database.sqlite.SQLiteOpenHelper
import androidx.core.database.getIntOrNull
import androidx.core.database.getStringOrNull
import com.example.studentplanadvisor.model.Course

/**
 * This is the DB helper that contains everything that is needed to handle the database of the application
 */
class DBHelper(context: Context) : SQLiteOpenHelper(context, DATABASE_NAME, null, DATABASE_VER) {

    companion object {
        private val DATABASE_NAME = "CourseInformation.db" //database name
        private val DATABASE_VER = 2 // database version


        //table name and table column names
        private val tCourses = "Courses"
        private val tYears = "Years"
        private val COL_ID = "id"
        private val COL_NAME = "name"
        private val COL_PREREQUISITE = "prerequisites"
        private val COL_PREREQUISITE2 = "prerequisites2"
        private val COL_PREREQUISITE3 = "prerequisites3"
        private val COL_CATEGORY = "category"
        private val COL_REQUIREMENT = "requirement"
        private val COL_SEMESTER = "semester"
        private val COL_COLOUR = "colour"

    }

    // create table
    override fun onCreate(db: SQLiteDatabase?) {
        val CREATE_TABLE_COURSES =
            ("CREATE TABLE $tCourses ( $COL_ID INTEGER, $COL_NAME TEXT, $COL_PREREQUISITE TEXT NULL, $COL_PREREQUISITE2 TEXT NULL, $COL_PREREQUISITE3 TEXT NULL, $COL_CATEGORY TEXT, $COL_REQUIREMENT TEXT, $COL_SEMESTER INTEGER , $COL_COLOUR INTEGER)")

        db!!.execSQL(CREATE_TABLE_COURSES) // execSQL() used to execute the SQL command

        val CREATE_TABLE_YEAR =
            ("CREATE TABLE $tYears ( $COL_ID INTEGER PRIMARY KEY, $COL_NAME TEXT)")
        db!!.execSQL(CREATE_TABLE_YEAR)

        Insert(db!!)

    }

    // insert table
    fun Insert(db: SQLiteDatabase?) {
        val INSERT_TABLE_QUERY =
            "INSERT INTO $tCourses($COL_ID, $COL_NAME, $COL_PREREQUISITE, $COL_PREREQUISITE2, $COL_PREREQUISITE3, $COL_CATEGORY, $COL_REQUIREMENT, " +
                    "$COL_SEMESTER, $COL_COLOUR) " +
                    "VALUES (30301121, 'English Pre-Intermediate Intensive','','','', 'HTU', 'Mandatory', 1, 1) " +
                    ", (30303111, 'Functional Math','','','', 'HTU', 'Mandatory', 1, 2)" +
                    ", (30309112, 'Functional Physics','','','', 'HTU', 'Mandatory', 1, 2)" +
                    ", (30201100, 'Fundamentals of Computing','','','', 'HTU', 'Mandatory', 1, 2)" +
                    ", (30302111, 'Soft Skills I', '','','', 'HTU','Mandatory',1, 1)" +
                    ", (30301122, 'English Intermediate', 'English Pre-Intermediate Intensive', '', '', 'HTU','Mandatory',2, 1 )" +
                    ", (00101103, 'Workshop I', '','', '', 'HTU','Mandatory',2, 2 )" +
                    ", (30201110, 'Networking', 'Fundamentals of Computing', '', '', 'Pearson','Mandatory',2, 4 )" +
                    ", (30201101, 'Programming', 'Fundamentals of Computing', '', '', 'Pearson','Mandatory',2, 4 )" +
                    ", (30202111, 'Soft Skills II', 'Soft Skills I', '', '', 'HTU','Mandatory',2, 1)" +
                    ", (30202191, 'Professional Practice', '', '', '', 'HTU','Mandatory',2, 2)" +
                    ", (30301121, 'English Upper-Intermediate', 'English Intermediate', '', '', 'HTU','Mandatory',3, 1)" +
                    ", (30201140, 'Security', 'Networking', '', '', 'Pearson','Mandatory',3 , 4)" +
                    ", (30201120, 'Database Design & Development','Programming', '', '', 'Pearson','Mandatory',3, 4 )" +
                    ", (30303121, 'STEM Lab I','', '', '', 'HTU','Mandatory',3, 2 )" +
                    ", (30202190, 'Managing a Successful Project','Professional Practice', 'Fundamentals of Computing', '', 'HTU','Mandatory',3, 2 )" +
                    ", (30201124, 'English Advanced','English Upper-Intermediate', '', '', 'HTU','Mandatory',4, 1 )" +
                    ", (30302231, 'Entrepreneurship Bootcamp','English Advanced','', '', 'HTU','Mandatory',4, 1)" +
                    ", (30202200, 'Data Structures & Algorithms','Programming', '', '', 'Pearson','Mandatory',4, 5 )" +
                    ", (30201200, 'Advanced Programming','Programming', '', '', 'Pearson','Mandatory',4, 5)" +
                    ", (30302232, 'Leadership Camp','Entrepreneurship Bootcamp', '', '', 'HTU','Mandatory',5, 1)" +
                    ", (30201210, 'Network Security','Networking', 'Security', '', 'Pearson','Mandatory',5, 5)" +
                    ", (30201260, 'Application Development','Data Structures and Algorithms', 'Database Design and Development', '', 'Pearson','Mandatory',5, 5)" +
                    ", (30201261, 'Prototyping','Programming', '', '', 'Pearson','Mandatory',5, 5)" +
                    ", (30202290, 'Computer Research Project','Managing a Successful Project', '', '', 'Pearson','Mandatory',5, 5)" +
                    ", (30201420, 'Operating Systems','Computer Systems Architecture', '', '', 'HTU','Mandatory',6, 3)" +
                    ", (30201401, 'Database Programming','Database Design and Development', '', '', 'HTU','Mandatory',6, 3)" +
                    ", (30202230, 'Business Intelligence','Database Design and Development', '', '', 'Pearson','Mandatory',6, 5)" +
                    ", (30201421, 'Advanced Software Engineering','Software Development Lifecycles', '', '', 'HTU','Mandatory',6, 3)" +
                    ", (30201271, 'IT Seminar','', '', '', 'HTU','Mandatory',6, 2)" +
                    ", (30201400, 'Systems Programming','Operating Systems', 'Networking', 'Programming', 'HTU','Mandatory',7, 3)" +
                    ", (30201480, 'Advanced Computer Architecture','Computer Systems Architecture', '', '', 'HTU','Mandatory',7, 3)" +
                    ", (30201460, 'Compiler Design','Programming', '', '', 'HTU','Mandatory',7, 3)" +
                    ", (30201471, 'Electronic Commerce','Website Design and Development', '', '', 'HTU','Mandatory',7, 3)" +
                    ", (30201390, 'On Job Training','Approval from university', '', '', 'HTU','Mandatory',8, 3)" +
                   // Electives
                    ", (30301130, 'French Language','', '', '', 'HTU','Elective',0, 1)" +
                    ", (30302121, 'Arab Contributions ','', '', '', 'HTU','Elective',0, 1)" +
                    ", (30302122, 'Philosophy of Science','', '', '', 'HTU','Elective',0, 1)" +
                    ", (30302123, 'Art Appreciation and Techniques','', '', '', 'HTU','Elective',0, 1)" +
                    ", (30302124, 'Civil & Professional Culture','', '', '', 'HTU','Elective',0, 1)" +
                    ", (30302125, 'Rights and Responsibilities','', '', '', 'HTU','Elective',0, 1)" +
                    ", (30302133, 'Principles of Management','', '', '', 'HTU','Elective',0, 1)" +
                    ", (30302134, 'Strategies for Industry Competitiveness','', '', '', 'HTU','Elective',0, 1)" +
                    // Department Electives
                    ", (30201422, 'Distributed Systems','Networking', 'Operating systems', '', 'HTU','Elective',0,3)" +
                    ", (30201435, 'Real-Time Systems','Programming', 'Operating Systems', '', 'HTU','Elective',0, 3)" +
                    ", (30201461, 'Mobile Application Development','Programming', 'Prototyping', '', 'HTU','Elective',0, 3)" +
                    ", (30201470, 'Special Topics','Department Approval', '', '', 'HTU','Elective',0, 3)" +
                    ", (30201481, 'Robotics','Programming', 'Math for Computing', '', 'HTU','Elective',0, 3)" +
                    // HNC
                    ", (30201102, 'Website Design & Development','Programming', '', '', 'Pearson','Elective',0, 4)" +
                    ", (30201121, 'Software Development and Lifecycles','Programming', '', '', 'Pearson','Elective',0, 4)" +
                    ", (30201181, 'Computer Systems Architecture','Networking', '', '', 'Pearson','Elective',0, 4)" +
                    ", (30202130, 'Data Analytics','Fundamentals of Computing', 'Maths for Computing', '', 'Pearson','Elective',0, 4)" +
                    ", (30202150, 'Strategic Information Systems','Fundamentals of Computing', 'Professional Practice', '', 'Pearson','Elective',0, 4)" +
                    ", (30202180, 'Maths for Computing','', '', '', 'Pearson','Elective',0, 4)"

        db!!.execSQL(INSERT_TABLE_QUERY)
        val INSERT_YEAR = "INSERT INTO $tYears($COL_ID, $COL_NAME) " +
                "VALUES (1, 'Year(1) Fall Semester'), " +
                "(2, 'Year(1) Spring Semester')," +
                "(3, 'Year(2) Fall Semester')," +
                "(4, 'Year(2) Spring Semester')," +
                "(5, 'Year(3) Fall Semester')," +
                "(6, 'Year(3) Spring Semester')," +
                "(7, 'Year(4) Fall Semester')," +
                "(8, 'Year(4) Spring Semester')," +
                "(0, '')"
        db!!.execSQL(INSERT_YEAR)

    }

    // drop table
    override fun onUpgrade(db: SQLiteDatabase?, oldVersion: Int, newVersion: Int) {
        db!!.execSQL("DROP TABLE IF EXISTS $tCourses ")
        db!!.execSQL("DROP TABLE IF EXISTS $tYears ")
        onCreate(db!!)

    }

    //add new course
    fun addCourse(course: Course) {
        val db = this.writableDatabase // open the connection with database
        val values = ContentValues()
        values.put(COL_ID, course.id)
        values.put(COL_NAME, course.name)
        values.put(COL_PREREQUISITE, course.prerequisites)
        values.put(COL_PREREQUISITE2, course.prerequisites2)
        values.put(COL_PREREQUISITE3, course.prerequisites3)
        values.put(COL_CATEGORY, course.category)
        values.put(COL_REQUIREMENT, course.requirement)
        values.put(COL_SEMESTER, course.semester)
        values.put(COL_COLOUR, course.colour)

        db.insert(tCourses, null, values)
        db.close() // close the connection to the database
    }

    //read all courses according to semester
    fun getAllCourses(num: Int): ArrayList<Course> {
        val listCourse = ArrayList<Course>()
        val selectQuery = "SELECT * FROM $tCourses where $COL_SEMESTER = $num"
        val db = this.writableDatabase
        val cursor = db.rawQuery(selectQuery, null)
        if (cursor.moveToFirst()) { //move to the first row
            do {
                val course = Course()
                course.id = cursor.getInt(cursor.getColumnIndex(COL_ID))
                course.name = cursor.getString(cursor.getColumnIndex(COL_NAME))
                course.prerequisites = cursor.getStringOrNull(cursor.getColumnIndex(COL_PREREQUISITE))
                course.prerequisites2 =
                    cursor.getStringOrNull(cursor.getColumnIndex(COL_PREREQUISITE2))
                course.prerequisites3 =
                    cursor.getStringOrNull(cursor.getColumnIndex(COL_PREREQUISITE3))
                course.category = cursor.getString(cursor.getColumnIndex(COL_CATEGORY))
                course.requirement = cursor.getString(cursor.getColumnIndex(COL_REQUIREMENT))
                course.semester = cursor.getIntOrNull(cursor.getColumnIndex(COL_SEMESTER))
                course.colour = cursor.getInt(cursor.getColumnIndex(COL_COLOUR))
                listCourse.add(course)
            } while (cursor.moveToNext()) //move to the next row
        }
        db.close()
        return listCourse
    }


    //update course by id (This method will be used in the future)
    fun updateCourse(course: Course): Int {
        val db = this.writableDatabase
        val values = ContentValues()
        values.put(COL_ID, course.id)
        values.put(COL_NAME, course.name)
        values.put(COL_PREREQUISITE, course.prerequisites)
        values.put(COL_PREREQUISITE2, course.prerequisites2)
        values.put(COL_PREREQUISITE3, course.prerequisites3)
        values.put(COL_CATEGORY, course.category)
        values.put(COL_REQUIREMENT, course.requirement)
        values.put(COL_SEMESTER, course.semester)
        values.put(COL_COLOUR, course.colour)
        return db.update(tCourses, values, "$COL_ID = ?", arrayOf(course.id.toString()))
    }

    //delete course by id, (this method will be used in the future, no need for it now)
    fun deleteCourse(course: Course) {
        val db = this.writableDatabase
        db.delete(tCourses, "$COL_ID = ?", arrayOf(course.id.toString()))
        db.close()
    }

    //read only one course
    fun getCourse(id: Int): Course {
        val course = Course()
        val selectQuery = "SELECT * FROM $tCourses WHERE $COL_ID = $id"
        val db = this.writableDatabase // open the connection to the database
        val cursor = db.rawQuery(selectQuery, null)
        //if the cursor is not null, we'll iterate over rows and then columns to form a table
        if (cursor != null) {
            cursor.moveToFirst()
        } //move to the first row
        while (cursor.moveToNext()) { //move to the next row
            course.id = cursor.getInt(cursor.getColumnIndex(COL_ID))
            course.name = cursor.getString(cursor.getColumnIndex(COL_NAME))
            course.prerequisites = cursor.getStringOrNull(cursor.getColumnIndex(COL_PREREQUISITE))
            course.prerequisites2 = cursor.getStringOrNull(cursor.getColumnIndex(COL_PREREQUISITE2))
            course.prerequisites3 = cursor.getStringOrNull(cursor.getColumnIndex(COL_PREREQUISITE3))
            course.category = cursor.getString(cursor.getColumnIndex(COL_CATEGORY))
            course.requirement = cursor.getString(cursor.getColumnIndex(COL_REQUIREMENT))
            course.semester = cursor.getIntOrNull(cursor.getColumnIndex(COL_SEMESTER))
        }
        db.close()
        return course
    }



    fun getAllCourseItems(item: String): List<String> {
        val listCourse = ArrayList<String>()
        val selectQuery = "SELECT * FROM $tCourses where $COL_NAME='$item'"
        val selectSem = "SELECT * FROM $tYears inner join $tCourses on $tCourses.$COL_SEMESTER= $tYears.$COL_ID where $tCourses.$COL_NAME='$item'"
        val db = this.writableDatabase
        val cursor = db.rawQuery(selectSem, null)
        if (cursor.moveToFirst()) { //move to the first row
            do {
                listCourse.add(cursor.getString(cursor.getColumnIndex(COL_NAME)))
                listCourse.add(cursor.getString(cursor.getColumnIndex(COL_ID)))
                listCourse.add(cursor.getString(cursor.getColumnIndex(COL_PREREQUISITE)))
                listCourse.add(cursor.getString(cursor.getColumnIndex(COL_PREREQUISITE2)))
                listCourse.add(cursor.getString(cursor.getColumnIndex(COL_PREREQUISITE3)))
                listCourse.add(cursor.getString(cursor.getColumnIndex(COL_CATEGORY)))
                listCourse.add(cursor.getString(cursor.getColumnIndex(COL_REQUIREMENT)))
                listCourse.add(cursor.getString(cursor.getColumnIndex(COL_SEMESTER)))
            } while (cursor.moveToNext()) //move to the next row
        }
        db.close()
        return listCourse
    }


}


