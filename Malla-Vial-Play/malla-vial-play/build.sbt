name := """malla-vial-play"""

version := "1.0"

scalaVersion := "2.13.14"

lazy val root = (project in file("."))
  .enablePlugins(PlayScala)

  // Agregar la dependencia de JPA
  .dependencies ++= Seq(
  "com.typesafe.play" %% "play-jpa" % "2.8.x", // Reemplaza 'x' por la versión que estás usando
  "org.hibernate" % "hibernate-core" % "7.0.0.Alpha2", // Reemplaza 'x' por la versión que necesites
  "org.hibernate" % "hibernate-entitymanager" % "6.0.0.Alpha7" // Reemplaza 'x' por la versión que necesites
)


libraryDependencies += guice

libraryDependencies ++= Seq(
  javaJdbc,
  "com.typesafe.play" %% "play" % "2.9.5",
  "org.postgresql" % "postgresql" % "42.5.0",
  "com.typesafe.play" %% "play-guice" % "2.9.5"
)

resolvers += "Typesafe Repository" at "https://repo.typesafe.com/typesafe/releases/"








