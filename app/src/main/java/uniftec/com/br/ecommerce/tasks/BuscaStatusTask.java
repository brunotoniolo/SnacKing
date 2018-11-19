package uniftec.com.br.ecommerce.tasks;

import android.os.AsyncTask;

import java.util.List;

import retrofit2.Call;
import uniftec.com.br.ecommerce.model.Pedido;
import uniftec.com.br.ecommerce.model.Response;
import uniftec.com.br.ecommerce.services.PedidoService;
import uniftec.com.br.ecommerce.singleton.RetrofitSingleton;

/**
 * Created by bruno.toniolo on 10/12/2017.
 */

public class BuscaStatusTask extends AsyncTask<Long, Void, Response<Pedido>> {

    private PedidoService service;
    private BuscaStatusDelegate delegate;

    public BuscaStatusTask(BuscaStatusDelegate delegate){
        this.service = RetrofitSingleton.getInstance().getRetrofit().create(PedidoService.class);
        this.delegate = delegate;
    }

    @Override
    protected Response<Pedido> doInBackground(Long... longs) {
        Call<Response<Pedido>> call = this.service.buscaStatus(longs[0]);

        try{
            retrofit2.Response<Response<Pedido>> response = call.execute();
            return response.body();
        }catch (Exception e){
            e.printStackTrace();
        }

        return null;
    }

    @Override
    protected void onPostExecute(Response<Pedido> response) {
        if(response != null){
            this.delegate.BuscaStatusSucesso(response);
        }else{
            this.delegate.BuscaStatusErro("Não foi possível atualizar status do pedido");
        }
    }

    public interface BuscaStatusDelegate{
        public void BuscaStatusSucesso(Response<Pedido> response);
        public void BuscaStatusErro(String mensagem);
    }
}
