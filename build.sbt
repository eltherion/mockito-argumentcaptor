name := "mockito-captor-example"

version := "0.0.1"

scalaVersion := "2.12.6"

libraryDependencies ++= Seq(
  "org.mockito" % "mockito-core" % "2.19.0" % Test,
  "org.scalatest" %% "scalatest" % "3.0.5" % Test
)

