inherit native deploy

DESCRIPTION = "Rockchip binary tools"

LICENSE = "BINARY"
LIC_FILES_CHKSUM = "file://LICENSE.TXT;md5=564e729dd65db6f65f911ce0cd340cf9"
NO_GENERIC_LICENSE[BINARY] = "LICENSE.TXT"

SRCREV = "${AUTOREV}"
SRC_URI = "git://github.com/rockchip-linux/rkbin.git"
S = "${WORKDIR}/git"

do_install () {
	install -m 0755 "${S}/tools/trust_merger" ${bindir}
	install -m 0755 "${S}/tools/firmwareMerger" ${bindir}

	install -m 0755 "${S}/tools/kernelimage" ${bindir}
	install -m 0755 "${S}/tools/loaderimage" ${bindir}

	install -m 0755 "${S}/tools/mkkrnlimg" ${bindir}
	install -m 0755 "${S}/tools/resource_tool" ${bindir}

	install -m 0755 "${S}/tools/upgrade_tool" ${bindir}
}
