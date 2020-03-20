package com.menueditor;

import android.app.Activity;
import android.content.Intent;
import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.CalendarView;
import android.widget.TextView;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

public class ChooseWeekStart extends AppCompatActivity  {

    private GeneratedMenu generatedMenu;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_choose_week_start);

        generatedMenu = GeneratedMenu.getInstance();


        CalendarView calendarView = (CalendarView)findViewById(R.id.calendarView);
        calendarView.setFirstDayOfWeek(Calendar.MONDAY);


        Date date = new Date(calendarView.getDate());
        if(generatedMenu.getDateStart()==null){
            generatedMenu.setDateStart((Date) date.clone());

            Calendar calendar = Calendar.getInstance();
            calendar.setTime(date);

            generatedMenu.setDateEnd(calculateEndDate(calendar));
        } else {

            calendarView.setDate(generatedMenu.getDateStart().getTime());
        }



        printDate();

        calendarView.setOnDateChangeListener(new CalendarView.OnDateChangeListener() {
            @Override
            public void onSelectedDayChange(CalendarView view, int year, int month,int dayOfMonth) {


                Calendar calendar = Calendar.getInstance();
                calendar.set(year, month, dayOfMonth);

                generatedMenu.setDateStart(calendar.getTime());

                generatedMenu.setDateEnd(calculateEndDate(calendar));

                printDate();

            }
        });


    }

    private Date calculateEndDate(Calendar calendar){

        int daysToAdd = 7;

        //Week starts from sunday
        switch(calendar.get(Calendar.DAY_OF_WEEK)){
            case 1:
                daysToAdd -= 7;
                break;
            case 2:
                daysToAdd -= 1;
                break;
            case 3:
                daysToAdd -= 2;
                break;
            case 4:
                daysToAdd -= 3;
                break;
            case 5:
                daysToAdd -= 4;
                break;
            case 6:
                daysToAdd -= 5;
                break;
            case 7:
                daysToAdd -= 6;
                break;
        }

        //long millisToAdd = /*(12*60*60*1000)+*/(daysToAdd*24*60*60*1000);
        //calendar.setTimeInMillis(calendar.getTimeInMillis()+millisToAdd);

        calendar.add(Calendar.DATE,daysToAdd);
        return calendar.getTime();

    }

    private void printDate(){
        SimpleDateFormat sdf = new SimpleDateFormat("dd.MM.yyyy");
        TextView selectedDate = (TextView)findViewById(R.id.textView4);
        selectedDate.setText("Od "+sdf.format(generatedMenu.getDateStart())+" do "+sdf.format(generatedMenu.getDateEnd()));

    }

    public  void onPrevClicked(View v){
        finish();
    }

    public  void onNextClicked(View v){
        generateDaysListFromCalendar();

        Intent intent = new Intent(this, ChooseTimeAndPrice.class);
        startActivity(intent);
    }

    private void generateDaysListFromCalendar(){
        Calendar start = Calendar.getInstance();
        start.setTime(generatedMenu.getDateStart());
        Calendar end = Calendar.getInstance();
        end.setTime(generatedMenu.getDateEnd());
        end.add(Calendar.DATE, 1);
        List<String> daysText = new ArrayList<>();
        for (Date date = start.getTime(); start.before(end); start.add(Calendar.DATE, 1), date = start.getTime()) {
            Calendar tmpCalendar = Calendar.getInstance();
            tmpCalendar.setTime(date);

            int dayOfWeek = tmpCalendar.get(Calendar.DAY_OF_WEEK);

            //TextView tmp = new TextView(this);

            StringBuilder day = new StringBuilder();

            SimpleDateFormat sdf = new SimpleDateFormat("dd.MM.yyyy");

            switch(dayOfWeek){
                case 1:
                    day.append("Niedziela "+sdf.format(tmpCalendar.getTime()));
                    break;
                case 2:
                    day.append("Poniedziałek "+sdf.format(tmpCalendar.getTime()));
                    break;
                case 3:
                    day.append("Wtorek "+sdf.format(tmpCalendar.getTime()));
                    break;
                case 4:
                    day.append("Środa "+sdf.format(tmpCalendar.getTime()));
                    break;
                case 5:
                    day.append("Czwartek "+sdf.format(tmpCalendar.getTime()));
                    break;
                case 6:
                    day.append("Piątek "+sdf.format(tmpCalendar.getTime()));
                    break;
                case 7:
                    day.append("Sobota "+sdf.format(tmpCalendar.getTime()));
                    break;
            }

            daysText.add(day.toString());
            //daysInWeek.add(tmp);



        }
        generatedMenu.setDaysInWeek(daysText);
    }

    public void onChangeEndDateClicked(View v){
        Intent intent = new Intent(this, ChooseWeekEnd.class);
        startActivityForResult(intent,1);
        overridePendingTransition(R.anim.slide_in_bottom, R.anim.slide_out_top);
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {

        if (requestCode == 1) {
            if(resultCode == Activity.RESULT_OK){
                printDate();
            }
            if (resultCode == Activity.RESULT_CANCELED) {

            }
        }
    }

    public void onPreviewClicked(View v){
        generateDaysListFromCalendar();
        Intent intent = new Intent(this, Preview.class);
        startActivity(intent);
        overridePendingTransition(R.anim.slide_in_bottom, R.anim.slide_out_top);
    }

}
