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
import uniftec.com.br.ecommerce.model.Endereco;

public class EnderecoAdapter extends RecyclerView.Adapter<EnderecoAdapter.EnderecoViewHolder>{

    private static CardViewListeners cardViewListeners;
    private List<Endereco> enderecoList;

    public EnderecoAdapter(List<Endereco> list, CardViewListeners listeners) {
        this.enderecoList = list;
        this.cardViewListeners = listeners;
    }


    @Override
    public EnderecoViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.endereco_card, parent, false);
        EnderecoViewHolder evh = new EnderecoViewHolder(v);
        return evh;
    }

    @Override
    public void onBindViewHolder(EnderecoViewHolder holder, int position) {
        holder.txtRua.setText(enderecoList.get(position).getRua()
                + " "
                + enderecoList.get(position).getNumero()
                + " "
                + enderecoList.get(position).getComplemento());
        holder.txtLocalizacao.setText(enderecoList.get(position).getCidade()
                + ", "
                + enderecoList.get(position).getEstado());

    }

    @Override
    public int getItemCount() {
        return enderecoList.size();
    }

    class EnderecoViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {
        CardView cardEndereco;
        TextView txtRua;
        TextView txtLocalizacao;

        EnderecoViewHolder(View itemView) {
            super(itemView);
            cardEndereco = (CardView)itemView.findViewById(R.id.endereco_card_view);
            txtRua = (TextView)itemView.findViewById(R.id.endereco_card_rua);
            txtLocalizacao = (TextView)itemView.findViewById(R.id.endereco_card_cidade_estado);

            cardEndereco.setOnClickListener(this);
        }

        @Override
        public void onClick(View v) {
            cardViewListeners.onItemClick(getAdapterPosition(), v);
        }



    }
}
