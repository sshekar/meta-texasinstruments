DESCRIPTION = "Texas Instruments OpenMAX IL JPEG Encoder."
DEPENDS = "tidspbridge-lib tiopenmax-core tiopenmax-lcml tiopenmax-rmproxy tiopenmax-resourcemanager tiopenmax-perf"
PR = "r0"
COMPONENT_PATH = "image/src/openmax_il/jpeg_enc"

require tiopenmax-modular.inc
require tiopenmax-cspec-${PV}.inc

SRC_URI = "\
	file://23.11-jpegencnocore.patch;patch=1 \
	file://23.11-jpegenctestnocore.patch;patch=1 \
	${@base_contains("DISTRO_FEATURES", "testpatterns", "", "file://remove-patterns.patch;patch=1", d)} \
	"

do_install_cleanup() {
	${@base_contains("DISTRO_FEATURES", "testpatterns", "mv ${D}${bindir}/vga256.yuv.length ${D}/usr/omx/patterns", "echo nothing to do here!", d)}
	${@base_contains("DISTRO_FEATURES", "testpatterns", "mv ${D}${bindir}/image_encoder.jpeg_i0def.* ${D}/usr/omx/patterns", "echo nothing to do here!", d)}
}

addtask install_cleanup after do_install before do_package
