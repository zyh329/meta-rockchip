FILESEXTRAPATHS_prepend := "${THISDIR}/${PN}:"
FILESPATH_prepend := "${THISDIR}/${PN}:"

SRC_URI_append = " \
                 file://0001-video-Add-VYUY-pixel-format.patch \
                 file://0002-WIP-video-Add-P010_10LEC-pixel-format.patch \
"

SELECTED_OPTIMIZATION := "${@d.getVar("SELECTED_OPTIMIZATION", True).replace("-O2", "-O0")}"
