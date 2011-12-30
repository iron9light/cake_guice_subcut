package iron9light.demos.cake_guice_subcut

import com.google.inject.ImplementedBy
import javax.inject.Inject

/**
 * @author il
 * @version 12/26/11 3:43 PM
 */

trait OnOffDevice {
  def on: String
  
  def off: String
}

class Heater extends OnOffDevice {
  def on: String = {
    println("heater.on")
    "heater.on"
  }

  def off: String = {
    println("heater.off")
    "heater.off"
  }
}

trait SensorDevice {
  def isCoffeePresent: Boolean
}

class PotSensor extends SensorDevice {
  def isCoffeePresent = true
}

trait Warmer {
  def trigger: String
}

@ImplementedBy(classOf[GeneratedAutoWarmer])
trait AutoWarmer extends Warmer {
  def onOff: OnOffDevice
  
  def sensor: SensorDevice
  
  def trigger = {
    if (sensor.isCoffeePresent) onOff.on
    else onOff.off
  }
}

private final class GeneratedAutoWarmer @Inject()(val onOff: OnOffDevice, val sensor: SensorDevice) extends AutoWarmer