require mali-userspace.inc

TYPE = "midgard"
SW_VER = "r13p0"
HW_VER = "r0p0"

LIB_PATH = "arm-linux-gnueabihf"

MALI_X11 = "libmali-${TYPE}-${SW_VER}-${HW_VER}.so"
MALI_WAYLAND = "libmali-${TYPE}-${SW_VER}-${HW_VER}-wayland.so"
MALI_GBM = "libmali-${TYPE}-${SW_VER}-${HW_VER}-gbm.so"

do_install_prepend () {
	mkdir -p x11
	cp git/lib/${LIB_PATH}/${MALI_X11} x11/libmali.so

	mkdir -p wayland
	cp git/lib/${LIB_PATH}/${MALI_WAYLAND}  wayland/libmali.so

	mkdir -p gbm
	cp git/lib/${LIB_PATH}/${MALI_GBM}  gbm/libmali.so
}
