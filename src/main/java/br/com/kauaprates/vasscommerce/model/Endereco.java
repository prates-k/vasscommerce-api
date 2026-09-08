package br.com.kauaprates.vasscommerce.model;

import java.time.LocalDateTime;

public class Endereco {

    private Long id;
    private String rua;
    private int numero;
    private String cep;
    private String complemento;
    private String telefone;
    private String bairro;
    private LocalDateTime dataCadastro;
    private LocalDateTime dataUltimaAtualizacao;
    private Long idCliente;
    private Long idCidade;

    public Endereco(Long id, String rua, int numero, String cep, String complemento,
                    String telefone, String bairro,
                    LocalDateTime dataCadastro, LocalDateTime dataUltimaAtualizacao,
                    Long idCliente, Long idCidade) {
        this.id = id;
        this.rua = rua;
        this.numero = numero;
        this.cep = cep;
        this.complemento = complemento;
        this.telefone = telefone;
        this.bairro = bairro;
        this.dataCadastro = dataCadastro;
        this.dataUltimaAtualizacao = dataUltimaAtualizacao;
        this.idCliente = idCliente;
        this.idCidade = idCidade;
    }

    public Long getId() {
        return id;
    }

    public String getRua() {
        return rua;
    }

    public int getNumero() {
        return numero;
    }

    public String getCep() {
        return cep;
    }

    public String getComplemento() {
        return complemento;
    }

    public String getTelefone() {
        return telefone;
    }

    public String getBairro() {
        return bairro;
    }

    public LocalDateTime getDataCadastro() {
        return dataCadastro;
    }

    public LocalDateTime getDataUltimaAtualizacao() {
        return dataUltimaAtualizacao;
    }

    public Long getIdCliente() {
        return idCliente;
    }

    public Long getIdCidade() {
        return idCidade;
    }
}
