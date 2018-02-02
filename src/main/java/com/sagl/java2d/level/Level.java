
package com.sagl.java2d.level;

public class Level {

	public String[]			lines;
	public int				width;
	public int				height;
	public TileAssociations	associations;

	private Tile[]			tiles;

	public Level(String[] lines, int width, int height, TileAssociations associations) {

		this.lines = lines;
		this.width = width;
		this.height = height;

		this.associations = associations;

		tiles = new Tile[width * height];

		loadTiles();

	}

	public void loadTiles() {

		for (int y = 0; y < height; y++) {

			for (int x = 0; x < width; x++) {

				String type = lines[y].subSequence(x, x + 1).toString().toUpperCase();
				if (associations.hasAssocation(type)) {

					tiles[x + y * width] = associations.getAssociation(type);

				} else {

					tiles[x + y * width] = new Tile(null, false);

				}

			}

		}

	}

	public int getWidth() {

		return width;

	}

	public int getHeight() {

		return height;

	}

	public Tile getTile(int x, int y) {

		try {
			return tiles[x + y * width];
		} catch (ArrayIndexOutOfBoundsException e) {
			e.printStackTrace();
			return new Tile(null, false);
		}

	}

}
