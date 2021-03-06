SECTION = "kernel"
DESCRIPTION = "Linux kernel for TI OMAP devices"
LICENSE = "GPL"

KERNEL_OUTPUT = "arch/${ARCH}/boot/compressed/${KERNEL_IMAGETYPE}"

inherit kernel

COMPATIBLE_MACHINE = "omap-3430ldp|omap-3430sdp|zoom2"

ADD_DISTRO_FEATURES = "	${@base_contains("DISTRO_FEATURES", "720p", "sed -i 's/# CONFIG_FB_OMAP_720P_STREAMING is not set/CONFIG_FB_OMAP_720P_STREAMING=y/' ${S}/.config;", "", d)}"

do_configure_prepend() {

	if [ -f '${WORKDIR}/defconfig-${MACHINE}' ]; then
		rm -f ${S}/.config || true

		if [ "${TARGET_OS}" = "linux-gnueabi" -o  "${TARGET_OS}" = "linux-uclibcgnueabi" ]; then
			echo "CONFIG_AEABI=y"                   >> ${S}/.config
			echo "CONFIG_OABI_COMPAT=y"             >> ${S}/.config
		else
			echo "# CONFIG_AEABI is not set"        >> ${S}/.config
			echo "# CONFIG_OABI_COMPAT is not set"  >> ${S}/.config
		fi

		sed     -e '/CONFIG_AEABI/d' \
			-e '/CONFIG_OABI_COMPAT=/d' \
			'${WORKDIR}/defconfig-${MACHINE}' >>'${S}/.config'

		yes '' | oe_runmake oldconfig
	else
		case ${MACHINE} in
			omap-3430ldp)
				yes '' | oe_runmake omap_3430ldp_defconfig
				sed -i "s/# CONFIG_FB_OMAP_LCD_VGA is not set/CONFIG_FB_OMAP_LCD_VGA=y/" \
					${S}/.config
				;;
			omap-3430sdp)
				yes '' | oe_runmake omap_3430sdp_defconfig
#				sed -i "s/# CONFIG_FB_OMAP_LCD_VGA is not set/CONFIG_FB_OMAP_LCD_VGA=y/" \
#					${S}/.config
				;;
			zoom2)
				yes '' | oe_runmake omap_zoom2_defconfig
				;;				
			*)
				yes '' | oe_runmake ${MACHINE}_defconfig
				;;
		esac
	fi

	# enable oprofile.. possibly, this should be controlled by a distro-feature??
	sed -i "s/# CONFIG_PROFILING is not set/CONFIG_PROFILING=y\nCONFIG_OPROFILE=y\nCONFIG_OPROFILE_ARMV7=y/" ${S}/.config

	${ADD_DISTRO_FEATURES}
}

do_deploy() {
	install -d ${DEPLOY_DIR_IMAGE}
	install -m 0644 arch/${ARCH}/boot/${KERNEL_IMAGETYPE} ${DEPLOY_DIR_IMAGE}/${KERNEL_IMAGETYPE}-${PV}-${MACHINE}-${DATETIME}.bin
	cd ${DEPLOY_DIR_IMAGE}
	ln -sf ${KERNEL_IMAGETYPE}-${PV}-${MACHINE}-${DATETIME}.bin ${KERNEL_IMAGETYPE}-${MACHINE}.bin
	tar -cvzf ${DEPLOY_DIR_IMAGE}/modules-${KERNEL_RELEASE}-${MACHINE}.tgz -C ${D} lib
}

do_deploy[dirs] = "${S}"

addtask deploy before do_populate_staging after do_install

do_stage_append() {

    for ii in arch/arm/mach-omap2 \
              drivers/media/video/isp
    do
        install -d ${STAGING_KERNEL_DIR}/$ii
        install -m 0644 ${S}/$ii/*.h ${STAGING_KERNEL_DIR}/$ii
    done

}

