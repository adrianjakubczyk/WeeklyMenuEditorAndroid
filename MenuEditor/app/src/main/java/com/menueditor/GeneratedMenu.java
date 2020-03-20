package com.menueditor;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Rect;
import android.graphics.RectF;
import android.graphics.Typeface;
import android.net.Uri;
import androidx.core.content.res.ResourcesCompat;

import java.util.Calendar;
import java.util.Date;
import java.util.List;

public class GeneratedMenu {

//    public static float finalImageWidth = 680;
//    public static float finalImageHeight = 960;
    public static float finalImageWidth = 1241;
    public static float finalImageHeight = 1754;
    private Uri backgroundImageUri;
    private Bitmap backgroundBitmap;
    private float backgroundOffsetX;
    private float backgroundOffsetY;
    private float backgroundScale;

    private int themeColor;
    private int headerTextColor;
    private int contentTextColor;

    private Date dateStart;
    private Date dateEnd;

    private String timeStart;
    private String timeEnd;

    private String price;

    private List<String> daysInWeek;
    private List<String> firstCourses;
    private List<String> secondCourses;

    //private boolean isBlured;
    //private boolean isTransparent;
    private int backgroundAlpha;
    private int backgroundBlur;
    private boolean isBold;

    private int fontSize;


    private static GeneratedMenu instance;

    private GeneratedMenu() {
    }

    public static GeneratedMenu getInstance() {
        if(instance == null){
            instance = new GeneratedMenu();
            instance.setBackgroundOffsetX(0);
            instance.setBackgroundOffsetY(0);
            instance.setBackgroundScale(1);
            instance.setBackgroundAlpha(100);
            instance.setBackgroundBlur(0);
            instance.setThemeColor(Color.parseColor("#bbc89a"));
            instance.setHeaderTextColor(Color.parseColor("#1F1F1F"));
            instance.setContentTextColor(Color.parseColor("#1F1F1F"));
            instance.setFontSize(18);
            instance.setPrice("15");
            instance.setTimeStart("11:00");
            instance.setTimeEnd("17:00");
        }
        return instance;
    }

    public Bitmap getBackgroundBitmap() {
        return backgroundBitmap;
    }

    public void setBackgroundBitmap(Bitmap backgroundBitmap) {
        this.backgroundBitmap = backgroundBitmap;
    }

    public Uri getBackgroundImageUri() {
        return backgroundImageUri;
    }

    public void setBackgroundImageUri(Uri backgroundImageUri) {
        this.backgroundImageUri = backgroundImageUri;
    }

    public float getBackgroundOffsetX() {
        return backgroundOffsetX;
    }

    public void setBackgroundOffsetX(float backgroundOffsetX) {
        this.backgroundOffsetX = backgroundOffsetX;
    }

    public float getBackgroundOffsetY() {
        return backgroundOffsetY;
    }

    public void setBackgroundOffsetY(float backgroundOffsetY) {
        this.backgroundOffsetY = backgroundOffsetY;
    }

    public float getBackgroundScale() {
        return backgroundScale;
    }

    public void setBackgroundScale(float backgroundScale) {
        this.backgroundScale = backgroundScale;
    }

    public int getThemeColor() {
        return themeColor;
    }

    public void setThemeColor(int themeColor) {
        this.themeColor = themeColor;
    }

    public int getHeaderTextColor() {
        return headerTextColor;
    }

    public void setHeaderTextColor(int headerTextColor) {
        this.headerTextColor = headerTextColor;
    }

    public Date getDateStart() {
        return dateStart;
    }

    public Date getDateEnd() {
        return dateEnd;
    }

    public String getTimeStart() {
        return timeStart;
    }

    public String getTimeEnd() {
        return timeEnd;
    }

    public String getPrice() {
        return price;
    }

    public void setDateStart(Date dateStart) {
        this.dateStart = dateStart;
    }

    public void setDateEnd(Date dateEnd) {
        this.dateEnd = dateEnd;
    }

    public void setTimeStart(String timeStart) {
        this.timeStart = timeStart;
    }

    public void setTimeEnd(String timeEnd) {
        this.timeEnd = timeEnd;
    }

    public void setPrice(String price) {
        this.price = price;
    }

    public List<String> getDaysInWeek() {
        return daysInWeek;
    }

    public void setDaysInWeek(List<String> daysInWeek) {
        this.daysInWeek = daysInWeek;
    }

