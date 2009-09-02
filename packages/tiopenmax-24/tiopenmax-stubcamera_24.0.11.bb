DEPENDS = "tiopenmax-base2 tiopenmax-core tiopenmax-osal"
DESCRIPTION = "Texas Instruments OpenMAX IL Video Decoder."
PACKAGES = "${PN} ${PN}-dbg ${PN}-dev"
PR = "r1"

SRC_URI = "git://sealion.sc.ti.com/git/camera-omx.git;protocol=git"
SRCREV = "c84688dedb4f083eb9f86f2a50cb6826dc673d17"
S = "${WORKDIR}/git/video/camera/"

EXTRA_OECONF = "--enable-tests"

inherit pkgconfig autotools

FILES_${PN} += "${libdir}/*.so"
FILES_${PN}-dev += "${libdir}/*.*a ${libdir}/pkgconfig/"
FILES_${PN}-dbg += "${libdir}/.debug/"

do_stage() {
	autotools_stage_all
}
