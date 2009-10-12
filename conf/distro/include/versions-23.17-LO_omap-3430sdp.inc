# omap3430 SDP specific versions

# baseport
PREFERRED_VERSION_x-load =             "4.62"
PREFERRED_VERSION_u-boot =             "5.10"
SRCREV_pn-linux-tiomap ?= "02b2ce47a93e32f3b4e26662d78a0f31a6ac37ab"

# bridge and friends
PREFERRED_VERSION_tidspbridge-lib =    "23.17-P3"
PREFERRED_PROVIDER_virtual/dspbridge-driver = "linux-tiomap"

