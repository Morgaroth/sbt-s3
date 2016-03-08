package io.github.morgaroth.sbt.s3

import sbt.File

object Implicits {
  def assembliedJarName(directory: File, projectName: String, version: String): (File, String) = {
    val fileName = "%s-%s.jar".format(projectName, version)
    new File(directory, fileName) -> fileName
  }
}
