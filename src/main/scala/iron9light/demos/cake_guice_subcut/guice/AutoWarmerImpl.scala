package iron9light.demos.cake_guice_subcut
package guice

import javax.inject.{Provider, Inject}

/**
 * @author il
 * @version 12/26/11 5:26 PM
 */

private final class AutoWarmerImpl @Inject()(val onOff: OnOffDevice, val sensor: SensorDevice) extends AutoWarmer {
}

class UglyAutoWarmerImpl extends AutoWarmer {
  @Inject var onOff: OnOffDevice = null

  @Inject var sensor: SensorDevice = null
}

class XAutoWarmerImpl @Inject()(onOffProvider: Provider[OnOffDevice], sensorProvider: Provider[SensorDevice]) extends AutoWarmer {
  def onOff = onOffProvider.get()

  def sensor = sensorProvider.get()
}