package ksemver

import com.github.zafarkhaja.semver.Version

fun String.ver() = Version.valueOf(this)

fun Version.inc() = this.incrementPatchVersion()

val Version.major: Int
    get() = getMajorVersion()

val Version.minor: Int
    get() = getMinorVersion()

val Version.patch: Int
    get() = getPatchVersion()

val Version.normal: String
    get() = getNormalVersion()

val Version.preRelease: String
    get() = getPreReleaseVersion()

val Version.buildMetadata: String
    get() = getBuildMetadata()
