DEPENDS = "tiopenmax-base tiopenmax-core tiopenmax-rmproxy tiopenmax-lcml"
DESCRIPTION = "Texas Instruments OpenMAX IL Audio Decoder."
PACKAGES = "${PN} ${PN}-dbg ${PN}-dev"
PR = "r1"

require tiopenmax-audio-${PV}.inc
S = "${WORKDIR}/git/audio/audio_decode/"
SRC_URI += "file://omap4-2-omap3.patch;patch=1;pnum=3"

EXTRA_OECONF = "--enable-tests"

inherit pkgconfig autotools

FILES_${PN} += "${libdir}/*.so"
FILES_${PN}-dev += "${libdir}/*.*a ${libdir}/pkgconfig/"
FILES_${PN}-dbg += "${libdir}/.debug/"

do_stage() {
	autotools_stage_all
}
