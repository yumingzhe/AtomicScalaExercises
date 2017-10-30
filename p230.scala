import com.atomicscala.AtomicTest._

// 1.
val fruits = Set("apple", "orange", "banana", "kiwi")
val vegetables = Set("beans", "peas",
  "carrots", "sweet potatoes",
  "asparagus", "spinach")
val meats = Set("beef", "chicken")
val groceryCart = Set("apple",
  "pretzels", "bread", "orange", "beef",
  "beans", "asparagus", "sweet potatoes",
  "spinach", "carrots")
def percentMeat(set: Set[String]): Double = (set & meats).size * 100.0 / set.size
def percentFruit(set: Set[String]): Double = (set & fruits).size * 100.0 / set.size * 1.0
def percentVeggies(set: Set[String]): Double = (set & vegetables).size * 100.0 / set.size * 1.0
def percentOther(set: Set[String]): Double = (set -- fruits -- vegetables -- meats).size * 100.0 / set.size * 1.0
percentMeat(groceryCart) is 10.0
percentFruit(groceryCart) is 20.0
percentVeggies(groceryCart) is 50.0
percentOther(groceryCart) is 20.0

// 2.
val vegetarian = Set("kidney beans", "black beans", "tofu")
val groceryCart2 = Set("apple", "pretzels",
  "bread", "orange", "beef",
  "beans", "asparagus", "sweet potatoes",
  "kidney beans", "black beans")
def percentVegetarian(set: Set[String]): Double = (set & vegetarian).size * 100.0 / set.size * 1.0
def percentProtein(set: Set[String]): Double = (set & (vegetarian | meats)).size * 100.0 / set.size * 1.0
percentMeat(groceryCart2) is 10.0
percentVegetarian(groceryCart2) is 20.0
percentProtein(groceryCart2) is 30.0

// 3.
val box1 = Set("shoes", "clothes")
val box2 = Set("toys", "dishes")
val box3 = Set("toys", "games", "books")
val attic = Set(box1, box2)
val basement = Set(box3)
val house = Set(attic, basement)
Set("shoes", "clothes", "toys", "dishes") is attic.flatten
Set("toys", "games", "books") is basement.flatten
Set("shoes", "clothes", "toys", "dishes", "games", "books") is house.flatten.flatten
