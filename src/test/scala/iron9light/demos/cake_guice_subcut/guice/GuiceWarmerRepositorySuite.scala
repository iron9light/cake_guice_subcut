package iron9light.demos.cake_guice_subcut
package guice

import org.scalatest.FunSuite
import org.junit.runner.RunWith
import org.scalatest.junit.JUnitRunner

/**
 * @author il
 * @version 12/26/11 6:14 PM
 */

@RunWith(classOf[JUnitRunner])
class GuiceWarmerRepositorySuite extends WarmerRepositorySuite with FunSuite {
  test("") {
    val repository = new GuiceWarmerRepository
    testWarmerRepository(repository)
  }
  
  test("ugly") {
    val repository = new UglyGuiceWarmerRepository
    testWarmerRepository(repository)
  }

  test("X") {
    val repository = new XGuiceWarmerRepository
    testWarmerRepository(repository)
  }
}