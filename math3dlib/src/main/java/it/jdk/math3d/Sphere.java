package it.jdk.math3d;

import static java.lang.Math.cos;
import static java.lang.Math.sin;
import static org.lwjgl.opengl.GL11.GL_MODELVIEW;
import static org.lwjgl.opengl.GL11.GL_TRIANGLES;
import static org.lwjgl.opengl.GL11.glBegin;
import static org.lwjgl.opengl.GL11.glColor3f;
import static org.lwjgl.opengl.GL11.glEnd;
import static org.lwjgl.opengl.GL11.glLoadIdentity;
import static org.lwjgl.opengl.GL11.glMatrixMode;
import static org.lwjgl.opengl.GL11.glVertex3d;
import static org.lwjgl.opengl.GL11.glNormal3d;
import static org.lwjgl.opengl.GL11.glRotatef;
import static org.lwjgl.opengl.GL11.glScalef;
import static org.lwjgl.opengl.GL11.glTranslatef;

class Sphere implements Object3D {

	private float radius;
	private float x, y, z;
	private float xAxis, yAxis, zAxis;
	private float xScale, yScale, zScale;
	private float rotAngle;
	private static final float AZIMUTH_ANGLE = 360f;
	private static final float POLAR_ANGLE = 180;
	private static final float AZIMUTH_ANGLE_STEP = 10;
	private static final float POLAR_ANGLE_STEP = 10;
	
	public Sphere() {
		this(0.2f);
	}

	public Sphere(float radius) {
		this.radius = radius;
		xScale = yScale = zScale = 1;
		yAxis = 1;
	}

	@Override
	public void setScale(float xScale, float yScale, float zScale) {
		this.xScale = xScale;
		this.yScale = yScale;
		this.zScale = zScale;
	}

	@Override
	public void setRotate(float rotAngle, float xAxis, float yAxis, float zAxis) {
		this.xAxis = xAxis;
		this.yAxis = yAxis;
		this.zAxis = zAxis;
		this.rotAngle = rotAngle;
	}

	@Override
	public void setLocation(float x, float y, float z) {
		this.x = x;
		this.y = y;
		this.z = z;
	}

	@Override
	public float getX() {
		return x;
	}

	@Override
	public float getY() {
		return y;
	}

	@Override
	public float getZ() {
		return z;
	}
	

	@Override
	public float getXScale() {
		return xScale;
	}

	@Override
	public float getYScale() {
		return yScale;
	}

	@Override
	public float getZScale() {
		return zScale;
	}

	@Override
	public float getXAxis() {
		return xAxis;
	}

	@Override
	public float getYAxis() {
		return yAxis;
	}

	@Override
	public float getZAxis() {
		return zAxis;
	}

	@Override
	public float getRotAngle() {
		return rotAngle;
	}

	@Override
	public void draw() {
		glMatrixMode(GL_MODELVIEW);
		glLoadIdentity(); 
		glTranslatef(x,y,z);
		glRotatef(rotAngle,xAxis,yAxis,zAxis);
		glScalef(xScale, yScale, zScale);
		glTranslatef(0,0,0);
		glBegin(GL_TRIANGLES);
		for (float azimuthAngle = 0; azimuthAngle <= AZIMUTH_ANGLE; azimuthAngle += AZIMUTH_ANGLE_STEP) {
			for (float polarAngle = 0; polarAngle <= POLAR_ANGLE; polarAngle += POLAR_ANGLE_STEP) {
				
				/*Current Triangle points: p1-p2-p3 is the first one, p4-p3-p2 is the second one*/
				Vector3 p1 = sphericalToCartesian(radius, polarAngle, azimuthAngle);
				Vector3 p2 = sphericalToCartesian(radius, polarAngle + 10, azimuthAngle);
				Vector3 p3 = sphericalToCartesian(radius, polarAngle, azimuthAngle + 10);
				Vector3 p4 = sphericalToCartesian(radius, polarAngle + 10, azimuthAngle + 10);
				
				glColor3f(1, 0.5f, 1);

				/*First triangle*/	
				vertexNormalMapping(p1);
				vertexMapping(p1);
				
				vertexNormalMapping(p2);
				vertexMapping(p2);
			
				vertexNormalMapping(p3);
				vertexMapping(p3);
					
				/*Second triangle*/
				vertexNormalMapping(p4);
				vertexMapping(p4);
				
				vertexNormalMapping(p3);
				vertexMapping(p3);
			
				vertexNormalMapping(p2);
				vertexMapping(p2);
			}
		}
		glEnd();
	}
	
	private Vector3 sphericalToCartesian(float radius, float polarAngle, float azimuthAngle){
		float z = radius* (float) (sin(polarAngle * PI_180)*cos(azimuthAngle * PI_180));
		float x = radius* (float) (sin(polarAngle * PI_180)*sin(azimuthAngle * PI_180));
		float y = radius* (float) cos(polarAngle * PI_180);
		return new Vector3(x,y,z);
    }
	
	private void vertexMapping(Vector3 vector){
		glVertex3d(vector.getX(),vector.getY(), vector.getZ());
	}

	private void vertexNormalMapping(Vector3 vector) {
		/*Vertex Normal using Gradient*/
		vector = vector.scalarMultiply(2);
		vector.normalize();
		glNormal3d(vector.getX(), vector.getY(), vector.getZ());
	}		
}
