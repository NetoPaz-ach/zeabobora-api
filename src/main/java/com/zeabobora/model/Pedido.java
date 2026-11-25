
package com.zeabobora.model;

import jakarta.persistence.Entity;

import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

import jakarta.persistence.ManyToOne;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.FetchType;
import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.Column;@Entity
public class Pedido {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;


@Column(name = "cliente_id")
private Long clienteId;

@Column(name = "produto_id")
private Long produtoId;

    private Integer quantidade;

@ManyToOne(fetch = FetchType.LAZY)
@JoinColumn(
    name = "cliente_id",
    insertable = false,
    updatable = false
)
@JsonIgnore
private Cliente cliente;

@ManyToOne(fetch = FetchType.LAZY)
@JoinColumn(
    name = "produto_id",
    insertable = false,
    updatable = false
)
@JsonIgnore
private Produto produto;

    public Pedido() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getClienteId() {
        return clienteId;
    }

    public void setClienteId(Long clienteId) {
        this.clienteId = clienteId;
    }

    public Long getProdutoId() {
        return produtoId;
    }

    public void setProdutoId(Long produtoId) {
        this.produtoId = produtoId;
    }

    public Integer getQuantidade() {
        return quantidade;
    }

    public void setQuantidade(Integer quantidade) {
        this.quantidade = quantidade;
    }
}
