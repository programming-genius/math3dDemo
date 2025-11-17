package it.jdk.math3d;

import static java.lang.Math.*;
import java.util.Objects;

/**
Anatomical Human Face Model - Game Programming Gems 8
by Marco Fratarcangeli - 2010
marco@fratarcangeli.net
http://www.fratarcangeli.net

This software is provided 'as-is', without any express or
implied warranty. In no event will the author be held
liable for any damages arising from the use of this software.

Permission is granted to anyone to use this software for any purpose,
including commercial applications, and to alter it and redistribute
it freely, subject to the following restrictions:

1. The origin of this software must not be misrepresented;
 you must not claim that you wrote the original software.
 If you use this software in a product, an acknowledgment
 in the product documentation would be appreciated but
 is not required.

2. Altered source versions must be plainly marked as such,
 and must not be misrepresented as being the original software.

3. This notice may not be removed or altered from any
 source distribution. 
 
 IMPORTANT: This class is a Java representation of the original C++ version.
 
 @author Alessandro Zoia
 @version 1.0.0
*/
class Vector3 {

	private float x, y, z;

	/**
	 * Make a zero length vector
	 */
	Vector3() {
		this(0, 0, 0);
	}

	/**
	 * Make a vector with the specified position in space
	 * respect to the world origin.
	 * @param x x coordinate
	 * @param y y coordinate
	 * @param z z coordinate
	 */
	Vector3(float x, float y, float z) {
		this.x = x;
		this.y = y;
		this.z = z;
	}

	/**
	 * Returns the euclidean norm of the vector.
	 * @return euclidean norm
	 */
	float length() {
		return (float) sqrt(squaredLength());
	}

	/**
	 * Returns the squared euclidean norm of the vector
	 * @return squared euclidean norm
	 */
	float squaredLength() {
		return (float) (pow(x, x) + pow(y, y) + pow(z, z));
	}

	/**
	 * Equal operator. This method allows to change the coordinates
	 * of the current vector.
	 * @param vector  vector to be assigned
	 */
	void assign(Vector3 vector) {
		x = vector.x;
		y = vector.y;
		z = vector.z;
	}

	/**
	 * Addition among vectors.
	 * @param vector vector to be added
	 * @return the sum of the current vector with the input vector
	 */
	Vector3 sum(Vector3 vector) {
		return new Vector3(x + vector.x, y + vector.y, z + vector.z);
	}

	/**
	 * Addition and assignment among vectors. This method changes the current
	 * vector with a coordinates sum plus assignment.
	 * @param vector vector to be added
	 */
	void sumAndAssign(Vector3 vector) {
		x += vector.x;
		y += vector.y;
		z += vector.z;
	}

	/**
	 * Difference and assignment among vectors. This method changes the current
	 * vector with a coordinates difference plus assignment.
	 * @param vector vector to be subtracted
	 */
	void minusAndAssign(Vector3 vector) {
		x -= vector.x;
		y -= vector.y;
		z -= vector.z;
	}

	/**
	 * Difference among vectors.
	 * @param vector vector to be subtracted
	 */
	Vector3 minus(Vector3 vector) {
		return new Vector3(x - vector.x, y - vector.y, z - vector.z);
	}

	/**
	 * Multiplication by a scalar.
	 * @param scalar scalar value
	 * @return a new vector with every coordinate multiplied by the scalar
	 */
	Vector3 scalarMultiply(float scalar) {
		return new Vector3(x * scalar, y * scalar, z * scalar);
	}

	
	/**
	 * Division by a scalar.
	 * @param scalar scalar value
	 * @return  a new vector with every coordinate divided by the scalar
	 * @throws VectorOperationException if the input value is zero
	 */
	Vector3 scalarDivision(float scalar) throws VectorOperationException {
		if (scalar == 0)
			throw new VectorOperationException("Cannot divide a value by zero");
		return new Vector3(x / scalar, y / scalar, z / scalar);
	}

	/**
	 * Division by a scalar with an assignment.
	 * @param scalar scalar value
	 * @throws VectorOperationException if the input value is zero
	 */
	void scalarDivisionAndAssign(float scalar) throws VectorOperationException {
		if (scalar == 0)
			throw new VectorOperationException("Cannot divide a value by zero");
		x /= scalar;
		y /= scalar;
		z /= scalar;
	}

	/**
	 * Cross product.
	 * @param vector the input vector
	 * @return the vector that represents the cross product
	 */
	Vector3 crossProduct(Vector3 vector) {
		return new Vector3(y * vector.z - z * vector.y, z * vector.x - x * vector.z, x * vector.y - y * vector.x);
	}

	/**
	 * Dot product.
	 * @param vector the input vector
	 * @return the scalar value that represents the dot product
	 */
	float dotProduct(Vector3 vector) {
		return x * vector.x + y * vector.y + z * vector.z;
	}

	/**
	 * Normalize the current vector.
	 */
	void normalize() {
		double length = length();
		x /= length;
		y /= length;
		z /= length;
	}

	@Override
	public boolean equals(Object vector) {
		if (vector instanceof Vector3) {
			Vector3 vet = (Vector3) vector;
			return x == vet.x && y == vet.y && z == vet.z;
		} else
			return false;
	}

	@Override
	public int hashCode() {
		return Objects.hash(x, y, z);
	}

	public float getX() {
		return x;
	}

	public void setX(float x) {
		this.x = x;
	}

	public float getY() {
		return y;
	}

	public void setY(float y) {
		this.y = y;
	}

	public float getZ() {
		return z;
	}

	public void setZ(float z) {
		this.z = z;
	}
	
	/**
	 * Compute triangle face normal
	 * @param p1
	 * @param p2
	 * @param p3
	 * @return a vector that represents a triangle normal
	 */
	static Vector3 triangleNormal(Vector3 p1, Vector3 p2, Vector3 p3){
		Vector3 v1 = new Vector3(p2.x - p1.x, p2.y - p1.y, p2.z - p1.z);
		Vector3 v2 = new Vector3(p3.x - p1.x, p3.y - p1.y, p3.z - p1.z);
		Vector3 vn = v1.crossProduct(v2);
		vn.normalize();
		return vn;
	}
}
