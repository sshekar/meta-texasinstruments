DEPENDS = "tidspbridge-lib tiopenmax-core tiopenmax-rmproxy"
DESCRIPTION = "Texas Instruments OpenMAX IL Policy Manager."
PR = "r1"
COMPONENT_PATH = "system/src/openmax_il/omx_policy_manager"

require tiopenmax-modular.inc
require tiopenmax-cspec-${PV}.inc

OMX_COMPILE_TARGET = "omx_policy_manager"
OMX_INSTALL_TARGET = "omx_policy_manager.install"
OMX_BUILD_DIR = ""

SRC_URI = "file://23.11-pmpthread.patch;patch=1"


do_stage_prepend() {
	install -d ${STAGING_BINDIR}
	install -d ${STAGING_LIBDIR}
	install -d ${STAGING_DIR_TARGET}/usr/omx/
	install -d ${STAGING_INCDIR}/omx/
}

