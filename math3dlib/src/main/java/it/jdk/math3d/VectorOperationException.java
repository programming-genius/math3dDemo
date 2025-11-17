package it.jdk.math3d;

public class VectorOperationException extends Exception {

	private static final long serialVersionUID = 8460096879223136490L;

	public VectorOperationException(String message) {
		super(message);
	}

	public VectorOperationException(Throwable cause) {
		super(cause);
	}

	public VectorOperationException(String message, Throwable cause) {
		super(message, cause);
	}

	public VectorOperationException(String message, Throwable cause, boolean enableSuppression,
			boolean writableStackTrace) {
		super(message, cause, enableSuppression, writableStackTrace);
	}

}
