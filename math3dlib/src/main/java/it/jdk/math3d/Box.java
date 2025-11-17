package it.jdk.math3d;

import static org.lwjgl.opengl.GL11.GL_MODELVIEW;
import static org.lwjgl.opengl.GL11.GL_QUADS;
import static org.lwjgl.opengl.GL11.glBegin;
import static org.lwjgl.opengl.GL11.glColor3f;
import static org.lwjgl.opengl.GL11.glEnd;
import static org.lwjgl.opengl.GL11.glLoadIdentity;
import static org.lwjgl.opengl.GL11.glMatrixMode;
import static org.lwjgl.opengl.GL11.glVertex3f;
import static org.lwjgl.opengl.GL11.glNormal3f;
import static org.lwjgl.opengl.GL11.glTranslatef;
import static org.lwjgl.opengl.GL11.glRotatef;
import static org.lwjgl.opengl.GL11.glScalef;

class Box implements Object3D {

	private float height;
	private float width;
	private float length;
	private float x, y, z;
	private float xAxis, yAxis, zAxis;
	private float xScale, yScale, zScale;
	private float rotAngle;

	public Box() {
		this(0.25f,0.25f,0.25f);
	}
	
	public Box(float height, float width, float length) {
		this.height = height;
		this.width = width;
		this.length = length;
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
	public float getX() { return x;}
	
	@Override
	public float getY() { return y;}
	
	@Override
	public float getZ() { return z;}
	
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
    public  float getXAxis() {return xAxis;}
	
	@Override
    public  float getYAxis() {return yAxis;}
	
	@Override
    public  float getZAxis() {return zAxis;}
	
	@Override
    public  float getRotAngle() {return rotAngle;}
	
	@Override
	public void draw() {
		glMatrixMode(GL_MODELVIEW);
		glLoadIdentity(); 
		glTranslatef(x,y,z);
		glRotatef(rotAngle,xAxis,yAxis,zAxis);
		glScalef(xScale, yScale, zScale);
		glTranslatef(0,0,0);
		
		Vector3 p1 = new Vector3();
		Vector3 p2 = new Vector3();
		Vector3 p3 = new Vector3();
		Vector3 p4 = new Vector3();

		// Front
		glBegin(GL_QUADS);
			glColor3f(1.f, 0.f, 0.f);
			setVertexCoordinates(p1,-1,1,1);
			setVertexCoordinates(p2,-1,-1,1);
			setVertexCoordinates(p3,1,-1,1);
			setVertexCoordinates(p4,1,1,1);
			setFaceNormal(p1,p2,p3);
			addVertexes(p1,p2,p3,p4);
		glEnd();
		
		// Right
		glBegin(GL_QUADS);
			glColor3f(0.f, 1.f, 0.f);
			setVertexCoordinates(p1,-1,1,-1);
			setVertexCoordinates(p2,-1,-1,-1);
			setVertexCoordinates(p3,-1,-1,1);
			setVertexCoordinates(p4,-1,1,1);
			setFaceNormal(p1,p2,p3);
			addVertexes(p1,p2,p3,p4);
		glEnd();
		
		// Back
		glBegin(GL_QUADS);
			glColor3f(1.f, 0.f, 0.f);
		    setVertexCoordinates(p1,-1,1,-1);
		    setVertexCoordinates(p2,-1,-1,-1);
		    setVertexCoordinates(p3,1,-1,-1);
		    setVertexCoordinates(p4,1,1,-1);
			setFaceNormal(p1,p2,p3);
			addVertexes(p1,p2,p3,p4);
		glEnd();
		
		// Left
		glBegin(GL_QUADS);
			glColor3f(0.f, 0.f, 1.f);
			setVertexCoordinates(p1,1,1,1);
			setVertexCoordinates(p2,1,-1,1);
			setVertexCoordinates(p3,1,-1,-1);
			setVertexCoordinates(p4,1,1,-1);
			setFaceNormal(p1,p2,p3);
			addVertexes(p1,p2,p3,p4);
		glEnd();

		// Top
		glBegin(GL_QUADS);
			glColor3f(0.f, 1.f, 1.f);
			setVertexCoordinates(p1,-1,1,-1);
			setVertexCoordinates(p2,-1,1,1);
			setVertexCoordinates(p3,1,1,1);
			setVertexCoordinates(p4,1,1,-1);
			setFaceNormal(p1,p2,p3);
			addVertexes(p1,p2,p3,p4);
		glEnd();
		
		// Bottom
		glBegin(GL_QUADS);
			glColor3f(1.f, 0.f, 1.f);
			setVertexCoordinates(p1,-1,-1,1);
			setVertexCoordinates(p2,-1,-1,-1);
			setVertexCoordinates(p3,1,-1,-1);
			setVertexCoordinates(p4,1,-1,1);
			setFaceNormal(p1,p2,p3);
			addVertexes(p1,p2,p3,p4);
		glEnd();	
	}
	
	private void setVertexCoordinates(Vector3 p, int xSign, int ySign, int zSign){
		p.setX(xSign * width / 2);
		p.setY(ySign * height / 2);
		p.setZ(zSign * length / 2);
	}

	private void addVertexes(Vector3 p1, Vector3 p2, Vector3 p3, Vector3 p4){
		//glTexCoord2d(0, 0);
		glVertex3f(p1.getX(),p1.getY(),p1.getZ());
		//glTexCoord2d(1, 0);
		glVertex3f(p4.getX(),p4.getY(),p4.getZ());
		//glTexCoord2d(1, 1);
		glVertex3f(p3.getX(),p3.getY(),p3.getZ());
		//glTexCoord2d(0, 1);
		glVertex3f(p2.getX(),p2.getY(),p2.getZ());
	}

	private void setFaceNormal(Vector3 p1, Vector3 p2, Vector3 p3){
		Vector3 normal = Vector3.triangleNormal(p1, p2, p3);
		glNormal3f(normal.getX(), normal.getY(), normal.getZ());
	}

}
