DEPENDS = "tidspbridge-lib tiopenmax-core"
DESCRIPTION = "Texas Instruments OpenMAX IL Clock."
PR = "r0"
COMPONENT_PATH = "system/src/openmax_il/clock_source"

require tiopenmax-modular.inc
require tiopenmax-cspec-${PV}.inc

OMX_COMPILE_TARGET = "clock"
OMX_INSTALL_TARGET = "clock.install"
OMX_BUILD_DIR = ""

SRC_URI = "file://23.11-clocknocore.patch;patch=1"

