# Copyright (C) 2017 Fuzhou Rockchip Electronics Co., Ltd
# Released under the MIT license (see COPYING.MIT for the terms)

DESCRIPTION = "Media Process Platform (MPP) module"
LICENSE = "MIT"
LIC_FILES_CHKSUM = "file://${COREBASE}/meta/COPYING.MIT;md5=3da9cfbcb788c80a0384361b4de20420"
SECTION = "multimedia"
DEPENDS = "libdrm"

SRCBRANCH ?= "rk3288_linux"
SRCREV = "${AUTOREV}"
SRC_URI = "git://github.com/rockchip-linux/mpp.git;branch=${SRCBRANCH}"

S = "${WORKDIR}/git"

inherit pkgconfig cmake

EXTRA_OECMAKE += " \
	-DRKPLATFORM=ON \
	-DHAVE_DRM=ON \
	-DENABLE_H264D=ON \
	-DENABLE_H265D=ON \
"
