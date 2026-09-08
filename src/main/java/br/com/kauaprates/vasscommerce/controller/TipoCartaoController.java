package br.com.kauaprates.vasscommerce.controller;

import br.com.kauaprates.vasscommerce.model.TipoCartao;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(path= "/tipo-cartao", produces = "application/json")
public class TipoCartaoController {

    @GetMapping
    public ResponseEntity<TipoCartao[]> listar() {
        return ResponseEntity.ok(TipoCartao.values());
    }
}