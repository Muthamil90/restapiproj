package com.simple.controllers;

import java.io.IOException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.simple.service.LocalImage;

@RestController
public class ImageController {

	@Autowired
	LocalImage localImg;

	@RequestMapping(value = "/getImage", produces = MediaType.IMAGE_JPEG_VALUE)
	public byte[] getImage() {
		byte[] image = null;
		try {
			image = localImg.DownloadImage();
		} catch (IOException e) {
			e.printStackTrace();
		}

		return image;
	}
}
