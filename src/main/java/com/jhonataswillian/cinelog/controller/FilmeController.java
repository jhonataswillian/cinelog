package com.jhonataswillian.cinelog.controller;

import com.jhonataswillian.cinelog.dto.FilmeRequestDTO;
import com.jhonataswillian.cinelog.dto.FilmeResponseDTO;
import com.jhonataswillian.cinelog.entity.Filme;
import com.jhonataswillian.cinelog.service.FilmeService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/filmes")
@RequiredArgsConstructor
public class FilmeController {

    private final FilmeService filmeService;

    @PostMapping
    public FilmeResponseDTO cadastrar(@RequestBody FilmeRequestDTO filme) {
        return filmeService.cadastrar(filme);
    }

    @GetMapping
    public List<FilmeResponseDTO> listar() {
        return filmeService.listarTodos();
    }

    @DeleteMapping("/{id}")
    public void excluir(@PathVariable Long id) {
        filmeService.excluir(id);
    }

    @PutMapping("/{id}")
    public FilmeResponseDTO atualizar(@PathVariable Long id, @RequestBody FilmeRequestDTO filme) {
        return filmeService.atualizar(id, filme);
    }
}
