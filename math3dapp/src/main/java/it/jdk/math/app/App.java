package it.jdk.math.app;

import it.jdk.math3d.App3D;
import it.jdk.math3d.App3DFactory;
import it.jdk.math3d.Object3D;
import it.jdk.math3d.Object3DDescription;
import it.jdk.math3d.Object3DFactory;
import static it.jdk.math3d.Object3DType.*;

public class App {

	private static void printInformations(Object3D object) {
		System.out.println("---------------------------------------");
		System.out.println("Nome:" + object.alias());
		System.out.println("X pos:" + object.getX());
		System.out.println("Y pos:" + object.getY());
		System.out.println("Z pos:" + object.getZ());
	}
	
	public static void main(String[] args) {	
		Object3D cube1 = Object3DFactory.getInstance(
				new Object3DDescription("Cube1", CUBE));
		Object3D cube2 = Object3DFactory.getInstance(
				new Object3DDescription(CUBE));
		Object3D cube3 = Object3DFactory.getInstance(
				new Object3DDescription("Cube2", CUBE));
		
		Object3D sphere1 = Object3DFactory.getInstance(
				new Object3DDescription("Sphere1", SPHERE));	
		Object3D sphere2 = Object3DFactory.getInstance(
				new Object3DDescription( SPHERE));
		Object3D sphere3 = Object3DFactory.getInstance(
				new Object3DDescription(SPHERE));
		
		cube1.setLocation(0, 0, 0);
		cube1.setRotate(45, 0, 1, 1);
		
		cube2.setLocation(0.5f, 0, 0);
		cube2.setRotate(120, 1, 1, 0);
        
		cube3.setLocation(0.3f, -0.5f, 0f);
		cube3.setScale(1.5f, 1.5f, 1.5f);
		cube3.setRotate(120, 1, 1, 0);
		
        sphere1.setLocation(-0.5f, 0, 0);
        sphere1.setRotate(90, 1, 0, 0);
      
        sphere2.setLocation(-0.5f, 0.5f, 0);
        
        sphere3.setLocation(0.5f, 0.5f, 0);
        sphere3.setScale(1.5f, 1f, 1f);
        
		Object3D[] objects = {cube1, cube2, cube3, sphere1, sphere2, sphere3};
		
		for(Object3D object: objects)
			printInformations(object);
		
		App3D app3D = App3DFactory.getInstance();
		app3D.setObjects(objects);
		app3D.run();
	}
}
