DEPENDS = "tidspbridge-lib"
DESCRIPTION = "Texas Instruments PERF instrumentation for OpenMAX IL."
PR = "r0"
COMPONENT_PATH = "system/src/openmax_il/perf"

require tiopenmax-modular.inc
require tiopenmax-cspec-${PV}.inc

OMX_COMPILE_TARGET = "perf"
OMX_INSTALL_TARGET = "perf.install"
OMX_BUILD_DIR = ""

