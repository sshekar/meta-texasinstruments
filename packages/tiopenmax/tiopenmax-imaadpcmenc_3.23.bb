DESCRIPTION = "Texas Instruments OpenMAX IL imaPCM Encoder."
DEPENDS = "tidspbridge-lib tiopenmax-core tiopenmax-lcml tiopenmax-rmproxy tiopenmax-resourcemanager tiopenmax-audiomanager tiopenmax-perf"
PR = "r0"
COMPONENT_PATH = "audio/src/openmax_il/imaadpcm_enc"

require tiopenmax-modular.inc
require tiopenmax-cspec-${PV}.inc

SRC_URI = "\
	file://23.14-imaadpcmencnocore.patch;patch=1 \
	file://23.14-imaadpcmenctestnocore.patch;patch=1 \
	file://23.14-imaadpcmencmkfile.patch;patch=1 \	
	file://23.14-imaadpcmencmktest.patch;patch=1 \
	file://23.14-imaadpcmencmsttest.patch;patch=1 \
	${@base_contains("DISTRO_FEATURES", "testpatterns", "", "file://remove-patterns.patch;patch=1", d)} \
	"

