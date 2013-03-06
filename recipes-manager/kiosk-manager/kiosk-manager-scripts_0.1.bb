DESCRIPTION = "some scripts for kiosk manager"
HOMEPAGE = "http://www.yoctoproject.org"
BUGTRACKER = "http://bugzilla.pokylinux.org"

PR = "r0"

LICENSE = "GPLv2"
LIC_FILES_CHKSUM = "file://manage_kiosk.sh;endline=1;md5=3e2b31c72181b87149ff995e7202c0e3   \
                    "

SRC_URI = "file://manage_kiosk.sh \
           file://change_url_for_client.sh \
          "
S = "${WORKDIR}"

USER = "root"
inherit update-alternatives

do_install() {
        install -d ${D}/${bindir}
        install -m 0755 ${S}/manage_kiosk.sh ${D}/${bindir}
        install -m 0755 ${S}/change_url_for_client.sh ${D}/${bindir}
}

FILES_${PN} += "/home/${USER}/.ssh/"
