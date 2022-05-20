package com.example.studentplanadvisor.model

class Course {
    var id: Int = 0
    var name: String=""
    var prerequisites: String? =null
    var prerequisites2: String? = null
    var prerequisites3: String? = null
    var category: String=""
    var requirement: String=""
    var semester: Int? = null
    var colour: Int = 0
    constructor() {} // default constructor

    // constructor with parameters to fill them in the data member

    constructor(id: Int, name: String, prerequisites: String, prerequisites2: String, prerequisites3: String,category: String, requirement: String, semester: Int, colour: Int) {
        this.name = name
        this.id = id
        this.prerequisites = prerequisites
        this.prerequisites2 = prerequisites2
        this.prerequisites3 = prerequisites3
        this.category = category
        this.requirement = requirement
        this.semester = semester
        this.colour = colour
    }

    
}