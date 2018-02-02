
package com.sagl.io;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;

public class FileLoader {

    public static File getResource(String location) {

	URL url = FileLoader.class.getResource(location);
	if (url == null) {
	    return null;
	}

	return new File(url.getFile().replace("%20", " "));

    }

    public static String[] getFileContent(File file) {

	if (file == null) {
	    return null;
	}

	try {

	    BufferedReader reader = new BufferedReader(new FileReader(file));

	    List<String> lines = new ArrayList<String>();
	    String nextLine;

	    while ((nextLine = reader.readLine()) != null) {
		lines.add(nextLine);
	    }

	    reader.close();

	    return lines.toArray(new String[0]);

	} catch (Exception e) {

	    e.printStackTrace();
	    return null;

	}

    }

    public static String[] getFileContent(String location) {

	return getFileContent(new File(location));

    }

    public static String[] getResourceContent(String location) {

	return getFileContent(getResource(location));

    }

}
