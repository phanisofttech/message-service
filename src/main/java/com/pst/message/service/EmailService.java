package com.pst.message.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;

import com.pst.message.request.EmailRequest;

@Service
public class EmailService {

	@Autowired
	private JavaMailSender mailSender;

	public void sendSimpleEmail(EmailRequest emailRequest) {
		// Null checks (optional)
		if (emailRequest.getToEmail() == null || emailRequest.getToEmail().isEmpty()) {
			throw new IllegalArgumentException("Recipient email is missing!");
		}

		SimpleMailMessage message = new SimpleMailMessage();
		message.setTo(emailRequest.getToEmail());
		message.setSubject(emailRequest.getSubject());
		message.setText(emailRequest.getBody());
		message.setFrom("skysolutions.sky@gmail.com");

		try {
			mailSender.send(message);
		} catch (Exception e) {
			throw new RuntimeException("Failed to send email", e);
		}
	}
}
