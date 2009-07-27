DESCRIPTION = "Texas Instruments OpenMAX IL armaac Encoder."
DEPENDS = "tidspbridge-lib tiopenmax-core tiopenmax-lcml tiopenmax-rmproxy tiopenmax-resourcemanager tiopenmax-perf"
PR = "r0"
COMPONENT_PATH = "audio/src/openmax_il/armaac_enc"

require tiopenmax-modular.inc
require tiopenmax-cspec-${PV}.inc

SRC_URI = "\
	file://23.14-armaacencnocore.patch;patch=1 \
	file://23.14-armaacencnoincinstall.patch;patch=1 \
	${@base_contains("DISTRO_FEATURES", "testpatterns", "", "file://remove-patterns.patch;patch=1", d)} \
	"

do_compile_prepend() {
	rm ${S}/${COMPONENT_PATH}/inc/TIDspOmx.h
	cp ${STAGING_INCDIR}/omx/TIDspOmx.h ${S}/${COMPONENT_PATH}/inc
}

