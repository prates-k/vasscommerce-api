package br.com.kauaprates.vasscommerce.model;

import java.time.LocalDate;
import java.time.LocalDateTime;

public class Cliente {
    private Long id;
    private String nomeCompleto;
    private String email;
    private String senha;
    private String fotoUrl;
    private LocalDate dataNascimento;
    private String cpf;
    private LocalDateTime dataCadastro;
    private LocalDateTime dataUltimaAtualizacao;

    public Cliente(Long id, String nomeCompleto, String email, String senha, String fotoUrl,
                   LocalDate dataNascimento, String cpf, LocalDateTime dataCadastro,
                   LocalDateTime dataUltimaAtualizacao) {
        this.id = id;
        this.nomeCompleto = nomeCompleto;
        this.email = email;
        this.senha = senha;
        this.fotoUrl = fotoUrl;
        this.dataNascimento = dataNascimento;
        this.cpf = cpf;
        this.dataCadastro = dataCadastro;
        this.dataUltimaAtualizacao = dataUltimaAtualizacao;
    }

    public Long getId() {
        return id;
    }

    public String getNomeCompleto() {
        return nomeCompleto;
    }

    public String getEmail() {
        return email;
    }

    public String getSenha() {
        return senha;
    }

    public String getFotoUrl() {
        return fotoUrl;
    }

    public LocalDate getDataNascimento() {
        return dataNascimento;
    }

    public String getCpf() {
        return cpf;
    }

    public LocalDateTime getDataCadastro() {
        return dataCadastro;
    }

    public LocalDateTime getDataUltimaAtualizacao() {
        return dataUltimaAtualizacao;
    }
}
