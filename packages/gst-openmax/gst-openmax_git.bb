DEPENDS = "gstreamer virtual/openmax-il"

SRC_URI = "git://github.com/roopar/gst-openmax.git;protocol=git \
	file://common-20090128.tar.gz \
	file://nogstcheck.patch;patch=1 \
	file://colorformatdec.patch;patch=1"
# From omap branch:
SRCREV = "87928514f42ffb1460f29881b21b75955044a87b"
S = "${WORKDIR}/git"

inherit autotools

EXTRA_OECONF += "--disable-valgrind"

do_configure_prepend() {
	mv ${WORKDIR}/common ${S}
}

FILES_${PN} += "${libdir}/gstreamer-0.10/libgstomx.so"
FILES_${PN}-dev += "${libdir}/gstreamer-0.10/libgstomx.*a"
FILES_${PN}-dbg += "${libdir}/gstreamer-0.10/.debug/"
