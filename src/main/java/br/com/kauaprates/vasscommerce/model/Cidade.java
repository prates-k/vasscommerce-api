package br.com.kauaprates.vasscommerce.model;

public class Cidade {
    private Long id;
    private String nome;
    private Long idEstado;

    public Cidade(Long id, String nome, Long idEstado) {
        this.id = id;
        this.nome = nome;
        this.idEstado = idEstado;
    }

    public Long getId() {
        return id;
    }

    public String getNome() {
        return nome;
    }

    public Long getIdEstado() {
        return idEstado;
    }
}
