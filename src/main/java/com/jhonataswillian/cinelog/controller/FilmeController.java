package com.jhonataswillian.cinelog.controller;

import com.jhonataswillian.cinelog.entity.Filme;
import com.jhonataswillian.cinelog.service.FilmeService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/filmes")
public class FilmeController {

    private final FilmeService filmeService;

    public FilmeController(FilmeService filmeService) {
        this.filmeService = filmeService;
    }

    @PostMapping("/cadastrar")
    public Filme cadastrar(@RequestBody Filme filme) {
        return filmeService.cadastrar(filme);
    }

    @GetMapping
    public List<Filme> listar() {
        return filmeService.listarTodos();
    }
}
