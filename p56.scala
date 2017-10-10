// 1.
class Hippo
class Lion
class Tiger
class Monkey
class Giraffe

val hippo = new Hippo
val lion = new Lion
val tiger  =new Tiger
val monkey = new Monkey
val giraffe = new Giraffe

println(hippo)
println(lion)
println(tiger)
println(monkey)
println(giraffe)

// 2.
val lion2 = new Lion
val giraffe2 = new Giraffe
val giraffe3 = new Giraffe
println(lion)
println(lion2)
println(giraffe)
println(giraffe2)
println(giraffe3)

println(lion==lion2) // false
println(giraffe == giraffe2) // false
println(giraffe == giraffe3) // false
println(giraffe2 == giraffe3)// false

// 3.
class Zebra {
  println("I have stripes")
}
new Zebra
