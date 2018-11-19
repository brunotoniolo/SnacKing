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

public class BuscaPorCategoriaTask extends AsyncTask<Long, Void, Response<List<Produto>>> {

    private ProdutoService service;
    private BuscaPorCategoriaDelegate delegate;

    public BuscaPorCategoriaTask(BuscaPorCategoriaDelegate delegate){
        this.service = RetrofitSingleton.getInstance().getRetrofit().create(ProdutoService.class);
        this.delegate = delegate;
    }


    @Override
    protected Response<List<Produto>> doInBackground(Long... longs) {
        Call<Response<List<Produto>>> call = this.service.buscaPorCategoria(longs[0]);
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
            this.delegate.BuscaPorCategoriaSucesso(response);
        }else{
            this.delegate.BuscaPorCategoriaErro("Não foi possível carregar produtos desta categoria");
        }
    }

    public interface BuscaPorCategoriaDelegate{
        public void BuscaPorCategoriaSucesso(Response<List<Produto>> response);
        public void BuscaPorCategoriaErro(String mensagem);
    }
}
