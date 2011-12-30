package iron9light.demos.cake_guice_subcut
package guice

import com.google.inject.{Guice, Binder, Module}


/**
 * @author il
 * @version 12/26/11 5:49 PM
 */

class GuiceWarmerRepository extends WarmerRepository {
  val injector = Guice.createInjector(new MyModule)

  def createWarmer = injector.getInstance(classOf[Warmer])
}

class UglyGuiceWarmerRepository extends WarmerRepository {
  val injector = Guice.createInjector(new UglyModule)

  def createWarmer = injector.getInstance(classOf[Warmer])
}

class XGuiceWarmerRepository extends WarmerRepository {
  val injector = Guice.createInjector(new XModule)

  def createWarmer = injector.getInstance(classOf[Warmer])
}

class MyModule extends Module {
  def configure(binder: Binder) {
    import binder._
    bind(classOf[OnOffDevice]) to classOf[Heater]
    bind(classOf[SensorDevice]) to classOf[PotSensor]
    bind(classOf[Warmer]) to classOf[AutoWarmerImpl]
  }
}

class UglyModule extends Module {
  def configure(binder: Binder) {
    import binder._
    bind(classOf[OnOffDevice]) to classOf[Heater]
    bind(classOf[SensorDevice]) to classOf[PotSensor]
    bind(classOf[Warmer]) to classOf[UglyAutoWarmerImpl]
  }
}

class XModule extends Module {
  def configure(binder: Binder) {
    import binder._
    bind(classOf[OnOffDevice]) to classOf[Heater]
    bind(classOf[SensorDevice]) to classOf[PotSensor]
    bind(classOf[Warmer]) to classOf[XAutoWarmerImpl]
  }
}

