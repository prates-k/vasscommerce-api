package br.com.kauaprates.vasscommerce.model;

import java.math.BigDecimal;
import java.time.LocalDateTime;

public class Pedido {

    private Long id;
    private LocalDateTime dataCadastro;
    private BigDecimal valorTotal;
    private PedidoStatus statusAtual;
    private Long idCliente;

    public Pedido(Long id, LocalDateTime dataCadastro, BigDecimal valorTotal,
                  PedidoStatus statusAtual, Long idCliente) {
        this.id = id;
        this.dataCadastro = dataCadastro;
        this.valorTotal = valorTotal;
        this.statusAtual = statusAtual;
        this.idCliente = idCliente;
    }

    public Long getId() {
        return id;
    }

    public LocalDateTime getDataCadastro() {
        return dataCadastro;
    }

    public BigDecimal getValorTotal() {
        return valorTotal;
    }

    public PedidoStatus getStatusAtual() {
        return statusAtual;
    }

    public Long getIdCliente() {
        return idCliente;
    }
}