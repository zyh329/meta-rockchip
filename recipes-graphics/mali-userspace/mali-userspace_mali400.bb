require mali-userspace.inc

TYPE = "utgard"
SW_VER = "r6p0"

LIB_PATH = "arm-linux-gnueabihf"

MALI_X11 = "libmali-${TYPE}-${SW_VER}.so"

do_install_prepend () {

	mkdir -p x11
	cp git/lib/${LIB_PATH}/${MALI_X11} x11/libmali.so

}
