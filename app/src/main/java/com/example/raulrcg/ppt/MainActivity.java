package com.example.raulrcg.ppt;

import android.graphics.drawable.AnimationDrawable;
import android.os.AsyncTask;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;

public class MainActivity extends AppCompatActivity {

    ImageView p1,p2;
    Button btn1,btn2;
    private AnimationDrawable ppt,ppt1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        p1=(ImageView)findViewById(R.id.imageView);
        p2=(ImageView)findViewById(R.id.imageView2);
        btn1=(Button)findViewById(R.id.button);
        btn2=(Button)findViewById(R.id.button2);

        p1.setVisibility(View.INVISIBLE);
        p1.setBackgroundResource(R.drawable.animacion);
        p2.setVisibility(View.INVISIBLE);
        p2.setBackgroundResource(R.drawable.animacion);

        ppt=(AnimationDrawable)p1.getBackground();
        ppt.setOneShot(true);
        ppt1=(AnimationDrawable)p2.getBackground();
        ppt1.setOneShot(true);

        btn1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                btn1.setText("Stop");
                p1.setVisibility(View.VISIBLE);
                if(ppt.isRunning()){ppt.stop();btn1.setText("play");}else{ppt.start();}
            }
        });
        btn2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                btn2.setText("Stop");
                p2.setVisibility(View.VISIBLE);
                if(ppt.isRunning()){ppt1.stop();btn2.setText("play");}else{ppt1.start();}
            }
        });
    }

}
