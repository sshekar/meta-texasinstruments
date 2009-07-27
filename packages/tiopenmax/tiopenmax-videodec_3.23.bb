DESCRIPTION = "Texas Instruments OpenMAX IL Video Decoder."
DEPENDS = "tidspbridge-lib tiopenmax-core tiopenmax-lcml tiopenmax-rmproxy tiopenmax-resourcemanager"
PR = "r1"
COMPONENT_PATH = "video/src/openmax_il/video_decode"

require tiopenmax-modular.inc
require tiopenmax-cspec-${PV}.inc

SRC_URI = "\
	file://23.13-videodecnocore.patch;patch=1 \
	file://23.13-videodectestpth.patch;patch=1 \
	file://23.13-videodectestnocore.patch;patch=1 \
	${@base_contains("DISTRO_FEATURES", "testpatterns", "", "file://remove-patterns.patch;patch=1", d)} \
	"

do_install_cleanup() {
	# move test files out of /usr/bin/ to /usr/omx only if test patterns exist
	${@base_contains("DISTRO_FEATURES", "testpatterns", "mv ${D}${bindir}/video_decoder.* ${D}/usr/omx/patterns", "echo nothing to do here!", d)}
	${@base_contains("DISTRO_FEATURES", "testpatterns", "mv ${D}${bindir}/pinball_*.length ${D}/usr/omx/patterns", "echo nothing to do here!", d)}
	${@base_contains("DISTRO_FEATURES", "testpatterns", "mv ${D}${bindir}/monster_*.length ${D}/usr/omx/patterns", "echo nothing to do here!", d)}
}

addtask install_cleanup after do_install before do_package
