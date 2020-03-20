package com.menueditor;

import android.app.Activity;
import android.content.Intent;
import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.CalendarView;
import android.widget.TextView;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

public class ChooseWeekEnd extends AppCompatActivity {

    private GeneratedMenu generatedMenu;
    private CalendarView calendarView;

    private Date endDate;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_choose_week_end);


        generatedMenu = GeneratedMenu.getInstance();

        endDate = generatedMenu.getDateEnd();


        calendarView = (CalendarView)findViewById(R.id.calendarView2);
        calendarView.setFirstDayOfWeek(Calendar.MONDAY);

        calendarView.setDate(generatedMenu.getDateEnd().getTime());

        calendarView.setMinDate(generatedMenu.getDateStart().getTime());
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(generatedMenu.getDateStart());
        calendarView.setMaxDate(calculateEndDate(calendar).getTime());

        printDate();

        calendarView.setOnDateChangeListener(new CalendarView.OnDateChangeListener() {
            @Override
            public void onSelectedDayChange(CalendarView view, int year, int month,int dayOfMonth) {

                Calendar calendar = Calendar.getInstance();
                calendar.set(year, month, dayOfMonth,1,0,0);



                Date dateEnd = calendar.getTime();

//                if(generatedMenu.getDateStart().after(dateEnd)){
//                    generatedMenu.setDateEnd(generatedMenu.getDateStart());
//
//                } else if(datesAreInDifferentWeek(generatedMenu.getDateStart(),dateEnd)){
//                    calendar.setTime(generatedMenu.getDateStart());
//                    generatedMenu.setDateEnd(calculateEndDate(calendar));
//                } else{
//                    generatedMenu.setDateEnd(dateEnd);
//                }

                endDate = dateEnd;

                //minus 6 hours
                //endDate.setTime(endDate.getTime()-21600000);

                System.out.println(endDate.toString());



                printDate();

            }
        });

    }

    private boolean datesAreInDifferentWeek(Date start, Date end){
        Calendar cal = Calendar.getInstance();
        cal.setTime(start);
        int weekStart = cal.get(Calendar.WEEK_OF_YEAR);
        cal.setTime(end);
        int weekEnd = cal.get(Calendar.WEEK_OF_YEAR);
        return weekStart!=weekEnd;
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

//        long millisToAdd = daysToAdd*24*60*60*1000;
//
//        calendar.setTimeInMillis(calendar.getTimeInMillis()+millisToAdd);

        calendar.add(Calendar.DATE,daysToAdd);
        return calendar.getTime();

    }
    private void printDate(){
        SimpleDateFormat sdf = new SimpleDateFormat("dd.MM.yyyy");
        TextView selectedDate = (TextView)findViewById(R.id.textView9);
        selectedDate.setText("Od "+sdf.format(generatedMenu.getDateStart())+" do "+sdf.format(endDate));

    }

    public void onOkClicked(View v){

        generatedMenu.setDateEnd(endDate);
        Intent returnIntent = new Intent();
        setResult(Activity.RESULT_OK,returnIntent);
        finish();
        overridePendingTransition(R.anim.slide_in_top, R.anim.slide_out_bottom);

    }

    public void onCancelClicked(View v){
        Intent returnIntent = new Intent();
        setResult(Activity.RESULT_CANCELED, returnIntent);
        finish();
        overridePendingTransition(R.anim.slide_in_top, R.anim.slide_out_bottom);
    }
}
