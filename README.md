ksemver
==========

Kotlin Extensions for [zafarkhaja/jsemver](https://github.com/zafarkhaja/jsemver)

Usage
----------

### Creating Versions

String has extension `ver()` function. This is based on `Version.valueOf`.

```kotlin
val v = "1.0.0-rc.1+build.1".ver()

val major = v.major // 1
val minor = v.minor // 0
val patch = v.patch // 0

val normal     = v.normal         // "1.0.0"
val preRelease = v.preRelease     // "rc.1"
val build      = v.buildMetadata  // "build.1"

val versionStr = v.toString() // "1.0.0-rc.1+build.1"
```

### Incrementing Version

`Version` in ksemver has increment operator(`++`). The `++` increments **Patch version**.

```kotlin
var v = "1.0.0-rc.1+build.1".ver()
v++
v.toString() // 1.0.1
```

### Comparing Versions

Thanks to the jsemver implements `Comparable` and overrides `Object.equals`, Kotlin's [Operator overriding](http://kotlinlang.org/docs/reference/operator-overloading.html) works for `==`, `!=`, `<`, `>`, `<=` and `>=`.

```kotlin
val v1 = "1.0.0-rc.1+build.1".ver()
val v2 = "1.3.7+build.2.b8f12d7".ver()

val result = v1 == v2   // false
val result = v1 != v2   // true

val result = v1 > v2    // false
val result = v1 < v2    // true
val result = v1 >= v2   // false
val result = v1 <= v2   // true
```
