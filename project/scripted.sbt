libraryDependencies <+= sbtVersion { sv =>
  "org.scala-sbt" % "scripted-plugin" % sv
}

scriptedSettings

scriptedLaunchOpts := { scriptedLaunchOpts.value ++
  Seq("-Xmx1024M", "-XX:MaxPermSize=256M", "-Dplugin.version=" + version.value)
}

scriptedBufferLog := false

