package com.jhonataswillian.cinelog.service;

import com.jhonataswillian.cinelog.entity.Filme;
import com.jhonataswillian.cinelog.infra.exception.NotaInvalidaException;
import com.jhonataswillian.cinelog.repository.FilmeRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class FilmeService {

    private final FilmeRepository filmeRepository;

    public FilmeService(FilmeRepository filmeRepository) {
        this.filmeRepository = filmeRepository;
    }

    @Transactional
    public Filme cadastrar(Filme filme) {

        if (filme.getNota() < 0 || filme.getNota() > 10) {
            throw new NotaInvalidaException("Nota inválida!");
        }

        return filmeRepository.save(filme);
    }

    public List<Filme> listarTodos() {
        return filmeRepository.findAll();
    }

    public List<Filme> buscarPorStatus(Boolean assistido) {
        return filmeRepository.findByAssistido(assistido);
    }
}
