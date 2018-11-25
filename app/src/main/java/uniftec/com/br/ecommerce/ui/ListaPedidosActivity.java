package uniftec.com.br.ecommerce.ui;

import android.content.Context;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.DragEvent;
import android.view.MenuItem;
import android.view.View;

import java.util.ArrayList;
import java.util.List;

import uniftec.com.br.ecommerce.R;
import uniftec.com.br.ecommerce.adapter.PedidoAdapter;
import uniftec.com.br.ecommerce.model.Pedido;

public class ListaPedidosActivity extends AbstractActivity {

    private RecyclerView listaPedidos;
    private List<Pedido> pedidos;
    private PedidoAdapter adapter;

    @Override
    protected int getLayoutRes() {
        return R.layout.activity_lista_pedidos;
    }

    @Override
    protected void setupView() {
        listaPedidos = (RecyclerView)findViewById(R.id.lista_pedidos_recycle);

        listaPedidos.setLayoutManager(new LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false));
        //buscar pedidos

        pedidos = new ArrayList<Pedido>();
        adapter = new PedidoAdapter(pedidos);
        listaPedidos.setAdapter(adapter);

        listaPedidos.setHasFixedSize(true);
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
}
