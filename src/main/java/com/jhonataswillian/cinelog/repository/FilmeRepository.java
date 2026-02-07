package com.jhonataswillian.cinelog.repository;

import com.jhonataswillian.cinelog.entity.Filme;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface FilmeRepository extends JpaRepository<Filme, Long> {
    List<Filme> findByAssistido(Boolean assistido);
}
