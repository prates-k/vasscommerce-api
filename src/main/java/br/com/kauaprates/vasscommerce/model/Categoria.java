package br.com.kauaprates.vasscommerce.model;

public class Categoria {
    private Long id;
    private String imagemSimboloUrl;
    private String nome;
    private String descricao;

    public Categoria(Long id, String imagemSimboloUrl, String nome, String descricao) {
        this.id = id;
        this.imagemSimboloUrl = imagemSimboloUrl;
        this.nome = nome;
        this.descricao = descricao;
    }

    public Long getId() {
        return id;
    }

    public String getImagemSimboloUrl() {
        return imagemSimboloUrl;
    }

    public String getNome() {
        return nome;
    }

    public String getDescricao() {
        return descricao;
    }
}
