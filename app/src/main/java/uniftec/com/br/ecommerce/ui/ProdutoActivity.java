package uniftec.com.br.ecommerce.ui;

import android.support.v4.view.ViewPager;
import android.view.DragEvent;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import uniftec.com.br.ecommerce.R;
import uniftec.com.br.ecommerce.model.Produto;

public class ProdutoActivity extends AbstractActivity implements View.OnClickListener {

    public static final String PRODUTO_PARAMETER = "PRODUTO_PARAMETER";

    private TextView txtResumo;
    private TextView txtNome;
    private TextView txtPreco;
    private ViewPager pgrImagens;
    private Produto produto;
    private Button btnAdicionarCarrinho;

    @Override
    protected int getLayoutRes() {
        return R.layout.activity_produto;
    }

    @Override
    protected void setupView() {
        txtResumo = (TextView) findViewById(R.id.produto_resumo);
        txtNome = (TextView) findViewById(R.id.produto_titulo);
        txtPreco = (TextView) findViewById(R.id.produto_preco);
        //pgrImagens = (ViewPager) findViewById(R.id.produto_lista_imagens);
        btnAdicionarCarrinho = (Button) findViewById(R.id.produto_adicionar_carrinho);
        btnAdicionarCarrinho.setOnClickListener(this);

        produto = (Produto) getIntent().getSerializableExtra(PRODUTO_PARAMETER);

        txtNome.setText(produto.getTitulo());

        String preco = "R$ " + produto.getPreco();
        txtPreco.setText(preco);

        txtResumo.setText(produto.getDescricao());

        //PageViewAdapter adapter = new PageViewAdapter(produto.getListaImagem(),this);
        //pgrImagens.setAdapter(adapter);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {

        if (item.getItemId() == android.R.id.home) {
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
    public void onClick(View view) {

    }
}
