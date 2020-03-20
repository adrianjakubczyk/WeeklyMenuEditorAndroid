package com.menueditor;

import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.Color;
import android.graphics.PorterDuff;
import android.graphics.Typeface;
import android.net.Uri;
import android.os.Environment;
import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import java.io.File;
import java.io.FileOutputStream;
import java.io.OutputStream;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class ChooseCourses extends AppCompatActivity {

    private GeneratedMenu gm;
    private CoursesDialogManager coursesDialogManager;
    private LinearLayout linearLayout;
    private List<TextView> daysInWeek;

    private List<TextView> firstCourses;
    private List<TextView> secondCourses;
    private List<Button> buttonsFc;
    private List<Button> buttonsSc1;
    private List<Button> buttonsSc2;
    private List<Button> buttonsSc3;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_choose_courses);

        gm = GeneratedMenu.getInstance();
        coursesDialogManager = new CoursesDialogManager(getApplicationContext());
        linearLayout = (LinearLayout)findViewById(R.id.liLa);


        daysInWeek = new ArrayList<>();
        firstCourses= new ArrayList<>();
        secondCourses= new ArrayList<>();
        buttonsFc= new ArrayList<>();
        buttonsSc1= new ArrayList<>();
        buttonsSc2= new ArrayList<>();
        buttonsSc3= new ArrayList<>();


        for(int i=0;i<gm.getDaysInWeek().size();++i){
            TextView tmp = new TextView(this);
            tmp.setText(gm.getDaysInWeek().get(i));
            daysInWeek.add(tmp);
        }


        createCoursesLayout();


        if(gm.getFirstCourses()!=null&&gm.getFirstCourses().size()==daysInWeek.size()){
            for(int i=0;i<daysInWeek.size();++i){
                firstCourses.get(i).setText(gm.getFirstCourses().get(i));
                secondCourses.get(i).setText(gm.getSecondCourses().get(i));
            }
        }


        for(int i=0; i<buttonsFc.size();++i){

            final TextView tmpTextView = firstCourses.get(i);
            buttonsFc.get(i).setOnClickListener(new View.OnClickListener() {

                @Override
                public void onClick(View view) {

                    coursesDialogManager.showFirstCourseDialog(ChooseCourses.this,tmpTextView);

                }
            });
        }

        for(int i=0; i<buttonsSc1.size();++i){

            final TextView tmpTextView = secondCourses.get(i);
            final StringBuilder[] textResult = new StringBuilder[3];
            buttonsSc1.get(i).setOnClickListener(new View.OnClickListener() {

                @Override
                public void onClick(View view) {

                    coursesDialogManager.showSecondCourseDialog(ChooseCourses.this,tmpTextView,textResult);

                }
            });
            buttonsSc2.get(i).setOnClickListener(new View.OnClickListener() {

                @Override
                public void onClick(View view) {

                    coursesDialogManager.showSecondCourseStarchesDialog(ChooseCourses.this,tmpTextView,textResult);

                }
            });
            buttonsSc3.get(i).setOnClickListener(new View.OnClickListener() {

                @Override
                public void onClick(View view) {

                    coursesDialogManager.showSecondCourseSaladsDialog(ChooseCourses.this,tmpTextView,textResult);

                }
            });
        }

