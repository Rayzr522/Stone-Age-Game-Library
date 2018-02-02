
package com.sagl.graphics;

public class SpriteSheet {

    private Texture spritesheet;
    private Texture[] sprites;
    private int nSprites;
    private int nSpritesX;
    private int nSpritesY;

    public SpriteSheet(String location, int nSprites) {

	spritesheet = TexLoader.loadTextureRes(location);
	this.nSprites = nSprites;

	int individualWidth = spritesheet.getWidth() / this.nSprites;
	int individualHeight = spritesheet.getHeight();

	sprites = new Texture[nSprites];

	for (int i = 0; i < this.nSprites; i++) {

	    sprites[i] = spritesheet.getSubimage(i * individualWidth, 0, individualWidth, individualHeight);

	}

    }

    public SpriteSheet(String location, int nSpritesX, int nSpritesY) {

	spritesheet = TexLoader.loadTextureRes(location);
	this.nSpritesX = nSpritesX;
	this.nSpritesY = nSpritesY;
	nSprites = nSpritesX * nSpritesY;

	int individualWidth = spritesheet.getWidth() / this.nSpritesX;
	int individualHeight = spritesheet.getHeight() / this.nSpritesY;

	sprites = new Texture[nSpritesX * nSpritesY];

	for (int y = 0; y < nSpritesY; y++) {

	    for (int x = 0; x < nSpritesX; x++) {

		sprites[x + y * this.nSpritesX] = spritesheet.getSubimage(x * individualWidth, y * individualHeight, individualWidth, individualHeight);

	    }

	}

    }

    public Texture getImage(int frame) {

	if (frame < nSprites) {
	    // System.out.println("Succesfully loaded the image!");
	    return sprites[frame];
	} else {
	    System.out.println("Did not load the image!");
	    return null;
	}

    }

    public Texture getImage(int x, int y) {

	if (x + y * nSpritesX <= sprites.length) {
	    System.out.println("Succesfully loaded the image!");
	    return sprites[x + y * nSpritesX];
	} else {
	    System.out.println("Did not load the image!");
	    return null;
	}

    }

    public int getNumberSprites() {

	return nSprites;

    }

}
