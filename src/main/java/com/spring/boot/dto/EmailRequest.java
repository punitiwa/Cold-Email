package com.spring.boot.dto;

import org.springframework.web.multipart.MultipartFile;

public class EmailRequest {
	
	private MultipartFile file;
	
    public MultipartFile getFile() {
		return file;
	}
	public void setFile(MultipartFile file) {
		this.file = file;
	}


    
}
