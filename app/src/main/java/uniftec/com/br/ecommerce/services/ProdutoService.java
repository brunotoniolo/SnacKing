package uniftec.com.br.ecommerce.services;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;
import uniftec.com.br.ecommerce.model.Categoria;
import uniftec.com.br.ecommerce.model.Produto;
import uniftec.com.br.ecommerce.model.Response;

/**
 * Created by bruno.toniolo on 09/12/2017.
 */

public interface ProdutoService {

    @GET("/api/produto")
    public Call<Response<List<Produto>>> buscaPorCategoria(@Query("categoria-id") Long categoriaId);

    @GET("/api/categoria")
    public Call<Response<List<Categoria>>>buscaTodasCategorias();

    @GET("/api/produto")
    public Call<Response<List<Produto>>> buscaTodosProdutos();
}
