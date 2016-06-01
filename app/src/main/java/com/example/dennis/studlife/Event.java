package com.example.dennis.studlife;

import android.app.Activity;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.text.Editable;
import android.util.DisplayMetrics;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;


import java.util.Random;

/**
 * Created by Maris on 30-5-2016.
 */
public class Event extends Activity {
    private int eventNumber;
    private EditText eventText;
    private int width;
    private int height;
    private Button yes;
    private Button no;


    /*
    public Event (int eventNumber) {
        this.eventNumber = eventNumber;
    }

    public Event () {

    }
    */

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_event);

        eventText = (EditText) findViewById(R.id.editTextEvent);

        yes = (Button) findViewById(R.id.buttonyes);
        no = (Button) findViewById(R.id.buttonno);

        randomEvent();
        chooseEvent();
        resizeDisplay();

        buttonYes();
        buttonNo();
    }

    private void resizeDisplay() {
        DisplayMetrics dm = new DisplayMetrics();
        getWindowManager().getDefaultDisplay().getMetrics(dm);
        width = dm.widthPixels;
        height = dm.heightPixels;
        getWindow().setLayout((int)(width*0.7),(int)(height*0.5));
    }

    private void randomEvent () {
        Random rng = new Random();
        eventNumber = rng.nextInt(10);
    }

    private void buttonYes() {
        yes.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });
    }

    private void buttonNo() {
        no.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });
    }

    private void chooseEvent() {
        eventText.setText("");
        switch (eventNumber) {
            case 0:
                eventText.setText("Dit is event 0");
                break;
            case 1:
                eventText.setText("Dit is event 1");
                break;
            case 2:
                eventText.setText("Dit is event 2");
                break;
            case 3:
                eventText.setText("Dit is event 3");
                break;
            case 4:
                eventText.setText("Dit is event 4");
                break;
            case 5:
                eventText.setText("Dit is event 5");
                break;
            case 6:
                eventText.setText("Dit is event 6");
                break;
            case 7:
                eventText.setText("Dit is event 7");
                break;
            case 8:
                eventText.setText("Dit is event 8");
                break;
            default:
                eventText.setText("Dit is event 9");
                break;

        }


    }



}
