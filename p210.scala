import com.atomicscala.AtomicTest._

// 1.
// match may not be exhaustive

// 2.
object EnumColor extends Enumeration {
  type EnumColor = Value
    val Red = Value("Red")
      val Green = Value("Green")
        val Blue = Value("Blue")
        }

        EnumColor.Red is "Red"
        EnumColor.Blue is "Blue"
        EnumColor.Green is "Green"

        // 3.
        // Red is already defined in the scope

        // 4.
        // Red is already defined in the scope
