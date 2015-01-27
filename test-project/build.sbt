import sbt.Keys._
import io.github.morgaroth.sbt.s3.Implicits.assembliedJarName

name := "test-s3-project"

version := "0.1.0"

mappings in s3Upload += assembliedJarName((crossTarget in Compile).value, name.value, version.value)

enablePlugins(S3Plugin)
