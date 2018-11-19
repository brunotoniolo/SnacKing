package uniftec.com.br.ecommerce.tasks;

import android.os.AsyncTask;

import java.util.List;

import retrofit2.Call;
import uniftec.com.br.ecommerce.model.Categoria;
import uniftec.com.br.ecommerce.model.Response;
import uniftec.com.br.ecommerce.services.ProdutoService;
import uniftec.com.br.ecommerce.singleton.RetrofitSingleton;

/**
 * Created by bruno.toniolo on 10/12/2017.
 */

public class BuscaTodasCategoriasTask extends AsyncTask<Void, Void, Response<List<Categoria>>> {

    private ProdutoService service;
    private BuscaTodasCategoriasDelegate delegate;

    public BuscaTodasCategoriasTask(BuscaTodasCategoriasDelegate delegate){
        this.service = RetrofitSingleton.getInstance().getRetrofit().create(ProdutoService.class);
        this.delegate = delegate;
    }

    @Override
    protected Response<List<Categoria>> doInBackground(Void... voids) {
        Call<Response<List<Categoria>>> call = this.service.buscaTodasCategorias();

        try {
            retrofit2.Response<Response<List<Categoria>>> response = call.execute();
            return response.body();
        }catch (Exception e){
            e.printStackTrace();
        }
        return null;
    }

    @Override
    protected void onPostExecute(Response<List<Categoria>> response) {
        if(response != null){
            this.delegate.BuscaTodasCategoriasSucesso(response);
        }else{
            this.delegate.BuscaTodasCategoriasErro("Não foi possível carregar as categorias");
        }
    }

    public interface BuscaTodasCategoriasDelegate{
        public void BuscaTodasCategoriasSucesso(Response<List<Categoria>> response);
        public void BuscaTodasCategoriasErro(String mensagem);
    }
}