    public List<String> getFirstCourses() {
        return firstCourses;
    }

    public void setFirstCourses(List<String> firstCourses) {
        this.firstCourses = firstCourses;
    }

    public List<String> getSecondCourses() {
        return secondCourses;
    }

    public void setSecondCourses(List<String> secondCourses) {
        this.secondCourses = secondCourses;
    }

    public int getContentTextColor() {
        return contentTextColor;
    }

    public void setContentTextColor(int contentTextColor) {
        this.contentTextColor = contentTextColor;
    }

    public int getBackgroundAlpha() {
        return backgroundAlpha;
    }

    public void setBackgroundAlpha(int backgroundAlpha) {
        this.backgroundAlpha = backgroundAlpha;
    }

    public int getBackgroundBlur() {
        return backgroundBlur;
    }

    public void setBackgroundBlur(int backgroundBlur) {
        this.backgroundBlur = backgroundBlur;
    }

    public boolean isBold() {
        return isBold;
    }

    public void setBold(boolean bold) {
        isBold = bold;
    }

    public int getFontSize() {
        return fontSize;
    }

    public void setFontSize(int fontSize) {
        this.fontSize = fontSize;
    }

    public String extractHours(String time){
        if(time.trim().length()==5||time.trim().length()==2){
            return time.substring(0,2);
        }
        if(time.trim().length()==4||time.trim().length()==1){
            return time.substring(0,1);
        }
        return "ERROR";

    }

    public  String extractMinutes(String time){
        if(time.trim().length()==5){
            return time.substring(3,5);
        }
        if(time.trim().length()==4){
            return time.substring(2,4);
        }
        if(time.trim().length()==1){
            return "00";
        }
        if(time.trim().length()==2){
            return "00";
        }

        return "ERROR";
    }

