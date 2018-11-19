package uniftec.com.br.ecommerce.model;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * Created by bruno.toniolo on 23/11/2017.
 */

public class Pedido {

    @JsonProperty("id")
    private int id;

    @JsonProperty("itens")
    private List<Produto> produtos;

    @JsonProperty("enderecoEntrega")
    private Endereco enderecoEntrega;

    @JsonProperty("status")
    private String status;

    @JsonProperty("data")
    private Date data;

    @JsonProperty("total")
    private double total;

    public Pedido(@JsonProperty("itens")List<Produto> produtos,
                  @JsonProperty("enderecoEntrega")Endereco enderecoEntrega,
                  @JsonProperty("status")String status,
                  @JsonProperty("data")Date data,
                  @JsonProperty("total")double total){
        this.produtos = produtos;
        this.enderecoEntrega = enderecoEntrega;
        this.status = status;
        this.data = data;
        this.total = total;
    }

    public List<Produto> getProdutos() {
        return produtos;
    }

    public void setProdutos(@JsonProperty("itens")List<Produto> produtos) {
        this.produtos = produtos;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(@JsonProperty("status")String status) {
        this.status = status;
    }

    public Date getData() {
        return data;
    }

    public void setData(@JsonProperty("data")Date data) {
        this.data = data;
    }

    public double getTotal() {
        return total;
    }

    public void setTotal(@JsonProperty("total")double total) {
        this.total = total;
    }

    public void setId(@JsonProperty("id") Integer id) {
        this.id = id;
    }

    public Integer getId() {
        return this.id;
    }
}
