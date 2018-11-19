package uniftec.com.br.ecommerce.adapter;

import android.support.v7.widget.CardView;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.List;

import uniftec.com.br.ecommerce.R;
import uniftec.com.br.ecommerce.interfaces.CardViewListeners;
import uniftec.com.br.ecommerce.model.Categoria;

public class CategoriaAdapter extends RecyclerView.Adapter<CategoriaAdapter.CategoriaViewHolder>  {

    private static CardViewListeners cardViewListeners;

    class CategoriaViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {
        CardView cardCategoria;
        TextView txtNome;

        CategoriaViewHolder(View itemView) {
            super(itemView);
            cardCategoria = (CardView)itemView.findViewById(R.id.categoria_card_view);
            txtNome = (TextView)itemView.findViewById(R.id.categoria_card_nome);

            cardCategoria.setOnClickListener(this);
        }

        @Override
        public void onClick(View v) {
            cardViewListeners.onItemClick(getAdapterPosition(), v);
        }
    }

    private List<Categoria> categorias;

    public CategoriaAdapter(List<Categoria> categorias, CardViewListeners cardViewListeners){
        this.categorias = categorias;
        this.cardViewListeners = cardViewListeners;
    }

    @Override
    public CategoriaViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.categoria_card, parent, false);
        CategoriaViewHolder cvh = new CategoriaViewHolder(v);
        return cvh;
    }

    @Override
    public void onBindViewHolder(CategoriaViewHolder holder, int position) {
        holder.txtNome.setText(categorias.get(position).getDescricao());
    }

    @Override
    public void onAttachedToRecyclerView(RecyclerView recyclerView) {
        super.onAttachedToRecyclerView(recyclerView);
    }

    @Override
    public int getItemCount() {
        return categorias.size();
    }
}