    public Bitmap fastblur(Bitmap sentBitmap, float scale, int radius) {

        int width = Math.round(sentBitmap.getWidth() * scale);
        int height = Math.round(sentBitmap.getHeight() * scale);
        sentBitmap = Bitmap.createScaledBitmap(sentBitmap, width, height, false);

        Bitmap bitmap = sentBitmap.copy(sentBitmap.getConfig(), true);

        if (radius < 1) {
            return (null);
        }

        int w = bitmap.getWidth();
        int h = bitmap.getHeight();

        int[] pix = new int[w * h];
        bitmap.getPixels(pix, 0, w, 0, 0, w, h);

        int wm = w - 1;
        int hm = h - 1;
        int wh = w * h;
        int div = radius + radius + 1;

        int r[] = new int[wh];
        int g[] = new int[wh];
        int b[] = new int[wh];
        int rsum, gsum, bsum, x, y, i, p, yp, yi, yw;
        int vmin[] = new int[Math.max(w, h)];

        int divsum = (div + 1) >> 1;
        divsum *= divsum;
        int dv[] = new int[256 * divsum];
        for (i = 0; i < 256 * divsum; i++) {
            dv[i] = (i / divsum);
        }

        yw = yi = 0;

        int[][] stack = new int[div][3];
        int stackpointer;
        int stackstart;
        int[] sir;
        int rbs;
        int r1 = radius + 1;
        int routsum, goutsum, boutsum;
        int rinsum, ginsum, binsum;

        for (y = 0; y < h; y++) {
            rinsum = ginsum = binsum = routsum = goutsum = boutsum = rsum = gsum = bsum = 0;
            for (i = -radius; i <= radius; i++) {
                p = pix[yi + Math.min(wm, Math.max(i, 0))];
                sir = stack[i + radius];
                sir[0] = (p & 0xff0000) >> 16;
                sir[1] = (p & 0x00ff00) >> 8;
                sir[2] = (p & 0x0000ff);
                rbs = r1 - Math.abs(i);
                rsum += sir[0] * rbs;
                gsum += sir[1] * rbs;
                bsum += sir[2] * rbs;
                if (i > 0) {
                    rinsum += sir[0];
                    ginsum += sir[1];
                    binsum += sir[2];
                } else {
                    routsum += sir[0];
                    goutsum += sir[1];
                    boutsum += sir[2];
                }
            }
            stackpointer = radius;

            for (x = 0; x < w; x++) {

                r[yi] = dv[rsum];
                g[yi] = dv[gsum];
                b[yi] = dv[bsum];

                rsum -= routsum;
                gsum -= goutsum;
                bsum -= boutsum;

                stackstart = stackpointer - radius + div;
                sir = stack[stackstart % div];

                routsum -= sir[0];
                goutsum -= sir[1];
                boutsum -= sir[2];

                if (y == 0) {
                    vmin[x] = Math.min(x + radius + 1, wm);
                }
                p = pix[yw + vmin[x]];

                sir[0] = (p & 0xff0000) >> 16;
                sir[1] = (p & 0x00ff00) >> 8;
                sir[2] = (p & 0x0000ff);

                rinsum += sir[0];
                ginsum += sir[1];
                binsum += sir[2];

                rsum += rinsum;
                gsum += ginsum;
                bsum += binsum;

                stackpointer = (stackpointer + 1) % div;
                sir = stack[(stackpointer) % div];

                routsum += sir[0];
                goutsum += sir[1];
                boutsum += sir[2];

                rinsum -= sir[0];
                ginsum -= sir[1];
                binsum -= sir[2];

                yi++;
            }
            yw += w;
        }
        for (x = 0; x < w; x++) {
            rinsum = ginsum = binsum = routsum = goutsum = boutsum = rsum = gsum = bsum = 0;
            yp = -radius * w;
            for (i = -radius; i <= radius; i++) {
                yi = Math.max(0, yp) + x;

                sir = stack[i + radius];

                sir[0] = r[yi];
                sir[1] = g[yi];
                sir[2] = b[yi];

                rbs = r1 - Math.abs(i);

                rsum += r[yi] * rbs;
                gsum += g[yi] * rbs;
                bsum += b[yi] * rbs;

                if (i > 0) {
                    rinsum += sir[0];
                    ginsum += sir[1];
                    binsum += sir[2];
                } else {
                    routsum += sir[0];
                    goutsum += sir[1];
                    boutsum += sir[2];
                }

                if (i < hm) {
                    yp += w;
                }
            }
            yi = x;
            stackpointer = radius;
            for (y = 0; y < h; y++) {
                // Preserve alpha channel: ( 0xff000000 & pix[yi] )
                pix[yi] = ( 0xff000000 & pix[yi] ) | ( dv[rsum] << 16 ) | ( dv[gsum] << 8 ) | dv[bsum];

                rsum -= routsum;
                gsum -= goutsum;
                bsum -= boutsum;

                stackstart = stackpointer - radius + div;
                sir = stack[stackstart % div];

                routsum -= sir[0];
                goutsum -= sir[1];
                boutsum -= sir[2];

                if (x == 0) {
                    vmin[y] = Math.min(y + r1, hm) * w;
                }
                p = x + vmin[y];

                sir[0] = r[p];
                sir[1] = g[p];
                sir[2] = b[p];

                rinsum += sir[0];
                ginsum += sir[1];
                binsum += sir[2];

                rsum += rinsum;
                gsum += ginsum;
                bsum += binsum;

                stackpointer = (stackpointer + 1) % div;
                sir = stack[stackpointer];

                routsum += sir[0];
                goutsum += sir[1];
                boutsum += sir[2];

                rinsum -= sir[0];
                ginsum -= sir[1];
                binsum -= sir[2];

                yi += w;
            }
        }

        bitmap.setPixels(pix, 0, w, 0, 0, w, h);

        return (bitmap);
    }

    public Bitmap generateOutputBitmap(Context context){
        Bitmap output= Bitmap.createBitmap((int)finalImageWidth, (int)finalImageHeight, Bitmap.Config.ARGB_8888);
        Canvas canvas = new Canvas(output);

        canvas.save();

        canvas.drawColor(Color.WHITE);

        if(instance.getBackgroundBitmap()!=null){
            drawMenuBitmap(canvas);
//            if(instance.isBlured) {
//                output = fastblur(output, 1, 32);
//                canvas.setBitmap(output);
//            }

        }
        drawMenuHeader(canvas,context);
        drawMenuContent(canvas,context);
        canvas.restore();

        return output;
    }

