DESCRIPTION = "Texas Instruments OpenMAX IL PCM Decoder."
DEPENDS = "tidspbridge-lib tiopenmax-core tiopenmax-lcml tiopenmax-rmproxy tiopenmax-resourcemanager tiopenmax-audiomanager tiopenmax-perf"
PR = "r0"
COMPONENT_PATH = "audio/src/openmax_il/pcm_dec"

require tiopenmax-modular.inc
require tiopenmax-cspec-${PV}.inc

SRC_URI = "\
	file://23.14-pcmdecnocore.patch;patch=1 \
	file://23.14-pcmdectestnocore.patch;patch=1 \
	${@base_contains("DISTRO_FEATURES", "testpatterns", "", "file://remove-patterns.patch;patch=1", d)} \
	"

do_compile_prepend() {
	rm ${S}/${COMPONENT_PATH}/inc/TIDspOmx.h
	cp ${STAGING_INCDIR}/omx/TIDspOmx.h ${S}/${COMPONENT_PATH}/inc
}

do_install_cleanup() {
	# move test files out of /usr/bin/ to /usr/omx only if test patterns exist
	${@base_contains("DISTRO_FEATURES", "testpatterns", "mv ${D}${bindir}/audio_renderer.pcm* ${D}/usr/omx/patterns/", "echo nothing to do here!", d)}
}

addtask install_cleanup after do_install before do_package
