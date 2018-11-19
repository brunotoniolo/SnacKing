package uniftec.com.br.ecommerce.adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.DragEvent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.List;

import uniftec.com.br.ecommerce.R;
import uniftec.com.br.ecommerce.interfaces.CardViewListeners;
import uniftec.com.br.ecommerce.model.Pedido;
import uniftec.com.br.ecommerce.model.Produto;

/**
 * Created by bruno.toniolo on 23/11/2017.
 */

public class PedidoAdapter extends RecyclerView.Adapter<PedidoAdapter.PedidoViewHolder> {

    private static CardViewListeners cardViewListeners;

    class PedidoViewHolder extends RecyclerView.ViewHolder {
        ImageView imagem;
        TextView statusData;
        TextView produtos;
        TextView preco;

        public PedidoViewHolder(View itemView) {
            super(itemView);
            imagem = (ImageView)itemView.findViewById(R.id.pedido_card_imagem);
            statusData = (TextView)itemView.findViewById(R.id.pedido_card_status_data);
            produtos = (TextView)itemView.findViewById(R.id.pedido_card_produtos);
            preco = (TextView)itemView.findViewById(R.id.pedido_card_preco);

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
        int i = 0;
        pedidos.get(position).getProdutos().get(0).getImagem().criaImagem(this.context, holder.imagem);

        for (Produto p : pedidos.get(position).getProdutos()) {
            if(i < 5) {
                holder.produtos.setText(holder.produtos.getText() + p.getTitulo() + "\n");
            }
            preco += p.getPreco();
            i++;
        }
        if( i > 5){
            holder.produtos.setText(holder.produtos.getText() + "+ " + (i - 5) + " produtos");
        }
        holder.preco.setText("R$ " + preco);
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