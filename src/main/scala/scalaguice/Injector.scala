package scalaguice

import javax.inject.Inject
import com.google.inject.{ImplementedBy, Injector => GInjector}

/**
 * @author il
 */

trait Injector {
  def inject[T: Manifest]: T
  
  def injectOption[T: Manifest]: Option[T]
}

class GuiceInjector @Inject()(private val gInjector: GInjector) extends Injector {
  import Helper.getClassType
  def inject[T: Manifest] = gInjector.getInstance(getClassType[T])
  
  def injectOption[T: Manifest] = try {
    Some(inject[T])
  } catch {
    case _ => None
  }
}

object GuiceInjector {
  implicit def toGInjector(injector: GuiceInjector) = injector.gInjector
}