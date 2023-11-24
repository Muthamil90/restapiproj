package com.simple.service;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;

import org.springframework.stereotype.Service;

@Service
public class LocalImage {
	public byte[] DownloadImage() throws IOException {

		FileInputStream fis = new FileInputStream(new File("<inputFilePaht>/Test.jpg"));
		byte[] fileData = fis.readAllBytes();
		fis.close();
		return fileData;
	}
}
