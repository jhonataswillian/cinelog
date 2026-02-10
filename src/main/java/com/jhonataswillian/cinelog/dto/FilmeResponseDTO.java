package com.jhonataswillian.cinelog.dto;

import com.jhonataswillian.cinelog.entity.Filme;

public record FilmeResponseDTO(Long id, String titulo, String genero, Double nota, Boolean assistido) {
    public static FilmeResponseDTO fromEntity(Filme filme) {
        return new FilmeResponseDTO(
                filme.getId(),
                filme.getTitulo(),
                filme.getGenero(),
                filme.getNota(),
                filme.getAssistido());
    }
}
