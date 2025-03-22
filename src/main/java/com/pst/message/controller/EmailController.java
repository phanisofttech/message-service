package com.pst.message.controller;

import com.pst.message.request.EmailRequest;
import com.pst.message.service.EmailService;
import jakarta.mail.MessagingException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/email")
public class EmailController {

	@Autowired
	private EmailService emailService;

	@PostMapping
	public ResponseEntity<String> sendEMail(@RequestBody EmailRequest emailRequest) {
		try {
			emailService.sendEmail(emailRequest);
			return ResponseEntity.ok("✅ Email sent successfully to: " + emailRequest.getToEmail());
		} catch (MessagingException e) {
			System.err.println("❌ Error while sending email: " + e.getMessage());
			return ResponseEntity.status(500).body("❌ Failed to send email: " + e.getMessage());
		} catch (IllegalArgumentException e) {
			return ResponseEntity.badRequest().body("❌ Invalid email request: " + e.getMessage());
		}
	}
}
