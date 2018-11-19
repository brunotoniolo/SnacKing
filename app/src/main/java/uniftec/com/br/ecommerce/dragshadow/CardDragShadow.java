package uniftec.com.br.ecommerce.dragshadow;

import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Point;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.Drawable;
import android.view.View;
import android.view.View.DragShadowBuilder;
import android.widget.ImageView;

import uniftec.com.br.ecommerce.R;

/**
 * Created by bruno.toniolo on 29/10/2017.
 */

public class CardDragShadow extends DragShadowBuilder  {

    private static Drawable shadow;

    public  CardDragShadow(View view){
        super(view);

        shadow = new ColorDrawable(Color.LTGRAY);
    }

    @Override
    public void onProvideShadowMetrics(Point size, Point touch) {
        int width, height;
        width = getView().getWidth() / 2;
        height = getView().getHeight() / 2;
        shadow.setBounds(0, 0, width, height);
        size.set(width, height);
        touch.set(width / 2, height / 2);

    }

    @Override
    public void onDrawShadow(Canvas canvas) {
        shadow.draw(canvas);
    }
}
