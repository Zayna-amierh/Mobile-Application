package com.example.studentplanadvisor.model

class Year {
    var id: Int = 0
    var name: String?=""
    constructor() {} // default constructor

    // constructor with parameters to fill them in the data member
    constructor(id: Int, name: String) {
        this.name = name
        this.id = id
    }
}