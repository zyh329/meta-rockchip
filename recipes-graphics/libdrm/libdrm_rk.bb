# Copyright (C) 2017 Fuzhou Rockchip Electronics Co., Ltd
# Released under the MIT license (see COPYING.MIT for the terms)

SECTION = "x11/base"
LICENSE = "MIT"
LIC_FILES_CHKSUM = "file://${COREBASE}/meta/COPYING.MIT;md5=3da9cfbcb788c80a0384361b4de20420"
PROVIDES = "drm"
DEPENDS = "libpthread-stubs libpciaccess"

FILESEXTRAPATHS_prepend := "${THISDIR}/${PN}:"
FILESPATH_prepend := "${THISDIR}/${PN}:"

SRCREV = "${AUTOREV}"
SRCBRANCH ?= "rockchip-2.4.74"
SRC_URI = " \
 git://github.com/rockchip-linux/libdrm-rockchip.git;branch=${SRCBRANCH} \
"

S = "${WORKDIR}/git"

inherit autotools pkgconfig manpages

EXTRA_OECONF += "--disable-cairo-tests \
                 --enable-omap-experimental-api \
                 --enable-etnaviv-experimental-api \
                 --enable-install-test-programs \
                 --disable-valgrind \
                 --enable-rockchip-experimental-api \
                "
PACKAGECONFIG[manpages] = "--enable-manpages, --disable-manpages, libxslt-native xmlto-native"

ALLOW_EMPTY_${PN}-drivers = "1"
PACKAGES =+ "${PN}-tests ${PN}-drivers ${PN}-radeon ${PN}-nouveau ${PN}-omap \
             ${PN}-intel ${PN}-exynos ${PN}-kms ${PN}-freedreno ${PN}-amdgpu \
             ${PN}-rockchip ${PN}-etnaviv"

RRECOMMENDS_${PN}-drivers = "${PN}-radeon ${PN}-nouveau ${PN}-omap ${PN}-intel \
                             ${PN}-exynos ${PN}-freedreno ${PN}-amdgpu \
                             ${PN}-etnaviv ${PN}-rockchip"

FILES_${PN}-tests = "${bindir}/*"
FILES_${PN}-radeon = "${libdir}/libdrm_radeon.so.*"
FILES_${PN}-nouveau = "${libdir}/libdrm_nouveau.so.*"
FILES_${PN}-omap = "${libdir}/libdrm_omap.so.*"
FILES_${PN}-intel = "${libdir}/libdrm_intel.so.*"
FILES_${PN}-exynos = "${libdir}/libdrm_exynos.so.*"
FILES_${PN}-kms = "${libdir}/libkms*.so.*"
FILES_${PN}-freedreno = "${libdir}/libdrm_freedreno.so.*"
FILES_${PN}-amdgpu = "${libdir}/libdrm_amdgpu.so.*"
FILES_${PN}-etnaviv = "${libdir}/libdrm_etnaviv.so.*"
FILES_${PN}-rockchip = "${libdir}/libdrm_rockchip.so.*"
