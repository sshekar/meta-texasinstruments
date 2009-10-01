DEPENDS = "tiopenmax-base tiopenmax-core tiopenmax-rmproxy tiopenmax-lcml ${@base_contains("DISTRO_FEATURES", "ttif", "ttif", "", d)}"
DESCRIPTION = "Texas Instruments OpenMAX IL Video Decoder."
PACKAGES = "${PN} ${PN}-dbg ${PN}-dev"
PR = "r2"

require tiopenmax-video-git.inc
S = "${WORKDIR}/git/video/video_decode/"

EXTRA_OECONF = "--enable-tests"

inherit pkgconfig autotools

FILES_${PN} += "${libdir}/*.so"
FILES_${PN}-dev += "${libdir}/*.*a ${libdir}/pkgconfig/"
FILES_${PN}-dbg += "${libdir}/.debug/"

do_stage() {
	autotools_stage_all
}
