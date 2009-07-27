# toplevel file should set a variable like:
# 
# COMPONENT_PATH = "video/src/openmax_il/camera"
# SRC_URI = ...

PACKAGES = "${PN}-dbg ${PN}-patterns ${PN}-dev ${PN}"

CCASE_PATHFETCH = "\
	/vobs/wtbu/OMAPSW_MPU/linux/${COMPONENT_PATH} \
	/vobs/wtbu/OMAPSW_MPU/linux/Makefile \
	/vobs/wtbu/OMAPSW_MPU/linux/Master.mk \
	"
CCASE_PATHCOMPONENTS = 3
CCASE_PATHCOMPONENT = "linux"

inherit ccasefetch

OMX_COMPILE_TARGET ?= "all"
OMX_INSTALL_TARGET ?= "install"
OMX_BUILD_DIR ?= "${COMPONENT_PATH}"

do_compile_prepend() {
	install -d ${D}/usr/omx/patterns
	install -d ${D}/usr/lib
	install -d ${D}/usr/bin
}

do_compile() {
	cd ${S}/${OMX_BUILD_DIR}
	oe_runmake \
		PREFIX=${D}/usr PKGDIR=${S} \
		CROSS=${AR%-*}- \	
		BRIDGEINCLUDEDIR=${STAGING_INCDIR}/dspbridge BRIDGELIBDIR=${STAGING_LIBDIR} \
		TARGETDIR=${D}/usr OMXTESTDIR=${D}${bindir} OMXROOT=${S} OMXLIBDIR=${STAGING_LIBDIR} \
		OMX_PERF_INSTRUMENTATION=1 OMX_PERF_CUSTOMIZABLE=1 \
		OMXINCLUDEDIR=${STAGING_INCDIR}/omx \
		INST2=1 \
		${OMX_COMPILE_TARGET}
}

do_install() {
	cd ${S}/${OMX_BUILD_DIR}
	oe_runmake \
		PREFIX=${D}/usr PKGDIR=${S} \
		CROSS=${AR%-*}- \
		BRIDGEINCLUDEDIR=${STAGING_INCDIR}/dspbridge BRIDGELIBDIR=${STAGING_LIBDIR} \
		TARGETDIR=${D}/usr OMXTESTDIR=${D}${bindir} OMXROOT=${S} \
		OMX_PERF_INSTRUMENTATION=1 OMX_PERF_CUSTOMIZABLE=1 \
		SYSTEMINCLUDEDIR=${D}/usr/include/omx \
		INST2=1 \
		${OMX_INSTALL_TARGET}
}

do_stage() {
	cd ${S}/${OMX_BUILD_DIR}
	oe_runmake \
		PREFIX=${STAGING_DIR_TARGET}/usr PKGDIR=${S} \
		CROSS=${AR%-*}- \
		BRIDGEINCLUDEDIR=${STAGING_INCDIR}/dspbridge BRIDGELIBDIR=${STAGING_LIBDIR} \
		TARGETDIR=${STAGING_DIR_TARGET}/usr OMXTESTDIR=${STAGING_BINDIR} OMXROOT=${S} \
		OMX_PERF_INSTRUMENTATION=1 OMX_PERF_CUSTOMIZABLE=1 \
		SYSTEMINCLUDEDIR=${STAGING_INCDIR}/omx \
		INST2=1 \
		${OMX_INSTALL_TARGET}
}

FILES_${PN} = "\
	/usr/lib \
	/usr/bin \
	"

FILES_${PN}-patterns = "\
	/usr/omx/patterns \
	"

FILES_${PN}-dbg = "\
	/usr/bin/.debug \
	/usr/lib/.debug \
	"

FILES_${PN}-dev = "\
	/usr/include \
	"

do_stage_rm_omxdir() {
	# Clean up undesired staging only if test patterns exist
	${@base_contains("DISTRO_FEATURES", "testpatterns", "rm -rf ${STAGING_DIR_TARGET}/usr/omx/", "echo nothing to do here!", d)}
}

addtask stage_rm_omxdir after do_populate_staging before do_package_stage
