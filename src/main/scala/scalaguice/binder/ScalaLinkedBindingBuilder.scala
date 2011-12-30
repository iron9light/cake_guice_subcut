package scalaguice.binder

import com.google.inject._
import com.google.inject.binder.LinkedBindingBuilder
import scalaguice.Helper._
import java.lang.reflect.Constructor
import scala.collection.mutable.ListBuffer
import net.liftweb.common.Loggable

trait ScalaLinkedBindingBuilder[T] extends ScalaScopedBindingBuilder with Loggable {

  val linkedCommands: ListBuffer[(LinkedBindingBuilder[T]) => Unit] =
    ListBuffer.empty[(LinkedBindingBuilder[T]) => Unit]

  def bind(builder: LinkedBindingBuilder[T]) = {
    logger.debug("Linked Bind - binding with " + builder)
    linkedCommands.foreach(c => c(builder))
    super.bind(builder)
  }

  def to(targetKey: Key[_ <: T]): ScalaScopedBindingBuilder = {
    // delay call to builder
    linkedCommands += {
      (builder: LinkedBindingBuilder[T]) => builder.to(targetKey)
    }
    this
  }

  def to(impl: TypeLiteral[_ <: T]): ScalaScopedBindingBuilder = {
    // delay call to builder
    linkedCommands += {
      (builder: LinkedBindingBuilder[T]) => builder.to(impl)
    }
    this
  }

  def to(impl: Class[_ <: T]): ScalaScopedBindingBuilder = {
    // delay call to builder
    linkedCommands += {
      (builder: LinkedBindingBuilder[T]) => builder.to(impl)
    }
    this
  }

  def to[I <: T](implicit manifI: Manifest[I]): ScalaScopedBindingBuilder = {
    // delay call to builder
    linkedCommands += {
      (builder: LinkedBindingBuilder[T]) => {
        if (manifI.typeArguments.isEmpty) {
          logger.debug(" binded to " + manifI.erasure)
          builder.to(getClassType(manifI))
        } else {
          logger.debug(" binded to TypeLiteral " + manifI.erasure)
          builder.to(typeLiteral(manifI))
        }
      }
    }
    this
  }

  def toConstructor[S <: T](constructor: Constructor[S]): ScalaScopedBindingBuilder = {
    // delay call to builder
    linkedCommands += {
      (builder: LinkedBindingBuilder[T]) => builder.toConstructor(constructor);
    }
    this
  }

  def toConstructor[S <: T](constructor: Constructor[S], `type`: TypeLiteral[_ <: S]): ScalaScopedBindingBuilder = {
    // delay call to builder
    linkedCommands += {
      (builder: LinkedBindingBuilder[T]) => builder.toConstructor(constructor, `type`)
    }
    this
  }

  def toInstance(instance: T) {
    // delay call to builder
    linkedCommands += {
      (builder: LinkedBindingBuilder[T]) => builder.toInstance(instance)
    }
  }

  def toProvider(providerKey: Key[_ <: Provider[_ <: T]]): ScalaScopedBindingBuilder = {
    // delay call to builder
    linkedCommands += {
      (builder: LinkedBindingBuilder[T]) => builder.toProvider(providerKey)
    }
    this
  }

  def toProvider(provider: Provider[_ <: T]): ScalaScopedBindingBuilder = {
    // delay call to builder
    linkedCommands += {
      (builder: LinkedBindingBuilder[T]) => builder.toProvider(provider)
    }
    this
  }

  def toProvider[I <: T](func: => I): ScalaScopedBindingBuilder = {
    linkedCommands += {
      (builder: LinkedBindingBuilder[T]) => builder.toProvider(new Provider[I] {
        def get = func
      })
    }
    this
  }

  def toProvider(providerType: TypeLiteral[_ <: Provider[_ <: T]]): ScalaScopedBindingBuilder = {
    // delay call to builder
    linkedCommands += {
      (builder: LinkedBindingBuilder[T]) => builder.toProvider(providerType)
    }
    this
  }

  def toProvider(providerType: Class[_ <: Provider[_ <: T]]): ScalaScopedBindingBuilder = {
    // delay call to builder
    linkedCommands += {
      (builder: LinkedBindingBuilder[T]) => builder.toProvider(providerType)
    }
    this
  }

  def toProvider[P <: Provider[_ <: T]](implicit manifP: Manifest[P]): ScalaScopedBindingBuilder = {
    // delay call to builder
    linkedCommands += {
      (builder: LinkedBindingBuilder[T]) => builder.toProvider(getClassType(manifP))
    }
    this
  }

}