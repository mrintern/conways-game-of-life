package packagewithstuff

// define the class
class Person(val firstName: String, val lastName: String) {

  println("the constructor begins")
  val fullName = firstName + " " + lastName
  val HOME = System.getProperty("user.home");

  // define some methods
  def printFullName {
    // access the fullName field, which is created above
    println(fullName)
  }
  def param(param: Int) : Int = {
    println(s"parameter ${param} received")
    return param
  }
  def double(number: Int) : Int = {
    if(number == None){
      println("*** invalid input *** Null value")
      return 0
    }
    else return number*2
  }

  printFullName
  println("still in the constructor")

}