package br.com.gravarImagem.ApiGravarImagem.controller;

import java.io.IOException;
//import java.net.MalformedURLException;
//import java.nio.file.Files;
//import java.nio.file.Path;
//import java.nio.file.Paths;
//import java.nio.file.StandardCopyOption;


import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.core.io.Resource;
//import org.springframework.core.io.UrlResource;
import org.springframework.http.HttpStatus;
//import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
//import org.springframework.web.bind.annotation.DeleteMapping;
//import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
//import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import br.com.gravarImagem.ApiGravarImagem.service.ImageService;
//import jakarta.annotation.Resource;
//import jakarta.persistence.criteria.Path;

@RestController
@RequestMapping("/images")
public class ImageController {
	

	@Autowired
	private ImageService imageService;
	 
	 

	@PostMapping("/upload")
	public ResponseEntity<String> uploadImage(@RequestParam("file") MultipartFile file) {
		if (file.isEmpty()) {
			
			//System.out.println("CAiu no 400");
			return new ResponseEntity<>("No file selected", HttpStatus.BAD_REQUEST);
		}
		try {
			//System.out.println("CAiu no boam");
			imageService.saveImage(file);
			return new ResponseEntity<>("Imagem foi gravada com successo", HttpStatus.OK);
		} catch (IOException e) {
			return new ResponseEntity<>("ERRO! Falha na gravação da imagem", HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}	
	 
}
