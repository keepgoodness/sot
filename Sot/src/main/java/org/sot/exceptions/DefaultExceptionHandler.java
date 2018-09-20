//package org.sot.exceptions;
//
//import org.springframework.http.HttpHeaders;
//import org.springframework.http.HttpStatus;
//import org.springframework.http.ResponseEntity;
//import org.springframework.orm.jpa.JpaSystemException;
//import org.springframework.web.bind.annotation.ControllerAdvice;
//import org.springframework.web.bind.annotation.ExceptionHandler;
//import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;
//
///**
// *
// * @author Jordan
// */
//@ControllerAdvice
//public class DefaultExceptionHandler extends ResponseEntityExceptionHandler {
//
//	@ExceptionHandler(Exception.class)
//	public final ResponseEntity<ErrorMessage> exceptionWenghtWrong(Exception ex) {
//		System.out.println(ex);
//		ErrorMessage exceptionRespone = new ErrorMessage(ex.getMessage(), "Kavi brat");
//		return new ResponseEntity<ErrorMessage>(exceptionRespone, new HttpHeaders(), HttpStatus.INTERNAL_SERVER_ERROR);
//	}
//	@ExceptionHandler(JpaSystemException.class)
//	public final ResponseEntity<ErrorMessage> jpaWenghtWrong(JpaSystemException jpaEx) {
//		System.out.println("jpaEx:" + jpaEx);
//		ErrorMessage exceptionRespone = new ErrorMessage("Jpa", "Има проблем!");
//		return new ResponseEntity<ErrorMessage>(exceptionRespone, new HttpHeaders(), HttpStatus.INTERNAL_SERVER_ERROR);
//	}
//
//}
//
//class ErrorMessage {
//
//	private String message;
//	private String details;
//
//	public ErrorMessage(String message, String details) {
//		this.message = message;
//		this.details = details;
//	}
//
//	public String getMessage() {
//		return message;
//	}
//
//	public void setMessage(String message) {
//		this.message = message;
//	}
//
//	public String getDetails() {
//		return details;
//	}
//
//	public void setDetails(String details) {
//		this.details = details;
//	}
//
//}
