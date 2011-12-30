package iron9light.demos.cake_guice_subcut

import org.scalatest.matchers.ShouldMatchers

trait WarmerRepositorySuite extends ShouldMatchers {
  def testWarmerRepository(repository: WarmerRepository) {
    val warmer = repository.createWarmer
    warmer.trigger should be === "heater.on"
  }
}