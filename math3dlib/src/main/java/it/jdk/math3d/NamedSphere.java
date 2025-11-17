package it.jdk.math3d;

public class NamedSphere extends Sphere {

	private String alias;
	
	public NamedSphere(String alias) {
		this.alias = alias;
	}

	@Override
	public String alias() {
		return alias;
	}
}
