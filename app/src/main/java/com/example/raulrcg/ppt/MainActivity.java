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
                p1.setVisibility(View.VISIBLE);
                p2.setVisibility(View.VISIBLE);

                AsyncT01 at1=new AsyncT01();
                AsyncT02 at2=new AsyncT02();

                at2.executeOnExecutor(AsyncTask.THREAD_POOL_EXECUTOR);
                at1.executeOnExecutor(AsyncTask.THREAD_POOL_EXECUTOR);
            }
        });
    }

    private class  AsyncT01 extends AsyncTask<Void, Integer,Boolean> {

        @Override
        protected Boolean doInBackground(Void... params) {
            ppt.start();
            delay();
            return true;
        }

        @Override
        protected void onPostExecute(Boolean aVoid) {
            //super.onPostExecute(aVoid);
            if (aVoid){
                p1.setImageResource(setImage());
            }
        }
    }

    private class  AsyncT02 extends AsyncTask<Void, Integer,Boolean> {

        @Override
        protected Boolean doInBackground(Void... params) {
            ppt1.start();
            delay();
            return true;
        }

        @Override
        protected void onPostExecute(Boolean aVoid) {
            //super.onPostExecute(aVoid);
            if (aVoid){
                p2.setImageResource(setImage());
            }
        }
    }

    private void delay() {
        try {
            Thread.sleep(6245);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    public int setImage(){
        int rnd=(int) (Math.random() * 3) + 1;

        switch (rnd){
            case 1:
                return R.drawable.papel;
                //break;
            case 2:
                return R.drawable.piedra;
                //break;
            case 3:
                return R.drawable.tijeras;
                //break;
            default:
                return 1;
                //break;
        }
    }

}
