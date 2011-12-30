package scalaguice

import com.google.inject.Binder
import binder.ScalaAnnotatedBindingBuilder
import scalaguice.Helper._
import net.liftweb.common.Loggable

class Configuration(private val map: Map[Class[_], ScalaAnnotatedBindingBuilder[_]]) extends Loggable {
  def bind(binder: Binder) = {
    logger.debug("Configuration bind")
    map.foreach {
      case (k, v) => v.bind(binder)
    }
  }

  def ++(config: Configuration): Configuration = new Configuration(this.map ++: config.map)

  def getBinding[T](implicit manifT: Manifest[T]): ScalaAnnotatedBindingBuilder[T] = {
    map.get(getClassType(manifT)) match {
      case Some(b) => b.asInstanceOf[ScalaAnnotatedBindingBuilder[T]]
      case None => sys.error("Not found - no binding for " + manifT.erasure)
    }
  }

  def getBindings(): Iterable[ScalaAnnotatedBindingBuilder[_]] = map.values

  def size(): Int = map.size

  override def toString = map.toString()


}

object ConfigurationMonoid {
  def mappend(a: Configuration, b: Configuration): Configuration = a ++ b

  def mzero(): Configuration = new Configuration(Map.empty[Class[_], ScalaAnnotatedBindingBuilder[_]])
}