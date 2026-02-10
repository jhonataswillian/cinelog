package com.jhonataswillian.cinelog.dto;

import com.jhonataswillian.cinelog.entity.Filme;

public record FilmeRequestDTO(
        String titulo,
        String genero,
        Double nota,
        Boolean assistido
) {

    public Filme toEntity() {
        Filme filme = new Filme();
        filme.setTitulo(this.titulo);
        filme.setGenero(this.genero);
        filme.setNota(this.nota);
        filme.setAssistido(this.assistido);
        return filme;
    }
}
