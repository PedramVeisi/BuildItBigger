
# Gradle for Android and Java Final Project
## Project 4 - Android Developer Nanodegree

This project, is an app with multiple flavors that uses
multiple libraries and Google Could Endpoints. The app consists
of four modules. A Java library that provides jokes, a Google Could Endpoints
(GCE) project that serves those jokes, an Android Library containing an
activity for displaying jokes, and an Android app that fetches jokes from the
GCE module and passes them to the Android Library for display.

## Why this Project

As Android projects grow in complexity, it becomes necessary to customize the
behavior of the Gradle build tool, allowing automation of repetitive tasks.
Particularly, factoring functionality into libraries and creating product
flavors allow for much bigger projects with minimal added complexity.

## Learning Points

* Adding free and paid flavors to an app, and setting up build to share code between them
* Factoring reusable functionality into a Java library
* Factoring reusable Android functionality into an Android library
* Configuring a multi project build to compile libraries and app
* Using the Gradle App Engine plugin to deploy a backend
* Configuring an integration test suite that runs against the local App Engine development server
* Writing functional tests for Android applications
* Working with AdMob (both banner and interstitial ads)
