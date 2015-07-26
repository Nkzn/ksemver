package ksemver

import com.github.zafarkhaja.semver.Version
import kotlin.test.assertEquals
import org.junit.Test as test

class KSemVerTest {

    test fun extentionForInit() {
        assert("1.2.3".ver() == Version.forIntegers(1,2,3))

        val actual = "1.0.0-rc.1+build.1".ver()
        val expected = Version.Builder()
                .setNormalVersion("1.0.0")
                .setPreReleaseVersion("rc.1")
                .setBuildMetadata("build.1")
                .build()

        assert(actual == expected)
        assert(actual.major == 1)
        assert(actual.minor == 0)
        assert(actual.patch == 0)
        assert(actual.normal == "1.0.0")
        assert(actual.preRelease == "rc.1")
        assert(actual.buildMetadata == "build.1")
    }

    test fun versionIncrementEffectsPatchVersion() {
        var version = "1.2.3-rc.1+build.1".ver()
        assert(++version == "1.2.4".ver()) {
            println("actual: " + version.toString())
        }
    }

    test fun comparable() {
        val v1 = "1.0.0-rc.1+build.1".ver()
        val v2 = "1.3.7+build.2.b8f12d7".ver()

        assert((v1 == v2) == false)
        assert((v1 != v2) == true)

        assert((v1 > v2) == false)
        assert((v1 < v2) == true)
        assert((v1 >= v2) == false)
        assert((v1 <= v2) == true)
    }

}