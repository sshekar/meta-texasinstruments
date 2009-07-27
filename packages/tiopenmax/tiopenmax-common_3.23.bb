DEPENDS = "tidspbridge-lib"
DESCRIPTION = "Texas Instruments Common files for OpenMAX IL."
PR = "r0"
COMPONENT_PATH = "system/src/openmax_il/common"

require tiopenmax-modular.inc
require tiopenmax-cspec-${PV}.inc

OMX_COMPILE_TARGET = "common"
OMX_INSTALL_TARGET = "common.install"
OMX_BUILD_DIR = ""

CCASE_PATHFETCH = "\
	/vobs/wtbu/OMAPSW_MPU/linux/system/src/openmax_il/common \
	/vobs/wtbu/OMAPSW_MPU/linux/audio/src/openmax_il/aac_dec/inc/TIDspOmx.h \
	/vobs/wtbu/OMAPSW_MPU/linux/Makefile \
	/vobs/wtbu/OMAPSW_MPU/linux/Master.mk \
	"

do_stage_prepend() {
	install -m 0644 ${S}/audio/src/openmax_il/aac_dec/inc/TIDspOmx.h ${STAGING_INCDIR}/omx
}

# this is a hack.  We should really only package ${PN}-dev since this recipe
# only ships headers.  However bitbake complains about not being able to
# satisfy deps during do_rootfs.  ALLOW_EMPTY = "1" doesn't seem to help...

PACKAGES = "${PN}"

FILES_${PN} = "\
        /usr/include \
        "

