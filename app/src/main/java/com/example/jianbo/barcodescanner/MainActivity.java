package com.example.jianbo.barcodescanner;

import android.graphics.Bitmap;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;

import com.example.jianbo.barcodescanner.create_code.QRCodeUtil;
import com.google.zxing.WriterException;

public class MainActivity extends AppCompatActivity {
    Button btn1,btn2;
    ImageView iv1,iv2;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        btn1= (Button) findViewById(R.id.btn_create);
        iv1 = (ImageView) findViewById(R.id.iv_barcode);
        btn2 = (Button) findViewById(R.id.btn_create_qr);
        iv2 = (ImageView) findViewById(R.id.iv_qrcode);
        btn1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
              Bitmap barcode =  QRCodeUtil.creatBarcode(MainActivity.this,"wangjianbo",500,120,false);
              iv1.setImageBitmap(barcode);
            }
        });
        btn2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                try {
                    Bitmap qrcode = QRCodeUtil.createQRCode("chengaolin",500);
                    iv2.setImageBitmap(qrcode);
                } catch (WriterException e) {
                    e.printStackTrace();
                }
            }
        });

    }
}
