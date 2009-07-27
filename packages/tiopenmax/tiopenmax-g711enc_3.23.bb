DESCRIPTION = "Texas Instruments OpenMAX IL G711 Encoder."
DEPENDS = "tidspbridge-lib tiopenmax-core tiopenmax-lcml tiopenmax-rmproxy tiopenmax-resourcemanager tiopenmax-audiomanager tiopenmax-perf"
PR = "r0"
COMPONENT_PATH = "audio/src/openmax_il/g711_enc"

require tiopenmax-modular.inc
require tiopenmax-cspec-${PV}.inc

SRC_URI = "\
	file://23.13-g711encnocore.patch;patch=1 \
	file://23.13-g711encnoincinstall.patch;patch=1 \
	${@base_contains("DISTRO_FEATURES", "testpatterns", "", "file://remove-patterns.patch;patch=1", d)} \
	"

