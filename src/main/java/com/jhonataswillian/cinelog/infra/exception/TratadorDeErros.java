package com.jhonataswillian.cinelog.infra.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class TratadorDeErros {

    @ExceptionHandler(NotaInvalidaException.class)
    public ResponseEntity<MensagemErro> tratarErro400(NotaInvalidaException ex) {
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(new MensagemErro(ex.getMessage()));
    }

    @ExceptionHandler(FilmeNaoEncontradoException.class)
    public ResponseEntity<MensagemErro> tratarErro404(FilmeNaoEncontradoException ex) {
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(new MensagemErro(ex.getMessage()));
    }

    // Record interno
    public record MensagemErro(String mensagem) {}
}
