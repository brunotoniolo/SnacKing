package uniftec.com.br.ecommerce.tasks;

import android.os.AsyncTask;

import retrofit2.Call;
import uniftec.com.br.ecommerce.model.Response;
import uniftec.com.br.ecommerce.model.Usuario;
import uniftec.com.br.ecommerce.services.UsuarioService;
import uniftec.com.br.ecommerce.singleton.RetrofitSingleton;

/**
 * Created by bruno.toniolo on 10/12/2017.
 */

public class AdicionarUsuarioTask extends AsyncTask<Usuario, Void, Response<String>> {

    private UsuarioService service;
    private AdicionarUsuarioDelegate delegate;

    public AdicionarUsuarioTask(AdicionarUsuarioDelegate delegate){
        this.service = RetrofitSingleton.getInstance().getRetrofit().create(UsuarioService.class);
        this.delegate = delegate;
    }

    @Override
    protected Response<String> doInBackground(Usuario... usuarios) {
        Call<Response<String>> call = this.service.adicionaUsuario(usuarios[0]);
        try {
            retrofit2.Response<Response<String>> response = call.execute();
            return response.body();
        }catch (Exception e){
            e.printStackTrace();
        }

        return null;
    }

    @Override
    protected void onPostExecute(Response<String> response) {
        if(response != null){
            this.delegate.AdicionarUsuarioSucesso(response);
        }else{
            this.delegate.AdicionarUsuarioErro("Não foi possível concluir o cadastro");
        }
    }

    public interface AdicionarUsuarioDelegate{
        public void AdicionarUsuarioSucesso(Response<String> response);
        public void AdicionarUsuarioErro(String mensagem);
    }
}
