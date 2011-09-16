import sbt._
import Keys._

object QuerulousBuild extends Build {

  lazy val root = Project(
    "querulous", file("."),
    settings = rootSettings
  ) aggregate core

  lazy val core = Project(
    "querulous-core", file("querulous-core"),
    settings = coreSettings
  )

//  lazy val tracing = Project(
//    "querulous-tracing", file("querulous-tracing"),
//    settings = tracingSettings
//  ) dependsOn core


  lazy val rootSettings = Defaults.defaultSettings ++ Seq(
    organization  := "com.twitter",
    version       := "2.3.14",
    scalaVersion  := "2.9.1",

    scalacOptions ++= Seq(
      "-deprecation",
      "-unchecked"
    )
  )

  lazy val coreSettings = rootSettings ++ Seq(
    resolvers += "twitter.com" at "http://maven.twttr.com/",

    libraryDependencies ++= Seq(
      "com.twitter"  %% "util-core"           % "1.11.2-SNAPSHOT",
      "commons-dbcp" % "commons-dbcp"         % "1.4",
      "mysql"        % "mysql-connector-java" % "5.1.17",
      "commons-pool" % "commons-pool"         % "1.5.6",

      "com.twitter"             %% "util-eval"         % "1.11.2-SNAPSHOT" % "test",
      "org.scala-lang"          % "scala-compiler"     % "2.9.1"  % "test",
      "org.hamcrest"            % "hamcrest-all"       % "1.1"    % "test",
      "org.scala-tools.testing" %% "specs"             % "1.6.9"  % "test",
      "org.objenesis"           % "objenesis"          % "1.1"    % "test",
      "org.jmock"               % "jmock"              % "2.4.0"  % "test",
      "cglib"                   % "cglib"              % "2.2"    % "test",
      "asm"                     % "asm"                % "1.5.3"  % "test",
      "commons-dbcp"            % "commons-dbcp-tests" % "1.4"    % "test"
    )
  )

//  lazy val tracingSettings = coreSettings ++ Seq(
//    libraryDependencies += "com.twitter"  % "finagle-core"         % "1.9.0"
//  )
}
