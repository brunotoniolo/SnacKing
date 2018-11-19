package uniftec.com.br.ecommerce.ui;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import uniftec.com.br.ecommerce.R;


public class LoginFragment extends Fragment implements View.OnClickListener {

    private TextView txtCriarConta;
    private Button btnLogin;
    private EditText txtUsuario;
    private EditText txtSenha;

    public LoginFragment(){

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.fragment_login, container, false);
        btnLogin = (Button)view.findViewById(R.id.fragment_login_btn_login);
        txtCriarConta = (TextView)view.findViewById(R.id.fragment_login_txt_criar_conta);
        txtUsuario = (EditText)view.findViewById(R.id.fragment_login_txt_usuario);
        txtSenha = (EditText)view.findViewById(R.id.fragment_login_txt_senha);

        btnLogin.setOnClickListener(this);
        txtCriarConta.setOnClickListener(this);

        return view;
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {

        super.onActivityCreated(savedInstanceState);
    }

    @Override
    public void onClick(View v) {
        if(v == btnLogin){
            Intent intent = new Intent(getActivity(), ContaActivity.class);

            startActivity(intent);
        }else if(v == txtCriarConta){
            Intent intent = new Intent(getActivity(), CriarContaActivity.class);

            startActivity(intent);
        }
    }
}
