lazy val root = (project in file("."))
  .settings(
    name := "playground-ecs-blue-green-deploy",
    scalaVersion := "2.12.18"
  ).enablePlugins(PlayScala)

ThisBuild / evictionErrorLevel := Level.Info