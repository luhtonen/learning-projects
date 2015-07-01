import sbt._
import sbt.Keys._

object HardyHeronBuild extends Build {
    val hardyHeronDependencies = List(
        "org.scalatest" % "scalatest_2.11" % "2.2.1" % "test"
        )

    val hardyHeronSettings = List(
        name := "HardyHeron",
        version := "1.0",
        scalaVersion := "2.11.6",
        libraryDependencies := hardyHeronDependencies
        )

    override lazy val settings = super.settings ++ hardyHeronSettings
}
