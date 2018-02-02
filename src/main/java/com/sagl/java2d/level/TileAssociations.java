package com.sagl.java2d.level;

import java.util.HashMap;

public class TileAssociations {

	private HashMap<String, Tile>	associations;

	public TileAssociations() {

		associations = new HashMap<String, Tile>();

	}

	public void addAssociation(String character, Tile tile) {

		if (!associations.containsKey(character)) {

			associations.put(character, tile);

		}

	}

	public void removeAssociation(String character) {

		String type = character.toUpperCase();

		if (associations.containsKey(type)) {

			associations.remove(type);

		}

	}

	public Tile getAssociation(String character) {

		String type = character.toUpperCase();

		if (associations.containsKey(type)) {

			return associations.get(type);

		} else {

			return new Tile(null, false);

		}

	}

	public boolean hasAssocation(String character) {

		String type = character.toUpperCase();
		return associations.containsKey(type);

	}

}
