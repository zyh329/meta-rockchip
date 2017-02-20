# Copyright (C) 2017 Fuzhou Rockchip Electronics Co., Ltd
# Released under the MIT license (see COPYING.MIT for the terms)

PACKAGECONFIG_GL   = "gles2"

PACKAGECONFIG_APPEND = "${@bb.utils.contains('DISTRO_FEATURES', 'x11', ' ', \
								bb.utils.contains('DISTRO_FEATURES', 'wayland',	\
									' ', 'eglfs', d), d)}"

PACKAGECONFIG_append = " ${PACKAGECONFIG_APPEND} kms"
