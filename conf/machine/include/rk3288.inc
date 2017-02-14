# Copyright (C) 2015 Romain Perier
# Released under the MIT license (see COPYING.MIT for the terms)

SOC_FAMILY  = "rk3288"

require conf/machine/include/tune-cortexa17.inc
require conf/machine/include/soc-family.inc

DEFAULTTUNE="cortexa17hf-neon-vfpv4"
PREFERRED_PROVIDER_virtual/kernel = "linux"
SERIAL_CONSOLES = "115200;ttyS2"
SPL_BINARY = "u-boot-spl-dtb.bin"
KERNEL_IMAGETYPE = "zImage"
KBUILD_DEFCONFIG = "multi_v7_defconfig"

PREFERRED_VERSION_mali-userspace = "t76x"

APPEND = "console=tty1 console=ttyS2,115200n8 rw root=/dev/mmcblk2p7 rootfstype=ext4 init=/sbin/init"
