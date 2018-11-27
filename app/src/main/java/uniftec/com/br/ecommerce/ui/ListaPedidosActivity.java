package uniftec.com.br.ecommerce.ui;

import android.app.ProgressDialog;
import android.content.Context;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.DragEvent;
import android.view.MenuItem;
import android.view.View;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

import uniftec.com.br.ecommerce.R;
import uniftec.com.br.ecommerce.adapter.PedidoAdapter;
import uniftec.com.br.ecommerce.model.Pedido;
import uniftec.com.br.ecommerce.model.Response;
import uniftec.com.br.ecommerce.tasks.BuscaTodosPedidosTask;

public class ListaPedidosActivity extends AbstractActivity implements BuscaTodosPedidosTask.BuscaTodosPedidosDelegate {

    private RecyclerView listaPedidos;
    private List<Pedido> pedidos;
    private PedidoAdapter adapter;
    ProgressDialog progressDialog;

    @Override
    protected int getLayoutRes() {
        return R.layout.activity_lista_pedidos;
    }

    @Override
    protected void setupView() {
        listaPedidos = (RecyclerView)findViewById(R.id.lista_pedidos_recycle);

        listaPedidos.setLayoutManager(new LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false));

        pedidos = new ArrayList<Pedido>();
        adapter = new PedidoAdapter(pedidos);
        listaPedidos.setAdapter(adapter);

        listaPedidos.setHasFixedSize(true);

        BuscaTodosPedidosTask task = new BuscaTodosPedidosTask(this);
        task.execute();
        progressDialog = ProgressDialog.show(this, "Aguarde", "Carregando Pedidos", true, false);

    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        if(item.getItemId() == android.R.id.home) {
            finish();
            return true;
        }
        return super.onOptionsItemSelected(item);
    }

    @Override
    public boolean onDrag(View v, DragEvent event) {
        return false;
    }

    @Override
    public void BuscaTodosPedidosSucesso(Response<List<Pedido>> response) {
        progressDialog.dismiss();
        progressDialog = null;

        this.pedidos = response.getData();

        adapter = new PedidoAdapter(this.pedidos);
        listaPedidos.setAdapter(adapter);
    }

    @Override
    public void BuscaTodosPedidosErro(String mensagem) {
        progressDialog.dismiss();
        progressDialog = null;
        Toast.makeText(this, mensagem, Toast.LENGTH_SHORT).show();
    }
}
