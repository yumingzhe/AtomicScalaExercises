// 1.
val sunny: Boolean = true
val temp: Int = 80
val partCloudy: Boolean = true

println(sunny && temp > 80)

// 2.
println((sunny || partCloudy) && temp > 80)

// 3.
println((sunny || partCloudy) && (temp > 80 || temp < 20))

// 4.
val celsiusTemp = (temp - 32) * 5 / 9.0
println(celsiusTemp)

// 5.
val fahrenheitTemp = celsiusTemp * 9.0 / 5 + 32
println(fahrenheitTemp)
