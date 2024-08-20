package br.com.gravarImagem.ApiGravarImagem.service;

import java.io.IOException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import br.com.gravarImagem.ApiGravarImagem.model.Image;
import br.com.gravarImagem.ApiGravarImagem.repository.ImageRepository;

@Service
public class ImageService {

	@Autowired
	private ImageRepository imageRepository;

	public List<Image> buscarTudo() {
		return imageRepository.findAll();
	}
	
	public Image saveImage(MultipartFile file) throws IOException {
		
    	Image image = new Image();
        image.setName(file.getOriginalFilename());
        image.setType(file.getContentType());
        image.setData(file.getBytes());
        return imageRepository.save(image);
    }

}
