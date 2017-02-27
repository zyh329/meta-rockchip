require mali-userspace.inc

TYPE = "midgard-4th"
SW_VER = "r9p0"

LIB_PATH = "aarch64-linux-gnu"

MALI_X11 = "libmali-${TYPE}-${SW_VER}.so"
MALI_WAYLAND = "libmali-${TYPE}-${SW_VER}-wayland.so"

do_install_prepend () {

	mkdir -p x11
	cp git/lib/${LIB_PATH}/${MALI_X11} x11/libmali.so

}
