package fr.inria.diverse.tools;
public class BusinessException extends Exception { 
    public BusinessException(String errorMessage) {
        super(errorMessage);
    }
}