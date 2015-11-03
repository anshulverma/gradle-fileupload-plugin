# gradle-fileupload

[![Build Status](https://travis-ci.org/anshulverma/gradle-fileupload-plugin.svg?branch=master)](https://travis-ci.org/anshulverma/gradle-fileupload-plugin)
[![Download](https://api.bintray.com/packages/anshulverma/gradle-plugins/gradle-fileupload-plugin/images/download.svg)](https://bintray.com/anshulverma/gradle-plugins/gradle-fileupload-plugin/_latestVersion)

A gradle plugin to upload a file to a remote loacation

## Usage

``` groovy
// first add the maven dependency for the plugin
buildscript {
  repositories {
    jcenter() // also works with mavenCentral()
  }
  dependencies {
    classpath 'net.anshulverma.gradle:gradle-fileupload-plugin:1.0.2'
  }
}

// then apply the plugin
apply plugin: 'net.anshulverma.gradle.fileupload'

// then specify properties for file upload
fileupload {
  url = 'http://upload.file.com/destination'
  file = "$projectDir/build/distributions/my-build-file.tar.gz"
  params.'type' = 'new'
  auth {
    username = 'admin'
    password = 'pass1234'
  }
}
```
