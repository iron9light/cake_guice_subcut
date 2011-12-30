package iron9light.demos.cake_guice_subcut
package sc

import org.scala_tools.subcut.inject.{Injectable, NewBindingModule}


/**
 * @author il
 * @version 12/26/11 4:30 PM
 */

class ConfigurationModule extends NewBindingModule(module => {
  import module._
  bind[OnOffDevice] toProvider new Heater
  bind[SensorDevice] toProvider new PotSensor
  bind[Warmer] toInjectable {new AutoWarmerImpl()(_)}
})

class SubcutWarmerRepository extends WarmerRepository with Injectable {
  val bindingModule = new ConfigurationModule

  def createWarmer = inject[Warmer]
}