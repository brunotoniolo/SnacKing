package uniftec.com.br.ecommerce.adapter;

import android.content.Context;
import android.content.Intent;
import android.support.v7.widget.CardView;
import android.support.v7.widget.RecyclerView;
import android.view.DragEvent;
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
import uniftec.com.br.ecommerce.model.Pedido;
import uniftec.com.br.ecommerce.model.Produto;
import uniftec.com.br.ecommerce.ui.QrCode;

/**
 * Created by bruno.toniolo on 23/11/2017.
 */

public class PedidoAdapter extends RecyclerView.Adapter<PedidoAdapter.PedidoViewHolder> {

    private static CardViewListeners cardViewListeners;

    class PedidoViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {
        ImageView imagem;
        TextView statusData;
        TextView produtos;
        TextView preco;
        CardView cardView;

        public PedidoViewHolder(View itemView) {
            super(itemView);
            ///imagem = (ImageView)itemView.findViewById(R.id.pedido_card_imagem);
            statusData = (TextView)itemView.findViewById(R.id.pedido_card_status_data);
            produtos = (TextView)itemView.findViewById(R.id.pedido_card_produtos);
            preco = (TextView)itemView.findViewById(R.id.pedido_card_preco);
            cardView = (CardView)itemView.findViewById(R.id.pedido_card_view);

            cardView.setOnClickListener(this);
        }

        @Override
        public void onClick(View v) {
            Intent intent = new Intent(context, QrCode.class);
            context.startActivity(intent);
        }
    }

    private List<Pedido> pedidos;
    private Context context;

    public PedidoAdapter(List<Pedido> pedidos){
        this.pedidos = pedidos;
    }

    @Override
    public PedidoViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.pedido_card, parent, false);
        this.context = parent.getContext();
        PedidoViewHolder pvh = new PedidoViewHolder(v);
        return pvh;
    }

    @Override
    public void onBindViewHolder(PedidoViewHolder holder, int position) {
        Double preco = 0.0;
        List<Produto> produtos = pedidos.get(position).getProdutos();
        int i = 0;
        //pedidos.get(position).getProdutos().get(0).getImagem().criaImagem(this.context, holder.imagem);

        for (Produto p : produtos) {
            if(i < 5) {
                holder.produtos.setText(holder.produtos.getText() + p.getTitulo() + "\n");
            }
            preco += p.getPreco();
            i++;
        }
        if( i > 5){
            holder.produtos.setText(holder.produtos.getText() + "+ " + (i - 5) + " produtos");
        }

        Locale ptBr = new Locale("pt", "BR");
        holder.statusData.setText(pedidos.get(position).getStatus());
        holder.preco.setText(NumberFormat.getCurrencyInstance(ptBr).format(preco));
    }

    @Override
    public void onAttachedToRecyclerView(RecyclerView recyclerView) {
        super.onAttachedToRecyclerView(recyclerView);
    }

    @Override
    public int getItemCount() {
        return pedidos.size();
    }
}