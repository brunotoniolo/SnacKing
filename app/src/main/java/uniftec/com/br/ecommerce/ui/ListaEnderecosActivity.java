package uniftec.com.br.ecommerce.ui;

import android.content.Intent;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.DragEvent;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

import uniftec.com.br.ecommerce.R;
import uniftec.com.br.ecommerce.adapter.EnderecoAdapter;
import uniftec.com.br.ecommerce.interfaces.CardViewListeners;
import uniftec.com.br.ecommerce.model.*;

public class ListaEnderecosActivity extends AbstractActivity implements View.OnClickListener, CardViewListeners {

    private RecyclerView listaEndereco;
    private TextView adicionaEndereco;
    private Button criarConta;
    private List<Endereco> enderecos;
    private EnderecoAdapter adapter;

    @Override
    protected int getLayoutRes() {
        return R.layout.activity_lista_enderecos;
    }

    @Override
    protected void setupView() {
        listaEndereco = (RecyclerView)findViewById(R.id.endereco_lista_recycle);
        adicionaEndereco = (TextView)findViewById(R.id.endereco_lista_adicionar_novo);

        adicionaEndereco.setOnClickListener(this);

        listaEndereco.setLayoutManager(new LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false));
        enderecos = new ArrayList<Endereco>();

        adapter = new EnderecoAdapter(enderecos, this);
        listaEndereco.setAdapter(adapter);

        listaEndereco.setHasFixedSize(true);
    }


    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        if(item.getItemId() == android.R.id.home){
            finish();
            return true;
        }
        return super.onOptionsItemSelected(item);
    }

    @Override
    public void onClick(View v) {
        if(v == adicionaEndereco){
            Intent intent = new Intent(this, EnderecoActivity.class);

            startActivity(intent);
        }
    }

    @Override
    public void onItemClick(int position, View v) {
        Intent intent = new Intent(this, EnderecoActivity.class);

        Endereco endereco = enderecos.get(position);
        intent.putExtra(EnderecoActivity.ENDERECO_PARAMETER, endereco);

        startActivity(intent);
    }

    @Override
    public boolean onItemDrag(Produto produto, View v, DragEvent event) {
        return false;
    }

    @Override
    public boolean onItemLongClickListener(Produto produto, View v) {
        return false;
    }

    @Override
    public boolean onDrag(View v, DragEvent event) {
        return false;
    }
}
