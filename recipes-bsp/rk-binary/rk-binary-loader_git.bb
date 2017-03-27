DESCRIPTION = "Rockchip binary loader"

LICENSE = "BINARY"
LIC_FILES_CHKSUM = "file://LICENSE.TXT;md5=564e729dd65db6f65f911ce0cd340cf9"
NO_GENERIC_LICENSE[BINARY] = "LICENSE.TXT"

DEPENDS = "rk-binary-native"

SRCREV = "${AUTOREV}"
SRC_URI = "git://github.com/rockchip-linux/rkbin.git"
S = "${WORKDIR}/git"

LOADER_rk3036 ?= "rk30/RK3036MiniLoaderAll_V2.19.bin"
LOADER_rk3288 ?= "rk32/RK3288UbootLoader_V2.30.06.bin"
LOADER_rk3399 ?= "rk33/RK3399MiniLoaderAll_V1.05.bin"

inherit deploy

LOADER_BIN   = "loader.bin"
UBOOT_IMG   = "uboot.img"
TRUST_IMG   = "trust.img"

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
