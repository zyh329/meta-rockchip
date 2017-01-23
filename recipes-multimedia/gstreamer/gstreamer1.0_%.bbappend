PV="1.10.2"

SRC_URI = " \
    http://gstreamer.freedesktop.org/src/gstreamer/gstreamer-${PV}.tar.xz \
"
SRC_URI[md5sum] = "0d289e5bcec6353e6540ddb75b7d371b"
SRC_URI[sha256sum] = "150e8e81febac94c161d8141cde78a38038a8f56e8ec549f353da54994278d65"

S = "${WORKDIR}/gstreamer-${PV}"
