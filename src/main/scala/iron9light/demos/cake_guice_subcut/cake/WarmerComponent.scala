package iron9light.demos.cake_guice_subcut
package cake

/**
 * @author il
 * @version 12/26/11 4:01 PM
 */

trait OnOffDeviceComponent {
  def onOff: OnOffDevice
}

trait HeaterOnOffDeviceComponent extends OnOffDeviceComponent {
  def onOff = new Heater
}

trait SensorDeviceComponent {
  def sensor: SensorDevice
}

trait PotSensorDeviceComponent extends SensorDeviceComponent {
  def sensor = new PotSensor
}

trait WarmerComponent {
  def warmer: Warmer
}

trait AutoWarmerComponent extends WarmerComponent {self: OnOffDeviceComponent with SensorDeviceComponent =>
  def warmer: Warmer = new AutoWarmer {
    val sensor = self.sensor

    val onOff = self.onOff
  }
}