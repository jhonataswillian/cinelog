package com.jhonataswillian.cinelog.service;

import com.jhonataswillian.cinelog.dto.FilmeRequestDTO;
import com.jhonataswillian.cinelog.dto.FilmeResponseDTO;
import com.jhonataswillian.cinelog.entity.Filme;
import com.jhonataswillian.cinelog.infra.exception.FilmeNaoEncontradoException;
import com.jhonataswillian.cinelog.infra.exception.NotaInvalidaException;
import com.jhonataswillian.cinelog.repository.FilmeRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class FilmeService {

    private final FilmeRepository filmeRepository;

    // CREATE
    @Transactional
    public FilmeResponseDTO cadastrar(FilmeRequestDTO dto) {

        if (dto.nota() < 0 || dto.nota() > 10) {
            throw new NotaInvalidaException("Nota inválida!");
        }

        Filme filme = dto.toEntity();
        filme = filmeRepository.save(filme);
        return FilmeResponseDTO.fromEntity(filme);
    }

    // READ (ALL)
    @Transactional(readOnly = true)
    public List<FilmeResponseDTO> listarTodos() {
        return filmeRepository.findAll()
                .stream()
                .map(FilmeResponseDTO::fromEntity)
                .toList();
    }

    // READ (SPECIFIC)
    @Transactional(readOnly = true)
    public List<FilmeResponseDTO> buscarPorStatus(Boolean assistido) {
        return filmeRepository.findByAssistido(assistido)
                .stream()
                .map(FilmeResponseDTO::fromEntity)
                .toList();
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
    public FilmeResponseDTO atualizar(Long id, FilmeRequestDTO dto) {

        Filme filme = filmeRepository.findById(id)
                .orElseThrow(() -> new FilmeNaoEncontradoException("Filme não encontrado"));

        filme.setTitulo(dto.titulo());
        filme.setGenero(dto.genero());
        filme.setNota(dto.nota());
        filme.setAssistido(dto.assistido());
        filme = filmeRepository.save(filme);

        return FilmeResponseDTO.fromEntity(filme);

    }
}
