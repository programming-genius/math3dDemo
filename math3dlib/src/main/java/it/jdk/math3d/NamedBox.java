package it.jdk.math3d;

public class NamedBox extends Box {

	private String alias;
	
	public NamedBox(String alias) {
		this.alias = alias;
	}
	
	@Override
	public String alias() {
		return alias;
	}

}
