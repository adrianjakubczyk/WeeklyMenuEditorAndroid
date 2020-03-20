package com.menueditor;

import android.content.Intent;

import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

public class ChooseTimeAndPrice extends AppCompatActivity {

    private GeneratedMenu gm;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_choose_time_and_price);

        EditText timeStart = (EditText) findViewById(R.id.timeStart);
        EditText timeEnd = (EditText) findViewById(R.id.timeEnd);
        EditText price = (EditText) findViewById(R.id.price);

        gm = GeneratedMenu.getInstance();

        timeStart.setText(gm.getTimeStart());
        timeEnd.setText(gm.getTimeEnd());
        price.setText(gm.getPrice());




//        timeStart.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View view) {
//                TimePickerDialog timePickerDialog = new TimePickerDialog(ChooseTimeAndPrice.this, new TimePickerDialog.OnTimeSetListener() {
//                    @Override
//                    public void onTimeSet(TimePicker timePicker, int hourOfDay, int minutes) {
//                        timeStart.setText(String.format("%d:%02d", hourOfDay, minutes));
//                    }
//                }, 11, 0, true);
//                timePickerDialog.show();
//            }
//        });

    }

    public  void onPrevClicked(View v){

        saveData();
        finish();
    }

    public  void onNextClicked(View v){

        saveData();

        //Intent intent = new Intent(this, InputDishesByDay.class);
        Intent intent = new Intent(this, ChooseCourses.class);
        startActivity(intent);
    }
    public void onPreviewClicked(View v){
        saveData();

        Intent intent = new Intent(this, Preview.class);
        startActivity(intent);
        overridePendingTransition(R.anim.slide_in_bottom, R.anim.slide_out_top);
    }

    private void saveData(){
        EditText timeStart = (EditText)findViewById(R.id.timeStart);
        EditText timeEnd = (EditText)findViewById(R.id.timeEnd);
        EditText price = (EditText)findViewById(R.id.price);


        gm.setTimeStart(timeStart.getText().toString());
        gm.setTimeEnd(timeEnd.getText().toString());
        gm.setPrice(price.getText().toString());
    }

}
