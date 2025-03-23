package com.pst.message.service;

import com.pst.message.request.EmailRequest;
import jakarta.mail.MessagingException;
import jakarta.mail.internet.MimeMessage;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Service;

@Service
public class EmailService {

	@Autowired
	private JavaMailSender mailSender;

	public void sendEmail(EmailRequest emailRequest) throws MessagingException {
		// Validate email address
		if (emailRequest.getToEmail() == null || emailRequest.getToEmail().isEmpty()) {
			throw new IllegalArgumentException("Recipient email is missing!");
		}

		// Create a new MIME message
		MimeMessage message = mailSender.createMimeMessage();
		MimeMessageHelper helper = new MimeMessageHelper(message, true, "UTF-8");

		// Set email properties
		helper.setTo(emailRequest.getToEmail());
		helper.setSubject(emailRequest.getSubject());
		helper.setFrom("skysolutions.sky@gmail.com"); // Change if needed
		helper.setText(emailRequest.getBody(), true); // Enable HTML content

		// Send email
		mailSender.send(message);
	}
}