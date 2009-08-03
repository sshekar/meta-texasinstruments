DEPENDS = "gstreamer virtual/openmax-il"
PR = "r2"
 
SRC_URI = "git://github.com/roopar/gst-openmax.git;protocol=git"
# From omap branch:
SRCREV = "3ef5da9d5b8617dde74c49610103baac56216a93"
S = "${WORKDIR}/git"
 
inherit autotools
   
EXTRA_OECONF += "--disable-valgrind"
    
do_patch2() {
     echo ${SRCREV} > ${S}/.version
}
       
FILES_${PN} += "${libdir}/gstreamer-0.10/libgstomx.so"
FILES_${PN}-dev += "${libdir}/gstreamer-0.10/libgstomx.*a"
FILES_${PN}-dbg += "${libdir}/gstreamer-0.10/.debug/"
       
addtask patch2 after do_patch before do_compile
