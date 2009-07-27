DESCRIPTION = "Texas Instruments OpenMAX IL Camera."
DEPENDS = "tidspbridge-lib tiopenmax-core tiopenmax-lcml tiopenmax-rmproxy tiopenmax-resourcemanager mm-isp tiopenmax-clock"
PR = "r1"

COMPONENT_PATH = "video/src/openmax_il/camera"

require tiopenmax-modular.inc
require tiopenmax-cspec-${PV}.inc

SRC_URI = "\
	file://23.14-cameranocore.patch;patch=1 \
	file://23.14-cameratestnocore.patch;patch=1 \
	${@base_contains("DISTRO_FEATURES", "testpatterns", "", "file://remove-patterns.patch;patch=1", d)} \
	"

do_compile_prepend() {
	install -d ${D}${libdir}
	install -d ${D}/usr/include/mmisp
	cp ${STAGING_INCDIR}/capl/inc/*.h ${S}/video/src/openmax_il/camera/inc
	cp ${STAGING_INCDIR}/camera_algo_frmwk/inc/*.h ${S}/video/src/openmax_il/camera/inc
	cp ${STAGING_INCDIR}/ipp/inc/*.h ${S}/video/src/openmax_il/camera/inc
	cp ${STAGING_INCDIR}/mmisp/*.h ${D}/usr/include/mmisp
}


