DESCRIPTION = "Texas Instruments OpenMAX IL Video Encoder."
DEPENDS = "tidspbridge-lib tiopenmax-core tiopenmax-lcml tiopenmax-rmproxy tiopenmax-resourcemanager"
PR = "r1"
COMPONENT_PATH = "video/src/openmax_il/video_encode"

require tiopenmax-modular.inc
require tiopenmax-cspec-${PV}.inc

SRC_URI = "\
	file://3.21-videoencnocore.patch;patch=1 \
	file://3.21-videoenctestnocore.patch;patch=1 \
	${@base_contains("DISTRO_FEATURES", "testpatterns", "", "file://remove-patterns.patch;patch=1", d)} \
	"

do_install_cleanup() {
	# move test files out of /usr/bin/ to /usr/omx only if test patterns exist
	${@base_contains("DISTRO_FEATURES", "testpatterns", "mv ${D}${bindir}/video_encoder.* ${D}/usr/omx/patterns", "echo nothing to do here!", d)}
	${@base_contains("DISTRO_FEATURES", "testpatterns", "mv ${D}${bindir}/qcif_420_300.yuv* ${D}/usr/omx/patterns", "echo nothing to do here!", d)}
}

addtask install_cleanup after do_install before do_package
