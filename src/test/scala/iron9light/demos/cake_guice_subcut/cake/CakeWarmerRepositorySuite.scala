package iron9light.demos.cake_guice_subcut
package cake

import org.scalatest.FunSuite
import org.scalatest.junit.JUnitRunner
import org.junit.runner.RunWith

/**
 * @author il
 * @version 12/26/11 5:58 PM
 */

@RunWith(classOf[JUnitRunner])
class CakeWarmerRepositorySuite extends WarmerRepositorySuite with FunSuite {
  test("") {
    val repository = new CakeWarmerRepository
    testWarmerRepository(repository)
  }
}