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
    }

    test fun versionIncrementEffectsPatchVersion() {
        var version = "1.2.3-rc.1+build.1".ver()
        assert(++version == "1.2.4".ver()) {
            println("actual: " + version.toString())
        }
    }

    test fun comparable() {
        assert("1.2.3".ver() > "1.2.2".ver())
    }

}