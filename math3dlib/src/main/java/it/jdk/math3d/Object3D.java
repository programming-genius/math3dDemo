package it.jdk.math3d;

import static java.lang.Math.E;
import static java.lang.Math.PI;
import static java.util.UUID.randomUUID;

/**
 * Interfaccia per il contratto che rappresenta
 * un generico oggetto 3D in una scena.
 *
 * @author Alessandro Zoia
 * @version 1.0.0
 */
public interface Object3D {

	public static final float PI_GRECO = (float) PI;
	public static final float EULER_NUMBER = (float) E;
	
	/** Angolo 180° espresso in radianti */
	public static final float PI_180 = 3.14159265359f / 180f ;
	
	/**
	 * Metodo per scalare le dimensioni di un oggetto.
	 * @param xScale scalatura lungo l'asse X
	 * @param yScale scalatura lungo l'asse Y
	 * @param zScale scalatura lungo l'asse Z
	 */
    public abstract void setScale(float xScale, float yScale, float zScale);
    
    /**
     * Metodo per ruotare un oggetto rispetto ad un vettore che rappresenta l'asse di rotazione.
     * @param rotAngle angolo di rotazione
     * @param xAxis componente X del vettore di rotazione
     * @param yAxis componente Y del vettore di rotazione
     * @param zAxis componente Z del vettore di rotazione
     */
    public abstract void setRotate(float rotAngle, float xAxis, float yAxis, float zAxis);
    
    /**
     * Metodo per traslare un oggetto in una posizione dello spazio.
     * 
     * @param x coordinata X
     * @param y coordinata Y
     * @param z coordinata Z
     */
    public abstract void setLocation(float x, float y, float z);
    
    /**
     * Ritorna la coordinata X attuale dell'oggetto.
     * @return coordinata X
     */
    public abstract float getX();
    
    /**
     * Ritorna la coordinata Y attuale dell'oggetto.
     * @return coordinata Y
     */
    public abstract float getY();
    
    /**
     * Ritorna la coordinata Z attuale dell'oggetto.
     * @return coordinata Z
     */
    public abstract float getZ();
    
    /**
     * Metodo per disegnare un oggetto in una scena.
     */
    public abstract void draw();
    
    /**
     * Ritorna il fattore di scala corrente lungo l'asse X.
     * @return fattore di scala lungo l'asse X
     */
    public abstract float getXScale();
    
    /**
     * Ritorna il fattore di scala corrente lungo l'asse Y.
     * @return fattore di scala lungo l'asse Y
     */
    public abstract float getYScale();
    
    /**
     * Ritorna il fattore di scala corrente lungo l'asse Z.
     * @return fattore di scala lungo l'asse Z
     */
    public abstract float getZScale();
    
    /**
     * Ritorna la componente X dell'asse di rotazione corrente.
     * @return componente X dell'asse di rotazione corrente
     */
    public abstract float getXAxis();
    
    /**
     * Ritorna la componente Y dell'asse di rotazione corrente.
     * @return componente Y dell'asse di rotazione corrente
     */
    public abstract float getYAxis();
    
    /**
     * Ritorna la componente Z dell'asse di rotazione corrente.
     * @return componente Z dell'asse di rotazione corrente
     */
    public abstract float getZAxis();
    
    /**
     * Ritorna l'angolo di rotazione corrente
     * @return angolo di rotazione corrente
     */
    public abstract float getRotAngle();
    
    // Since from Java 8
    /**
     * Generazione automatica del nome dell'oggetto nella forma Object_UUID
     * @return nome generato automaticamente
     */
    public default String alias() { return "Object_" + generateRandomName();}
    
    /**
     * API Description
     * @return una descrizione delle API
     */
    public static String getApiDescription() { 
    	return getDefaultApiInfo();
    }
    
    // Since from Java 9
    /**
     * Genera un nome randomico
     * @return un nome randomico
     */
    private String generateRandomName() { return randomUUID().toString();}
    
    /**
     * Ritorna la stringa descrittiva delle API
     * @return stringa descrittiva API
     */
    private static String getDefaultApiInfo() { 
    	return "Description: Api to modelling 3D objects";
    }   
}
