package it.jdk.math3d;

/**
 * Classe per la costruzione di una scena 3D
 */
public class App3DFactory {

	private App3DFactory() {
	}
	
	/**
	 * Ritorna una scena 3D
	 * @return un oggetto di una scena 3D
	 */
	public static App3D getInstance() {
		return new AppOpenGL();
	}

}
