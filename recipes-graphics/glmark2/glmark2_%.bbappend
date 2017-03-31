FILESEXTRAPATHS_prepend := "${THISDIR}/${PN}:"

SRC_URI += " \
	file://0001-Use-eglGetPlatformDisplayEXT-for-ARM-Mali-Midgard-DR.patch \
"

PACKAGECONFIG = "${@bb.utils.contains('DISTRO_FEATURES', 'x11', 'x11-gles2', '', d)} \
                 ${@bb.utils.contains('DISTRO_FEATURES', 'wayland', 'wayland-gles2', '', d)} \
                 drm-gles2"
