package uniftec.com.br.ecommerce.ui;

import android.content.Context;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.DragEvent;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.Toast;

import uniftec.com.br.ecommerce.R;
import uniftec.com.br.ecommerce.model.Response;
import uniftec.com.br.ecommerce.model.Usuario;
import uniftec.com.br.ecommerce.tasks.AdicionarUsuarioTask;

public class CriarContaActivity extends AbstractActivity implements View.OnClickListener, AdicionarUsuarioTask.AdicionarUsuarioDelegate{

    private EditText nome;
    private EditText email;
    private EditText senha;
    private EditText repetirSenha;
    private EditText cpf;
    private EditText telefone;
    private CheckBox termosUso;
    private Button avancar;

    @Override
    protected int getLayoutRes() {
        return R.layout.activity_criar_conta;
    }

    @Override
    protected void setupView() {
        nome = (EditText)findViewById(R.id.criar_conta_nome);
        email = (EditText)findViewById(R.id.criar_conta_email);
        senha = (EditText)findViewById(R.id.criar_conta_senha);
        repetirSenha = (EditText)findViewById(R.id.criar_conta_repetir_senha);
        cpf = (EditText)findViewById(R.id.criar_conta_cpf);
        telefone = (EditText)findViewById(R.id.criar_conta_telefone);
        termosUso = (CheckBox)findViewById(R.id.criar_conta_termos_uso);
        avancar = (Button) findViewById(R.id.criar_conta_avancar);

        avancar.setOnClickListener(this);
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
        if(v == avancar){
            AdicionarUsuarioTask task = new AdicionarUsuarioTask(this);

            task.execute(new Usuario( nome.getText().toString()
                                    , email.getText().toString()
                                    , senha.getText().toString()
                                    , cpf.getText().toString()
                                    , telefone.getText().toString()));

            Intent intent = new Intent(this, ListaEnderecosActivity.class);
            startActivity(intent);
        }
    }

    @Override
    public boolean onDrag(View v, DragEvent event) {
        return false;
    }

    @Override
    public void AdicionarUsuarioSucesso(Response<String> response) {
        this.appUtil.setToken(response.getData());
        Toast.makeText(this, "Usuário cadastrado", Toast.LENGTH_LONG).show();
    }

    @Override
    public void AdicionarUsuarioErro(String mensagem) {
        Toast.makeText(this, mensagem, Toast.LENGTH_LONG).show();
    }
}
