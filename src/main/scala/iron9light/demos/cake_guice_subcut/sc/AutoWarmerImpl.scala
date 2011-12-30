package iron9light.demos.cake_guice_subcut
package sc

import org.scala_tools.subcut.inject.{Injectable, BindingModule}


/**
 * @author il
 * @version 12/26/11 4:30 PM
 */

class AutoWarmerImpl(implicit val bindingModule: BindingModule) extends AutoWarmer with Injectable {
  val onOff = inject[OnOffDevice]

  val sensor = inject[SensorDevice]
}