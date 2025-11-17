package it.jdk.test;

public class Triangolo {

	public Number area(Integer b, Integer h) throws MyException {
		System.out.println("Sono nella superclasse");
		if (b == null || h == null)
			throw new MyException();
		return b * h;
	}
}
