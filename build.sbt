import com.typesafe.sbt.pgp.PgpKeys._
import sbtrelease.ReleaseStep
import sbtrelease.ReleaseStateTransformations._
import sbtrelease.Utilities._

name := "sbt-s3"

description := "S3 Plugin for sbt"

organization := "io.github.morgaroth"

sbtPlugin := true

libraryDependencies ++= Seq(
  "com.amazonaws" % "aws-java-sdk-s3" % "1.9.16",
  "commons-lang" % "commons-lang" % "2.6"
)

sbtVersion in Global := "0.13.5"

scalaVersion in Global := "2.10.4"

releaseSettings

val publishArtifactsLocally = ReleaseStep(action = (st: State) => {
  val extracted = st.extract
  val ref = extracted.get(thisProjectRef)
  extracted.runAggregated(publishLocal in Global in ref, st)
})

val publishArtifactsSigned = ReleaseStep(action = (st: State) => {
  val extracted = st.extract
  val ref = extracted.get(thisProjectRef)
  extracted.runAggregated(publishSigned in Global in ref, st)
})

sonatypeSettings

import SonatypeKeys._

val finishReleseAtSonatype = ReleaseStep(action = (st: State) => {
  val extracted = st.extract
  val ref = extracted.get(thisProjectRef)
  extracted.runAggregated(sonatypeReleaseAll in Global in ref, st)
})

ReleaseKeys.releaseProcess := Seq[ReleaseStep](
  checkSnapshotDependencies, // : ReleaseStep
  inquireVersions, // : ReleaseStep
  runTest, // : ReleaseStep
  setReleaseVersion, // : ReleaseStep
  publishArtifactsSigned,
  finishReleseAtSonatype,
  commitReleaseVersion, // : ReleaseStep, performs the initial git checks
  tagRelease, // : ReleaseStep
  setNextVersion, // : ReleaseStep
  commitNextVersion, // : ReleaseStep
  pushChanges // : ReleaseStep, also checks that an upstream branch is properly configured
)

scriptedSettings

scriptedLaunchOpts := { scriptedLaunchOpts.value ++
  Seq("-Xmx1024M", "-XX:MaxPermSize=256M", "-Dplugin.version=" + version.value)
}

scriptedBufferLog := false