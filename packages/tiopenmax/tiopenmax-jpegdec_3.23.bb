DESCRIPTION = "Texas Instruments OpenMAX IL JPEG Decoder."
DEPENDS = "tidspbridge-lib tiopenmax-core tiopenmax-lcml tiopenmax-rmproxy tiopenmax-resourcemanager tiopenmax-perf"
PR = "r0"
COMPONENT_PATH = "image/src/openmax_il/jpeg_dec"

require tiopenmax-modular.inc
require tiopenmax-cspec-${PV}.inc

SRC_URI = "\
	file://23.11-jpegdecnocore.patch;patch=1 \
	file://23.11-jpegdectestnocore.patch;patch=1 \
	${@base_contains("DISTRO_FEATURES", "testpatterns", "", "file://remove-patterns.patch;patch=1", d)} \
	"

do_install_cleanup() {
	${@base_contains("DISTRO_FEATURES", "testpatterns", "mv ${D}${bindir}/240VGA.jpg.length ${D}/usr/omx/patterns", "echo nothing to do here!", d)}
	${@base_contains("DISTRO_FEATURES", "testpatterns", "mv ${D}${bindir}/image_decoder.jpeg_i0def.* ${D}/usr/omx/patterns", "echo nothing to do here!", d)}
}

addtask install_cleanup after do_install before do_package
