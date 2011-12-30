package scalaguice.binder

import java.lang.annotation.Annotation
import com.google.inject.binder.ScopedBindingBuilder
import com.google.inject.Scope
import scalaguice.Helper._
import scala.collection.mutable.ListBuffer
import net.liftweb.common.Loggable

trait ScalaScopedBindingBuilder extends Loggable {

  val scopedCommands: ListBuffer[(ScopedBindingBuilder) => Unit] =
    ListBuffer.empty[(ScopedBindingBuilder) => Unit]

  def bind(builder : ScopedBindingBuilder) = {
    logger.debug("ScopedBind - binding with " + builder )
    scopedCommands.foreach(c => c(builder))
  }

  def asEagerSingleton() {
    // delay call to builder
    scopedCommands += { (builder: ScopedBindingBuilder) => builder.asEagerSingleton() }
  }

  def in(scopeAnnotation: Class[_ <: Annotation]) {
    // delay call to builder
    scopedCommands += { (builder: ScopedBindingBuilder) => builder.in(scopeAnnotation) }
  }

  def in(scope: Scope) {
    // delay call to builder
    scopedCommands += { (builder: ScopedBindingBuilder) => builder.in(scope) }
  }

  def in[A <: Annotation](implicit manifA: Manifest[A]) {
    // delay call to builder
    scopedCommands += { (builder: ScopedBindingBuilder) => builder.in(getClassType(manifA)) }
  }

}