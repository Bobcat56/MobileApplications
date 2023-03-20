package com.example.introtokotlin1

fun main() {
    println("Welcome to Kotlin")

    //Variables (type inference - find out type from context)
    var name = "Mandy";

    //By default, for whole numbers, Int is used.
    var age = 21;

    var mByte: Byte = 12
    var mShort : Short = 321
    var mInt : Int = 123456
    var mLong : Long = 32164321632

    //By default, for numbers with fractional parts, Double is used.
    var bankBalance = 32165432.32

    var mFloat : Float = 3215.21F //Use the F suffix to force compiler to treat the decimal number as a float.
    var mDouble : Double = 321321.321321

    var mChar : Char = 'a'
    var mBoolean : Boolean = true

    //Constants, also known as immutable variables
    val PI = 3.142

    //TODO: Create a new function here

    //String interpolation
    //println("name: " + name)
    println("name $name, ${name.length}") //Include variables directly in string.
    println("is 5 greater than or equal to 3: ${5>=3}")

    var x = 5
    println("x: ${++x}");

    //Data types & casting
    var a = 5
    var b = 3
    var result = (a.toDouble() / b)

    println("result: $result"); //To get floating point number, either a or b must be double.

    //Conditional statements (decision making)

    //The if-statement is the same as in Java and C#.

    var season = 3
    when(season) {
        1 -> println("Spring")
        2 -> println("Summer")
        3 -> {
            println("Fall")
            println("Autumn")
        }
        4 -> println("")
        else -> println("Invalid season")
    }

    var month = 1
    when(month) {
        in 3 .. 5 -> println("Spring")
        in 6 .. 8 -> println("Summer")
        in 9 .. 11 -> println("Autumn")
        1,2,12 -> println("Winter")
        else -> println("Incorrect month")
    }

    var newNum : Any = 23
    when(newNum) {
        is Int -> println("newNum is an integer")
        is Double -> println("newNum is double")
        is String -> println("newNum is a string")
        else -> println("Incorrect data type")
    }

    //! inverts
    //!is Double -> println("newNum is not a double")

    //Repetition statements

    //While loop and do-while loop are the same as in Java and C#.

    //For-loops are different in terms of syntax.
    for(i in 1 .. 10) //.. includes the maximum boundary.
        print(" $i "); //Print each element on the same line.

    println()

    for(i in 1 until 10) //until does not include the maximum boundary.
        print(" $i ") //Print each element on the same line.

    println()

    for(i in 1 until 10 step 2) //step skips numbers accordingly.
        print(" $i ") //Print each element on the same line.

    println()

    for(i in 10 downTo 1) //Starts from 10 and keeps going down to 1.
        print(" $i ") //Print each element on the same line.

    println()

    for(i in 10 downTo 1 step 2) //Starts from 10 and keeps going down to 1, this is combined with step.
        print(" $i ") //Print each element on the same line.

    println()

    output()

    output("Mandy")

    println("The average of 21 and 32 is ${avg(21,32)}")

    //Null values

    //var x : Int = null //This returns an error because x is not a nullable value.

    var myNumber : Int? = 5
    myNumber = null

    var myName : String = "James"
    var myNullableName : String? = null

    //Option 1
    if(myNullableName != null) {
        println(myNullableName.length)
    } else {
        //if myNullableName is null...
    }

    //Option 2 - The Kotlin way
    var length = myNullableName?.length
    println(myNullableName?.lowercase())

    //The following output only works if myNullable is not null
    myNullableName?.let{ println("Name toUpper: ${myNullableName.uppercase()}") }

    //?: Elvis Operator
    //If name is null, use the default value "Guest"
    var extraName = myNullableName ?: "Guest"

    //!! is not null assertion
    //Converts a nullable type to a not null type (risky!)
    myNullableName!!.lowercase()
}

fun output() {
    println("This is an output from a function.")
}

fun output(name : String) {
    println("Hello $name!")
}

fun avg(num1 : Int, num2 : Int): Int {
    return (num1 + num2) / 2
}