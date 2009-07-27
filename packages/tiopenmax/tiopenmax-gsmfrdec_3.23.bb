DESCRIPTION = "Texas Instruments OpenMAX IL GSMFR Decoder."
DEPENDS = "tidspbridge-lib tiopenmax-core tiopenmax-lcml tiopenmax-rmproxy tiopenmax-resourcemanager tiopenmax-audiomanager tiopenmax-perf"
PR = "r0"
COMPONENT_PATH = "audio/src/openmax_il/gsmfr_dec"

require tiopenmax-modular.inc
require tiopenmax-cspec-${PV}.inc

SRC_URI = "\
	file://23.14-gsmfrdecnocore.patch;patch=1 \
	file://23.14-gsmfrdectestnocore.patch;patch=1 \
	${@base_contains("DISTRO_FEATURES", "testpatterns", "", "file://remove-patterns.patch;patch=1", d)} \
	"

do_compile_prepend() {
	rm ${S}/${COMPONENT_PATH}/inc/TIDspOmx.h
	cp ${STAGING_INCDIR}/omx/TIDspOmx.h ${S}/${COMPONENT_PATH}/inc
}

