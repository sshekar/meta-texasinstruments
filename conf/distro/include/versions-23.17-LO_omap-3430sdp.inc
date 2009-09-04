# omap3430 SDP specific versions

# baseport
PREFERRED_VERSION_x-load =             "4.62"
PREFERRED_VERSION_u-boot =             "5.10"
SRCREV_pn-linux-tiomap ?= "f1cc27d4e30cc7e33dfb50b52dbe1e844218c4dc"

# bridge and friends
PREFERRED_VERSION_tidspbridge-lib =    "23.17-P3"
PREFERRED_PROVIDER_virtual/dspbridge-driver = "linux-tiomap"

