DESCRIPTION = "Midori X session files for poky"
HOMEPAGE = "http://www.yoctoproject.org"
BUGTRACKER = "http://bugzilla.pokylinux.org"

PR = "r4"

LICENSE = "GPLv2"
LIC_FILES_CHKSUM = "file://midori-session;endline=5;md5=8a71b7d46689f813bdaad08fe4293361   \
                    file://config;endline=5;md5=af9f64a7fada0e62a23995d7ea534a71    \
                    "

SECTION = "x11"
RCONFLICTS_${PN} = "matchbox-common"

SRC_URI = "file://midori-session file://config"
S = "${WORKDIR}"

inherit update-alternatives

BROWSER="midori"
USER="root"

ALTERNATIVE_${PN} = "x-session-manager"
ALTERNATIVE_TARGET[x-session-manager] = "${bindir}/midori-session"
ALTERNATIVE_PRIORITY = "50"

do_install() {
        install -d ${D}/${bindir}
        install -m 0755 ${S}/midori-session ${D}/${bindir}
        # Uncomment the following lines if the network has proxy
        # configurations
        install -d ${D}/home/${USER}/.config/${BROWSER}/
        install ${S}/config ${D}/home/${USER}/.config/${BROWSER}/
}

FILES_${PN} += "/home/${USER}/.config/${BROWSER}/config"
