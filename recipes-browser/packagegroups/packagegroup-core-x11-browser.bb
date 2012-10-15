SUMMARY = "Basic X11 session with Midori Browser"
DESCRIPTION = "Packages required to set up a basic working X11 session that incorporates the Midori Browser"
LICENSE = "MIT"
PR = "r1"

inherit packagegroup

# For backwards compatibility after rename
RPROVIDES_${PN} = "task-core-x11-mini task-core-x11-browser"
RREPLACES_${PN} = "task-core-x11-mini task-core-x11-browser"
RCONFLICTS_${PN} = "task-core-x11-mini task-core-x11-browser"

RDEPENDS_${PN} = "\
    packagegroup-core-x11-xserver \
    packagegroup-core-x11-utils \
    dbus \
    pointercal \
    matchbox-wm \
    matchbox-keyboard   \
    matchbox-keyboard-im    \
    midori-session  \
    liberation-fonts \
    midori  \
    connman \
    "
