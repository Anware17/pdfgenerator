package com.app.springboot_advanced.service;

import java.io.ByteArrayOutputStream;
import java.io.IOException;

import org.xhtmlrenderer.pdf.ITextRenderer;

import com.itextpdf.text.DocumentException;

public class HtmlToPdfService {
	
	public static ByteArrayOutputStream createPdfItext(String html ) {
		ITextRenderer renderer = new ITextRenderer();
		renderer.setDocumentFromString(html);
		renderer.layout();
		
		ByteArrayOutputStream fs = new ByteArrayOutputStream();
		try {
			renderer.createPDF(fs);
		} catch (DocumentException e) {
			throw new RuntimeException(e);
			
		} catch (IOException e) {
			throw new RuntimeException(e);
		}
		
	return fs	;
	}

	
}
