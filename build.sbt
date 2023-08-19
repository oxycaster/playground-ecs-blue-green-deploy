lazy val root = (project in file("."))
  .settings(
    name := "playground-ecs-blue-green-deploy",
    scalaVersion := "2.12.18",
    Universal / javaOptions ++= Seq ("-Dpidfile.path=/dev/null"),

    dockerBaseImage := "amazoncorretto:11",
    dockerExposedPorts ++= Seq(9000),

    dockerEnvVars := Map("TZ" -> "Asia/Tokyo"),
    dockerEntrypoint := Seq("bin/entrypoint.sh"),

    Docker / daemonUserUid := None,
    Docker / daemonUser := "daemon",

    libraryDependencies ++= Seq(
      "com.softwaremill.macwire" %% "macros" % "2.5.8" % Provided,
      "com.softwaremill.macwire" %% "macrosakka" % "2.5.8" % Provided,
      "com.softwaremill.macwire" %% "util" % "2.5.8",
      "com.softwaremill.macwire" %% "proxy" % "2.5.8",
    )
  ).enablePlugins(PlayScala)
  .enablePlugins(DockerPlugin)

ThisBuild / evictionErrorLevel := Level.Info