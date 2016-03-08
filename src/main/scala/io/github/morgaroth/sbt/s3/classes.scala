package io.github.morgaroth.sbt.s3

import sbt._

case class UploadResult(inputFile: File)

case class DownloadResult(outputFile: File)