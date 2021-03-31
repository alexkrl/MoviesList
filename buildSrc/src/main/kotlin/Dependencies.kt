/*
 * Copyright (c) 2019 Razeware LLC
 *
 * Permission is hereby granted, free of charge, to any person obtaining a copy
 * of this software and associated documentation files (the "Software"), to deal
 * in the Software without restriction, including without limitation the rights
 * to use, copy, modify, merge, publish, distribute, sublicense, and/or sell
 * copies of the Software, and to permit persons to whom the Software is
 * furnished to do so, subject to the following conditions:
 *
 * The above copyright notice and this permission notice shall be included in
 * all copies or substantial portions of the Software.
 *
 * Notwithstanding the foregoing, you may not use, copy, modify, merge, publish,
 * distribute, sublicense, create a derivative work, and/or sell copies of the
 * Software in any work that is designed, intended, or marketed for pedagogical or
 * instructional purposes related to programming, coding, application development,
 * or information technology.  Permission for such use, copying, modification,
 * merger, publication, distribution, sublicensing, creation of derivative works,
 * or sale is expressly withheld.
 *
 * THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR
 * IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY,
 * FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL THE
 * AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER
 * LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM,
 * OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN
 * THE SOFTWARE.
 */

const val kotlinVersion = "1.4.32"

object BuildPlugins {

  object Versions {
    const val buildToolsVersion = "7.0.0-alpha12"
  }

  const val androidGradlePlugin = "com.android.tools.build:gradle:${Versions.buildToolsVersion}"
  const val kotlinGradlePlugin = "org.jetbrains.kotlin:kotlin-gradle-plugin:$kotlinVersion"
  const val androidApplication = "com.android.application"
  const val kotlinAndroid = "android"
  const val kotlinAndroidExtensions = "android.extensions"
  const val kotlinKapt = "kapt"

}

object AndroidSdk {
  const val min = 21
  const val compile = 29
  const val target = compile
}

object Libraries {
  private object Versions {
    const val room = "2.2.5"
    const val lifecycle = "2.2.0"
    const val jetpack = "1.1.0"
    const val constraintLayout = "1.1.3"
    const val retrofit = "2.9.0"
    const val okHttp = "4.7.1"
    const val glide = "4.11.0"
    const val cardview = "1.0.0"
    const val koin = "2.1.6"

  }

  const val roomRuntime = "androidx.room:room-runtime:${Versions.room}"
  const val roomCompiler = "androidx.room:room-compiler:${Versions.room}"
  const val roomKtx = "androidx.room:room-ktx:${Versions.room}"

  const val lifecycleViewModelKtx = "androidx.lifecycle:lifecycle-viewmodel-ktx:${Versions.lifecycle}"
  const val lifecycleExtensions = "androidx.lifecycle:lifecycle-extensions:${Versions.lifecycle}"

  const val kotlinStdLib = "org.jetbrains.kotlin:kotlin-stdlib-jdk8:$kotlinVersion"

  const val appCompat = "androidx.appcompat:appcompat:${Versions.jetpack}"
  const val material = "com.google.android.material:material:${Versions.jetpack}"
  const val recyclerView = "androidx.recyclerview:recyclerview:${Versions.jetpack}"
  const val constraintLayout = "androidx.constraintlayout:constraintlayout:${Versions.constraintLayout}"
  const val cardView = "androidx.cardview:cardview:${Versions.cardview}"

  const val glide = "com.github.bumptech.glide:glide:${Versions.glide}"
  const val glideCompiler = "com.github.bumptech.glide:compiler:${Versions.glide}"

  const val retrofit = "com.squareup.retrofit2:retrofit:${Versions.retrofit}"
  const val retrofitGson = "com.squareup.retrofit2:converter-gson:${Versions.retrofit}"
  const val okHttpInterceptor = "com.squareup.okhttp3:logging-interceptor:${Versions.okHttp}"

  const val koin_core = "org.koin:koin-core:${Versions.koin}"
  const val koin_viewmodel = "org.koin:koin-androidx-viewmodel:${Versions.koin}"

}

