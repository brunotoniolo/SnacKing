package uniftec.com.br.ecommerce.model;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.io.Serializable;

/**
 * Created by bruno.toniolo on 09/12/2017.
 */

public class Login implements Serializable{
    @JsonProperty("email")
    public String email;
    @JsonProperty("senha")
    public String senha;

    public Login(@JsonProperty("email")String email,
                 @JsonProperty("senha")String senha) {
        this.email = email;
        this.senha = senha;
    }
}
