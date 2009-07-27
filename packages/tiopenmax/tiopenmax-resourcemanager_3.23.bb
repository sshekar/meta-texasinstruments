DESCRIPTION = "Texas Instruments OpenMAX IL Resource Manager."
DEPENDS = "tidspbridge-lib tiopenmax-core tiopenmax-ram tiopenmax-policymanager"
PR = "r1"
COMPONENT_PATH = "system/src/openmax_il/resource_manager"

require tiopenmax-modular.inc
require tiopenmax-cspec-${PV}.inc

SRC_URI = "\
	file://23.10-rmmakenocore.patch;patch=1 \
	file://23.10-rmmakenoram.patch;patch=1 \
	"

