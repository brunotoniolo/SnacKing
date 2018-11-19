package uniftec.com.br.ecommerce.model;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.io.Serializable;
import java.util.List;

public class Usuario implements Serializable {

    @JsonProperty("id")
    private int id;

    @JsonProperty("nome")
    private String nome;

    @JsonProperty("email")
    private String email;

    @JsonProperty("senha")
    private String senha;

    @JsonProperty("cpf")
    private String cpf;

    @JsonProperty("telefone")
    private String telefone;

    @JsonProperty("enderecos")
    private List<Endereco> enderecos;

    public Usuario(@JsonProperty("nome")String nome,
                   @JsonProperty("email")String  email,
                   @JsonProperty("senha")String senha,
                   @JsonProperty("cpf")String cpf,
                   @JsonProperty("telefone")String telefone,
                   @JsonProperty("enderecos")List<Endereco> enderecos){

        this.nome = nome;
        this.email = email;
        this.senha = senha;
        this.cpf = cpf;
        this.telefone = telefone;
        this.enderecos = enderecos;
    }

    public Usuario(@JsonProperty("nome")String nome,
                   @JsonProperty("email")String  email,
                   @JsonProperty("senha")String senha,
                   @JsonProperty("cpf")String cpf,
                   @JsonProperty("telefone")String telefone){

        this.nome = nome;
        this.email = email;
        this.senha = senha;
        this.cpf = cpf;
        this.telefone = telefone;
    }

    public String getNome() { return nome; }

    public void setNome(@JsonProperty("nome")String nome) {
        this.nome = nome;
    }

    public String getEmail() { return email; }

    public void setEmail(@JsonProperty("email")String email) {
        this.email = email;
    }

    public String getSenha() { return senha; }

    public void setSenha(@JsonProperty("senha")String senha) {
        this.senha = senha;
    }

    public String getCpf() { return cpf; }

    public void setCpf(@JsonProperty("cpf")String cpf) {
        this.cpf = cpf;
    }

    public String getTelefone() { return telefone; }

    public void setTelefone(@JsonProperty("telefone")String telefone) {
        this.telefone = telefone;
    }

    public List<Endereco> getEnderecos() {
        return enderecos;
    }

    public void setEnderecos(@JsonProperty("enderecos")List<Endereco> enderecos) {
        this.enderecos = enderecos;
    }

    public void setId(@JsonProperty("id") Integer id) {
        this.id = id;
    }

    public Integer getId() {
        return this.id;
    }
}
