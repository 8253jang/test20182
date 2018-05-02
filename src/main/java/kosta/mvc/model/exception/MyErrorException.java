package kosta.mvc.model.exception;

public class MyErrorException extends Exception {
  public MyErrorException() {}
  public MyErrorException(String message) {
	  super(message);
  }
}
