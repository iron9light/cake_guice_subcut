package scalaguice.binder

import java.lang.annotation.Annotation
import com.google.inject.binder.AnnotatedBindingBuilder
import com.google.inject.name.Names
import scalaguice.Helper._
import com.google.inject.Binder
import scala.collection.mutable.ListBuffer
import net.liftweb.common.Loggable

case class ScalaAnnotatedBindingBuilder[T](implicit manifT: Manifest[T])
  extends ScalaLinkedBindingBuilder[T] with Loggable {

  val bindType = getClassType(manifT)

  val annotatedCommands: ListBuffer[(AnnotatedBindingBuilder[T]) => Unit] =
    ListBuffer.empty[(AnnotatedBindingBuilder[T]) => Unit]

  def bind(binder:Binder) = {

    val builder = binder.bind(bindType)

    logger.debug("Annotated Bind - binding with " + builder)
    annotatedCommands.foreach(c => c(builder))
    super.bind(builder)
  }

  def annotatedWith(annotation: Annotation): ScalaLinkedBindingBuilder[T] = {
    // delay call to builder
    annotatedCommands += {
      (builder: AnnotatedBindingBuilder[T]) =>
      {
        logger.debug("annotatedWith: " + annotation)
        builder.annotatedWith(annotation)
      }
    }
    this
  }

  def annotatedWith(annotationType: Class[_ <: Annotation]): ScalaLinkedBindingBuilder[T] = {
    //delay call to builder
    annotatedCommands += {
      (builder: AnnotatedBindingBuilder[T]) =>
      {
        logger.debug("annotatedWith: " + annotationType)
        builder.annotatedWith(annotationType)
      }
    }
    this
  }

  def annotatedWith[A <: Annotation](implicit manifA: Manifest[A]): ScalaLinkedBindingBuilder[T] = {
    //delay call to builder
    annotatedCommands += {
      (builder: AnnotatedBindingBuilder[T]) =>
      {
        logger.debug("annotatedWith: " + manifA.erasure)
        builder.annotatedWith(getClassType(manifA))
      }
    }
    this
  }

  def annotatedWithName(name: String): ScalaLinkedBindingBuilder[T] = {
    //delay call to builder
    annotatedCommands += {
      (builder: AnnotatedBindingBuilder[T]) =>
      {
        logger.debug("annotatedWithName: " + name)
        builder.annotatedWith(Names.named(name))
      }
    }
    this
  }
}