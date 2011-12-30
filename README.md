# How to do Dependency Injection in Scala?

## The story

There's no standard way to do DI in scala.

Some one love [cake pattern](http://jboner.github.com/2008/10/06/real-world-scala-dependency-injection-di.html), because it's scala only. Scala, the typed monster.

Others think [guice](http://code.google.com/p/google-guice/) is more fexible and widly used.

Even if you don't like so many 'classOf', you can use the [scala-guice](https://github.com/rcavalcanti/scala-guice).

And there are man in the middle, he created [subcut](https://github.com/dickwall/subcut).

I tried them all to do the same thing, inject some denpendencies.

On one is better than all others.

They all have their pros and cons. And The all need to write lots of boilerplate code.

## The solution

So I create [autoguice](https://github.com/iron9light/autoguice) (I should name it autoinject), a scala compiler plugin.

It will generate the boilerplate code for you.

The benefit is:

 * Just write the meanful logic. No more boilerplate code.

 * Easy to change your DI solutions. This plugin in will support more DI framewok in the future.

## DI pattern and framework list

 * scala only

     1. Cake pattern

 * scala framework

     0. [autoguice](https://github.com/iron9light/autoguice)
     1. [subcut](https://github.com/dickwall/subcut)
     2. [scaldi](https://github.com/OlegIlyenko/scaldi)
     3. [sindi](http://aloiscochard.github.com/sindi/) I did not use it yet.
     4. [scala-guice](https://github.com/rcavalcanti/scala-guice) by Renato Cavalcanti (@rcavalcanti)
     5. [scala-guice](https://github.com/benlings/scala-guice) by Ben Lings (@benlings)
     6. [scalamodules](https://github.com/weiglewilczek/scalamodules) more than just DI

 * java world

     1. [guice](http://code.google.com/p/google-guice)
     2. [spring](www.springsource.org)
     3. [CDI](http://seamframework.org/Weld) JSR299 by Weld