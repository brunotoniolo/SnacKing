package uniftec.com.br.ecommerce.services;

import android.util.Log;

import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.DELETE;
import retrofit2.http.GET;
import retrofit2.http.Header;
import retrofit2.http.Headers;
import retrofit2.http.POST;
import retrofit2.http.PUT;
import retrofit2.http.Path;
import uniftec.com.br.ecommerce.model.Endereco;
import uniftec.com.br.ecommerce.model.Login;
import uniftec.com.br.ecommerce.model.Response;
import uniftec.com.br.ecommerce.model.Usuario;

/**
 * Created by bruno.toniolo on 09/12/2017.
 */

public interface UsuarioService {
    @PUT("/usuario")
    public Call<Response<String>> adicionaUsuario(@Body Usuario usuario);

    @Headers("Accept: application/json;charset=UTF-8")
    @PUT("/usuario/endereco")
    public Call<Response<Usuario>> adicionaEndereco(@Header("X-Token") String token, @Body Endereco endereco);

    @Headers("Accept: application/json;charset=UTF-8")
    @DELETE("/usuario/endereco/{id}")
    public Call<Response<Usuario>> apagaEndereco(@Header("X-Token") String token, @Path("id") Integer id);

    @Headers("Accept: application/json;charset=UTF-8")
    @POST("/usuario")
    public Call<Response<Usuario>> atualizaUsuario(@Header("X-Token") String token, @Body Usuario usuario);

    @Headers("Accept: application/json;charset=UTF-8")
    @GET("/usuario")
    public Call<Response<Usuario>> buscaPorToken(@Header("X-Token") String token);

    @POST("/usuario/login")
    public Call<Response<String>> login(@Body Login login);
}
