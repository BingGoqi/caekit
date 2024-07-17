/**
 * @Title: Vector3D.java
 * @Description: TODO
 * @author BingGoqi
 * @date 2024-07-16 03:49:28
 */

package meiKoKwan;

public class Vector3d {
	public double x;
	public double y;
	public double z;
	public Vector3d() {
	}
	public Vector3d(double d) {
		this.x = d;
		this.y = d;
		this.z = d;
	}
	public Vector3d(double x, double y, double z) {
		this.x = x;
		this.y = y;
		this.z = z;
	}
	public Vector3d(double[] xyz) {
		this.x = xyz[0];
		this.y = xyz[1];
		this.z = xyz[2];
	}
	public Vector3d(float[] xyz) {
		this.x = xyz[0];
		this.y = xyz[1];
		this.z = xyz[2];
	}
	public double x() {
		return this.x;
	}

	public double y() {
		return this.y;
	}

	public double z() {
		return this.z;
	}
	public Vector3d set(double d) {
		this.x = d;
		this.y = d;
		this.z = d;
		return this;
	}
	public Vector3d set(double x, double y, double z) {
		this.x = x;
		this.y = y;
		this.z = z;
		return this;
	}
	public Vector3d set(double[] xyz) {
		this.x = xyz[0];
		this.y = xyz[1];
		this.z = xyz[2];
		return this;
	}
	public Vector3d set(float[] xyz) {
		this.x = xyz[0];
		this.y = xyz[1];
		this.z = xyz[2];
		return this;
	}
	public Vector3d setComponent(int component, double value) throws IllegalArgumentException {
		switch (component) {
		case 0:
			x = value;
			break;
		case 1:
			y = value;
			break;
		case 2:
			z = value;
			break;
		default:
			throw new IllegalArgumentException();
		}
		return this;
	}
	public Vector3d sub(double x, double y, double z) {
		this.x = this.x - x;
		this.y = this.y - y;
		this.z = this.z - z;
		return this;
	}
	public Vector3d add(double x, double y, double z, Vector3d dest) {
		dest.x = this.x + x;
		dest.y = this.y + y;
		dest.z = this.z + z;
		return dest;
	}
	public Vector3d div(Vector3d v) {
		this.x = x / v.x();
		this.y = y / v.y();
		this.z = z / v.z();
		return this;
	}
	public Vector3d mul(double scalar) {
		this.x = x * scalar;
		this.y = y * scalar;
		this.z = z * scalar;
		return this;
	}

	public Vector3d mul(double scalar, Vector3d dest) {
		dest.x = x * scalar;
		dest.y = y * scalar;
		dest.z = z * scalar;
		return dest;
	}
	public Vector3d mul(double x, double y, double z) {
		this.x = this.x * x;
		this.y = this.y * y;
		this.z = this.z * z;
		return this;
	}

	public Vector3d mul(double x, double y, double z, Vector3d dest) {
		dest.x = this.x * x;
		dest.y = this.y * y;
		dest.z = this.z * z;
		return dest;
	}
	public Vector3d div(double scalar) {
		double inv = 1.0 / scalar;
		this.x = x * inv;
		this.y = y * inv;
		this.z = z * inv;
		return this;
	}

