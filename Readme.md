# Cold Email Project

## Overview
The **Cold Email Project** is designed to streamline the process of sending mass emails effortlessly. This project includes a script that automates the email-sending process when you upload a JSON file containing user details. This is particularly useful for HR teams, recruiters, businesses or someone who is looking for a job and want to send out personalized emails in bulk.

## Features
- **Automated Email Sending**: Upload a JSON file, and the script will handle sending emails to all recipients.
- **Customizable Email Templates**: Personalize your email template for each recipient.
- **Simple Integration**: Easily configure the sender email and application properties.

## Prerequisites
- **Java 17**
- **Maven**
- **Spring Boot Framework**

## Project Setup Guide

### Step 1. Download the Project
- Clone the repository or download the ZIP file:
  ```bash
  git clone https://github.com/yourusername/cold-email-project.git
  cd cold-email-project


### Step 2: Configure `application.properties`
- Open the `src/main/resources/application.properties` file.
- Replace the following placeholder values with your own email credentials:
 ```bash
  spring.mail.username=your-email@example.com
  spring.mail.password=your-generated-password
```
- Use this link to know how to generate the app passowrd: https://stackoverflow.com/questions/60701936/error-invalid-login-application-specific-password-required


### Step 3: Update the `ColdEmailService` Class
- Locate the `ColdEmailService` class in `src/main/java/com/spring/boot/service/ColdEmailService.java`.
- Modify the `messageHelper.setFrom()` line to reflect your name and email:
  ```java
  messageHelper.setFrom("Your Name <your-email@example.com>");



### Step 4: Run the Project


### Step 5: Upload the JSON File
- Use Postman or any API client to upload the JSON file.
- Send a `POST` request to: http://localhost:8080/send-mail

- Ensure the file is uploaded as `form-data` with the key `file`.


### Step 6: Confirm Email Sent
- Once the JSON file is uploaded, the emails will be sent to all the recipients listed in the file.
- Check the logs for confirmation and any potential errors.



## Adding Your Resume to the ColdEmailService

To include your resume as an attachment in the `ColdEmailService`:

1. Place your resume file (`YourName_Resume.pdf`) in the `src/main/resources` directory.
2. Modify the `sendEmail` function in `ColdEmailService.java` as follows:

```java
import org.springframework.core.io.ClassPathResource;
import org.springframework.core.io.InputStreamSource;

// Inside ColdEmailService.java
public void sendEmail() {
    // Update the file name to match your resume file
    InputStreamSource attachmentSource = new ClassPathResource("YourName_Resume.pdf");
    // Additional code for sending the email...
}
```

### JSON Structure Example:
```json
[
{
  "first_name": "John",
  "last_name": "Doe",
  "email": "john.doe@example.com",
  "company_name": "Example Corp"
},
{
  "first_name": "Jane",
  "last_name": "Smith",
  "email": "jane.smith@example.com",
  "company_name": "Innovate Ltd"
}
]




