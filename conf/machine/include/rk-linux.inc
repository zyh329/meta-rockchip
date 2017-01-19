# Rockchip BSP default settings

PREFERRED_PROVIDER_virtual/egl = "mali-userspace"
PREFERRED_PROVIDER_virtual/libgles1 = "mali-userspace"
PREFERRED_PROVIDER_virtual/libgles2 = "mali-userspace"
PREFERRED_PROVIDER_virtual/libopencl = "mali-userspace"

# Workaround: libmali.so provided by rk having no SONAME field in it
# so add it to fix rdepends problems
ASSUME_SHLIBS += "libEGL.so:mali-userspace"
ASSUME_SHLIBS += "libGLESv1_CM.so:mali-userspace"
ASSUME_SHLIBS += "libGLESv2.so:mali-userspace"
ASSUME_SHLIBS += "libOpenCL.so:mali-userspace"
ASSUME_SHLIBS += "libgbm.so:mali-userspace"
ASSUME_SHLIBS += "libwayland-egl.so:mali-userspace"

PREFERRED_PROVIDER_virtual/kernel = "linux-rockchip"
PREFERRED_PROVIDER_virtual/bootloader = "u-boot-rockchip"

IMAGE_CLASSES += "rockchip-next-image"
