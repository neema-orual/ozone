@Suppress("DSL_SCOPE_VIOLATION")
plugins {
  val agp = libs.versions.agp
  val compose = libs.versions.compose
  val kotlin = libs.versions.kotlin
  val ksp = libs.versions.ksp
  val mavenPublish = libs.versions.maven.publish
  val kotlinxAbi = libs.versions.kotlinx.abi.plugin

  kotlin("jvm") version kotlin apply false
  kotlin("multiplatform") version kotlin apply false
  kotlin("plugin.serialization") version kotlin apply false
  kotlin("android") version kotlin apply false
  id("com.android.application") version agp apply false
  id("com.android.library") version agp apply false
  id("com.google.devtools.ksp") version ksp apply false
  id("com.vanniktech.maven.publish") version mavenPublish apply false
  id("org.jetbrains.compose") version compose apply false
  id("org.jetbrains.kotlinx.binary-compatibility-validator") version kotlinxAbi apply false
}

allprojects {
  group = property("POM_GROUP_ID").toString()
  version = property("POM_VERSION").toString()
}
