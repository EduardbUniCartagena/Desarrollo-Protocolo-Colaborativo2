package main.java.domain.excepciones;

public class DomainException extends RuntimeException {
    public DomainException(String message) {
        super(message);
    }
}