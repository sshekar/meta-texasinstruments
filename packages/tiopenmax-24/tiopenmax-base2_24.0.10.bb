DEPENDS = "tiopenmax-osal tiopenmax-core"
DESCRIPTION = "Texas Instruments OpenMAX IL (New) Base Component."
PACKAGES = "${PN} ${PN}-dbg ${PN}-dev"
PR = "r1"

require tiopenmax-system-git.inc
S = "${WORKDIR}/git/system/omx_base/"

inherit pkgconfig autotools

FILES_${PN} += "${libdir}/*.so"
FILES_${PN}-dev += "${libdir}/*.*a ${libdir}/pkgconfig/"
FILES_${PN}-dbg += "${libdir}/.debug/"

do_stage() {
	autotools_stage_all
}
