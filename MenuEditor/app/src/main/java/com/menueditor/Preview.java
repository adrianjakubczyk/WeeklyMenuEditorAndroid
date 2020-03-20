package com.menueditor;

import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Rect;
import android.graphics.RectF;
import android.graphics.drawable.BitmapDrawable;
import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;


import static com.menueditor.GeneratedMenu.finalImageHeight;

public class Preview extends AppCompatActivity {
    private ImageView imageView;
    private float scale;
    private Bitmap bitmap;
    private Canvas canvas;
    private GeneratedMenu gm;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_preview);

        gm = GeneratedMenu.getInstance();

    }
    public void onWindowFocusChanged(boolean hasFocus) {
        // TODO Auto-generated method stub
        super.onWindowFocusChanged(hasFocus);
        if (hasFocus) {
            imageView = findViewById(R.id.imageView);

            if (scale == 0) {
                scale = imageView.getHeight() / finalImageHeight;
            }



            if (bitmap == null) {
                bitmap = Bitmap.createBitmap(imageView.getWidth(), imageView.getHeight(), Bitmap.Config.ARGB_8888);
            }
            if (canvas == null) {
                canvas = new Canvas(bitmap);
            }

            Paint p = new Paint();
            Bitmap result = gm.generateOutputBitmap(this);
            float x = canvas.getWidth()/2-result.getWidth()/2*scale;
            float y = canvas.getHeight()/2-result.getHeight()/2*scale;
            Rect src = new Rect(0,0,result.getWidth(),result.getHeight());
            RectF dst = new RectF(x,y,result.getWidth()*scale+x,result.getHeight()*scale+y);
            canvas.drawBitmap(result,src,dst,p);

            imageView.setImageDrawable(new BitmapDrawable(getResources(), bitmap));
        }
    }

    public void onPrevClicked(View v){
        finish();
        overridePendingTransition(R.anim.slide_in_top, R.anim.slide_out_bottom);
    }

}
