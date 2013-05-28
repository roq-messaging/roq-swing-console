package org.roqmessaging.management.desktop;

import javax.swing.ImageIcon;

/**
 * Various methods to help developing the client desktop application
 * @author Maxime Jeanmart
 *
 */
public class DesktopUtils {

	/**
	 * creates an image icon from the file located at the specified path
	 */
	public static ImageIcon createImageIcon(String path, String description) {
		java.net.URL imgURL = DesktopUtils.class.getResource(path);
		if (imgURL != null) {
			return new ImageIcon(imgURL, description);
		} else {
			System.err.println("Couldn't find file: " + path);
			return null;
		}
	}
}
