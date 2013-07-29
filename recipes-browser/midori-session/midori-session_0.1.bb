DESCRIPTION = "Midori X session files for poky"
HOMEPAGE = "http://www.yoctoproject.org"
BUGTRACKER = "http://bugzilla.pokylinux.org"

PR = "r4"

LICENSE = "GPLv2"
LIC_FILES_CHKSUM = "file://midori-session;endline=5;md5=6b723371204b61cd4b9c0679ecfdc1ea   \
                    "

SECTION = "x11"
RCONFLICTS_${PN} = "matchbox-common"

SRC_URI = "file://midori-session \
           file://auto_restart_with_new_config.sh \
           file://change_midori_url.sh \
           file://config \
          "
S = "${WORKDIR}"

inherit update-alternatives

BROWSER="midori"
USER="root"

ALTERNATIVE_${PN} = "x-session-manager"
ALTERNATIVE_TARGET[x-session-manager] = "${bindir}/midori-session"
ALTERNATIVE_PRIORITY = "90"

do_install() {
        install -d ${D}/${bindir}
        install -m 0755 ${S}/midori-session ${D}/${bindir}
        install -m 0755 ${S}/auto_restart_with_new_config.sh ${D}/${bindir}
        install -m 0755 ${S}/change_midori_url.sh ${D}/${bindir}
        install -d ${D}/home/${USER}/.config/${BROWSER}/
        install ${S}/config ${D}/home/${USER}/.config/${BROWSER}/
}

FILES_${PN} += "/home/${USER}/.config/${BROWSER}/config"
