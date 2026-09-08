package br.com.kauaprates.vasscommerce.controller;

import br.com.kauaprates.vasscommerce.model.Cartao;
import br.com.kauaprates.vasscommerce.model.Cliente;
import br.com.kauaprates.vasscommerce.model.Endereco;
import br.com.kauaprates.vasscommerce.model.Pedido;
import br.com.kauaprates.vasscommerce.model.PedidoStatus;
import br.com.kauaprates.vasscommerce.model.TipoCartao;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping(path = "/cliente", produces = "application/json")
public class ClienteController {

    private final List<Cliente> clientes = new ArrayList<>();
    private final List<Cartao> cartoes = new ArrayList<>();
    private final List<Endereco> enderecos = new ArrayList<>();
    private final List<Pedido> pedidos = new ArrayList<>();

    public ClienteController() {
        clientes.add(new Cliente(
                1L,
                "João Silva",
                "joao@email.com",
                "123456",
                "foto_joao.png",
                LocalDate.of(1995, 5, 20),
                "123.456.789-00",
                LocalDateTime.now(),
                LocalDateTime.now()
        ));

        cartoes.add(new Cartao(1L, LocalDateTime.now(), false, TipoCartao.CREDITO, 1L));
        cartoes.add(new Cartao(2L, LocalDateTime.now(), false, TipoCartao.DEBITO, 1L));

        enderecos.add(new Endereco(1L, "Rua das Flores", 100, "27100-000", "Apto 101",
                "24999999999", "Centro", LocalDateTime.now(), LocalDateTime.now(), 1L, 1L));

        pedidos.add(new Pedido(1L, LocalDateTime.now(), new BigDecimal("215.00"), PedidoStatus.AGUARDANDO_PAGAMENTO, 1L));
    }

    @GetMapping("/{id}")
    public ResponseEntity<Cliente> buscarPorId(@PathVariable Long id) {
        return clientes.stream()
                .filter(c -> c.getId().equals(id))
                .findFirst()
                .map(ResponseEntity::ok)
                .orElseGet(() -> ResponseEntity.notFound().build());
    }

    @GetMapping("/{idcliente}/formas-de-pagamento")
    public ResponseEntity<List<Cartao>> listarFormasPagamento(@PathVariable Long idcliente) {
        List<Cartao> resultado = cartoes.stream()
                .filter(c -> c.getIdCliente().equals(idcliente))
                .collect(Collectors.toList());
        return ResponseEntity.ok(resultado);
    }

    @GetMapping("/{idcliente}/endereco")
    public ResponseEntity<Endereco> buscarEndereco(@PathVariable Long idcliente) {
        return enderecos.stream()
                .filter(e -> e.getIdCliente().equals(idcliente))
                .findFirst()
                .map(ResponseEntity::ok)
                .orElseGet(() -> ResponseEntity.notFound().build());
    }

    @GetMapping("/{idcliente}/pedido")
    public ResponseEntity<List<Pedido>> listarPedidos(@PathVariable Long idcliente) {
        List<Pedido> resultado = pedidos.stream()
                .filter(p -> p.getIdCliente().equals(idcliente))
                .collect(Collectors.toList());
        return ResponseEntity.ok(resultado);
    }
}