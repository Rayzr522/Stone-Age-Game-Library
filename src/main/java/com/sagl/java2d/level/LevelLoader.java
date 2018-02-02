
package com.sagl.java2d.level;

import java.io.BufferedReader;
import java.io.FileReader;

public class LevelLoader {

	public static Level getLevel(String location, TileAssociations associations) {

		String l = LevelLoader.class.getResource(location).getFile().replaceAll("%20", " ");

		try {
			FileReader f = new FileReader(l);
			BufferedReader br = new BufferedReader(f);

			int width = Integer.parseInt(br.readLine());
			int height = Integer.parseInt(br.readLine());

			String[] lines = new String[height];
			for (int i = 0; i < height; i++) {

				lines[i] = br.readLine();

			}
			Level l2d = new Level(lines, width, height, associations);

			br.close();

			return l2d;

		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}

	}

}
