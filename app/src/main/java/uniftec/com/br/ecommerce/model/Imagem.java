package uniftec.com.br.ecommerce.model;

import android.content.Context;
import android.media.Image;
import android.widget.ImageView;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.squareup.picasso.Picasso;

import java.io.Serializable;

/**
 * Created by bruno.toniolo on 09/12/2017.
 */

@JsonIgnoreProperties(ignoreUnknown = true)
public class Imagem implements Serializable {

    @JsonProperty("id")
    private Integer id;

    @JsonProperty("url")
    private String url;

    public String getUrl() {
        return url;
    }

    public Integer getId() {
        return id;
    }

    public void criaImagem(Context contexto, ImageView imageView) {
        Picasso.with(contexto).load(this.url)
                .resize(100, 100).centerInside()
                .into(imageView);
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public void setId(Integer id) {
        this.id = id;
    }
}
