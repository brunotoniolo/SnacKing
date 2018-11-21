package uniftec.com.br.ecommerce.adapter;

import android.content.Context;
import android.support.v7.widget.CardView;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import java.text.NumberFormat;
import java.util.List;
import java.util.Locale;

import uniftec.com.br.ecommerce.R;
import uniftec.com.br.ecommerce.interfaces.CardViewListeners;
import uniftec.com.br.ecommerce.model.Produto;

public class CarrinhoAdapter extends RecyclerView.Adapter<CarrinhoAdapter.CarrinhoViewHolder> {

    private static CardViewListeners cardViewListeners;
    private List<Produto> produtos;
    private Context context;

    public CarrinhoAdapter(List<Produto> produtos, CardViewListeners cardViewListeners){
        this.produtos = produtos;
        this.cardViewListeners = cardViewListeners;
    }

    @Override
    public CarrinhoViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.carrinho_card, parent, false);
        this.context = parent.getContext();
        CarrinhoViewHolder cvh = new CarrinhoViewHolder(v);
        return cvh;
    }

    @Override
    public void onBindViewHolder(CarrinhoViewHolder holder, int position) {
        Produto p = produtos.get(position);
        holder.txtTitulo.setText(p.getTitulo());
        if(p.getDescricao().length() > 50) {
            holder.txtDescricao.setText(p.getDescricao().replace("\n", "").substring(0, 50).concat("..."));
        }else{
            holder.txtDescricao.setText(p.getDescricao().replace("\n", ""));
        }
        //p.getImagem().criaImagem(this.context, holder.imgImagem);
        Locale ptBr = new Locale("pt", "BR");
        String valorPreco = NumberFormat.getCurrencyInstance(ptBr).format(p.getPreco());

        holder.txtPreco.setText(valorPreco);
    }

    @Override
    public int getItemCount() {
        return produtos.size();
    }

    class CarrinhoViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {
        CardView cardCarrinho;
        TextView txtTitulo;
        TextView txtPreco;
        TextView txtDescricao;
        //ImageView imgImagem;

        CarrinhoViewHolder(View itemView) {
            super(itemView);
            cardCarrinho = (CardView)itemView.findViewById(R.id.carrinho_card_view);
            txtTitulo = (TextView)itemView.findViewById(R.id.carrinho_card_titulo);
            txtPreco = (TextView)itemView.findViewById(R.id.carrinho_card_preco);
            txtDescricao = (TextView)itemView.findViewById(R.id.carrinho_card_descricao);
            //imgImagem = (ImageView)itemView.findViewById(R.id.carrinho_card_imagem);

            cardCarrinho.setOnClickListener(this);
        }

        @Override
        public void onClick(View v) {
            cardViewListeners.onItemClick(getAdapterPosition(), v);
        }
    }


}
