package uniftec.com.br.ecommerce.tasks;

import android.app.Activity;
import android.content.Context;
import android.os.AsyncTask;

import retrofit2.Call;
import uniftec.com.br.ecommerce.model.Endereco;
import uniftec.com.br.ecommerce.model.Response;
import uniftec.com.br.ecommerce.model.Usuario;
import uniftec.com.br.ecommerce.services.UsuarioService;
import uniftec.com.br.ecommerce.singleton.RetrofitSingleton;
import uniftec.com.br.ecommerce.ui.AbstractActivity;

/**
 * Created by bruno.toniolo on 10/12/2017.
 */

public class AdicionaEnderecoTask extends AsyncTask<Endereco, Void, Response<Usuario>> {

    private UsuarioService service;
    private AdicionaEnderecoDelegate delegate;

    public AdicionaEnderecoTask(AdicionaEnderecoDelegate delegate){
        this.service = RetrofitSingleton.getInstance().getRetrofit().create(UsuarioService.class);
        this.delegate = delegate;
    }

    @Override
    protected Response<Usuario> doInBackground(Endereco... enderecos) {
        String token = ((AbstractActivity)delegate).appUtil.getToken();
        
        Call<Response<Usuario>> call = this.service.adicionaEndereco(token ,enderecos[0]);
        try {
            retrofit2.Response<Response<Usuario>> response = call.execute();
            return response.body();
        }catch (Exception e){
            e.printStackTrace();
        }

        return null;
    }

    @Override
    protected void onPostExecute(Response<Usuario> usuarioResponse) {
        if (usuarioResponse != null){
            this.delegate.AdicionaEnderecoSucesso(usuarioResponse.getData());
        }else{
            this.delegate.AdicionaEnderecoErro("Não foi possível adicionar o endereço");
        }
    }

    public interface AdicionaEnderecoDelegate{
        public void AdicionaEnderecoSucesso(Usuario usuario);
        public void AdicionaEnderecoErro(String mensagem);
    }
}
