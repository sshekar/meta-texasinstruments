DEPENDS = "tidspbridge-lib tiopenmax-core"
DESCRIPTION = "Texas Instruments OpenMAX IL Resource Manager Proxy."
PR = "r1"
COMPONENT_PATH = "system/src/openmax_il/resource_manager_proxy"

require tiopenmax-modular.inc
require tiopenmax-cspec-${PV}.inc

OMX_COMPILE_TARGET = "resource_manager_proxy"
OMX_INSTALL_TARGET = "resource_manager_proxy.install"
OMX_BUILD_DIR = ""

