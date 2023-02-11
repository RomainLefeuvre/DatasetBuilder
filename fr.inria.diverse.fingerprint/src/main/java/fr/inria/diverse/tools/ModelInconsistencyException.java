package fr.inria.diverse.tools;

public class ModelInconsistencyException extends RuntimeException {
	public ModelInconsistencyException(String errorMessage) {
		super(errorMessage);
	}

	public static class OriginModelInconsistencyException extends ModelInconsistencyException {
		public OriginModelInconsistencyException(String errorMessage) {
			super(errorMessage);
		}
	}
}