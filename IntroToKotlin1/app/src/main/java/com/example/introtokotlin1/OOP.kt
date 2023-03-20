package com.example.introtokotlin1

fun main() {
    var p1 = Person("Mandy", "Farrugia") //Mandy Farrugia
    var p2 = Person() //Joe Borg
    var p3 = Person("Peter") //Peter Borg

    println(p1.name)
    println(p1.surname)

    var p4 = Person("Jane", "Tarzan", 21)
    p4.age = 25 //goes through the setter
}

//firstName : String = "Joe", lastName : String = "Borg" denotes optional parameters.
class Person(firstName : String = "Joe", lastName : String = "Borg") {
    lateinit var name : String //The variable is declared as a non-nullable variable but it will be initialised later on.
    var surname : String? = null

    var age : Int = 0
    get() {
        if(age < 0)
            return 0
        return field //field refers to the variable
    }
    set(value) {
        if(value < 0)
            field = 0
        field = value
    }

    //Initialiser block
    init {
        println("A new Person initialised with name $firstName and surname $lastName");
        this.name = firstName //name = firstName
        this.surname = lastName //surname = lastName
    }

    //Secondary constructor
    constructor(firstName: String, lastName: String, age : Int) : this(firstName, lastName) {
        this.age = age;
        println("A Person created with the secondary constructor");
    }
}