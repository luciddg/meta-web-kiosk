# META-WEB-KIOSK

The layer contains a new bitbake target, core-image-web-kiosk, that automatically
starts a Midori browser right after boot and enables the use of a virtual keyboard
if there is support for it.

This specific branch is tuned to enable the use of a read-only root filesystem,
and provide support for a browser configuration in the /media directory.

## CHANGE THE HOMEPAGE OF THE BROWSER

There are two ways to change the default page that shows at boot time. The first way is
to edit `recipes-browser/midori-session/files/config`. This will "bake in" the URL, by
putting that file in `/etc/midori/config`.

The other way is to drop a midori config file (e.g. a copy of /etc/midori/config) at
`/media/browser.conf` during boot. This file may come from a mounted SD card, for 
example, or be put into place dynamically at boot time some other way. The Midori startup 
script will prefer the file `/media/browser.conf`, copying it into the runtime directory.

## PROXY CONFIGURATIONS

If you are using the application inside a network that has proxy configuration, 
uncomment the lines in `recipes-browser/midori-session/files/config`, and manage the file
as described in the previous section.

## DISPLAY CONFIGURATIONS

You can customize your display resolution by uncommenting the following line
from recipes-browser/midori-session/files/midori-session:
	# Modify here for the desired resolution
	# Full HD - 1920 x 1080
	#xrandr -s 1240x768
by changing the 1240x768 resolution with the one that you desire.

## DEPENDENCIES

The layer depends on the Poky metadata. For further information, please visit 
the official Yocto Project website at:
	http://www.yoctoproject.org

## ENABLE TOUCHSCREEN FOR qemux86

If you want to test the image using runqemu be sure that the variable `HAVE_KEYBOARD`
from `poky/meta/recipes-bsb/formfactor/files/*arch*/machconfig` is set to 0.
[Change `*arch*` keyword with the machine you are testing e.g if you use a x86 machine
`*arch*` will be qemux86]

## BUILDING THE META-WEB-KIOSK LAYER

After you download the meta-web-kiosk layer, be sure to add its location to the
bblayer.conf file.

```
BBLAYERS ?= "	\
	/<path>/meta	\
	/<path>/meta-yocto	\
	/<path>/meta-web-kiosk	\
"
```

You should, now be able to build the new images
```bash
	$ . ./oe-init-build-env
	$ bitbake core-image-web-kiosk
	$ bitbake core-image-kiosk-manager
```

For further information visit the wiki page of the layer at
https://wiki.yoctoproject.org/wiki/Web_Application_for_Interactive_Kiosk_Devices


## LICENSE

All metadata is MIT licensed unless otherwise stated. Source code included
in tree for individual recipes is under the LICENSE stated in each recipe
(.bb file) unless otherwise stated.
