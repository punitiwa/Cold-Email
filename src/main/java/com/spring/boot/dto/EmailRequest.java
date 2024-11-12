package com.spring.boot.dto;

import org.springframework.web.multipart.MultipartFile;

public class EmailRequest {
	
	private MultipartFile file;
    private String fileName;
	
    public MultipartFile getFile() {
		return file;
	}
	public void setFile(MultipartFile file) {
		this.file = file;
	}
	public String getFileName() {
		return fileName;
	}
	public void setFileName(String fileName) {
		this.fileName = fileName;
	}


    
}
