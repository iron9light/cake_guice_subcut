package iron9light.demos.cake_guice_subcut
package cake

/**
 * @author il
 * @version 12/26/11 4:21 PM
 */

class ComponentRegistry extends HeaterOnOffDeviceComponent
with PotSensorDeviceComponent
with AutoWarmerComponent
{
}

class CakeWarmerRepository extends WarmerRepository {
  val componentRegistry = new ComponentRegistry
  def createWarmer = componentRegistry.warmer
}