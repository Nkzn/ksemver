package ksemver

import com.github.zafarkhaja.semver.Version

fun String.ver() = Version.valueOf(this)

fun Version.inc() = this.incrementPatchVersion()