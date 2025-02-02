plugins {
  id("com.android.application")
  kotlin("android")
  id("ozone-android")
  id("ozone-compose")
}

dependencies {
  implementation(project(":common"))
  implementation(libs.androidx.activity.compose)
  implementation(libs.androidx.appcompat)
  implementation(libs.androidx.core)
  implementation(libs.retainedactivity)
}

android {
  namespace = "sh.christian.ozone"

  defaultConfig {
    applicationId = "sh.christian.ozone"
    versionCode = 100
    versionName = version.toString()
  }
}
