DESCRIPTION = "Texas Instruments OpenMAX IL Pre-Post Processor."
DEPENDS = "tidspbridge-lib tiopenmax-core tiopenmax-lcml tiopenmax-rmproxy tiopenmax-resourcemanager tiopenmax-clock"
PR = "r0"
COMPONENT_PATH = "video/src/openmax_il/prepost_processor"

require tiopenmax-modular.inc
require tiopenmax-cspec-${PV}.inc

SRC_URI = "\
	file://23.16-prepostprocnocore.patch;patch=1 \
	file://23.16-prepostproctestnocore.patch;patch=1 \
	file://23.11-vppmake.patch;patch=1 \
	${@base_contains("DISTRO_FEATURES", "testpatterns", "", "file://remove-patterns.patch;patch=1", d)} \
	"

