package scalaguice

import com.google.inject.{Guice, Module}

object ScalaGuiceUtils {

  def toMergedModule(configurations: Configuration*): Module =
    new ScalaMergedModule(configurations: _*)

  def toModules(configurations: Configuration*): Seq[Module] =
    for (c <- configurations) yield new ScalaModule(c)

  def toModule(configurations: Configuration*): Module =
    new ScalaModule(configurations: _ *)

  def createInjector(configurations: Configuration*): GuiceInjector =
    Guice.createInjector(toModule(configurations: _*))
}