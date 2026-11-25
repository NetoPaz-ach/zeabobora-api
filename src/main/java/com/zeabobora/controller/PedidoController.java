
package com.zeabobora.controller;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.zeabobora.model.Pedido;
import com.zeabobora.repository.PedidoRepository;
import com.zeabobora.repository.ClienteRepository;
import com.zeabobora.repository.ProdutoRepository;

@RestController
@RequestMapping("/pedidos")
public class PedidoController {

    private final PedidoRepository repository;
    private final ClienteRepository clienteRepository;
    private final ProdutoRepository produtoRepository;

    public PedidoController(
            PedidoRepository repository,
            ClienteRepository clienteRepository,
            ProdutoRepository produtoRepository) {

        this.repository = repository;
        this.clienteRepository = clienteRepository;
        this.produtoRepository = produtoRepository;
    }

    // Cadastrar pedido
    @PostMapping
    public ResponseEntity<Pedido> cadastrar(@RequestBody Pedido pedido) {

        if (pedido.getClienteId() == null ||
            pedido.getProdutoId() == null ||
            pedido.getQuantidade() == null ||
            pedido.getQuantidade() <= 0) {
            return ResponseEntity.badRequest().build();
        }

        if (!clienteRepository.existsById(pedido.getClienteId()) ||
            !produtoRepository.existsById(pedido.getProdutoId())) {
            return ResponseEntity.badRequest().build();
        }

        Pedido novoPedido = repository.save(pedido);

        return ResponseEntity.status(HttpStatus.CREATED)
                .body(novoPedido);
    }

    // Listar todos os pedidos
    @GetMapping
    public List<Pedido> listar() {
        return repository.findAll();
    }

    // Consultar pedido pelo ID
    @GetMapping("/{id}")
    public ResponseEntity<Pedido> buscarPorId(@PathVariable Long id) {
        return repository.findById(id)
                .map(ResponseEntity::ok)
                .orElseGet(() -> ResponseEntity.notFound().build());
    }

    // Excluir pedido
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> excluir(@PathVariable Long id) {

        if (!repository.existsById(id)) {
            return ResponseEntity.notFound().build();
        }

        repository.deleteById(id);
        return ResponseEntity.noContent().build();
    }
}
