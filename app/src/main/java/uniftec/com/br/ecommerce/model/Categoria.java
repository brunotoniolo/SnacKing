package uniftec.com.br.ecommerce.model;

import android.support.v7.widget.CardView;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

import java.io.Serializable;
import java.security.PublicKey;
import java.util.ArrayList;
import java.util.List;

@JsonIgnoreProperties(ignoreUnknown = true)
public class Categoria implements Serializable {

    @JsonProperty("id")
    private Integer id;

    @JsonProperty("nome")
    private String descricao;

    public String getDescricao() {
        return descricao;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getId() {
        return this.id;
    }

}
