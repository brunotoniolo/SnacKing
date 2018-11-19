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

public class BuscaPorTokenTask extends AsyncTask<String, Void, Response<Usuario>> {

    private UsuarioService service;
    private BuscaPorTokenDelegate delegate;

    public BuscaPorTokenTask(BuscaPorTokenDelegate delegate){
        this.service = RetrofitSingleton.getInstance().getRetrofit().create(UsuarioService.class);
        this.delegate = delegate;
    }

    @Override
    protected Response<Usuario> doInBackground(String... strings) {
        Call<Response<Usuario>> call = service.buscaPorToken(strings[0]);

        try{
            retrofit2.Response<Response<Usuario>> response = call.execute();
            return response.body();
        }catch (Exception e){
            e.printStackTrace();
        }

        return null;
    }

    @Override
    protected void onPostExecute(Response<Usuario> response) {
        if(response != null){
            this.delegate.BuscaPorTokenSucesso(response);
        }else{
            this.delegate.BuscaPorTokenErro("Não foi buscar usuário");
        }
    }

    public interface BuscaPorTokenDelegate{
        public void BuscaPorTokenSucesso(Response<Usuario> response);
        public void BuscaPorTokenErro(String mensagem);
    }
}
