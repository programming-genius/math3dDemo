package it.jdk.test;

public class MyTriangolo extends Triangolo {

	public Integer area(Integer b, Integer h) throws MyNewException {
		System.out.println("Sono nella sottoclasse");
		try {
			Number number = super.area(b, h);
			return number.intValue();
		} catch (MyException e) {
			throw new MyNewException();
		}
	}

}
