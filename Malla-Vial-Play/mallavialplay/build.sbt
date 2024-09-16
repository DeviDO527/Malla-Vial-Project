import scala.collection.Seq

name := """mallavialplay"""

version := "1.0-SNAPSHOT"

scalaVersion := "2.13.14"

libraryDependencies ++= Seq(
  "com.typesafe.play" %% "play" % "2.9.5",
  "org.postgresql" % "postgresql" % "42.5.0",
  "com.typesafe.play" %% "play-guice" % "2.9.5"
)

resolvers += "Typesafe Repository" at "https://repo.typesafe.com/typesafe/releases/"

fork in run := true
