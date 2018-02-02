
package com.sagl.graphics;

import java.awt.Image;
import java.awt.image.BufferedImage;
import java.lang.reflect.Method;
import java.net.URL;

import javax.imageio.ImageIO;

public class TexLoader {

    private static BufferedImage lImage(URL url) {

	try {
	    return ImageIO.read(url);
	} catch (Exception e) {
	    System.err.println("Couldn't load the the image \"" + url + "\"");
	    e.printStackTrace();
	    return null;
	}

    }

    private static Texture lTexture(URL url, int type) {

	try {

	    BufferedImage image = lImage(url);
	    Texture texture = new Texture(image, type);
	    return texture;
	} catch (Exception e) {
	    System.err.println("Couldn't load the the image \"" + url + "\"");
	    e.printStackTrace();
	    return null;
	}

    }

    public static BufferedImage loadImageRes(String location) {

	return lImage(TexLoader.class.getResource(location));

    }

    public static BufferedImage loadImage(String location) {

	try {
	    return lImage(new URL(location));
	} catch (Exception e) {
	    e.printStackTrace();
	    return null;
	}

    }

    public static Texture loadTextureRes(String location) {

	return lTexture(TexLoader.class.getResource(location), BufferedImage.TYPE_INT_ARGB);

    }

    public static Texture loadTexture(String location) {

	try {
	    return lTexture(new URL(location), BufferedImage.TYPE_INT_ARGB);
	} catch (Exception e) {
	    e.printStackTrace();
	    return null;
	}

    }

    public static Texture loadTextureRes(String location, int type) {

	return lTexture(TexLoader.class.getResource(location), type);

    }

    public static Texture loadTexture(String location, int type) {

	try {
	    return lTexture(new URL(location), type);
	} catch (Exception e) {
	    e.printStackTrace();
	    return null;
	}

    }

    public static boolean setDockIconImage(Texture texture) {

	try {

	    Class<?> util = Class.forName("com.apple.eawt.Application");
	    Method getApplication = util.getMethod("getApplication");
	    Object application = getApplication.invoke(util);
	    Method setDockIconImage = util.getMethod("setDockIconImage", Image.class);
	    setDockIconImage.invoke(application, texture);

	    return true;

	} catch (Exception e) {

	    System.err.println("Couldn't set dock icon image!");

	    e.printStackTrace();

	    return false;

	}

    }

}