//        if(gm.getDishesInWeek()!=null&&gm.getDishesInWeek().size()==daysInWeek.size()){
//            for(int i=0;i<daysInWeek.size();++i){
//                daysInWeekTextArea.get(i).setText(gm.getDishesInWeek().get(i));
//            }
//        }


    }

    private void createCoursesLayout(){
        for(int i=0;i<daysInWeek.size();++i){
            LinearLayout tmpLinearLayout = new LinearLayout(this);
            tmpLinearLayout.setPadding(15,15,15,50);
            if((i&1)==0){
                tmpLinearLayout.setBackgroundColor(Color.parseColor("#ffefdb"));
            } else{
                tmpLinearLayout.setBackgroundColor(Color.parseColor("#d9fff5"));
            }

            tmpLinearLayout.setOrientation(LinearLayout.VERTICAL);

            daysInWeek.get(i).setTextSize(18);
            daysInWeek.get(i).setTypeface(null, Typeface.BOLD);
            tmpLinearLayout.addView(daysInWeek.get(i));

            createFirstCourseLayout(tmpLinearLayout,i);
            createSecondCourseLayout(tmpLinearLayout,i);


            linearLayout.addView(tmpLinearLayout);
        }
    }

    private void createFirstCourseLayout(LinearLayout currentDayLayout,int currentDay){
        TextView firstCourseText = new TextView(this);
        firstCourseText.setText("Pierwsze danie:");
        firstCourseText.setTextSize(16);
        currentDayLayout.addView(firstCourseText);


        TextView tmpTextViewFc = new TextView(this);
        tmpTextViewFc.setLayoutParams(new LinearLayout.LayoutParams(LinearLayout.LayoutParams.MATCH_PARENT, LinearLayout.LayoutParams.WRAP_CONTENT, 1));
        firstCourses.add(tmpTextViewFc);
        Button tmpButtonFc = new Button(this);
        tmpButtonFc.setLayoutParams(new LinearLayout.LayoutParams(LinearLayout.LayoutParams.MATCH_PARENT, LinearLayout.LayoutParams.WRAP_CONTENT, 1));
        tmpButtonFc.setText("Zupa");
        LinearLayout tmpButtonLayout = new LinearLayout(this);
        tmpButtonLayout.setOrientation(LinearLayout.HORIZONTAL);
        tmpButtonLayout.setLayoutParams(new LinearLayout.LayoutParams(LinearLayout.LayoutParams.MATCH_PARENT, LinearLayout.LayoutParams.WRAP_CONTENT, 1));
        tmpButtonLayout.addView(tmpButtonFc);
        buttonsFc.add(tmpButtonFc);
//            fcLinearLayout.addView(firstCourses.get(i));
//            fcLinearLayout.addView(tmpButtonLayout);
        currentDayLayout.addView(firstCourses.get(currentDay));
        currentDayLayout.addView(tmpButtonLayout);
    }

    private void createSecondCourseLayout(LinearLayout currentDayLayout,int currentDay){
        TextView secondCourseText = new TextView(this);
        secondCourseText.setText("Drugie danie:");
        secondCourseText.setTextSize(16);
        currentDayLayout.addView(secondCourseText);


        TextView tmpTextViewSc = new TextView(this);
        tmpTextViewSc.setLayoutParams(new LinearLayout.LayoutParams(LinearLayout.LayoutParams.MATCH_PARENT, LinearLayout.LayoutParams.WRAP_CONTENT, 1));
        secondCourses.add(tmpTextViewSc);
        Button tmpButtonSc1 = new Button(this);
        tmpButtonSc1.setLayoutParams(new LinearLayout.LayoutParams(LinearLayout.LayoutParams.MATCH_PARENT, LinearLayout.LayoutParams.WRAP_CONTENT, 1));
        tmpButtonSc1.setText("Danie główne");
        Button tmpButtonSc2 = new Button(this);
        tmpButtonSc2.setLayoutParams(new LinearLayout.LayoutParams(LinearLayout.LayoutParams.MATCH_PARENT, LinearLayout.LayoutParams.WRAP_CONTENT, 1));
        tmpButtonSc2.setText("Dodatek");
        Button tmpButtonSc3 = new Button(this);
        tmpButtonSc3.setLayoutParams(new LinearLayout.LayoutParams(LinearLayout.LayoutParams.MATCH_PARENT, LinearLayout.LayoutParams.WRAP_CONTENT, 1));
        tmpButtonSc3.setText("Surówka");
        LinearLayout tmpButtonLayout2 = new LinearLayout(this);
        tmpButtonLayout2.setOrientation(LinearLayout.HORIZONTAL);
        tmpButtonLayout2.setLayoutParams(new LinearLayout.LayoutParams(LinearLayout.LayoutParams.MATCH_PARENT, LinearLayout.LayoutParams.WRAP_CONTENT, 1));
        tmpButtonLayout2.addView(tmpButtonSc1);
        buttonsSc1.add(tmpButtonSc1);
        tmpButtonLayout2.addView(tmpButtonSc2);
        buttonsSc2.add(tmpButtonSc2);
        tmpButtonLayout2.addView(tmpButtonSc3);
        buttonsSc3.add(tmpButtonSc3);
//            scLinearLayout.addView(secondCourses.get(i));
//            scLinearLayout.addView(tmpButtonLayout2);
        currentDayLayout.addView(secondCourses.get(currentDay));
        currentDayLayout.addView(tmpButtonLayout2);
    }

    public  void onPrevClicked(View v){
        saveData();
        finish();
    }

    public  void onNextClicked(View v){
        saveData();

        try {
            String path = Environment.getExternalStorageDirectory().toString();

            OutputStream fOut = null;
            long name = new Date().getTime();
            File parent = new File(path+"/MenuEditor/");
            parent.mkdirs();
            File file = new File(parent, String.valueOf(name) +".png"); // the File to save , append increasing numeric counter to prevent files from getting overwritten.

            fOut = new FileOutputStream(file);

            Bitmap pictureBitmap = gm.generateOutputBitmap(this); // obtaining the Bitmap
            pictureBitmap.compress(Bitmap.CompressFormat.PNG,100,fOut);
            fOut.close(); // do not forget to close the stream



            Toast toast = Toast.makeText(this, "Utworzono", Toast.LENGTH_LONG);
            View view = toast.getView();
            view.getBackground().setColorFilter(Color.parseColor("#50C878"), PorterDuff.Mode.SRC_IN);
            TextView text = view.findViewById(android.R.id.message);
            text.setTextColor(Color.WHITE);
            text.setShadowLayer(1,0,2,Color.BLACK);

            toast.show();

            sendBroadcast(new Intent(Intent.ACTION_MEDIA_SCANNER_SCAN_FILE, Uri.fromFile(file)));
            //MediaStore.Images.Media.insertImage(getContentResolver(), file.getAbsolutePath(), file.getName(), file.getName());
        } catch (Exception e){
            e.printStackTrace();
            Toast toast = Toast.makeText(this, "Nieznany błąd", Toast.LENGTH_LONG);
            View view = toast.getView();
            view.getBackground().setColorFilter(Color.parseColor("#DC143C"), PorterDuff.Mode.SRC_IN);
            TextView text = view.findViewById(android.R.id.message);
            text.setTextColor(Color.WHITE);
            text.setShadowLayer(1,0,2,Color.BLACK);

            toast.show();
        }

        //Intent intent = new Intent(this, ChooseWeekStart.class);
        //startActivity(intent);
    }

    private void saveData(){
        List<String> listDaysInWeek = new ArrayList<>();
        List<String> firstCoursesText = new ArrayList<>();
        List<String> secondCoursesText = new ArrayList<>();


        for(int i=0;i<daysInWeek.size();++i){
            //dishesInWeek.add(firstCourses.get(i).getText().toString()+"\n"+secondCourses.get(i).getText().toString());
            listDaysInWeek.add(daysInWeek.get(i).getText().toString());
            firstCoursesText.add(firstCourses.get(i).getText().toString());
            secondCoursesText.add((secondCourses.get(i).getText().toString()));
        }
        gm.setFirstCourses(firstCoursesText);
        gm.setSecondCourses(secondCoursesText);
        gm.setDaysInWeek(listDaysInWeek);
    }
}
