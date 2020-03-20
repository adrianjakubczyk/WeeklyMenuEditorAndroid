package com.menueditor;

import android.annotation.SuppressLint;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.PorterDuff;
import android.graphics.PorterDuffXfermode;
import android.graphics.Rect;
import android.graphics.RectF;
import android.graphics.drawable.BitmapDrawable;
import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.view.MotionEvent;
import android.view.View;
import android.widget.ImageView;

import static com.menueditor.GeneratedMenu.finalImageHeight;
import static com.menueditor.GeneratedMenu.finalImageWidth;

public class EditBackground extends AppCompatActivity {

    private static final int NONE = 0;
    private static final int SINGLE = 1;
    private static final int DOUBLE = 3;
    private int mode;


    private float offsetX;

    private float offsetY;

    private float offsetXSum;

    private float offsetYSum;

    private float startX;

    private float startY;

    private ImageView imageView;

    private Bitmap overlay;
    private Bitmap bitmap;
    private Canvas canvas;

    float padding = 100;
    float zoom = 1;
    float zoomTmp = 1;
    float scale;
    float scaleInverse;


    float oldDist = 1f;

    private GeneratedMenu gm;


    @SuppressLint("ClickableViewAccessibility")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_edit_backgound);

        gm = GeneratedMenu.getInstance();


        scaleInverse=1;
        imageView = (ImageView)findViewById(R.id.imageView);



        imageView.setOnTouchListener(new View.OnTouchListener() {

            @Override
            public boolean onTouch(View view, MotionEvent event) {
                switch(event.getAction() & MotionEvent.ACTION_MASK){
                    case MotionEvent.ACTION_DOWN : {
                        mode = SINGLE;
                        scale*=zoom*zoomTmp;
                        offsetXSum += offsetX;
                        offsetYSum += offsetY;
                        offsetXSum *= zoom*zoomTmp;
                        offsetYSum *= zoom*zoomTmp;
                        zoom =1;
                        zoomTmp=1;
                        offsetX = 0;
                        offsetY = 0;
                        startX = event.getX();
                        startY = event.getY();
                        redraw();
                    }
                    break;
                    case MotionEvent.ACTION_POINTER_DOWN: {

                        zoom *= zoomTmp;

                        zoomTmp=1;
                        oldDist = spacing(event);
                        if (oldDist > 10f) {
                            mode = DOUBLE;
                        }
                        redraw();
                    }
                    break;
                    case MotionEvent.ACTION_MOVE : {

                        if (mode == SINGLE) {

                            offsetX = event.getX()-startX;
                            offsetY = event.getY()-startY;
                            redraw();

                        } else if (mode == DOUBLE && event.getPointerCount() == 2) {
                            float newDist = spacing(event);
                            if (newDist > 10f) {
                                zoomTmp = newDist / oldDist;

                            }
                            redrawZooming();
                        }

                    }
                    break;
                    case MotionEvent.ACTION_UP :
                    {
                        mode = NONE;
                    }
                    break;
                    case MotionEvent.ACTION_POINTER_UP:
                    {
                        mode = NONE;
                        scale*=zoom*zoomTmp;
                        offsetXSum=(offsetXSum+offsetX)*(zoom*zoomTmp);
                        offsetYSum=(offsetYSum+offsetY)*(zoom*zoomTmp);
                        zoom=1;
                        zoomTmp=1;
                        offsetX=0;
                        offsetY=0;


                        redraw();

                    }
                    break;
                }
                return true;
            }
        });


    }


    public void onWindowFocusChanged(boolean hasFocus) {
        // TODO Auto-generated method stub
        super.onWindowFocusChanged(hasFocus);
        if (hasFocus) {
            imageView = (ImageView)findViewById(R.id.imageView);

            if(scale==0){
                scale = (imageView.getHeight()-2*padding)/ finalImageHeight;
                scaleInverse = finalImageHeight/(imageView.getHeight()-2*padding);
            }

            if(bitmap==null){
                bitmap = Bitmap.createBitmap(imageView.getWidth(), imageView.getHeight(), Bitmap.Config.ARGB_8888);
            }
            if(canvas==null){
                canvas = new Canvas(bitmap);
            }
            if(overlay==null){
                overlay = createOverlayBitmap();
            }


            offsetXSum = gm.getBackgroundOffsetX()*scale;
            offsetYSum = gm.getBackgroundOffsetY()*scale;
            scale *= gm.getBackgroundScale();

            redraw();



        }

    }

    private Bitmap createOverlayBitmap(){
        Bitmap ov = Bitmap.createBitmap(imageView.getWidth(), imageView.getHeight(), Bitmap.Config.ARGB_8888);
        Canvas canvas = new Canvas(ov);
        canvas.setBitmap(ov);
        Paint paintOverlay = new Paint();
        paintOverlay.setColor(0x4C0077FF);
        canvas.drawRect(0,0,ov.getWidth(),ov.getHeight(),paintOverlay);
        paintOverlay.setStyle(Paint.Style.STROKE);
        paintOverlay.setColor(0xCC0077FF);
        paintOverlay.setStrokeWidth(6);

        float scaledFinalWidth = finalImageWidth*scale;
        float scaledFinalHeight = finalImageHeight*scale;
        float left = ov.getWidth()/2-scaledFinalWidth/2;
        float top = ov.getHeight()/2-scaledFinalHeight/2;
        float right = ov.getWidth()/2+scaledFinalWidth/2;
        float bottom = ov.getHeight()/2+scaledFinalHeight/2;

        canvas.drawRect(left, top, right, bottom,paintOverlay);
        paintOverlay.setStyle(Paint.Style.FILL);
        paintOverlay.setXfermode(new PorterDuffXfermode(PorterDuff.Mode.CLEAR));
        canvas.drawRect(left, top, right, bottom, paintOverlay);

        return ov;
    }

    private void redraw(){
        Paint p = new Paint();
        p.setColor(Color.parseColor("#ff0000"));
        canvas.drawColor(Color.TRANSPARENT, PorterDuff.Mode.CLEAR);


        float x = canvas.getWidth()/2-gm.getBackgroundBitmap().getWidth()/2*scale*(zoom*zoomTmp)+(offsetXSum+offsetX);
        float y = canvas.getHeight()/2-gm.getBackgroundBitmap().getHeight()/2*scale*(zoom*zoomTmp)+(offsetYSum+offsetY);
        Rect src = new Rect(0,0,gm.getBackgroundBitmap().getWidth(),gm.getBackgroundBitmap().getHeight());
        RectF dst = new RectF(x,y,gm.getBackgroundBitmap().getWidth()*scale*(zoom*zoomTmp)+x,gm.getBackgroundBitmap().getHeight()*scale*(zoom*zoomTmp)+y);
        canvas.drawBitmap(gm.getBackgroundBitmap(),src,dst,p);

        canvas.drawBitmap(overlay,0,0,p);



        imageView.setImageDrawable(new BitmapDrawable(getResources(), bitmap));
    }
    private void redrawZooming(){
        Paint p = new Paint();
        p.setColor(Color.parseColor("#ff0000"));
        canvas.drawColor(Color.TRANSPARENT, PorterDuff.Mode.CLEAR);


        float x = canvas.getWidth()/2-gm.getBackgroundBitmap().getWidth()/2*scale*(zoom*zoomTmp)+(offsetXSum+offsetX)*(zoom*zoomTmp);
        float y = canvas.getHeight()/2-gm.getBackgroundBitmap().getHeight()/2*scale*(zoom*zoomTmp)+(offsetYSum+offsetY)*(zoom*zoomTmp);
        Rect src = new Rect(0,0,gm.getBackgroundBitmap().getWidth(),gm.getBackgroundBitmap().getHeight());
        RectF dst = new RectF(x,y,gm.getBackgroundBitmap().getWidth()*scale*(zoom*zoomTmp)+x,gm.getBackgroundBitmap().getHeight()*scale*(zoom*zoomTmp)+y);
        canvas.drawBitmap(gm.getBackgroundBitmap(),src,dst,p);

        canvas.drawBitmap(overlay,0,0,p);



        imageView.setImageDrawable(new BitmapDrawable(getResources(), bitmap));
    }


    private float spacing(MotionEvent event) {
        float x = event.getX(0) - event.getX(1);
        float y = event.getY(0) - event.getY(1);
        return (float)Math.sqrt(x * x + y * y);

    }



    public void onOkClicked(View v){


        gm.setBackgroundScale(scale*(zoom*zoomTmp)*scaleInverse);
        gm.setBackgroundOffsetX(((offsetXSum+offsetX))*scaleInverse);
        gm.setBackgroundOffsetY(((offsetYSum+offsetY))*scaleInverse);

        finish();
        overridePendingTransition(R.anim.slide_in_top, R.anim.slide_out_bottom);


    }

    public void onCancelClicked(View v){


        finish();
        overridePendingTransition(R.anim.slide_in_top, R.anim.slide_out_bottom);
    }

}
