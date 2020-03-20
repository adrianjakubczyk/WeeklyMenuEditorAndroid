package com.menueditor;

import android.Manifest;
import android.content.DialogInterface;
import android.content.Intent;
import android.database.Cursor;
import android.graphics.BitmapFactory;
import android.graphics.Color;
import android.net.Uri;
import android.provider.MediaStore;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.LinearLayout;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

import pub.devrel.easypermissions.EasyPermissions;
import yuku.ambilwarna.AmbilWarnaDialog;

public class ChooseColors extends AppCompatActivity {
    private Button buttonBgImage;
    private Button buttonEditBg;
    private Button buttonThemeColor;
    private Button buttonHeaderTextColor;
    private Button buttonContentTextColor;
    private Button buttonFontSize;
    private Button buttonAlphaBlur;
    private CheckBox checkBoxAlpha;
    private CheckBox checkBoxBlur;
    private CheckBox checkBoxBold;
    private GeneratedMenu gm;

    private static int RESULT_LOAD_IMAGE = 1;

    private String[] galleryPermissions = {Manifest.permission.READ_EXTERNAL_STORAGE, Manifest.permission.WRITE_EXTERNAL_STORAGE, Manifest.permission.ACCESS_MEDIA_LOCATION};
//    private static final int REQUEST_EXTERNAL_STORAGE = 1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_choose_colors);

        if (EasyPermissions.hasPermissions(this, galleryPermissions)) {
            //pickImageFromGallery();
        } else {
            EasyPermissions.requestPermissions(this, "Access for storage",
                    101, galleryPermissions);
        }

//        int permission = ActivityCompat.checkSelfPermission(this, Manifest.permission.WRITE_EXTERNAL_STORAGE);
//
//        if (permission != PackageManager.PERMISSION_GRANTED) {
//            // We don't have permission so prompt the user
//            ActivityCompat.requestPermissions(
//                    this,
//                    galleryPermissions,
//                    REQUEST_EXTERNAL_STORAGE
//            );
//        }

        buttonEditBg = (Button)findViewById(R.id.buttonEditBg);
        buttonAlphaBlur = (Button)findViewById(R.id.buttonAlphaBlur);

        buttonAlphaBlur.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                openEditBgAlphaBlur(view);
            }
        });

        gm = GeneratedMenu.getInstance();
        if(gm.getBackgroundBitmap()==null){

            buttonEditBg.setTextColor(Color.parseColor("#AAAAAA"));
            buttonEditBg.setEnabled(false);
            buttonAlphaBlur.setTextColor(Color.parseColor("#AAAAAA"));
            buttonAlphaBlur.setEnabled(false);
        }


        buttonBgImage =(Button) findViewById(R.id.buttonBgImage);
        buttonBgImage.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View arg0) {

                Intent i = new Intent(
                        Intent.ACTION_PICK,
                        android.provider.MediaStore.Images.Media.EXTERNAL_CONTENT_URI);

                startActivityForResult(i, RESULT_LOAD_IMAGE);
            }
        });



//        checkBoxAlpha = (CheckBox)findViewById(R.id.checkBoxAlpha);
//        checkBoxBlur = (CheckBox)findViewById(R.id.checkBoxBlur);
        checkBoxBold = (CheckBox)findViewById(R.id.checkBoxBold);

