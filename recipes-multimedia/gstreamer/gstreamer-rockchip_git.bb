DESCRIPTION = "GStreamer 1.0 plugins for Rockchip platforms"
LICENSE = "GPLv2"
LIC_FILES_CHKSUM = "file://COPYING;md5=6d1e4aa87f6192354d3de840cf774d93"
SECTION = "multimedia"
DEPENDS = "gstreamer1.0 gstreamer1.0-plugins-base mpp virtual/kernel virtual/egl \
           virtual/libgles2 ${@bb.utils.contains('DISTRO_FEATURES', 'x11', 'virtual/libx11', '', d)}"

SRCBRANCH ?= "master"
SRCREV = "${AUTOREV}"
SRC_URI = "git://github.com/rockchip-linux/gstreamer-rockchip.git;branch=${SRCBRANCH}"
SRC_URI_append = " file://0001-yocto-remove-10bit-support.patch"

S = "${WORKDIR}/git"

inherit gettext autotools pkgconfig

# LIBV is used by gst-plugins-package.inc to specify the GStreamer version (0.10 vs 1.0)
LIBV = "1.0"
require recipes-multimedia/gstreamer/gst-plugins-package.inc

# the following line is required to produce one package for each plugin
PACKAGES_DYNAMIC = "^${PN}-.*"

do_configure() {
    NOCONFIGURE=true ${S}/autogen.sh
    oe_runconf
}
