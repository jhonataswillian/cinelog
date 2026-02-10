package com.jhonataswillian.cinelog.service;

import com.jhonataswillian.cinelog.entity.Filme;
import com.jhonataswillian.cinelog.infra.exception.FilmeNaoEncontradoException;
import com.jhonataswillian.cinelog.infra.exception.NotaInvalidaException;
import com.jhonataswillian.cinelog.repository.FilmeRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@RequiredArgsConstructor
public class FilmeService {

    private final FilmeRepository filmeRepository;

    // CREATE
    @Transactional
    public Filme cadastrar(Filme filme) {

        if (filme.getNota() < 0 || filme.getNota() > 10) {
            throw new NotaInvalidaException("Nota inválida!");
        }

        return filmeRepository.save(filme);
    }

    // READ (ALL)
    @Transactional(readOnly = true)
    public List<Filme> listarTodos() {
        return filmeRepository.findAll();
    }

    // READ (SPECIFIC)
    @Transactional(readOnly = true)
    public List<Filme> buscarPorStatus(Boolean assistido) {
        return filmeRepository.findByAssistido(assistido);
    }

    // DELETE
    @Transactional
    public void excluir(Long id) {

        if (!filmeRepository.existsById(id)) {
            throw new FilmeNaoEncontradoException("Filme não encontrado!");
        }

        filmeRepository.deleteById(id);
    }

    // UPDATE
    @Transactional
    public Filme atualizar(Long id, Filme filmeAtualizado) {

        Filme filme = filmeRepository.findById(id)
                .orElseThrow(() -> new FilmeNaoEncontradoException("Filme não encontrado"));

        filme.setTitulo(filmeAtualizado.getTitulo());
        filme.setGenero(filmeAtualizado.getGenero());
        filme.setNota(filmeAtualizado.getNota());
        filme.setAssistido(filmeAtualizado.getAssistido());

        return filmeRepository.save(filme);

    }
}
