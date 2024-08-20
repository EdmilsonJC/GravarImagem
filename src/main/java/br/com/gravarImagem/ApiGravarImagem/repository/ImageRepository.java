package br.com.gravarImagem.ApiGravarImagem.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.gravarImagem.ApiGravarImagem.model.Image;

public interface ImageRepository extends JpaRepository<Image, Long>{

}
