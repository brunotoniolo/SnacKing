package uniftec.com.br.ecommerce.ui;

import android.graphics.Bitmap;
import android.graphics.Point;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.Display;
import android.view.WindowManager;
import android.widget.ImageView;

import com.google.zxing.BarcodeFormat;
import com.google.zxing.WriterException;

import uniftec.com.br.ecommerce.R;
import uniftec.com.br.ecommerce.qrcode.Contents;
import uniftec.com.br.ecommerce.qrcode.QRCodeEncoder;

public class QrCode extends AppCompatActivity {

    private String LOG_TAG = "GenerateQRCode";

    private String qrCode;
    private ImageView imageQrCode;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_qr_code);

        imageQrCode = (ImageView) findViewById(R.id.image_view_qr_code);

        qrCode = "Teste geral";

        Log.v(LOG_TAG, qrCode);

        WindowManager manager = (WindowManager) getSystemService(WINDOW_SERVICE);
        assert manager != null;
        Display display = manager.getDefaultDisplay();
        Point point = new Point();
        display.getSize(point);

        int width = point.x;
        int heigth = point.y;
        int smallerDimension = width < heigth ? width : heigth;

        smallerDimension = smallerDimension * 3 / 4;

        //Encode with a QR Code Image
        QRCodeEncoder qrCodeEncoder = new QRCodeEncoder(
                qrCode,
                null,
                Contents.Type.TEXT,
                BarcodeFormat.QR_CODE.toString(),
                smallerDimension
        );

        try {
            Bitmap bitmap = qrCodeEncoder.encodeAsBitmap();
            imageQrCode.setImageBitmap(bitmap);
        } catch (WriterException e) {
            e.printStackTrace();
        }
    }
}
