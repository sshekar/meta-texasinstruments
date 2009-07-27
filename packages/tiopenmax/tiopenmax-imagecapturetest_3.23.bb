DESCRIPTION = "Texas Instruments OpenMAX IL Image Capture Test Application."
DEPENDS = "tidspbridge-lib tiopenmax-core tiopenmax-lcml tiopenmax-rmproxy tiopenmax-resourcemanager tiopenmax-rmproxy tiopenmax-postproc tiopenmax-prepostproc tiopenmax-jpegdec tiopenmax-camera"
PR = "r0"
COMPONENT_PATH = "application/src/openmax_il/image_capture"

require tiopenmax-modular.inc
require tiopenmax-cspec-${PV}.inc

SRC_URI = "\
	file://23.16-imagecapnocore.patch;patch=1 \
	${@base_contains("DISTRO_FEATURES", "testpatterns", "", "file://remove-patterns.patch;patch=1", d)} \
	"

do_install_cleanup() {
	# move test files out of /usr/bin/ to /usr/omx only if test patterns exist
	${@base_contains("DISTRO_FEATURES", "testpatterns", "mv ${D}${bindir}/video_decoder.* ${D}/usr/omx/patterns", "echo nothing to do here!", d)}
	${@base_contains("DISTRO_FEATURES", "testpatterns", "mv ${D}${bindir}/pinball_*.length ${D}/usr/omx/patterns", "echo nothing to do here!", d)}
	${@base_contains("DISTRO_FEATURES", "testpatterns", "mv ${D}${bindir}/monster_*.length ${D}/usr/omx/patterns", "echo nothing to do here!", d)}
}

addtask install_cleanup after do_install before do_package
