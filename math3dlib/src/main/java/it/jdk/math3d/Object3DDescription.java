package it.jdk.math3d;

/**
 * Classe per rappresentare una richiesta
 * di un particolare oggetto 3D.
 *
 * @author Alessandro Zoia
 * @version 1.0.0
 */
public class Object3DDescription {

	private String alias;
	private Object3DType object3dType;
	
	/**
	 * Costruttore per richiedere un oggetto 3D
	 * @param alias il nome che si vuole assegnare all'oggetto
	 * @param object3dType tipo di oggetto 3D
	 */
	public Object3DDescription(String alias, Object3DType object3dType) {
		this(object3dType);
		this.alias = alias;
	}
	
	/**
	 * Costruttore per richiedere un oggetto 3D
	 * @param object3dType tipo di oggetto 3D
	 */
	public Object3DDescription(Object3DType object3dType) {
		this.object3dType = object3dType;
	}
	
	/**
	 * Ritorna il nome dell'oggetto
	 * @return il nome dell'oggetto
	 */
	public String getAlias() {
		return alias;
	}
	
	/**
	 * Ritorna il tipo di oggetto 3D
	 * @return il tipo di oggetto 3D
	 */
	public Object3DType getType() {
		return object3dType;
	}
}
