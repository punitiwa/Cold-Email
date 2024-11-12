package com.spring.boot.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;
import com.spring.boot.dto.EmailRequest;
import com.spring.boot.service.ColdEmailService;

@RestController
public class ColdEmailController {
	
	private static final Logger logger = LoggerFactory.getLogger(ColdEmailController.class);
	
	@Autowired
	private final ColdEmailService coldEmailService;
	
	public ColdEmailController(ColdEmailService coldEmailService) {
		this.coldEmailService = coldEmailService;
	}
	
	@PostMapping("/send-mail")
	public ResponseEntity<String> sendEmail(@ModelAttribute EmailRequest emailRequest) {
		logger.info("Received request to send emails with file: {}", emailRequest.getFileName());

		if (emailRequest.getFile().isEmpty()) {
			logger.warn("File is empty, please upload a valid JSON file.");
            return ResponseEntity.badRequest().body("Please upload a JSON file.");
        }

        try {
            coldEmailService.sendEmailToHR(emailRequest.getFile());
            logger.info("Email sending process started successfully for file: {}", emailRequest.getFileName());
            return ResponseEntity.ok("Emails are being sent successfully.");
        } catch (Exception e) {
            logger.error("Error processing file: {}", emailRequest.getFileName(), e);
            return ResponseEntity.status(500).body("An error occurred while sending emails.");
        }
	}
}
