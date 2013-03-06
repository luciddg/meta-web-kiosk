DESCRIPTION = "ssh private & public key packages"
HOMEPAGE = "http://www.yoctoproject.org"
BUGTRACKER = "http://bugzilla.pokylinux.org"

PR = "r0"

LICENSE = "MIT"
LIC_FILES_CHKSUM = "file://id_rsa;beginline=0;endline=1;md5=9d800edbd5011b4ed869580bd62a07f0"

#Note: The keys populated here are just as an example,
# These keys are no more private.
# Do not use same keys for your project
# You are expected to create user own ssh keys to replace these sample keys.

SRC_URI = "file://id_rsa \
           file://id_rsa.pub \
          "
S = "${WORKDIR}"

USER="root"

do_install() {
        install -d ${D}/home/${USER}/.ssh/
        install -m 0700 ${S}/id_rsa ${D}/home/${USER}/.ssh/
        install -m 0755 ${S}/id_rsa.pub ${D}/home/${USER}/.ssh/
        install -m 0755 ${S}/id_rsa.pub ${D}/home/${USER}/.ssh/authorized_keys
}

PACKAGES += "${PN}-client ${PN}-server"

FILES_${PN}-client += "/home/${USER}/.ssh/id_rsa.pub /home/${USER}/.ssh/id_rsa"
FILES_${PN}-server += "/home/${USER}/.ssh/authorized_keys"
