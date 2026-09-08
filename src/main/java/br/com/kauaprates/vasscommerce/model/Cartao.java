package br.com.kauaprates.vasscommerce.model;

import java.time.LocalDateTime;

public class Cartao {

    private Long id;
    private LocalDateTime dataCriacao;
    private boolean excluido;
    private TipoCartao tipo;
    private Long idCliente;

    public Cartao(Long id, LocalDateTime dataCriacao, boolean excluido,
                  TipoCartao tipo, Long idCliente) {
        this.id = id;
        this.dataCriacao = dataCriacao;
        this.excluido = excluido;
        this.tipo = tipo;
        this.idCliente = idCliente;
    }

    public Long getId() {
        return id;
    }

    public LocalDateTime getDataCriacao() {
        return dataCriacao;
    }

    public boolean isExcluido() {
        return excluido;
    }

    public TipoCartao getTipo() {
        return tipo;
    }

    public Long getIdCliente() {
        return idCliente;
    }
}