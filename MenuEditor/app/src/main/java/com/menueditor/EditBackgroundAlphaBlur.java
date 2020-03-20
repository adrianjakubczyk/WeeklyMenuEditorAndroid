package com.menueditor;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.SeekBar;
import android.widget.TextView;

public class EditBackgroundAlphaBlur extends AppCompatActivity {

    private TextView alphaValue;
    private TextView blurValue;
    private SeekBar seekBarAlpha;
    private SeekBar seekBarBlur;
    private Button buttonResetAlpha;
    private Button buttonResetBlur;

    private GeneratedMenu gm;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_edit_background_alpha_blur);

        gm = GeneratedMenu.getInstance();

        alphaValue = (TextView)findViewById(R.id.alphaValue);
        blurValue = (TextView)findViewById(R.id.blurValue);
        seekBarAlpha = (SeekBar)findViewById(R.id.seekBarAlpha);
        seekBarBlur = (SeekBar)findViewById(R.id.seekBarBlur);
        buttonResetAlpha = (Button)findViewById(R.id.buttonResetAlpha);
        buttonResetBlur = (Button)findViewById(R.id.buttonResetBlur);

        seekBarAlpha.setMax(100);
        seekBarAlpha.setProgress(gm.getBackgroundAlpha());

        seekBarAlpha.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar, int i, boolean b) {
                alphaValue.setText("Kontrast: "+seekBarAlpha.getProgress()+"%");
            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {

            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {

            }
        });

        seekBarBlur.setMax(5);
        seekBarBlur.setProgress(gm.getBackgroundBlur());

        seekBarBlur.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar, int i, boolean b) {
                blurValue.setText("Poziom rozmycia: "+seekBarBlur.getProgress());
            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {

            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {

            }
        });

        alphaValue.setText("Kontrast: "+seekBarAlpha.getProgress()+"%");
        blurValue.setText("Poziom rozmycia: "+seekBarBlur.getProgress());

        buttonResetAlpha.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                seekBarAlpha.setProgress(100);
            }
        });

        buttonResetBlur.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                seekBarBlur.setProgress(0);
            }
        });

    }

    public void onOkClicked(View v){


        gm.setBackgroundAlpha(seekBarAlpha.getProgress());
        gm.setBackgroundBlur(seekBarBlur.getProgress());

        finish();
        overridePendingTransition(R.anim.slide_in_top, R.anim.slide_out_bottom);


    }

    public void onCancelClicked(View v){


        finish();
        overridePendingTransition(R.anim.slide_in_top, R.anim.slide_out_bottom);
    }
}
