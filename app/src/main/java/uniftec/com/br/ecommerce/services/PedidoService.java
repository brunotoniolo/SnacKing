package uniftec.com.br.ecommerce.services;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.GET;
import retrofit2.http.Header;
import retrofit2.http.Headers;
import retrofit2.http.POST;
import retrofit2.http.PUT;
import uniftec.com.br.ecommerce.model.NovaCompra;
import uniftec.com.br.ecommerce.model.Pedido;
import uniftec.com.br.ecommerce.model.Response;

/**
 * Created by bruno.toniolo on 09/12/2017.
 */

public interface PedidoService {
    @Headers("Accept: application/json;charset=UTF-8")
    @PUT("/api/pedido")
    public Call<Response<Pedido>> adicionaPedido(@Header("X-Token") String token, @Body NovaCompra novaCompra);

    @Headers("Accept: application/json;charset=UTF-8")
    @POST("/api/pedido/{id}")
    public Call<Response<Pedido>> buscaStatus(@Header("id") Long id);

    @Headers("Accept: application/json;charset=UTF-8")
    @GET("/api/pedido")
    public Call<Response<List<Pedido>>> buscaTodosPedidos();

}
