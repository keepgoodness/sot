package org.sot.exceptions;

import com.mysql.jdbc.CommunicationsException;
import java.net.ConnectException;
import java.util.Arrays;
import javax.servlet.http.HttpServletRequest;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.sot.interceptors.LoggerInterceptor;
import org.sot.services.EmailService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.transaction.CannotCreateTransactionException;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

/**
 *
 * @author Jordan
 */
@ControllerAdvice
public class GlobalControllerExceptionHandler {

	private final EmailService emailService;
	private final String MAIL_TO_SEND = "yordanlazarov83@gmail.com";

	@Autowired
	public GlobalControllerExceptionHandler(EmailService emailService) {
		this.emailService = emailService;
	}

	private static Logger log = LoggerFactory.getLogger(GlobalControllerExceptionHandler.class);

	@ExceptionHandler(Exception.class)
	public String getException(HttpServletRequest req, Model model, Exception ex) {
//		String newLine = System.lineSeparator();
//		String text = "Request: " + req.getRequestURI() + ", Raised: " + ex;
//
//		StringBuilder stackTrace = new StringBuilder();
//		StackTraceElement[] stackTraceArray = ex.getStackTrace();
//		Arrays.stream(stackTraceArray).forEach(e -> {
//			stackTrace.append(e).append(newLine);
//		});
//
//		String textToMail = "Request: " + req.getRequestURI() + newLine + newLine
//				+ "StackTrace:" + newLine + stackTrace;
//
//		emailService.sendEmailMessage(MAIL_TO_SEND, "Грешка", textToMail);
//		log.info(text + newLine + "#START Mail sended text: " + newLine + textToMail + newLine + "#END Mail sended text");

		model.addAttribute("msg", "Грешка!");
		return "error";
	}

}
