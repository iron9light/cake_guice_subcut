package iron9light.demos.cake_guice_subcut

import org.scalatest.FunSuite
import org.junit.runner.RunWith
import org.scalatest.junit.JUnitRunner

/**
 * @author il
 */

@RunWith(classOf[JUnitRunner])
class MyWarmerRepositorySuite extends WarmerRepositorySuite with FunSuite {
  test("") {
    val repository = new MyWarmerRepository
    testWarmerRepository(repository)
  }
}