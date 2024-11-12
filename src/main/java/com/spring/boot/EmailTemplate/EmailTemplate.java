package com.spring.boot.EmailTemplate;

public class EmailTemplate {
	private static String emailContent = "Hi recruiterName,<br>"
			+ "<br>"
			+ "I hope this message finds you well. I am reaching out to explore software engineering opportunities at "
			+ "companyName, as I believe my experience in backend development, AWS integration, and system scalability aligns with "
			+ "the impactful work your team is known for.<br>"
			+ "<br>"
			+ "In my current role at Livegage, I lead backend development efforts, implementing scalable solutions for "
			+ "complex data-driven projects. "
			+ "Recently, I enhanced PDF processing efficiency by <strong>50% through multithreading </strong> and optimized "
			+ "cross-account data transfers "
			+ "using Amazon S3. "
			+ "This role has allowed me to hone my skills in cloud architecture, and I have configured components such as <b>AWS Cognito, "
			+ "API Gateway, and S3</b> to bolster reliability and security across applications.<br>"
			+ "<br>"
			+ "I am proficient in Python, Java, and key AWS services, with additional experience in database optimization and "
			+ "low-level design. I am confident that my strong technical skills, combined with my commitment to clean, maintainable code, "
			+ "make me a valuable asset to your team.<br>"
			+ "<br>"
			+ "If you’re open to a conversation, I would love the opportunity to discuss how my background and skills can support "
			+ "companyName objectives. Thank you for your consideration.<br>"
			+ "<br>"
			+ "Best regards,<br>"
			+ "Punit Tiwari<br><br>"
			+ "Email: punit.tiwari1416@gmail.com <br> "
			+ "Mobile No: 8305026801 <br> "
			+ "LinkedIn: https://www.linkedin.com/in/punit--tiwari/";

	
	public static String getEmailContent() {
		return emailContent;
	}
}
