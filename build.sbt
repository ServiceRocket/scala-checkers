javacOptions ++= Seq("-source", "1.8", "-target", "1.8", "-Xlint")
scalacOptions ++= Seq("-feature", "-target:jvm-1.8")
scalaVersion := "2.11.12"
val ScalacheckVersion = "1.13.5"

resolvers := Resolver
  .withDefaultResolvers(
    mavenCentral = true,
    userResolvers = Seq(
      Resolver.mavenLocal,
      "Atlassian's Maven Public Repository" at "https://maven.atlassian.com/content/groups/public/",
      "Typesafe Repository" at "http://repo.typesafe.com/typesafe/releases/",
      "Typesafe Simple Repository" at "http://repo.typesafe.com/typesafe/simple/maven-releases/",
      "ServiceRocket's Private Repository" at "https://t-nx2.performancerocket.com/content/groups/private/",
      "ServiceRocket's Public Repository" at "https://t-nx2.performancerocket.com/content/groups/public/"
    )
  )

credentials += Credentials(Path.userHome / ".ivy2" / ".credentials")
publishTo := version { (v: String) =>
  val Nexus = "https://t-nx2.performancerocket.com/"
  if (v.trim.endsWith("SNAPSHOT")) Some("ServiceRocket's Snapshots" at Nexus + "content/repositories/snapshots")
  else Some("ServiceRocket's Releases" at Nexus + "content/repositories/releases")
}.value

name := "scala-checkers"
version := "0.1.0-SNAPSHOT"
description := "ScalaCheck Generators Extension"
organization := "com.servicerocket"
organizationName := "ServiceRocket"
organizationHomepage := Option(url("http://www.servicerocket.com"))
libraryDependencies += "org.scalacheck" %% "scalacheck" % ScalacheckVersion % "provided"