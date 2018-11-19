package uniftec.com.br.ecommerce.ui;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.DragEvent;
import android.view.View;
import android.widget.Toast;

import uniftec.com.br.ecommerce.R;
import uniftec.com.br.ecommerce.model.Produto;
import uniftec.com.br.ecommerce.util.AppUtil;

public abstract class AbstractActivity extends AppCompatActivity implements View.OnDragListener {

    private Produto produto;
    protected ActionBar actionBar;
    public AppUtil appUtil;

    @Override
    protected final void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(getLayoutRes());

        Toolbar toolbar = (Toolbar)findViewById(R.id.main_toolbar);
        setSupportActionBar(toolbar);

        toolbar.setOnDragListener(this);

        actionBar = getSupportActionBar();
        actionBar.setDisplayHomeAsUpEnabled(true);

        this.appUtil = new AppUtil(this);
        setupView();
    }

    protected abstract int getLayoutRes();
    protected abstract void setupView();

    public boolean onDragProduto(Produto produto, View v, DragEvent event){
        this.produto = produto;
        return onDrag(v, event);
    }

    @Override
    public boolean onDrag(View v, DragEvent event) {
        int action = event.getAction();
        float y = event.getY();

        if(y < 132) {
            if (action == DragEvent.ACTION_DROP){
                appUtil.addCarrinho(produto);
                Toast.makeText(this, "Adicionado ao Carrinho", Toast.LENGTH_LONG).show();
            }
        }

        return true;
    }

}
