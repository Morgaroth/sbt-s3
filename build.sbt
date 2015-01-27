name := "sbt-s3"

description := "S3 Plugin for sbt"

version := "0.10-SNAPSHOT"

organization := "io.github.morgaroth"

sbtPlugin := true

libraryDependencies ++= Seq(
  "com.amazonaws" % "aws-java-sdk-s3" % "1.9.16",
  "commons-lang" % "commons-lang" % "2.6"
)

publishMavenStyle := false

sbtVersion in Global := "0.13.5"

scalaVersion in Global := "2.10.4"

pomExtra := {
  <url>https://github.com/Morgaroth/sbt-s3</url>
    <licenses>
      <license>
        <name>Apache 2</name>
        <url>http://www.apache.org/licenses/LICENSE-2.0.txt</url>
      </license>
    </licenses>
    <scm>
      <connection>scm:git:git@github.com:Morgaroth/sbt-s3.git</connection>
      <developerConnection>scm:git:git@github.com:Morgaroth/sbt-s3.git</developerConnection>
      <url>https://github.com/Morgaroth/sbt-s3</url>
    </scm>
    <developers>
      <developer>
        <id>Morgaroth</id>
        <name>Mateusz Jaje</name>
        <url>http://morgaroth.github.io/</url>
      </developer>
    </developers>
}