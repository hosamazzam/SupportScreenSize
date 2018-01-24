# SupportScreenSize
[![](https://jitpack.io/v/hosamazzam/SupportScreenSize.svg)](https://jitpack.io/#hosamazzam/SupportScreenSize)

## Synopsis
SupportScreenSize is library rhat allow you to know whice type of phone you have (phone,phap,tablet,larage tablet)

## Install

To get a Git project into your build: (Min SDK is API 21)

Step 1. Add the JitPack repository to your build file (Gradle)

Add it in your root build.gradle at the end of repositories:

	allprojects {
		repositories {
			...
			maven { url "https://jitpack.io" }
		}
	}
  
Step 2. Add the dependency in app/build.gradle

	dependencies {
	        compile 'com.github.hosamazzam:SupportScreenSize:v1.0.5'
	}

## Built With

* [Gradle](https://gradle.org/) - Build Tool
* [JitPack](https://jitpack.io/) - Publish your JVM and Android libraries

## Code Examples
```
if(new SupportScreenSize(this).isTablet()){
	// do something
}
```

```
new SupportScreenSize(this).checkDeviceType() : return type of device
new SupportScreenSize(this).getDensity() : return device Density
new SupportScreenSize(this).getHeightIndp() : return device Height in dp
new SupportScreenSize(this).getHeigh() : return device Height in pixels
```

## License
This project is licensed under the MIT License - see the [LICENSE.md](License.md) file for details
