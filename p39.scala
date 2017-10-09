// 1.
val a: Int = 1
val b: Int = 6 
val c: Int = 5
if(a <= c){
    println("a <= c")
}else{
    println("a > c")
   }
if(b <= c){
    println("b <= c")
}else{
    println("b > c")
}

// 2.
if(a <= c && b <=c){
    println("both are")
}else{
    if(a <=c || b <=c){
        println("one is and one isn't!")
    }
}

// 3.
val highTemp = 50
val lowTemp = 20
val temp = 25
val goodTemperature = {temp >= lowTemp && temp <= highTemp} 

// 4.
val distance = 9
val activity = "running"
val willDo = {
    if(activity == "running" && distance < 6){
        true
    }
    if(activity == "biking" && distance < 20){
        true
    }
    if(activity == "swimming" && distance < 1){
        true
    }
    false
}
println(willDo)
