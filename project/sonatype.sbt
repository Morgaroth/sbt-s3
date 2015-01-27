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

publishTo := {
  val nexus = "https://oss.sonatype.org/"
  if (version.value.endsWith("SNAPSHOT"))
    Some("snapshots" at nexus + "content/repositories/snapshots")
  else
    Some("releases" at nexus + "service/local/staging/deploy/maven2")
}

publishArtifact in Test := false
