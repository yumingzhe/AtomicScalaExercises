// 1.
val intValue: Int = 1
println(intValue)

// 2.
//intValue = 2 // reassignment to val

// 3.
var intVar: Int = 1
//intVar = 1.0 // error: type mismatch

// 4.
val doubleValue: Double = 1.0
println(doubleValue)

// 5.
val dValue: Double = 15
println(dValue)

// 6.
val str: String = """This is
a multi-lines
sentence"""
println(str)

// 7.
//val bValue: Boolean = "maybe" // error: type mismatch

// 8.
//val iValue: Int = 15.4 // error: type mismatch

// 9.
val lbs = 150.0
val height = 68.0
val weightStatus = {
    val bmi = lbs/(height * height) * 703.07
    if(bmi < 18.5) println("Underweight")
    else if(bmi < 25) println("Normal weight")
    else println("Overweight")
}
println(weightStatus)

// 10.
val weightStatus2 = {
    var bmi = lbs/(height * height) * 703.07
    bmi = 22 
    if(bmi < 18.5) println("Underweight")
    else if(bmi == 22.0) println("idealWeight")
    else if(bmi < 25) println("Normal weight")
    else println("Overweight")
}
