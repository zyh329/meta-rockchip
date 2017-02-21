SUMMARY = "Userspace mali driver for Midgard-T76x"
DESCRIPTION = "Userspace mali driver for Midgard-T76x"
LICENSE = "CLOSED"
SECTION = "libs"

DEPENDS = "libdrm"
DEPENDS += "${@bb.utils.contains("DISTRO_FEATURES", "wayland", " mesa", " ", d)}"

PROVIDES += "virtual/egl virtual/libgles1 virtual/libgles2 virtual/libopencl libgbm"
PROVIDES += "${@bb.utils.contains("DISTRO_FEATURES", "wayland", " virtual/libwayland-egl", " ", d)}"

S = "${WORKDIR}"

SRC_URI = "git://github.com/rockchip-linux/libmali.git;branch=rockchip;"
SRCREV_pn-${PN} = "${AUTOREV}"

INSANE_SKIP_${PN} = "already-stripped ldflags dev-so"

INHIBIT_PACKAGE_DEBUG_SPLIT = "1"
INHIBIT_PACKAGE_STRIP = "1"

USE_X11 = "${@bb.utils.contains("DISTRO_FEATURES", "x11", "yes", "no", d)}"
USE_WL = "${@bb.utils.contains("DISTRO_FEATURES", "wayland", "yes", "no", d)}"

do_configure[noexec] = "1"
do_compile[noexec] = "1"

do_install () {
	# Create MALI manifest
	install -m 755 -d ${D}/${libdir}
	if [ "${USE_X11}" = "yes" ]; then
		install ${S}/x11/libmali.so ${D}/${libdir}
	elif [ "${USE_WL}" = "yes" ]; then
		install ${S}/wayland/libmali.so ${D}/${libdir}
	else
		install ${S}/gbm/libmali.so ${D}/${libdir}
	fi

	ln -sf libmali.so ${D}/${libdir}/libEGL.so
	ln -sf libmali.so ${D}/${libdir}/libEGL.so.1
	ln -sf libmali.so ${D}/${libdir}/libGLESv1_CM.so
	ln -sf libmali.so ${D}/${libdir}/libGLESv1_CM.so.1
	ln -sf libmali.so ${D}/${libdir}/libGLESv2.so
	ln -sf libmali.so ${D}/${libdir}/libGLESv2.so.2
	ln -sf libmali.so ${D}/${libdir}/libOpenCL.so
	ln -sf libmali.so ${D}/${libdir}/libOpenCL.so.1
	ln -sf libmali.so ${D}/${libdir}/libgbm.so
	ln -sf libmali.so ${D}/${libdir}/libgbm.so.1

	if [ "${USE_WL}" = "yes" ]; then
		ln -sf libmali.so ${D}/${libdir}/libwayland-egl.so
	fi
}

PACKAGES = "${PN}"
FILES_${PN} += "${libdir}/*.so"

RREPLACES_${PN} = "libegl libgles1 libglesv1-cm1 libgles2 libglesv2-2 libgbm"
RPROVIDES_${PN} = "libegl libgles1 libglesv1-cm1 libgles2 libglesv2-2 libgbm"
RCONFLICTS_${PN} = "libegl libgles1 libglesv1-cm1 libgles2 libglesv2-2 libgbm"

# Workaround: libmali.so provided by rk having no SONAME field in it
# so add it to fix rdepends problems
RPROVIDES_${PN} += "libwayland-egl.so libgbm.so libGLESv1_CM.so libGLESv2.so libEGL.so libOpenCL.so"
