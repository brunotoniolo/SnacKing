package uniftec.com.br.ecommerce.ui;

import android.content.Context;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.RecyclerView;
import android.view.DragEvent;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import uniftec.com.br.ecommerce.R;
import uniftec.com.br.ecommerce.model.Endereco;
import uniftec.com.br.ecommerce.model.Pedido;
import uniftec.com.br.ecommerce.model.Response;
import uniftec.com.br.ecommerce.tasks.AdicionarPedidoTask;

public class FinalizaCompraActivity extends AbstractActivity implements View.OnClickListener, AdicionarPedidoTask.AdicionarPedidoDelegate {

    private RecyclerView listaEnderecos;
    private TextView adicionaEndereco;
    private EditText numeroCartao;
    private EditText expiracao;
    private EditText cvv;
    private Button finalizarPedido;

    @Override
    protected int getLayoutRes() {
        return R.layout.activity_finaliza_compra;
    }

    @Override
    protected void setupView() {
        listaEnderecos = (RecyclerView)findViewById(R.id.finaliza_compra_recycle_endereco);
        adicionaEndereco = (TextView)findViewById(R.id.finaliza_compra_adiciona_endereco);
        numeroCartao = (EditText) findViewById(R.id.finaliza_compra_cartao);
        expiracao = (EditText)findViewById(R.id.finaliza_compra_expiracao);
        cvv = (EditText)findViewById(R.id.finaliza_compra_cvv);
        finalizarPedido = (Button)findViewById(R.id.finaliza_compra_finaliza_pedido);

        finalizarPedido.setOnClickListener(this);

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
        if(v == finalizarPedido){
            AdicionarPedidoTask task = new AdicionarPedidoTask(this);
            /*task.execute(new Pedido( this.appUtil.getCarrinho()
                                   , null // Endereço Selecionado ??
                                   , "RECEIVED"
                                   ,

            )))*/
            Intent intent = new Intent(this, QrCode.class);
            startActivity(intent);
        }
    }

    @Override
    public boolean onDrag(View v, DragEvent event) {
        return false;
    }

    @Override
    public void AdicionarPedidoSucesso(Response<Pedido> response) {

    }

    @Override
    public void AdicionarPedidoErro(String mensagem) {

    }
}
