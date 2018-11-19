package uniftec.com.br.ecommerce.tasks;

import android.os.AsyncTask;

import retrofit2.Call;
import uniftec.com.br.ecommerce.model.NovaCompra;
import uniftec.com.br.ecommerce.model.Pedido;
import uniftec.com.br.ecommerce.model.Response;
import uniftec.com.br.ecommerce.services.PedidoService;
import uniftec.com.br.ecommerce.singleton.RetrofitSingleton;

/**
 * Created by bruno.toniolo on 10/12/2017.
 */

public class AdicionarPedidoTask extends AsyncTask<NovaCompra, Void, Response<Pedido>> {

    private PedidoService service;
    private AdicionarPedidoDelegate delegate;

    public AdicionarPedidoTask(AdicionarPedidoDelegate delegate){
        this.service = RetrofitSingleton.getInstance().getRetrofit().create(PedidoService.class);
        this.delegate = delegate;
    }

    @Override
    protected Response<Pedido> doInBackground(NovaCompra... novaCompras) {
        Call<Response<Pedido>> call = this.service.adicionaPedido("", novaCompras[0]);

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
            this.delegate.AdicionarPedidoSucesso(response);
        }else{
            this.delegate.AdicionarPedidoErro("Não foi possível adicionar o pedido");
        }
    }

    public interface AdicionarPedidoDelegate{
        public void AdicionarPedidoSucesso(Response<Pedido> response);
        public void AdicionarPedidoErro(String mensagem);
    }

}
