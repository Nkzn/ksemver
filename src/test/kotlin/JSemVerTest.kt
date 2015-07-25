import com.github.zafarkhaja.semver.Version
import org.junit.Test as test

class JSemVerTest {
    test fun valueOfCanParseVersionString() {
        val v: Version = Version.valueOf("1.0.0-rc.1+build.1")

        assert(v.getMajorVersion() == 1)
        assert(v.getMinorVersion() == 0)
        assert(v.getPatchVersion() == 0)
        assert(v.getNormalVersion() == "1.0.0")
        assert(v.getPreReleaseVersion() == "rc.1")
        assert(v.getBuildMetadata() == "build.1")
        assert(v.toString() == "1.0.0-rc.1+build.1")
    }
}