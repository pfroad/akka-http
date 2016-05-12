name := "akka-http-rest"
organization := "me.archdev"
version := "1.0.0"
scalaVersion := "2.11.8"

libraryDependencies ++= {
  val akkaV = "2.4.4"
  val scalaTestV = "3.0.0-M15"
  val slickVersion = "3.1.1"
  val circeV = "0.4.1"
  Seq(
    "com.typesafe.akka" %% "akka-http-core" % akkaV,
    "com.typesafe.akka" %% "akka-http-experimental" % akkaV,
    "de.heikoseeberger" %% "akka-http-circe" % "1.6.0",

    "com.typesafe.akka" % "akka-slf4j_2.11" % "2.4.4",
    "ch.qos.logback" % "logback-classic" % "1.1.3",

    "com.typesafe.slick" %% "slick" % slickVersion,
    "org.postgresql" % "postgresql" % "9.4-1201-jdbc41",
    "org.flywaydb" % "flyway-core" % "3.2.1",

    "com.zaxxer" % "HikariCP" % "2.4.5",
//    "org.slf4j" % "slf4j-nop" % "1.6.4",

    "io.circe" %% "circe-core" % circeV,
    "io.circe" %% "circe-generic" % circeV,
    "io.circe" %% "circe-parser" % circeV,

    "mysql" % "mysql-connector-java" % "5.1.38",

    "org.scalatest" %% "scalatest" % scalaTestV % "test",
    "com.typesafe.akka" %% "akka-http-testkit" % akkaV % "test",
    "ru.yandex.qatools.embed" % "postgresql-embedded" % "1.13" % "test"
  )
}

Revolver.settings
enablePlugins(JavaAppPackaging)
enablePlugins(DockerPlugin)

dockerExposedPorts := Seq(9000)
dockerEntrypoint := Seq("bin/%s" format executableScriptName.value, "-Dconfig.resource=docker.conf")