package uniftec.com.br.ecommerce.ui;

import android.app.ProgressDialog;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.DragEvent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;
import java.util.ListIterator;

import uniftec.com.br.ecommerce.R;
import uniftec.com.br.ecommerce.adapter.ProdutoAdapter;
import uniftec.com.br.ecommerce.dragshadow.CardDragShadow;
import uniftec.com.br.ecommerce.interfaces.CardViewListeners;
import uniftec.com.br.ecommerce.model.Produto;
import uniftec.com.br.ecommerce.model.Response;
import uniftec.com.br.ecommerce.tasks.BuscaTodosProdutosTask;
import uniftec.com.br.ecommerce.util.AppUtil;

public class ListaProdutosFragment extends Fragment implements CardViewListeners, BuscaTodosProdutosTask.BuscaTodosProdutosDelegate {

    private RecyclerView recyclerView;
    private ProdutoAdapter adapter;
    private List<Produto> produtos;
    private AppUtil appUtil;
    ProgressDialog progressDialog;

    public ListaProdutosFragment(){

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.fragment_lista_produtos, container, false);
        recyclerView = (RecyclerView)view.findViewById(R.id.activity_produto_recycle);
        recyclerView.setHasFixedSize(true);

        return view;
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        this.appUtil = new AppUtil(getActivity());

        BuscaTodosProdutosTask task = new BuscaTodosProdutosTask(this);
        task.execute();
        progressDialog = ProgressDialog.show(getActivity(), "Aguarde", "Carregando Produtos", true, false);

        recyclerView.setLayoutManager(new GridLayoutManager(getActivity(), 2, GridLayoutManager.VERTICAL, false));

        super.onActivityCreated(savedInstanceState);
    }


    @Override
    public void onItemClick(int position, View v) {
        Intent intent = new Intent(getActivity(), ProdutoActivity.class);

        Produto produto = produtos.get(position);
        intent.putExtra(ProdutoActivity.PRODUTO_PARAMETER, produto);

        startActivity(intent);
    }

    @Override
    public boolean onItemDrag(Produto produto, View v, DragEvent event) {
        return ((MenuActivity) getActivity()).onDragProduto(produto, v, event);
    }

    @Override
    public boolean onItemLongClickListener(Produto produto, View v) {

        CardDragShadow cardDragShadow = new CardDragShadow(v);
        v.startDrag(null, cardDragShadow, null, 0);

        return true;
    }

    @Override
    public void BuscaTodosProdutosSucesso(Response<List<Produto>> response) {
        progressDialog.dismiss();
        progressDialog = null;

        this.produtos = response.getData();

        adapter = new ProdutoAdapter(produtos, this);
        recyclerView.setAdapter(adapter);
    }

    @Override
    public void BuscaTodosProdutosErro(String mensagem) {
        progressDialog.dismiss();
        progressDialog = null;
        Toast.makeText(getActivity(), mensagem, Toast.LENGTH_SHORT).show();
    }
}
