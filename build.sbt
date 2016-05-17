organization := "com.feynmanliang"

name := "shapely"

version := "0.1-SNAPSHOT"

scalaVersion := "2.11.8"

scalacOptions in Compile += "-language:_"

libraryDependencies ++= Seq(
  "org.typelevel" %% "macro-compat" % "1.1.1",
  "org.scala-lang" % "scala-reflect" % scalaVersion.value % "provided",
  "org.scala-lang" % "scala-compiler" % scalaVersion.value % "provided",
  "org.scalactic" %% "scalactic" % "2.2.6",
  "org.scalatest" %% "scalatest" % "2.2.6" % "test",
  compilerPlugin("org.scalamacros" % "paradise" % "2.1.0" cross CrossVersion.full))
