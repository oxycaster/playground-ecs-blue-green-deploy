lazy val root = (project in file("."))
  .settings(
    name := "playground-ecs-blue-green-deploy",
    scalaVersion := "2.12.18",
    Universal / javaOptions ++= Seq ("-Dpidfile.path=/dev/null"),
    dockerBaseImage := "eclipse-temurin:11",
    libraryDependencies ++= Seq(
      "com.softwaremill.macwire" %% "macros" % "2.5.8" % Provided,
      "com.softwaremill.macwire" %% "macrosakka" % "2.5.8" % Provided,
      "com.softwaremill.macwire" %% "util" % "2.5.8",
      "com.softwaremill.macwire" %% "proxy" % "2.5.8",
    )
  ).enablePlugins(PlayScala)
  .enablePlugins(DockerPlugin)

ThisBuild / evictionErrorLevel := Level.Info