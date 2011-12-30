package iron9light.demos.cake_guice_subcut
package sguice

import org.scalatest.FunSuite
import org.junit.runner.RunWith
import org.scalatest.junit.JUnitRunner

/**
 * @author il
 */

@RunWith(classOf[JUnitRunner])
class SGuiceWarmerRepositorySuite extends WarmerRepositorySuite with FunSuite {
  test("") {
    val repository = new SGuiceWarmerRepository
    testWarmerRepository(repository)
  }
}