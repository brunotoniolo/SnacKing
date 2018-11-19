package uniftec.com.br.ecommerce.ui;

import android.content.Context;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.DragEvent;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import uniftec.com.br.ecommerce.R;
import uniftec.com.br.ecommerce.model.Endereco;
import uniftec.com.br.ecommerce.model.Usuario;
import uniftec.com.br.ecommerce.tasks.AdicionaEnderecoTask;

public class EnderecoActivity extends AbstractActivity implements View.OnClickListener, AdicionaEnderecoTask.AdicionaEnderecoDelegate {

    public static final String ENDERECO_PARAMETER = "ENDERECO_PARAMETER";

    private EditText rua;
    private EditText numero;
    private EditText complemento;
    private EditText bairro;
    private EditText cidade;
    private EditText uf;
    private Button salvar;
    private Endereco endereco;

    @Override
    protected int getLayoutRes() {
        return R.layout.activity_endereco;
    }

    @Override
    protected void setupView() {
        rua = (EditText)findViewById(R.id.endereco_rua);
        numero = (EditText)findViewById(R.id.endereco_numero);
        complemento = (EditText) findViewById(R.id.endereco_complemento);
        bairro = (EditText)findViewById(R.id.endereco_bairro);
        cidade = (EditText)findViewById(R.id.endereco_cidade);
        uf = (EditText)findViewById(R.id.endereco_estado);
        salvar = (Button)findViewById(R.id.endereco_salvar);

        salvar.setOnClickListener(this);

        endereco = (Endereco)getIntent().getSerializableExtra(ENDERECO_PARAMETER);

        if(endereco != null) {
            rua.setText(endereco.getRua());
            numero.setText("" + endereco.getNumero());
            complemento.setText(endereco.getComplemento());
            bairro.setText(endereco.getBairro());
            cidade.setText(endereco.getCidade());
            uf.setText(endereco.getEstado());
        }
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
        if (v == salvar){
            AdicionaEnderecoTask task = new AdicionaEnderecoTask(this);
            task.execute(new Endereco( this.rua.getText().toString()
                                     , Integer.getInteger(this.numero.getText().toString())
                                     , this.complemento.getText().toString()
                                     , this.bairro.getText().toString()
                                     , this.cidade.getText().toString()
                                     , this.uf.getText().toString()));
        }
    }

    @Override
    public boolean onDrag(View v, DragEvent event) {
        return false;
    }

    @Override
    public void AdicionaEnderecoSucesso(Usuario usuario) {
        Toast.makeText(this, "Endereço Cadastrado", Toast.LENGTH_LONG).show();
    }

    @Override
    public void AdicionaEnderecoErro(String mensagem) {
        Toast.makeText(this, mensagem, Toast.LENGTH_LONG).show();
    }
}
