DESCRIPTION = "Rockchip binary loader"

LICENSE = "BINARY"
LIC_FILES_CHKSUM = "file://LICENSE.TXT;md5=564e729dd65db6f65f911ce0cd340cf9"
NO_GENERIC_LICENSE[BINARY] = "LICENSE.TXT"

DEPENDS = "rk-binary-native"

SRC_URI = "git://github.com/rockchip-linux/rkbin.git"
SRCREV = "7b3142bfc7b43709b2d09ca00faf85b36f8f74a4"
S = "${WORKDIR}/git"

LOADER_rk3036 ?= "rk30/rk3036_loader_v1.07.219.bin"
LOADER_rk3288 ?= "rk32/rk3288_ubootloader_v1.01.06.bin"
LOADER_rk3399 ?= "rk33/rk3399_loader_v1.08.106.bin"

inherit deploy

LOADER_BIN	= "loader.bin"
UBOOT_IMG	= "uboot.img"
TRUST_IMG	= "trust.img"

do_deploy() {
	install -d ${DEPLOYDIR}
	install "${S}/${LOADER}" ${DEPLOYDIR}/${LOADER_BIN}
}

do_deploy_append_rk3399() {
	install -d ${DEPLOYDIR}
	install "${S}/img/rk3399/${UBOOT_IMG}" ${DEPLOYDIR}/${UBOOT_IMG}
	install "${S}/img/rk3399/${TRUST_IMG}" ${DEPLOYDIR}/${TRUST_IMG}
}

addtask deploy before do_build after do_compile

do_package[noexec] = "1"
do_packagedata[noexec] = "1"
do_package_write[noexec] = "1"
do_package_write_ipk[noexec] = "1"
do_package_write_rpm[noexec] = "1"
do_package_write_deb[noexec] = "1"
do_package_write_tar[noexec] = "1"
