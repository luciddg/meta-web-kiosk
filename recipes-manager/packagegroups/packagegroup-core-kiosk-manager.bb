SUMMARY = "package group for kiosk manager recipes"
DESCRIPTION = "Packages used by the kiosk manager images"
LICENSE = "MIT"
PR = "r1"

inherit packagegroup

RDEPENDS_${PN} = "\
    kiosk-manager-scripts \
    ssh-keys-client \
    "
