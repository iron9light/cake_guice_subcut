package iron9light.demos.cake_guice_subcut

import scalaguice.ConfigurationBuilder
import scalaguice.ScalaGuiceUtils._

/**
 * @author il
 * @version 12/26/11 4:19 PM
 */

trait WarmerRepository {
  def createWarmer: Warmer
}

class MyWarmerRepository extends WarmerRepository with ConfigurationBuilder {
  val configuration = config {
    bind[OnOffDevice].to[Heater]
    bind[SensorDevice].to[PotSensor]
    bind[Warmer].to[AutoWarmer]
  }

  val injector = createInjector(configuration)
  
  def createWarmer = injector.inject[Warmer]
}