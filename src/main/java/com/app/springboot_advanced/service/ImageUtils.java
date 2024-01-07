package com.app.springboot_advanced.service;

import java.io.IOException;
import java.net.URL;
import java.util.Base64;

import org.apache.commons.io.IOUtils;

public class ImageUtils {
	
	public static String BASE64_IMAGE_JPEG = "jpeg";
	public static String BASE64_IMAGE_PNG = "png";
	public static String BASE64_IMAGE_GIF = "gif";
	
	
	public static String convertImageToBase64(String imagePath) {
		String imageFormat = BASE64_IMAGE_JPEG;
		
		if (imagePath.toLowerCase().endsWith(".png")) {
			imageFormat = BASE64_IMAGE_PNG;
		} else if (imagePath.toLowerCase().endsWith(".gif"))  {
			imageFormat = BASE64_IMAGE_GIF;
		}
		
		return convertImageToBase64(imagePath,imageFormat);
	}
	
	public static String convertImageToBase64(String imagePath, String imageFormat) {
	    URL fr=ImageUtils.class.getResource("/templates/"+imagePath);
	    //URL fr = ImageUtils.class.getResource("/pdf/images/" + imagePath);
	    System.out.println("Image URL: " + fr);

	    byte[] b = new byte[0];
	    try {
	    	b=IOUtils.toByteArray(fr.openStream());
	    } catch (IOException e ) {
	    	e.printStackTrace();
	    	
	    }
	    String imgBase64=Base64.getEncoder().encodeToString(b);
	       return "data:image/" + imageFormat + ";base64," + imgBase64;

	    }
	}
