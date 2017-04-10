inherit native deploy

DESCRIPTION = "Rockchip binary tools"

LICENSE = "BINARY"
LIC_FILES_CHKSUM = "file://LICENSE.TXT;md5=564e729dd65db6f65f911ce0cd340cf9"
NO_GENERIC_LICENSE[BINARY] = "LICENSE.TXT"

SRC_URI = "git://github.com/rockchip-linux/rkbin.git"
SRCREV = "7b3142bfc7b43709b2d09ca00faf85b36f8f74a4"
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
