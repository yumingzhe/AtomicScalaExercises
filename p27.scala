// 1.
val va1: Int = 5
// va1 = 10 // error

// 2.
var v1: Int = 5
v1 = 10
val constantv1 = v1
println(constantv1) // 10

// 3.
v1 = 15
println(constantv1) // 10

// 4.
var v2: Int = v1
v1 = 20
println(v2) // 15
