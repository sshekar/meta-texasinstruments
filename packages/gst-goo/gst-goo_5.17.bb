SECTION = "libs"
PRIORITY = "optional"
DEPENDS = "glib-2.0 libgoo gst-plugins-base"
DESCRIPTION = "GStreamer plug-ins for OpenMAX IL based on LibGoo"
LICENSE = "LGPL"
PR = "r0"

SRCREV = "cd5dd2c3435a35735ccca65ec1abbe550c3fd27c"
SRC_URI = "git://github.com/mrchapp/gst-goo.git;protocol=git;branch=experimental"
S = "${WORKDIR}/git"

# reduce goo element priority so as to not conflict with v4l2sink, alsasink, and gst-openmax elements:
SRC_URI += "file://reduce-gooelement-priority.patch;patch=1"

inherit autotools pkgconfig

FILES_${PN} += "${libdir}/gstreamer-0.10/libgstgoo.so"
FILES_${PN}-dev += "${libdir}/gstreamer-0.10/libgstgoo.*a"
FILES_${PN}-dbg += "${libdir}/gstreamer-0.10/.debug/"

do_stage() {
	autotools_stage_all
}
