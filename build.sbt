val scala3Version = "3.7.3"

lazy val root = project
  .in(file("."))
  .settings(
    name := "zjp",
    version := "0.1.0-SNAPSHOT",
    scalaVersion := scala3Version,
    libraryDependencies ++= Seq(
      "org.scalameta" %% "munit" % "1.2.1" % Test,
      "org.apache.pekko" %% "pekko-actor-typed" % "1.3.0",
      "org.apache.pekko" %% "pekko-stream" % "1.3.0",
      "org.apache.pekko" %% "pekko-http" % "1.3.0",
      "ch.qos.logback" % "logback-classic" % "1.5.21" // logging
    )
  )
