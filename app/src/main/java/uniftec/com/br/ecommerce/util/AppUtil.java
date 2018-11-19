package uniftec.com.br.ecommerce.util;

import android.content.Context;
import android.content.SharedPreferences;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import uniftec.com.br.ecommerce.model.Categoria;
import uniftec.com.br.ecommerce.model.Pedido;
import uniftec.com.br.ecommerce.model.Produto;
import uniftec.com.br.ecommerce.model.Usuario;

/**
 * Created by bruno.toniolo on 10/12/2017.
 */

public class AppUtil {
    private Context context;
    private SharedPreferences sharedPreferences;
    private ObjectMapper mapper;
    private SharedPreferences.Editor editor;

    public AppUtil(Context context){
        this.context = context;
        this.sharedPreferences = context.getSharedPreferences("AppPreferences", Context.MODE_PRIVATE);
        this.mapper = new ObjectMapper();
        this.editor = this.sharedPreferences.edit();
    }

    public boolean temUsuarioLogado() {
        return this.getUsuarioLogado() != null ? true : false;
    }

    public List<Produto> getCarrinho() {
        List<Produto> produtos = null;
        String data = this.sharedPreferences.getString("carrinho", null);

        if (data != null) {
            try {
                produtos = new ArrayList<Produto>(Arrays.asList(this.mapper.readValue(data, Produto[].class)));
            } catch (IOException e) {
                e.printStackTrace();
            }
        } else {
            produtos = new ArrayList<Produto>();
        }

        return produtos;
    }

    public void addCarrinho(Produto produto) {
        try {
            if(produto.getPrecoDesconto() == null){
                produto.setPrecoDesconto(produto.getPreco());
            }

            List<Produto> lista = this.getCarrinho();
            lista.add(produto);

            this.editor.putString("carrinho", this.mapper.writeValueAsString(lista));
            this.editor.commit();
        } catch (JsonProcessingException e) {
            e.printStackTrace();
        }
    }

    public Usuario getUsuarioLogado() {
        Usuario user = null;
        String data = this.sharedPreferences.getString("usuario_logado", null);
        try {
            user = this.mapper.readValue(data, Usuario.class);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return user;
    }

    public void setUsuarioLogado(Usuario loggedUser) {
        try {
            this.editor.putString("usuario_logado", this.mapper.writeValueAsString(loggedUser));
            this.editor.commit();
        } catch (JsonProcessingException e) {
            e.printStackTrace();
        }
    }

    public String getToken() {
        String token = null;
        String data = this.sharedPreferences.getString("token", null);
        return data;
    }

    public void setToken(String token) {
        this.editor.putString("token", token);
        this.editor.commit();
    }
}
