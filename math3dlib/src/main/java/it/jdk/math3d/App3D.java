package it.jdk.math3d;

/**
 * Contratto per la creazione di una scena
 * di un'applicazione 3D
 * 
 * @author Alessandro Zoia
 * @version 1.0.0
 */
public interface App3D {
	
	/**
	 * Inserimento degli oggetti nella scena
	 * @param objects oggetti da inserire nella scena
	 */
	public void setObjects(Object3D[] objects);
	
	/**
	 * Disegno degli oggetti
	 */
    public void drawObjects();
    
    /**
     * Esecuzine della scena
     */
    public void run();
}
