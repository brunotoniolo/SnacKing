package uniftec.com.br.ecommerce.adapter;

import android.content.Context;
import android.support.v7.widget.CardView;
import android.support.v7.widget.RecyclerView;
import android.view.DragEvent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import java.text.NumberFormat;
import java.util.List;
import java.util.Locale;

import uniftec.com.br.ecommerce.R;
import uniftec.com.br.ecommerce.interfaces.CardViewListeners;
import uniftec.com.br.ecommerce.model.Produto;

public class ProdutoAdapter extends RecyclerView.Adapter<ProdutoAdapter.ProdutoViewHolder> {

    private static CardViewListeners cardViewListeners;

    class ProdutoViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener, View.OnDragListener, View.OnLongClickListener {
        View layoutView;
        CardView cardProduto;
        //ImageView imgProduto;
        TextView prodValor;
        TextView prodNome;
        TextView prodDescricao;

        ProdutoViewHolder(View itemView) {
            super(itemView);
            layoutView = itemView;
            cardProduto = (CardView)itemView.findViewById(R.id.produto_card_view);
            //imgProduto = (ImageView)itemView.findViewById(R.id.produto_card_imagem);
            prodValor = (TextView)itemView.findViewById(R.id.produto_card_preco);
            prodNome = (TextView)itemView.findViewById(R.id.produto_card_nome);
            prodDescricao = (TextView)itemView.findViewById(R.id.produto_card_descricao);

            itemView.setOnClickListener(this);
            itemView.setOnDragListener(this);
            itemView.setOnLongClickListener(this);
        }

        @Override
        public void onClick(View v) {
            cardViewListeners.onItemClick(getAdapterPosition(), v);
        }

        @Override
        public boolean onDrag(View v, DragEvent event) {
            return cardViewListeners.onItemDrag(produtos.get(getAdapterPosition()), v, event);
        }

        @Override
        public boolean onLongClick(View v) {
            return cardViewListeners.onItemLongClickListener(produtos.get(getAdapterPosition()), v);

        }
    }

    private List<Produto> produtos;
    private Context context;

    public ProdutoAdapter(List<Produto> produtos, CardViewListeners clickListener){
        this.produtos = produtos;
        this.cardViewListeners = clickListener;
    }


    @Override
    public ProdutoViewHolder onCreateViewHolder(ViewGroup viewGroup, int i){
        View v = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.produto_card, viewGroup, false);
        this.context = viewGroup.getContext();
        ProdutoViewHolder pvh = new ProdutoViewHolder(v);
        return pvh;
    }

    @Override
    public void onBindViewHolder(ProdutoViewHolder produtoViewHolder, int i) {
        produtoViewHolder.layoutView.setTag(produtos.get(i));

        //produtos.get(i).getImagem().criaImagem(this.context, produtoViewHolder.imgProduto);

        produtoViewHolder.prodNome.setText(produtos.get(i).getTitulo());

        Locale ptBr = new Locale("pt", "BR");
        String valorPreco = NumberFormat.getCurrencyInstance(ptBr).format(produtos.get(i).getPreco());

        produtoViewHolder.prodValor.setText(valorPreco);
        if(produtos.get(i).getDescricao().length() > 50) {
            produtoViewHolder.prodDescricao.setText(produtos.get(i).getDescricao().replace("\n", "").substring(0, 50).concat("..."));
        }else {
            produtoViewHolder.prodDescricao.setText(produtos.get(i).getDescricao().replace("\n", ""));
        }
    }

    @Override
    public void onAttachedToRecyclerView(RecyclerView recyclerView) {
        super.onAttachedToRecyclerView(recyclerView);
    }

    @Override
    public int getItemCount() {
        return produtos.size();
    }
}
