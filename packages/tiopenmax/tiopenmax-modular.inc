# toplevel file should set a variable like:
# 
# COMPONENT_PATH = "video/src/openmax_il/camera"
# SRC_URI = ...

require tiopenmax.inc

CCASE_PATHFETCH = "\
	/vobs/wtbu/OMAPSW_MPU/linux/${COMPONENT_PATH} \
	/vobs/wtbu/OMAPSW_MPU/linux/Makefile \
	/vobs/wtbu/OMAPSW_MPU/linux/Master.mk \
	"
CCASE_PATHCOMPONENTS = 3
CCASE_PATHCOMPONENT = "linux"


