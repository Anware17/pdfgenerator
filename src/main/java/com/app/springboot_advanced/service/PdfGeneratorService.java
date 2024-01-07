package com.app.springboot_advanced.service;

import java.io.ByteArrayOutputStream;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.thymeleaf.context.Context;
import org.thymeleaf.spring5.SpringTemplateEngine;


@Service
public class PdfGeneratorService {

	@Autowired
	SpringTemplateEngine springTemplateEngine;
	
	public ByteArrayOutputStream createPdf(String title) {
		return HtmlToPdfService.createPdfItext(renderHtmlForPdf(title));
		
	}
	
	
	public String renderHtmlForPdf (String title) {
		Context context = new Context();
		context.setVariable("title",title);
		String javaImageBase64 = ImageUtils.convertImageToBase64("pdf/images/ok.png");
		context.setVariable("ok", javaImageBase64);

		//context.setVariable("Java", ImageUtils.convertImageToBase64("pdf/images/Java.png"));
		
		SimpleDateFormat dateFormat = new SimpleDateFormat("dd.MM.yyyy HH:mm:ss");
		context.setVariable("today",dateFormat.format(new Date()));
		
		return springTemplateEngine.process("pdf/confirmation.html",context);
		
	}
	
	
}
