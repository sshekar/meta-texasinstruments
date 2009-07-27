DESCRIPTION = "Texas Instruments OpenMAX IL Post Processor."
DEPENDS = "tidspbridge-lib tiopenmax-core tiopenmax-lcml tiopenmax-rmproxy tiopenmax-resourcemanager tiopenmax-clock"
PR = "r1"
COMPONENT_PATH = "video/src/openmax_il/post_processor"

require tiopenmax-modular.inc
require tiopenmax-cspec-${PV}.inc

SRC_URI = "\
	file://23.13-postprocnocore.patch;patch=1 \
	file://23.13-postproctestnocore.patch;patch=1 \
	${@base_contains("DISTRO_FEATURES", "testpatterns", "", "file://remove-patterns.patch;patch=1", d)} \
	"

