FILESEXTRAPATHS_prepend := "${THISDIR}/${PN}:"
FILESPATH_prepend := "${THISDIR}/${PN}:"

SELECTED_OPTIMIZATION := "${@d.getVar("SELECTED_OPTIMIZATION", True).replace("-O2", "-O0")}"
