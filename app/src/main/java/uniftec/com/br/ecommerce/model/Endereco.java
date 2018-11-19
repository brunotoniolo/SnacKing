package uniftec.com.br.ecommerce.model;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class Endereco implements Serializable {

    @JsonProperty("id")
    private int id;

    @JsonProperty("logradouro")
    private String rua;

    @JsonProperty("numero")
    private int numero;

    @JsonProperty("complemento")
    private String complemento;

    @JsonProperty("bairro")
    private String bairro;

    @JsonProperty("cidade")
    private String cidade;

    @JsonProperty("estado")
    private String estado;

    public Endereco(@JsonProperty("logradouro")String rua,
                    @JsonProperty("numero")int numero,
                    @JsonProperty("complemento")String complemento,
                    @JsonProperty("bairro")String bairro,
                    @JsonProperty("cidade")String cidade,
                    @JsonProperty("estado")String estado){
        this.id = id;
        this.rua = rua;
        this.numero = numero;
        this.complemento = complemento;
        this.bairro = bairro;
        this.cidade = cidade;
        this.estado = estado;
    }

    public String getRua() {
        return rua;
    }

    public void setRua(@JsonProperty("logradouro")String rua) {
        this.rua = rua;
    }

    public int getNumero() {
        return numero;
    }

    public void setNumero(@JsonProperty("numero")int numero) {
        this.numero = numero;
    }

    public String getComplemento() {
        return complemento;
    }

    public void setComplemento(@JsonProperty("complemento")String complemento) {
        this.complemento = complemento;
    }

    public String getBairro() {
        return bairro;
    }

    public void setBairro(@JsonProperty("bairro")String bairro) {
        this.bairro = bairro;
    }

    public String getCidade() {
        return cidade;
    }

    public void setCidade(@JsonProperty("cidade")String cidade) {
        this.cidade = cidade;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(@JsonProperty("estado")String estado) {
        this.estado = estado;
    }

    public void setId(@JsonProperty("id") Integer id) {
        this.id = id;
    }

    public Integer getId() {
        return this.id;
    }

}

