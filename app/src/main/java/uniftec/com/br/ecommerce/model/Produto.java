package uniftec.com.br.ecommerce.model;

import android.app.ProgressDialog;

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

    @JsonProperty("imagemPrincipal")
    private Imagem imagem;

    @JsonProperty("imagens")
    private List<Imagem> listaImagem;

    @JsonProperty("preco")
    private Double preco;

    @JsonProperty("precoDesconto")
    private Double precoDesconto;

    @JsonProperty("categoira")
    private Categoria categoria;

    public String getTitulo() {
        return titulo;
    }

    public String getDescricao() {
        return descricao;
    }

    public Imagem getImagem() {
        return imagem;
    }

    public List<Imagem> getListaImagem() {
        return listaImagem;
    }

    public Double getPreco() {
        return preco;
    }

    public Double getPrecoDesconto() {
        return precoDesconto;
    }

    public Categoria getCategoria() {
        return categoria;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public void setPrecoDesconto(Double precoDesconto) {
        this.precoDesconto = precoDesconto;
    }

    public Integer getId() {
        return this.id;
    }

}