    private void drawMenuBitmap(Canvas canvas){
        Paint p = new Paint();
        p.setColor(Color.parseColor("#ff0000"));
        //canvas.drawColor(Color.TRANSPARENT, PorterDuff.Mode.CLEAR);

        p.setAlpha((int)(255*(instance.getBackgroundAlpha()/100f)));


        float x = canvas.getWidth()/2-instance.getBackgroundBitmap().getWidth()/2*instance.getBackgroundScale()+instance.getBackgroundOffsetX();
        float y = canvas.getHeight()/2-instance.getBackgroundBitmap().getHeight()/2*instance.getBackgroundScale()+instance.getBackgroundOffsetY();
        Rect src = new Rect(0,0,instance.getBackgroundBitmap().getWidth(),instance.getBackgroundBitmap().getHeight());
        RectF dst = new RectF(x,y,instance.getBackgroundBitmap().getWidth()*instance.getBackgroundScale()+x,instance.getBackgroundBitmap().getHeight()*instance.getBackgroundScale()+y);

        if(instance.getBackgroundBlur()<=0){
            canvas.drawBitmap(instance.getBackgroundBitmap(),src,dst,p);
        } else{
            Bitmap bluredBitmap= Bitmap.createBitmap((int)finalImageWidth, (int)finalImageHeight, Bitmap.Config.ARGB_8888);
            Canvas tmpCanvas = new Canvas(bluredBitmap);

            tmpCanvas.drawBitmap(instance.getBackgroundBitmap(),src,dst,p);
            bluredBitmap = fastblur(bluredBitmap, 1, 1<<instance.getBackgroundBlur());

            canvas.drawBitmap(bluredBitmap,0,0,p);
        }

//        if(instance.isBlured){
//            //p.setMaskFilter(new BlurMaskFilter(8, BlurMaskFilter.Blur.NORMAL));
//
//            Bitmap bluredBitmap= Bitmap.createBitmap((int)finalImageWidth, (int)finalImageHeight, Bitmap.Config.ARGB_8888);
//            Canvas tmpCanvas = new Canvas(bluredBitmap);
//
//            tmpCanvas.drawBitmap(instance.getBackgroundBitmap(),src,dst,p);
//            bluredBitmap = fastblur(bluredBitmap, 1, 32);
//
//            canvas.drawBitmap(bluredBitmap,0,0,p);
//
//
//        } else{
//            canvas.drawBitmap(instance.getBackgroundBitmap(),src,dst,p);
//        }





    }

