DESCRIPTION = "A basic image with web browser integrated"

LIC_FILES_CHKSUM = "file://${COREBASE}/LICENSE;md5=3f40d7994397109285ec7b81fdeb3b58 \
                    file://${COREBASE}/meta/COPYING.MIT;md5=3da9cfbcb788c80a0384361b4de20420"

IMAGE_FEATURES += "splash package-management x11-browser ssh-server-openssh"

PR="r2"

LICENSE = "MIT"

inherit core-image
