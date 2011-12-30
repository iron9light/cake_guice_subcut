package iron9light.demos.cake_guice_subcut
package sguice

import scalaguice.ScalaGuiceUtils._
import scalaguice.ConfigurationBuilder

/**
 * @author il
 */

class SGuiceWarmerRepository extends WarmerRepository with ConfigurationBuilder {
  val configuration = config {
    bind[OnOffDevice].to[Heater]
    bind[SensorDevice].to[PotSensor]
    bind[Warmer].to[AutoWarmerImpl]
  }
  
  val injector = createInjector(configuration)

  def createWarmer = injector.inject[Warmer]
}