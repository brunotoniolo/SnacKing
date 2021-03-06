package uniftec.com.br.ecommerce.ui;

import android.content.Context;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.DragEvent;
import android.view.MenuItem;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

import uniftec.com.br.ecommerce.R;
import uniftec.com.br.ecommerce.adapter.EnderecoAdapter;
import uniftec.com.br.ecommerce.interfaces.CardViewListeners;
import uniftec.com.br.ecommerce.model.Endereco;
import uniftec.com.br.ecommerce.model.Produto;

public class ContaActivity extends AbstractActivity implements View.OnClickListener, CardViewListeners {

    private EditText usuario;
    private EditText email;
    private EditText cpf;
    private EditText telefone;
    private TextView historicoCompras;

    @Override
    protected int getLayoutRes() {
        return R.layout.activity_conta;
    }

    @Override
    protected void setupView() {
        usuario = (EditText)findViewById(R.id.conta_usuario);
        email = (EditText)findViewById(R.id.conta_email);
        cpf = (EditText)findViewById(R.id.conta_cpf);
        telefone = (EditText)findViewById(R.id.conta_telefone);
        historicoCompras = (TextView)findViewById(R.id.conta_historico_compras);
        historicoCompras.setOnClickListener(this);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {

        if(item.getItemId() == android.R.id.home){
            finish();
            return true;
        }

        return false;
    }

    @Override
    public void onClick(View v) {

        if(v == historicoCompras){
            Intent intent = new Intent(this, ListaPedidosActivity.class);

            startActivity(intent);
        }
    }

    @Override
    public void onItemClick(int position, View v) {
        Intent intent = new Intent(this, EnderecoActivity.class);

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
