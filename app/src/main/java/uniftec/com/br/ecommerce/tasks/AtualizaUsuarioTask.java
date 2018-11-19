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

public class AtualizaUsuarioTask extends AsyncTask<Usuario, Void, Response<Usuario>> {

    private UsuarioService service;
    private AtualizaUsuarioDelegate delegate;

    public AtualizaUsuarioTask(AtualizaUsuarioDelegate delegate){
        this.service = RetrofitSingleton.getInstance().getRetrofit().create(UsuarioService.class);
        this.delegate = delegate;
    }

    @Override
    protected Response<Usuario> doInBackground(Usuario... usuarios) {
        Call<Response<Usuario>> call = this.service.atualizaUsuario("", usuarios[0]);
        try{
            retrofit2.Response<Response<Usuario>> response = call.execute();
            return  response.body();
        }catch (Exception e){
            e.printStackTrace();
        }

        return null;
    }

    @Override
    protected void onPostExecute(Response<Usuario> response) {
        if(response != null){
            this.delegate.AtualizaUsuarioSucesso(response);
        }else{
            this.delegate.AtualizaUsuarioErro("Não foi possível atualizar os dados");
        }
    }

    public interface AtualizaUsuarioDelegate{
        public void AtualizaUsuarioSucesso(Response<Usuario> response);
        public void AtualizaUsuarioErro(String mensagem);
    }
}
