package uniftec.com.br.ecommerce.tasks;

import android.os.AsyncTask;

import java.util.List;

import retrofit2.Call;
import uniftec.com.br.ecommerce.model.Produto;
import uniftec.com.br.ecommerce.model.Response;
import uniftec.com.br.ecommerce.services.ProdutoService;
import uniftec.com.br.ecommerce.singleton.RetrofitSingleton;

/**
 * Created by bruno.toniolo on 10/12/2017.
 */

public class BuscaTodosProdutosTask extends AsyncTask<Void, Void, Response<List<Produto>>> {

    private ProdutoService service;
    private BuscaTodosProdutosDelegate delegate;

    public BuscaTodosProdutosTask(BuscaTodosProdutosDelegate delegate){
        this.service = RetrofitSingleton.getInstance().getRetrofit().create(ProdutoService.class);
        this.delegate = delegate;
    }

    @Override
    protected Response<List<Produto>> doInBackground(Void... voids) {
        Call<Response<List<Produto>>> call = this.service.buscaTodosProdutos();

        try {
            retrofit2.Response<Response<List<Produto>>> response = call.execute();
            return response.body();
        }catch (Exception e){
            e.printStackTrace();
        }

        return null;
    }

    @Override
    protected void onPostExecute(Response<List<Produto>> response) {
        if(response != null){
            this.delegate.BuscaTodosProdutosSucesso(response);
        }else{
            this.delegate.BuscaTodosProdutosErro("Não foi possível carregar os produtos");
        }
    }

    public interface BuscaTodosProdutosDelegate{
        public void BuscaTodosProdutosSucesso(Response<List<Produto>> response);
        public void BuscaTodosProdutosErro(String mensagem);
    }
}
