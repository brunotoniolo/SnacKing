package uniftec.com.br.ecommerce.adapter;

import android.content.Context;
import android.media.Image;
import android.net.Uri;
import android.support.v4.view.PagerAdapter;
import android.support.v4.view.ViewPager;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import java.net.URI;
import java.util.List;

import uniftec.com.br.ecommerce.model.Imagem;

/**
 * Created by bruno.toniolo on 29/10/2017.
 */

public class PageViewAdapter extends PagerAdapter {

    private Context context;
    private List<Imagem> imagens;

    public PageViewAdapter(List<Imagem> imagens, Context context){
        this.context = context;
        this.imagens = imagens;
    }

    @Override
    public int getCount() {
        return imagens.size();
    }

    @Override
    public boolean isViewFromObject(View view, Object object) {
        return view.equals(object);
    }

    @Override
    public void destroyItem(ViewGroup container, int position, Object object) {
        ((ViewPager) container).removeView((ImageView) object);
    }

    @Override
    public Object instantiateItem(ViewGroup container, int position) {
        ImageView imagem = new ImageView(context);
        imagem.setScaleType(ImageView.ScaleType.CENTER_INSIDE);

        Uri uri = Uri.parse(imagens.get(position).getUrl());

        imagem.setImageURI(uri);
        imagens.get(position).criaImagem(container.getContext(), imagem);

        ((ViewPager) container).addView(imagem, 0);
        return imagem;
    }
}
