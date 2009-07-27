DEPENDS = "tidspbridge-lib tiopenmax-core"
DESCRIPTION = "Texas Instruments OpenMAX IL's Resource Activity Monitor."
PR = "r0"
COMPONENT_PATH = "system/src/openmax_il/resource_manager/resource_activity_monitor"

require tiopenmax-modular.inc
require tiopenmax-cspec-${PV}.inc

OMX_COMPILE_TARGET = "resource_activity_monitor"
OMX_INSTALL_TARGET = "resource_activity_monitor.install"
OMX_BUILD_DIR = ""

SRC_URI = "file://23.11-mknocore.patch;patch=1"

