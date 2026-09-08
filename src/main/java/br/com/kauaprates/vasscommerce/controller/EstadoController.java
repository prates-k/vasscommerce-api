package br.com.kauaprates.vasscommerce.controller;

import br.com.kauaprates.vasscommerce.model.Cidade;
import br.com.kauaprates.vasscommerce.model.Estado;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping(path = "/estado", produces = "application/json")
public class EstadoController {

    private final List<Estado> estados = new ArrayList<>();
    private final List<Cidade> cidades = new ArrayList<>();

    public EstadoController() {
        estados.add(new Estado(1L, "RJ", "Rio de Janeiro"));
        estados.add(new Estado(2L, "SP", "São Paulo"));
        estados.add(new Estado(3L, "MG", "Minas Gerais"));

        cidades.add(new Cidade(1L, "Vassouras", 1L));
        cidades.add(new Cidade(2L, "Rio de Janeiro", 1L));
        cidades.add(new Cidade(3L, "São Paulo", 2L));
        cidades.add(new Cidade(4L, "Campinas", 2L));
        cidades.add(new Cidade(5L, "Belo Horizonte", 3L));
    }

    @GetMapping
    public ResponseEntity<List<Estado>> listar() {
        return ResponseEntity.ok(estados);
    }

    @GetMapping("/{idestado}/cidade")
    public ResponseEntity<List<Cidade>> listarCidades(@PathVariable Long idestado) {
        List<Cidade> cidadesDoEstado = new ArrayList<>();

        for (Cidade cidade : cidades) {
            if (cidade.getIdEstado().equals(idestado)) {
                cidadesDoEstado.add(cidade);
            }
        }

        return ResponseEntity.ok(cidadesDoEstado);
    }
}