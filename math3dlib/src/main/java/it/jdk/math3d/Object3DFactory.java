package it.jdk.math3d;

/**
 * Factory per la creazione di oggetti 3D
 *
 * @author Alessandro Zoia
 * @version 1.0.0
 */
public class Object3DFactory {

	private Object3DFactory() {}

	/**
	 * Ritorna un oggetto in base alla descrizione fornita
	 * @param object3dDescription descrizione dell'oggetto
	 * @return un oggetto in base alla descrizione
	 */
	public static Object3D getInstance(Object3DDescription object3dDescription) {
		switch (object3dDescription.getType()) {
			case CUBE:
				if(object3dDescription.getAlias() != null) {
					return new NamedBox(object3dDescription.getAlias());
				} else {
					return new Box();
				}
			case SPHERE:
				if(object3dDescription.getAlias() != null) {
					return new NamedSphere(object3dDescription.getAlias());
				} else {
					return new Sphere();
				}
			default:
				throw new RuntimeException("Object undefined!");
		}
	}
}
