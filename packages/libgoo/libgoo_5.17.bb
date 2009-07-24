SECTION = "libs"
DEPENDS = "glib-2.0 virtual/openmax-il ${TTIF_DEPENDS}"
DESCRIPTION = "Library for interacting OpenMAX IL."
LICENSE = "LGPL"
PR = "r0${TTIF_PR}"

SRCREV = "f6e97ba8e00252d9cde645dfd814245207513248"
SRC_URI = "git://github.com/mrchapp/libgoo.git;protocol=git"
SRC_URI += " ${@base_contains("DISTRO_FEATURES", "ttif", "file://ttif.patch;patch=1", "", d)} "
S = "${WORKDIR}/git"

EXTRA_OECONF = "--enable-ti-camera --enable-ti-clock"

inherit autotools pkgconfig

do_stage() {
	autotools_stage_all
}

