package uniftec.com.br.ecommerce.ui;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.DragEvent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import java.util.List;

import uniftec.com.br.ecommerce.R;
import uniftec.com.br.ecommerce.adapter.CarrinhoAdapter;
import uniftec.com.br.ecommerce.adapter.ProdutoAdapter;
import uniftec.com.br.ecommerce.interfaces.CardViewListeners;
import uniftec.com.br.ecommerce.model.Produto;

public class CarrinhoFragment extends Fragment implements CardViewListeners, View.OnClickListener {

    private RecyclerView recyclerView;
    private List<Produto> produtos;
    private CarrinhoAdapter adapter;
    private Button finalizaCarrinho;

    public CarrinhoFragment() {
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_carrinho, container, false);
        recyclerView = (RecyclerView)view.findViewById(R.id.fragment_carrinho_recycle);
        recyclerView.setHasFixedSize(true);

        finalizaCarrinho = (Button) view.findViewById(R.id.finaliza_compra_carrinho);
        return view;
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        recyclerView.setLayoutManager(new LinearLayoutManager(getActivity(), LinearLayoutManager.VERTICAL, false));
        this.produtos = ((AbstractActivity)getActivity()).appUtil.getCarrinho();

        adapter = new CarrinhoAdapter(produtos, this);
        recyclerView.setAdapter(adapter);

        finalizaCarrinho.setOnClickListener(this);

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
        return false;
    }

    @Override
    public boolean onItemLongClickListener(Produto produto, View v) {
        return false;
    }

    @Override
    public void onClick(View view) {
        Intent intent = new Intent(getActivity(), FinalizaCompraActivity.class);
        startActivity(intent);
    }
}
