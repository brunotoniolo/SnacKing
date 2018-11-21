package uniftec.com.br.ecommerce.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

import java.io.Serializable;
import java.util.List;

@JsonIgnoreProperties(ignoreUnknown = true)
public class Produto implements Serializable {

    @JsonProperty("id")
    private Integer id;

    @JsonProperty("nome")
    private String titulo;

    @JsonProperty("descricao")
    private String descricao;

    //@JsonProperty("imagemPrincipal")
    //private Imagem imagem;

    //@JsonProperty("imagens")
    //private List<Imagem> listaImagem;

    @JsonProperty("preco")
    private Double preco;

    @JsonProperty("precoDesconto")
    private Double precoDesconto;

    @JsonProperty("categoria")
    private Categoria categoria;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    /*public Imagem getImagem() {
        return imagem;
    }

    public void setImagem(Imagem imagem) {
        this.imagem = imagem;
    }

    public List<Imagem> getListaImagem() {
        return listaImagem;
    }

    public void setListaImagem(List<Imagem> listaImagem) {
        this.listaImagem = listaImagem;
    }*/

    public Double getPreco() {
        return preco;
    }

    public void setPreco(Double preco) {
        this.preco = preco;
    }

    public Double getPrecoDesconto() {
        return precoDesconto;
    }

    public void setPrecoDesconto(Double precoDesconto) {
        this.precoDesconto = precoDesconto;
    }

    public Categoria getCategoria() {
        return categoria;
    }

    public void setCategoria(Categoria categoria) {
        this.categoria = categoria;
    }
}
