package object scalaguice {
  implicit def toInjector(gInjector: com.google.inject.Injector) = new GuiceInjector(gInjector)

  implicit def toTypeLiteral[T: Manifest] = Helper.typeLiteral
}