//        checkBoxAlpha.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View view) {
//                gm.setTransparent(((CheckBox)view).isChecked());
//            }
//        });
//        checkBoxBlur.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View view) {
//                gm.setBlured(((CheckBox)view).isChecked());
//            }
//        });
        checkBoxBold.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                gm.setBold(((CheckBox)view).isChecked());
            }
        });


        buttonHeaderTextColor = (Button)findViewById(R.id.buttonHeaderTextColor);
        buttonContentTextColor = (Button)findViewById(R.id.buttonContentTextColor);
        buttonThemeColor = (Button)findViewById(R.id.buttonThemeColor);
        buttonFontSize = (Button)findViewById(R.id.buttonFontSize);

        buttonThemeColor.setBackgroundColor(gm.getThemeColor());
        buttonHeaderTextColor.setBackgroundColor(gm.getHeaderTextColor());
        buttonContentTextColor.setBackgroundColor(gm.getContentTextColor());


        buttonThemeColor.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v){
                openThemeColorPicker();
            }
        });
        buttonHeaderTextColor.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v){
                openHeaderTextColorPicker();
            }
        });
        buttonContentTextColor.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v){
                openContentTextColorPicker();
            }
        });

        buttonFontSize.setText(String.valueOf(gm.getFontSize()));


        buttonFontSize.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(final View view) {

                AlertDialog.Builder builder = new AlertDialog.Builder(ChooseColors.this);
                builder.setTitle("Rozmiar czcionki:");

                final String[] sizes = {"16","17","18","19","20","21","22","23","24","25","26"};

                builder.setItems(sizes, new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {

                        ((Button)view).setText(sizes[which]);
                        gm.setFontSize(Integer.parseInt(sizes[which]));

                    }
                });

                AlertDialog dialog = builder.create();
                dialog.show();


            }
        });
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

        if (requestCode == RESULT_LOAD_IMAGE && resultCode == RESULT_OK && null != data) {




            gm.setBackgroundImageUri(data.getData());


            Uri selectedImage = data.getData();
            String[] filePathColumn = { MediaStore.Images.Media.DATA };


            Cursor cursor = getContentResolver().query(selectedImage,
                    filePathColumn, null, null, null);
            cursor.moveToFirst();

            int columnIndex = cursor.getColumnIndex(filePathColumn[0]);
            String picturePath = cursor.getString(columnIndex);
            cursor.close();


            gm.setBackgroundBitmap(BitmapFactory.decodeFile(picturePath));

            if(gm.getBackgroundBitmap()!=null){

                buttonEditBg.setTextColor(Color.parseColor("#000000"));
                buttonEditBg.setEnabled(true);
                buttonAlphaBlur.setTextColor(Color.parseColor("#000000"));
                buttonAlphaBlur.setEnabled(true);
            }

        }


    }

    public void openThemeColorPicker(){
        AmbilWarnaDialog colorPicker = new AmbilWarnaDialog(this, gm.getThemeColor(), new AmbilWarnaDialog.OnAmbilWarnaListener() {
            @Override
            public void onCancel(AmbilWarnaDialog dialog) {

            }

            @Override
            public void onOk(AmbilWarnaDialog dialog, int color) {
                gm.setThemeColor(color);
                buttonThemeColor.setBackgroundColor(color);
            }
        });
        colorPicker.show();
    }

    public void openHeaderTextColorPicker(){
        AmbilWarnaDialog colorPicker = new AmbilWarnaDialog(this, gm.getHeaderTextColor(), new AmbilWarnaDialog.OnAmbilWarnaListener() {
            @Override
            public void onCancel(AmbilWarnaDialog dialog) {

            }

            @Override
            public void onOk(AmbilWarnaDialog dialog, int color) {
                gm.setHeaderTextColor(color);
                buttonHeaderTextColor.setBackgroundColor(color);
            }
        });
        colorPicker.show();
    }
    public void openContentTextColorPicker(){
        AmbilWarnaDialog colorPicker = new AmbilWarnaDialog(this, gm.getContentTextColor(), new AmbilWarnaDialog.OnAmbilWarnaListener() {
            @Override
            public void onCancel(AmbilWarnaDialog dialog) {

            }

            @Override
            public void onOk(AmbilWarnaDialog dialog, int color) {
                gm.setContentTextColor(color);
                buttonContentTextColor.setBackgroundColor(color);
            }
        });
        colorPicker.show();
    }

    public void openEditBg(View v){
        Intent intent = new Intent(this, EditBackground.class);
        startActivity(intent);
        overridePendingTransition(R.anim.slide_in_bottom, R.anim.slide_out_top);
    }

    public void openEditBgAlphaBlur(View v){
        Intent intent = new Intent(this, EditBackgroundAlphaBlur.class);
        startActivity(intent);
        overridePendingTransition(R.anim.slide_in_bottom, R.anim.slide_out_top);
    }

    public void onPrevClicked(View v){
        finish();
    }

    public void onNextClicked(View v){
        Intent intent = new Intent(this, ChooseWeekStart.class);
        startActivity(intent);
    }

    public void onPreviewClicked(View v){
        Intent intent = new Intent(this, Preview.class);
        startActivity(intent);
        overridePendingTransition(R.anim.slide_in_bottom, R.anim.slide_out_top);
    }
}
