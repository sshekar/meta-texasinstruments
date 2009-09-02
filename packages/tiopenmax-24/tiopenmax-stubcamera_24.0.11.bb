DEPENDS = "tiopenmax-base2 tiopenmax-core tiopenmax-osal"
DESCRIPTION = "Texas Instruments OpenMAX IL Video Decoder."
PACKAGES = "${PN} ${PN}-dbg ${PN}-dev"
PR = "r1"

SRC_URI = "git://sealion.sc.ti.com/git/camera-omx.git;protocol=git"
SRCREV = "f9fb27ed5e757e22ae00653b5ce7b6af8c12bfe9"
S = "${WORKDIR}/git/video/camera/"

EXTRA_OECONF = "--enable-tests"

inherit pkgconfig autotools

FILES_${PN} += "${libdir}/*.so"
FILES_${PN}-dev += "${libdir}/*.*a ${libdir}/pkgconfig/"
FILES_${PN}-dbg += "${libdir}/.debug/"

do_stage() {
	autotools_stage_all
}
