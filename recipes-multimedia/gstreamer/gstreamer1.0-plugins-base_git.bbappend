FILESEXTRAPATHS_prepend := "${THISDIR}/${PN}:"
FILESPATH_prepend := "${THISDIR}/${PN}:"

SRC_URI_append = " \
                 file://0003-WIP-video-Add-P010_10LEC-pixel-format.patch \
"

EXTRA_OEMAKE = " \
	ERROR_CFLAGS="" \
"

SELECTED_OPTIMIZATION := "${@d.getVar("SELECTED_OPTIMIZATION", True).replace("-O2", "-O0")}"
