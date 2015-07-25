import com.github.zafarkhaja.semver.Version
import spock.lang.Specification

class JSemVerSpec extends Specification {
    def 'valueOf() can parse version string'() {
        given:
        String versionStr = '1.0.0-rc.1+build.1'

        when:
        Version v = Version.valueOf(versionStr);

        then:
        v.getMajorVersion() == 1
        v.getMinorVersion() == 0
        v.getPatchVersion() == 0
        v.getNormalVersion() == '1.0.0'
        v.getPreReleaseVersion() == 'rc.1'
        v.getBuildMetadata() == 'build.1'
        v.toString() == '1.0.0-rc.1+build.1'
    }
}