DEFAULTTUNE ?= "cortexa53-32"

require conf/machine/include/arm/arch-armv8.inc

TUNEVALID[cortexa53] = "Enable Cortex-A53 specific processor optimizations"
TUNE_CCARGS .= "${@bb.utils.contains('TUNE_FEATURES', 'cortexa53', ' -mcpu=cortex-a53 ', '',d)}"

TUNEVALID[armv8] = "Enable instructions for ARMv8"
TUNECONFLICTS[armv8] = "armv4 armv5 armv6 armv7 armv7a armv7ve"

TUNE_CCARGS .= \
"-mtune=cortex-a57.cortex-a53"

TUNE_CCARGS_MFPU .= \
"${@' crypto-neon-fp-armv8' if bb.utils.contains('TUNE_FEATURES', [ 'armv8', 'neon', 'cryptov8' ], True, False, d) else \
' neon-fp-armv8' if bb.utils.contains('TUNE_FEATURES', [ 'armv8', 'neon' ], True, False, d) else \
bb.utils.contains('TUNE_FEATURES', [ 'armv8' ], ' fp-armv8', '', d)}"

MACHINEOVERRIDES =. "${@bb.utils.contains('TUNE_FEATURES', 'armv8', 'armv8:', '' ,d)}"

AVAILTUNES += "armv8"
TUNE_FEATURES_tune-armv8 = "armv8"
PACKAGE_EXTRA_ARCHS_tune-armv8 = "armv8"

AVAILTUNES += "armv8-neon"
TUNE_FEATURES_tune-armv8-neon = "${TUNE_FEATURES_tune-armv8} neon"
PACKAGE_EXTRA_ARCHS_tune-armv8-neon = "${PACKAGE_EXTRA_ARCHS_tune-armv8} armv8-neon"

AVAILTUNES += "armv8hf"
TUNE_FEATURES_tune-armv8hf = "${TUNE_FEATURES_tune-armv8} callconvention-hard"
PACKAGE_EXTRA_ARCHS_tune-armv8hf = "armv8hf"

AVAILTUNES += "armv8hf-neon"
TUNE_FEATURES_tune-armv8hf-neon = "${TUNE_FEATURES_tune-armv8hf} neon"
PACKAGE_EXTRA_ARCHS_tune-armv8hf-neon = "${PACKAGE_EXTRA_ARCHS_tune-armv8hf} armv8hf-neon"

# Extra tune selections
AVAILTUNES += "cortexa53-32"
ARMPKGARCH_tune-cortexa53-32 ?= "cortexa53"
TUNE_FEATURES_tune-cortexa53-32 = "${TUNE_FEATURES_tune-armv8-neon} cortexa53"
BASE_LIB_tune-cortexa53-32 = "lib"
TUNE_PKGARCH_tune-cortexa53-32 = "cortexa53-32"
PACKAGE_EXTRA_ARCHS_tune-cortexa53-32 = "${PACKAGE_EXTRA_ARCHS_tune-armv8-neon} cortexa53-32 cortexa53-neon-fp-armv8"

AVAILTUNES += "cortexa53hf-32"
ARMPKGARCH_tune-cortexa53hf-32 ?= "cortexa53"
TUNE_FEATURES_tune-cortexa53hf-32 = "${TUNE_FEATURES_tune-armv8hf-neon} cortexa53"
BASE_LIB_tune-cortexa53hf-32 = "lib"
TUNE_PKGARCH_tune-cortexa53hf-32 = "cortexa53hf-32"
PACKAGE_EXTRA_ARCHS_tune-cortexa53hf-32 = "${PACKAGE_EXTRA_ARCHS_tune-armv8hf-neon} cortexa53hf-32 cortexa53hf-neon-fp-armv8"

AVAILTUNES += "cortexa53-64"
ARMPKGARCH_tune-cortexa53-64 ?= "cortexa53"
TUNE_FEATURES_tune-cortexa53-64 = "${TUNE_FEATURES_tune-aarch64} cortexa53"
BASE_LIB_tune-cortexa53-64 = "lib64"
TUNE_PKGARCH_tune-cortexa53-64 = "cortexa53-64"
PACKAGE_EXTRA_ARCHS_tune-cortexa53-64 = "${PACKAGE_EXTRA_ARCHS_tune-aarch64} cortexa53-64"
