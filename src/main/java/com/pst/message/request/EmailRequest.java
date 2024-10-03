package com.pst.message.request;

public class EmailRequest {

	private String toEmail;
	private String subject;
	private String body;

	// No-argument constructor
	public EmailRequest() {
	}

	// Getters and Setters
	public String getToEmail() {
		return toEmail;
	}

	public void setToEmail(String toEmail) {
		this.toEmail = toEmail;
	}

	public String getSubject() {
		return subject;
	}

	public void setSubject(String subject) {
		this.subject = subject;
	}

	public String getBody() {
		return body;
	}

	public void setBody(String body) {
		this.body = body;
	}
}
