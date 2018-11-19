package uniftec.com.br.ecommerce.interfaces;

import android.view.DragEvent;
import android.view.View;
import uniftec.com.br.ecommerce.model.*;

public interface CardViewListeners {
    public void onItemClick(int position, View v);
    public boolean onItemDrag(Produto produto, View v, DragEvent event);
    public boolean onItemLongClickListener(Produto produto, View v);
}