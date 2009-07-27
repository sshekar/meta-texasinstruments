DEPENDS = "tidspbridge-lib tiopenmax-core"
DESCRIPTION = "Texas Instruments OpenMAX IL Audio Manager."
PR = "r0"
COMPONENT_PATH = "system/src/openmax_il/audio_manager"

require tiopenmax-modular.inc
require tiopenmax-cspec-${PV}.inc

OMX_COMPILE_TARGET = "audio_manager"
OMX_INSTALL_TARGET = "audio_manager.install"
OMX_BUILD_DIR = ""

SRC_URI = "file://23.11-ampthread.patch;patch=1 \
	${@base_contains("DISTRO_FEATURES", "testpatterns", "", "file://remove-patterns.patch;patch=1", d)} \
	"

