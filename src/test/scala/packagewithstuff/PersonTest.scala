package packagewithstuff
import org.scalatest.FlatSpec

case class PersonTest() extends FlatSpec{
  "the 'double' method" should "output an integer twice as large as the input" in {
    val person = new Person("Nico","Charlemagne")
    assert(person.double(1) == 2)
  }
  it should "return 0 when it receives 0 as input" in {
    val person = new Person("Nico","Charlemagne")
    assert(person.double(0) == 0)
  }
  /**
   * Get this checked l8r
   * I don't understand how nulls are handled in scala yet
   */
  /*
  it should "handle NULL values by returning 0" in {
    val person = new Person("Nico","Charlemagne")
    assert(person.double(null) == 0)
  }
  */

}
