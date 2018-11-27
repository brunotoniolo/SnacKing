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

public class BuscaTodosPedidosTask extends AsyncTask<Void, Void, Response<List<Pedido>>> {

    private PedidoService service;
    private BuscaTodosPedidosDelegate delegate;

    public BuscaTodosPedidosTask(BuscaTodosPedidosDelegate delegate){
        this.service = RetrofitSingleton.getInstance().getRetrofit().create(PedidoService.class);
        this.delegate = delegate;
    }

    @Override
    protected Response<List<Pedido>> doInBackground(Void... voids) {
        Call<Response<List<Pedido>>> call = this.service.buscaTodosPedidos();

        try {
            retrofit2.Response<Response<List<Pedido>>> response = call.execute();
            return response.body();
        }catch (Exception e){
            e.printStackTrace();
        }

        return null;
    }

    @Override
    protected void onPostExecute(Response<List<Pedido>> response) {
        if(response != null){
            this.delegate.BuscaTodosPedidosSucesso(response);
        }else{
            this.delegate.BuscaTodosPedidosErro("Não foi possível buscar os pedidos");
        }
    }

    public interface BuscaTodosPedidosDelegate{
        public void BuscaTodosPedidosSucesso(Response<List<Pedido>> response);
        public void BuscaTodosPedidosErro(String mensagem);
    }

}
