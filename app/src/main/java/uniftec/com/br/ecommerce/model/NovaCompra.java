package uniftec.com.br.ecommerce.model;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.io.Serializable;
import java.util.List;

/**
 * Created by bruno.toniolo on 09/12/2017.
 */

public class NovaCompra implements Serializable {

    @JsonProperty("cartaoCredito")
    private String cartaoCredito;

    @JsonProperty("codigoSeguranca")
    private String cvc;

    @JsonProperty("validadeCartaoCredito")
    private String vencimento;

    @JsonProperty("idEnderecoUsuario")
    private int enderecoId;

    @JsonProperty("produtos")
    private List<Produto> produtos;

    public NovaCompra(@JsonProperty("cartaoCredito") String cartaoCredito,
                      @JsonProperty("codigoSeguranca") String cvc,
                      @JsonProperty("validadeCartaoCredito") String vencimento,
                      @JsonProperty("idEnderecoUsuario") int enderecoId,
                      @JsonProperty("produtos") List<Produto> produtos){
        this.setCartaoCredito(cartaoCredito);
        this.setCvc(cvc);
        this.setVencimento(vencimento);
        this.setEnderecoId(enderecoId);
        this.setProdutos(produtos);
    }


    public String getCartaoCredito() {
        return cartaoCredito;
    }

    @JsonProperty("cartaoCredito")
    public void setCartaoCredito(String cartaoCredito) {
        this.cartaoCredito = cartaoCredito;
    }

    public String getCvc() {
        return cvc;
    }

    @JsonProperty("codigoSeguranca")
    public void setCvc(String cvc) {
        this.cvc = cvc;
    }

    public String getVencimento() {
        return vencimento;
    }
    @JsonProperty("validadeCartaoCredito")
    public void setVencimento(String vencimento) {
        this.vencimento = vencimento;
    }

    public int getEnderecoId() {
        return enderecoId;
    }

    @JsonProperty("idEnderecoUsuario")
    public void setEnderecoId(int enderecoId) {
        this.enderecoId = enderecoId;
    }

    public List<Produto> getProdutos() {
        return produtos;
    }

    @JsonProperty("produtos")
    public void setProdutos(List<Produto> produtos) {
        this.produtos = produtos;
    }
}
