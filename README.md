# sbt-s3

## Description

*sbt-s3* is a simple sbt plugin that can manipulate objects on Amazon S3.

## Usage

* add to your project/plugin.sbt the line:
   `addSbtPlugin("io.github.morgaroth" % "sbt-s3" % "0.10")`
* then add to your build.sbt the line:
   enablePlugins(S3Plugin)
 
You will then be able to use the tasks s3-upload, s3-download and s3-delete commands
All these operations will use HTTPS as a transport protocol.
 
## Example

Here is a complete example:

project/plugin.sbt:
    
    addSbtPlugin("io.github.morgaroth" % "sbt-s3" % "0.10")

build.sbt:

```scala
mappings in upload := Seq((new java.io.File("a"),"zipa.txt"),(new java.io.File("b"),"pongo/zipb.jar"))

host in upload := "s3sbt-test.s3.amazonaws.com"

credentials += Credentials(Path.userHome / ".s3credentials")
```

~/.s3credentials:

    realm=Amazon S3
    host=s3sbt-test.s3.amazonaws.com
    user=<Access Key ID>
    password=<Secret Access Key>

Just create two sample files called "a" and "b" in the same directory that contains build.sbt, then try:

    $ sbt s3-upload
    
You can also see progress while uploading:

    $ sbt
    > set S3.progress in S3.upload := true
    > s3-upload
    [==================================================]   100%   zipa.txt
    [=====================================>            ]    74%   zipb.jar
