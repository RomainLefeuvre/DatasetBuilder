package fr.inria.diverse.tools;

public class ModelInconsistencyException extends RuntimeException { 
    public ModelInconsistencyException(String errorMessage) {
        super(errorMessage);
    }
}