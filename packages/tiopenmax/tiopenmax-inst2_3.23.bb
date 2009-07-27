DESCRIPTION = "Texas Instruments OpenMAX IL INST2 Utility"
DEPENDS = "tidspbridge-lib tiopenmax-core"
PR = "r0"
COMPONENT_PATH = "utilities/src/inst2"

require tiopenmax-modular.inc
#require tiopenmax-cspec-${PV}.inc
#hack for fetching INST2 code from ClearCase. linux/utilities folder is not labeled with LINUX-MMROOT_RLS_* label. This needs to be solved by DU's

CCASE_SPEC = "\
	${@base_contains("DISTRO_FEATURES", "testpatterns", "", "element patterns /main/0", d)}%\
	# OMX INST2 utilities%\
        element /vobs/wtbu/OMAPSW_MPU/linux/utilities/src/inst2/... LINUX-MMUTILS_RLS_3.02.03%\
	# ROOT folder & Make files%\
	element /vobs/wtbu/OMAPSW_MPU/linux/... LINUX-MMROOT_RLS_3.20%\
	element * /main/LATEST%\
	"

FILES_${PN} = "\
	/usr/inst2 \
	"

FILES_${PN}-dbg = "\
	/usr/inst2/.debug \
	"