    private void drawMenuHeader(Canvas canvas,Context context){
        Paint p = new Paint();

        p.setColor(instance.getThemeColor());
        p.setAntiAlias(true);

        //p.setColor(Color.parseColor("#99FF0000"));
        canvas.drawRect(0.4044f*finalImageWidth, 0.03125f*finalImageHeight, finalImageWidth, 0.166666f*finalImageHeight,p);



        p.setColor(instance.getHeaderTextColor());
        p.setStrokeWidth(0.0026f*finalImageHeight);

        canvas.drawLine(0,0.1078f*finalImageHeight,finalImageWidth,0.1078f*finalImageHeight,p);


        Typeface typeface = ResourcesCompat.getFont(context, R.font.header_font);

        //typeface = Typeface.create(typeface,Typeface.BOLD);

        p.setTypeface(typeface);
        p.setTextSize(/*57*/ 0.059375f*finalImageHeight);

        canvas.drawText("Tygodniowe menu",0.42352f*finalImageWidth, 0.090625f*finalImageHeight,p);


        if(instance.getDateStart()!=null) {
            typeface = ResourcesCompat.getFont(context, R.font.big_font);
            p.setTypeface(typeface);
            p.setTextSize(/*20*/ 0.020833f*finalImageHeight);

            Calendar calStart = Calendar.getInstance();
            calStart.setTime(instance.getDateStart());
            Calendar calEnd = Calendar.getInstance();
            calEnd.setTime(instance.getDateEnd());

            String weekDate = String.format("%02d", calStart.get(Calendar.DAY_OF_MONTH));


            if (calStart.get(Calendar.YEAR) == calEnd.get(Calendar.YEAR) && calStart.get(Calendar.MONTH) != calEnd.get(Calendar.MONTH)) {
                weekDate += String.format(".%02d", calStart.get(Calendar.MONTH)+1);
            }
            if (calStart.get(Calendar.YEAR) != calEnd.get(Calendar.YEAR)) {

                weekDate += String.format(".%02d.%04d", calStart.get(Calendar.MONTH)+1, calStart.get(Calendar.YEAR));
            }

            weekDate += String.format("-%02d", calEnd.get(Calendar.DAY_OF_MONTH));

            weekDate += String.format(".%02d", calEnd.get(Calendar.MONTH)+1);

            weekDate += "." + calEnd.get(Calendar.YEAR);

            canvas.drawText(weekDate,0.43676f*finalImageWidth,0.13541f*finalImageHeight,p);
        }


        if(instance.getPrice()!=null){
            typeface = ResourcesCompat.getFont(context, R.font.big_font);
            p.setTypeface(typeface);
            p.setTextSize(/*20*/ 0.020833f*finalImageHeight);

            canvas.drawText("cena " + instance.getPrice() + " zł", 0.77941f*finalImageWidth,0.13541f*finalImageHeight,p);

        }

        if(instance.getTimeStart()!=null){
            typeface = ResourcesCompat.getFont(context, R.font.normal_font);
            p.setTypeface(typeface);
            p.setTextSize(/*18*/ 0.01875f*finalImageHeight);

            canvas.drawText("*dostępne w godzinach: " + instance.extractHours(instance.getTimeStart()), 0.43676f*finalImageWidth, 0.15833f*finalImageHeight,p);
            float textWidth = p.measureText("*dostępne w godzinach: " + instance.extractHours(instance.getTimeStart()))+1;


            p.setTextSize(/*8*/ 0.008333333f*finalImageHeight);
            canvas.drawText(instance.extractMinutes(instance.getTimeStart()), 0.43676f*finalImageWidth+ textWidth, 0.14895f*finalImageHeight,p);
            textWidth += p.measureText(instance.extractMinutes(instance.getTimeStart()))+0.0014705f*finalImageWidth;
            p.setTextSize(/*18*/ 0.01875f*finalImageHeight);
            canvas.drawText("-"+instance.extractHours(instance.getTimeEnd()),0.43676f*finalImageWidth+textWidth,0.15833f*finalImageHeight,p);
            textWidth += p.measureText("-"+instance.extractHours(instance.getTimeEnd()))+0.0014705f*finalImageWidth;
            p.setTextSize(/*8*/ 0.008333333f*finalImageHeight);
            canvas.drawText(instance.extractMinutes(instance.getTimeEnd()),0.43676f*finalImageWidth+textWidth,0.14895f*finalImageHeight,p);
        }


    }
    private void drawMenuContent(Canvas canvas, Context context){
        if(instance.getDaysInWeek()!=null){
            Paint p = new Paint();
            p.setColor(instance.getContentTextColor());
            p.setAntiAlias(true);
            Typeface typeface = ResourcesCompat.getFont(context, R.font.normal_font);
            if(instance.isBold()){
                typeface = Typeface.create(typeface,Typeface.BOLD);
            }
            p.setTypeface(typeface);
            p.setTextSize(/*18*/ /*0.01875f*/ instance.getFontSize()/960f*finalImageHeight);

            p.setStrokeWidth(0.001041f*finalImageHeight);
            float linesStart = 0.203125f*finalImageHeight;
            float linesSpacing = 0.1177083f*finalImageHeight;

            for (int i = 0; i < instance.getDaysInWeek().size(); ++i) {

                canvas.drawLine(0,linesStart,0.4779411f*finalImageWidth,linesStart,p);
                canvas.drawText(instance.getDaysInWeek().get(i), 0.2058823f*finalImageWidth, linesStart-(0.003125f*finalImageHeight), p);
//                float y=0;
//                for (String line: instance.getDaysInWeek().get(i).split("\n")) {
//                    canvas.drawText(line, 0.2058823f*finalImageWidth, linesStart-(0.003125f*finalImageHeight)+y, p);
//                    y += p.descent() - p.ascent();
//                }
//                y=0;
                float y = 0;
                if(instance.getFirstCourses()!=null&&instance.getFirstCourses().get(i).length()>0){
                    canvas.drawText(instance.getFirstCourses().get(i), 0.2058823f*finalImageWidth, linesStart+(0.0208333333f*finalImageHeight), p);
                    y = p.descent() - p.ascent();
                }
//                if(instance.getSecondCourses()!=null)
//                canvas.drawText(instance.getSecondCourses().get(i), 0.2058823f*finalImageWidth, linesStart+(0.0208333333f*finalImageHeight)+(p.descent() - p.ascent()), p);

                if(instance.getSecondCourses()!=null) {
                    for (String line : instance.getSecondCourses().get(i).split("\n")) {
                        canvas.drawText(line, 0.2058823f * finalImageWidth, linesStart + (0.0208333333f * finalImageHeight) + y, p);
                        y += p.descent() - p.ascent();
                    }
                }


                linesStart += linesSpacing;
            }
        }
    }
}
