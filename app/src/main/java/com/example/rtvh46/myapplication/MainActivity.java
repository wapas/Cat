package com.example.rtvh46.myapplication;

import android.content.Intent;
import android.media.MediaPlayer;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    String msg = "Android";
    String cat = "Kot wabi sie";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        String name ="";
        setContentView(R.layout.activity_main);

        Intent intent = getIntent();
        //String name = intent.getStringExtra("namev");

    }

    @Override
    protected void onActivityResult(int requestCode,
                                    int resultCode, Intent data){
        Log.d(msg, "Result");
        String name = null;
        TextView text = (TextView) findViewById(R.id.intro);
        if (data != null) {
            name = data.getStringExtra("name");
        }


        if (name != null) {
            text.setText(name);
        }
    }

    public void click(View v){
       Log.d(msg, "Click");
        int code = 1;
        //Intent intent = new Intent(getApplicationContext(), info.class);
        Intent intent = new Intent(this, Main2Activity.class);
        startActivityForResult(intent, code);

    }

    public void onBackPressed()
    {
        Log.d(msg, "Back");
        this.finish();
    }
}
