package iron9light.demos.cake_guice_subcut
package sc

import org.scalatest.FunSuite
import org.junit.runner.RunWith
import org.scalatest.junit.JUnitRunner

/**
 * @author il
 * @version 12/26/11 6:11 PM
 */

@RunWith(classOf[JUnitRunner])
class SubcutWarmerRepositorySuite extends WarmerRepositorySuite with FunSuite {
  test("") {
    val repository = new SubcutWarmerRepository
    testWarmerRepository(repository)
  }
}