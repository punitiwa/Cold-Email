package com.spring.boot.service;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.ClassPathResource;
import org.springframework.core.io.InputStreamSource;
import org.springframework.mail.MailException;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.spring.boot.EmailTemplate.EmailTemplate;

import Model.User;
import jakarta.mail.MessagingException;
import jakarta.mail.internet.MimeMessage;

@Service
public class ColdEmailService {
	
	private static final Logger logger = LoggerFactory.getLogger(ColdEmailService.class);
	
	@Autowired
	private JavaMailSender javaMailSender;
	
	@Async
	private void sendEmail(User user) throws MailException, MessagingException {
		logger.info("Preparing to send email to: {}", user.getEmail());
		try {
			String to = user.getEmail();
			String subject = "Software Engineer with Expertise in Backend Development and AWS";
			String emailContent = EmailTemplate.getEmailContent()
											.replace("companyName", user.getCompany_name())
											.replace("recruiterName", user.getFirst_name()+" "+user.getLast_name());
			MimeMessage mimeMessage = javaMailSender.createMimeMessage();
			MimeMessageHelper messageHelper = new MimeMessageHelper(mimeMessage, true);
			
			messageHelper.setFrom("Replace this with your name <Replace this with your email>");
			messageHelper.setTo(to); 
			messageHelper.setSubject(subject);
			messageHelper.setText(emailContent, true);
			
			InputStreamSource attachmentSource = new ClassPathResource("Punit_Tiwari_Resume.pdf");
			messageHelper.addAttachment("Punit_Tiwari_Resume.pdf", attachmentSource);

			javaMailSender.send(mimeMessage);
			logger.info("Email sent successfully to: {}", user.getEmail());
		} catch (Exception e) {
			logger.error("Error sending email to: {}", user.getEmail(), e);
		}
	}
	
	@Async
	public void sendEmailToHR(MultipartFile file) {
		logger.info("Started processing file: {}", file.getOriginalFilename());
		try {
			ObjectMapper objectMapper = new ObjectMapper();
			List<User> users = objectMapper.readValue(file.getInputStream(), 
					objectMapper.getTypeFactory().constructCollectionType(List.class, User.class));  // Read and deserialize JSON

	        for (User user : users) {
	        	logger.info("Sending email to user: {} {}", user.getFirst_name(), user.getLast_name());
	        	sendEmail(user);
	        	logger.debug("User details: First Name: {}, Last Name: {}, Email: {}, Company: {}", 
	        		user.getFirst_name(), user.getLast_name(), user.getEmail(), user.getCompany_name());
	        } 	
        } catch (Exception e) {
			logger.error("Error processing file: {}", file.getOriginalFilename(), e);
		}
	}
}
