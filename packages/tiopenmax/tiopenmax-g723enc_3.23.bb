DESCRIPTION = "Texas Instruments OpenMAX IL g723 Encoder."
DEPENDS = "tidspbridge-lib tiopenmax-core tiopenmax-lcml tiopenmax-rmproxy tiopenmax-resourcemanager tiopenmax-audiomanager"
PR = "r0"
COMPONENT_PATH = "audio/src/openmax_il/g723_enc"

require tiopenmax-modular.inc
require tiopenmax-cspec-${PV}.inc

SRC_URI = "\
	file://23.14-g723encnocore.patch;patch=1 \
	file://23.14-g723encnoincinstall.patch;patch=1 \
	${@base_contains("DISTRO_FEATURES", "testpatterns", "", "file://remove-patterns.patch;patch=1", d)} \
	"

