// 1.
def getSquare(num: Int):Int = {
    num * num
}

val a = getSquare(3)
assert(a == 9,"expected " + 9 +", got "+ a)

val b = getSquare(6)
assert(b == 36,"expected " + 36+", got "+b)

val c = getSquare(5)
assert(c == 25,"expected " + 25+", got "+c)

// 2.
def getSquareDouble(num: Double):Double = {
    num * num
}

val sd1 = getSquareDouble(1.2)
assert(1.44 == sd1, "Your message here")
val sd2 = getSquareDouble(5.7)
assert(32.49 == sd2, "Your message here")

// 3.
def isArg1GreaterThanArg2(num1: Double, num2: Double):Boolean = {
    num1 > num2
}
val t1 = isArg1GreaterThanArg2(4.1, 4.12)
assert(false == t1, "not greater")
val t2 = isArg1GreaterThanArg2(2.1, 1.2)
assert(true == t2, "greater than")

// 4.
def getMe(str: String):String = {
    str.toLowerCase()
}

val g1 = getMe("abraCaDabra")
assert("abracadabra" == g1, "your message here")
val g2 = getMe("zyxwVUT")
assert("zyxwvut" == g2, "your message here")

// 5.
def addStrings(s1:String, s2:String):String = {
    s1 + s2
}
val s1 = addStrings("abc", "def")
assert("abcdef" == s1, "message here")
val s2 = addStrings("zyx", "abc")
assert("zyxabc" == s2, "message here")

// 6.
def manyTimesString(str: String, count:Int):String = {
    str * count
}

val m1 = manyTimesString("abc", 3)
assert("abcabcabc" == m1, "message here")
val m2 = manyTimesString("123", 2)
assert("123123" == m2, "message here")

// 7.
def bmiStatus(height:Double, weight:Double):String = {
    val kg = weight * 0.4535924
    val heightM = 0.0254 * height
    println(kg)
    println(heightM)
    val bmi = kg / (heightM * heightM)
    if(bmi < 18.5)
        "Underweight"
    else if(bmi < 25)
        "Normal weight"
    else "Overweight"
}
val normal = bmiStatus(160, 68)
assert("Normal weight" == normal, "Expected Normal weight, Got " + normal)
val overweight = bmiStatus(180, 60)
assert("Overweight" == overweight, "Expected Overweight, Got " + overweight)
val underweight = bmiStatus(100, 68)
assert("Underweight" == underweight, "Expected Underweight, Got " + underweight)
