package uniftec.com.br.ecommerce.tasks;

import android.os.AsyncTask;

import retrofit2.Call;
import uniftec.com.br.ecommerce.model.Login;
import uniftec.com.br.ecommerce.model.Response;
import uniftec.com.br.ecommerce.model.Usuario;
import uniftec.com.br.ecommerce.services.UsuarioService;
import uniftec.com.br.ecommerce.singleton.RetrofitSingleton;

/**
 * Created by bruno.toniolo on 10/12/2017.
 */

public class LoginTask extends AsyncTask<Login, Void, Response<String>> {

    private UsuarioService service;
    private LoginDelegate delegate;

    public LoginTask(LoginDelegate delegate){
        this.service = RetrofitSingleton.getInstance().getRetrofit().create(UsuarioService.class);
        this.delegate = delegate;
    }

    @Override
    protected Response<String> doInBackground(Login... logins) {
        Call<Response<String>> call = this.service.login(logins[0]);
        try{
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
            this.delegate.LoginSucesso(response);
        }else{
            this.delegate.LoginErro("Não foi possível fazer login");
        }
    }

    public interface LoginDelegate{
        public void LoginSucesso(Response<String> response);
        public void LoginErro(String mensagem);
    }
}
