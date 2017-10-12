import com.atomicscala.AtomicTest._

// 1.
// 回文时正序和逆序相同

// 2.
def isPalindrome(str: String): Boolean = {
  str.equals(str.reverse)
}
isPalindrome("mom") is true
isPalindrome("dad") is true
isPalindrome("street") is false

// 3.
def isPalIgnoreCase(str: String): Boolean = {
  str.equalsIgnoreCase(str.reverse)
}

isPalIgnoreCase("Bob") is true
isPalIgnoreCase("DAD") is true
isPalIgnoreCase("Blob") is false

// 4.
def ifPalIgnoreSpecial(str: String): Boolean = {
  var createdStr = ""
  for (c <- str) {
    val theValue = c.toInt
    if (theValue >= 65 && theValue <= 122) {
      createdStr += c
    } else if (theValue >= 48 && theValue <= 57) {
      createdStr += c
    }
  }
  createdStr.equalsIgnoreCase(createdStr.reverse)
}
ifPalIgnoreSpecial("Madam I'm adam") is true
