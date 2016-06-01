package com.example.dennis.studlife;

import android.annotation.TargetApi;
import android.content.Intent;
import android.graphics.drawable.AnimationDrawable;
import android.os.Build;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.Spinner;
import android.view.View;

import java.util.Random;

public class UitgaanActivity extends AppCompatActivity {
    private Student student;
    private ProgressBar vier;
    private ProgressBar vijf;
    private ProgressBar zes;
    private Spinner spinner;
    private ImageView stud;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_uitgaan);
        student = (Student) getIntent().getSerializableExtra("student");
        student.checkDead(this);



        spinner = (Spinner) findViewById(R.id.spinner3);
        spinner.setOnItemSelectedListener(new CustomOnItemSelectedListener(this, student));

        setProgressBars();
        student.setProgressBars(zes, vijf, vier);

        stud = (ImageView) findViewById(R.id.studanimation);

        stud.post(new Runnable(){
            @Override
            public void run(){
                ((AnimationDrawable) stud.getBackground()).start();
            }
        });

        Button event = (Button) findViewById(R.id.event);
        event.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(UitgaanActivity.this,Event.class));
            }
        });
    }

    public void event() {

        //Event e = new Event(eventNumber);
        //Event e2 = new Event();
    }


    public void setProgressBars(){
        vier = (ProgressBar) findViewById(R.id.progressBar4);
        vijf = (ProgressBar) findViewById(R.id.progressBar5);
        zes = (ProgressBar) findViewById(R.id.progressBar6);
        vier.setProgress(student.getEnergy());
        vijf.setProgress(student.getHappiness());
        zes.setProgress(student.getHealth());
    }

    public void drinkBier(View v){
        int u = student.getHealth();
        zes.setProgress(u - 6);
        student.setGezondheid( u - 6, this);

        int w = student.getHappiness();
        vijf.setProgress(w + 8);
        student.setGeluk(w + 8, this);
    }

    @Override
    protected void onStop(){
        student.save(this);
        super.onStop();

    }


    @TargetApi(Build.VERSION_CODES.JELLY_BEAN)
    @Override
    public void onBackPressed(){
        student.save(this);
        finishAffinity();
    }
}
