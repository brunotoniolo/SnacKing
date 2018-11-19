package uniftec.com.br.ecommerce.ui;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.DragEvent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import java.util.List;

import uniftec.com.br.ecommerce.R;
import uniftec.com.br.ecommerce.adapter.CategoriaAdapter;
import uniftec.com.br.ecommerce.model.*;
import uniftec.com.br.ecommerce.interfaces.CardViewListeners;
import uniftec.com.br.ecommerce.model.Categoria;
import uniftec.com.br.ecommerce.tasks.BuscaTodasCategoriasTask;

public class ListaCategoriasFragment extends Fragment implements CardViewListeners, BuscaTodasCategoriasTask.BuscaTodasCategoriasDelegate {

    public ListaCategoriasFragment() {

    }
    private List<Categoria> categorias;
    private RecyclerView recyclerView;
    private CategoriaAdapter adapter;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.fragment_lista_categorias, container, false);
        recyclerView = (RecyclerView)view.findViewById(R.id.fragment_categoria_recycle);
        recyclerView.setHasFixedSize(true);
        return view;
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        LinearLayoutManager llm = new LinearLayoutManager(getActivity(), GridLayoutManager.VERTICAL, false);
        recyclerView.setLayoutManager(llm);

        BuscaTodasCategoriasTask task = new BuscaTodasCategoriasTask(this);
        task.execute();

        super.onActivityCreated(savedInstanceState);
    }

    @Override
    public void onItemClick(int position, View v) {
        ListaProdutosFragment fragment = new ListaProdutosFragment();

        FragmentTransaction transaction = getFragmentManager().beginTransaction();
        transaction.replace(R.id.main_container, fragment);
        transaction.commit();
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
    public void BuscaTodasCategoriasSucesso(Response<List<Categoria>> response) {
        this.categorias = response.getData();
        CategoriaAdapter adapter = new CategoriaAdapter(categorias, this);
        recyclerView.setAdapter(adapter);

    }

    @Override
    public void BuscaTodasCategoriasErro(String mensagem) {
        Toast.makeText(getActivity(), mensagem, Toast.LENGTH_SHORT).show();
    }
}
