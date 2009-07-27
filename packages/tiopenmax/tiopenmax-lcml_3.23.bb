DEPENDS = "tidspbridge-lib tiopenmax-core"
DESCRIPTION = "Texas Instruments Linux Common Media Library for OpenMAX IL."
PR = "r0"
COMPONENT_PATH = "system/src/openmax_il/lcml"

require tiopenmax-modular.inc
require tiopenmax-cspec-${PV}.inc

OMX_COMPILE_TARGET = "lcml"
OMX_INSTALL_TARGET = "lcml.install"
OMX_BUILD_DIR = ""

SRC_URI = "file://23.11-lcmlnocore.patch;patch=1"

