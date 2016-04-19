import org.scalatest.Matchers._
import ByteConversions._

lazy val root = (project in file(".")).enablePlugins(JavaAppPackaging)

name := "sandbox-all-args"

version := "0.1.0-SNAPSHOT"

// ConductR bundle keys
BundleKeys.nrOfCpus := 1.0
BundleKeys.memory := 64.MiB
BundleKeys.diskSpace := 10.MB

val checkConductrIsStopped = taskKey[Unit]("")
checkConductrIsStopped := {
  """docker ps --quiet --filter name=cond""".lines_! should have size 0
}