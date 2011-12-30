package iron9light.demos.cake_guice_subcut
package sguice

import javax.inject.Inject
import scalaguice.Injector

/**
 * @author il
 */

class AutoWarmerImpl @Inject()(private[this] val injector: Injector) extends AutoWarmer {
  import injector._

  val onOff = inject[OnOffDevice]

  val sensor = inject[SensorDevice]
}