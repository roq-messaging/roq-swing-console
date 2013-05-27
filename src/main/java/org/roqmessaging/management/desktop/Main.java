package org.roqmessaging.management.desktop;


/**
 * The starting point for the RoQ Desktop Management Application
 * @author Maxime Jeanmart
 *
 */
public class Main {

	
	
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		
		javax.swing.SwingUtilities.invokeLater(new Runnable() {
            public void run() {
               new RoQDesktop();
            }
        });
		
	}

}
