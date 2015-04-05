DESCRIPTION = "Midori X session files for poky"
HOMEPAGE = "http://www.yoctoproject.org"
BUGTRACKER = "http://bugzilla.pokylinux.org"

PR = "r4"

LICENSE = "GPLv2"
LIC_FILES_CHKSUM = "file://midori-session;endline=5;md5=caa15bc7675a9d01becce7b6d24a8861 \
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
        install -d ${D}/etc/${BROWSER}/
        install ${S}/config ${D}/etc/${BROWSER}
}

FILES_${PN} += "/etc/${BROWSER}/config"