	public Vector3d div(double scalar, Vector3d dest) {
		double inv = 1.0 / scalar;
		dest.x = x * inv;
		dest.y = y * inv;
		dest.z = z * inv;
		return dest;
	}
	public Vector3d div(double x, double y, double z) {
		this.x = this.x / x;
		this.y = this.y / y;
		this.z = this.z / z;
		return this;
	}
	public Vector3d div(double x, double y, double z, Vector3d dest) {
		dest.x = this.x / x;
		dest.y = this.y / y;
		dest.z = this.z / z;
		return dest;
	}
	public double lengthSquared() {
		return Math.fma(x, x, Math.fma(y, y, z * z));
	}
	public static double lengthSquared(double x, double y, double z) {
		return Math.fma(x, x, Math.fma(y, y, z * z));
	}
	public double length() {
		return Math.sqrt(Math.fma(x, x, Math.fma(y, y, z * z)));
	}
	public static double length(double x, double y, double z) {
		return Math.sqrt(Math.fma(x, x, Math.fma(y, y, z * z)));
	}
	public Vector3d cross(double x, double y, double z) {
		double rx = Math.fma(this.y, z, -this.z * y);
		double ry = Math.fma(this.z, x, -this.x * z);
		double rz = Math.fma(this.x, y, -this.y * x);
		this.x = rx;
		this.y = ry;
		this.z = rz;
		return this;
	}
	public Vector3d cross(double x, double y, double z, Vector3d dest) {
		double rx = Math.fma(this.y, z, -this.z * y);
		double ry = Math.fma(this.z, x, -this.x * z);
		double rz = Math.fma(this.x, y, -this.y * x);
		dest.x = rx;
		dest.y = ry;
		dest.z = rz;
		return dest;
	}
	public double distance(double x, double y, double z) {
		double dx = this.x - x;
		double dy = this.y - y;
		double dz = this.z - z;
		return Math.sqrt(Math.fma(dx, dx, Math.fma(dy, dy, dz * dz)));
	}
	public double distanceSquared(double x, double y, double z) {
		double dx = this.x - x;
		double dy = this.y - y;
		double dz = this.z - z;
		return Math.fma(dx, dx, Math.fma(dy, dy, dz * dz));
	}
	public static double distance(double x1, double y1, double z1, double x2, double y2, double z2) {
		return Math.sqrt(distanceSquared(x1, y1, z1, x2, y2, z2));
	}
	public static double distanceSquared(double x1, double y1, double z1, double x2, double y2, double z2) {
		double dx = x1 - x2;
		double dy = y1 - y2;
		double dz = z1 - z2;
		return Math.fma(dx, dx, Math.fma(dy, dy, dz * dz));
	}
	public double dot(double x, double y, double z) {
		return Math.fma(this.x, x, Math.fma(this.y, y, this.z * z));
	}
	public double angleSigned(double x, double y, double z, double nx, double ny, double nz) {
		return Math.atan2(
				(this.y * z - this.z * y) * nx + (this.z * x - this.x * z) * ny + (this.x * y - this.y * x) * nz,
				this.x * x + this.y * y + this.z * z);
	}
	public Vector3d zero() {
		this.x = 0;
		this.y = 0;
		this.z = 0;
		return this;
	}
	public Vector3d negate() {
		this.x = -x;
		this.y = -y;
		this.z = -z;
		return this;
	}

	public Vector3d negate(Vector3d dest) {
		dest.x = -x;
		dest.y = -y;
		dest.z = -z;
		return dest;
	}
	public Vector3d absolute() {
		this.x = Math.abs(this.x);
		this.y = Math.abs(this.y);
		this.z = Math.abs(this.z);
		return this;
	}
	public Vector3d absolute(Vector3d dest) {
		dest.x = Math.abs(this.x);
		dest.y = Math.abs(this.y);
		dest.z = Math.abs(this.z);
		return dest;
	}
	public Vector3d reflect(double x, double y, double z) {
		double dot = Math.fma(this.x, x, Math.fma(this.y, y, this.z * z));
		this.x = this.x - (dot + dot) * x;
		this.y = this.y - (dot + dot) * y;
		this.z = this.z - (dot + dot) * z;
		return this;
	}
	public Vector3d reflect(double x, double y, double z, Vector3d dest) {
		double dot = Math.fma(this.x, x, Math.fma(this.y, y, this.z * z));
		dest.x = this.x - (dot + dot) * x;
		dest.y = this.y - (dot + dot) * y;
		dest.z = this.z - (dot + dot) * z;
		return dest;
	}
	public Vector3d get(Vector3d dest) {
		dest.x = this.x();
		dest.y = this.y();
		dest.z = this.z();
		return dest;
	}
	public Vector3d floor() {
		this.x = Math.floor(x);
		this.y = Math.floor(y);
		this.z = Math.floor(z);
		return this;
	}
	public Vector3d floor(Vector3d dest) {
		dest.x = Math.floor(x);
		dest.y = Math.floor(y);
		dest.z = Math.floor(z);
		return dest;
	}
	public Vector3d ceil() {
		this.x = Math.ceil(x);
		this.y = Math.ceil(y);
		this.z = Math.ceil(z);
		return this;
	}
	public Vector3d ceil(Vector3d dest) {
		dest.x = Math.ceil(x);
		dest.y = Math.ceil(y);
		dest.z = Math.ceil(z);
		return dest;
	}
	public Vector3d round() {
		this.x = Math.round(x);
		this.y = Math.round(y);
		this.z = Math.round(z);
		return this;
	}
	public Vector3d round(Vector3d dest) {
		dest.x = Math.round(x);
		dest.y = Math.round(y);
		dest.z = Math.round(z);
		return dest;
	}
}