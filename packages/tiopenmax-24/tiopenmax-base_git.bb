DEPENDS = "tiopenmax-osal tiopenmax-core"
DESCRIPTION = "Texas Instruments OpenMAX IL Base functionality."
PACKAGES = "${PN} ${PN}-dbg ${PN}-dev"
PR = "r0"

require tiopenmax-audio-${PV}.inc
S = "${WORKDIR}/git/system/omx_base/"
SRC_URI += "file://basetracettif.patch;patch=1"

inherit pkgconfig autotools

FILES_${PN} += "${libdir}/*.so"
FILES_${PN}-dev += "${libdir}/*.*a ${libdir}/pkgconfig/"
FILES_${PN}-dbg += "${libdir}/.debug/"

do_stage() {
	autotools_stage_all
}
