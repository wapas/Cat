package com.example.rtvh46.myapplication;

import android.content.Intent;
import android.media.MediaPlayer;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.KeyEvent;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class Main2Activity extends AppCompatActivity {

    final String msg = "Druga";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.info);

        Button miau = (Button) findViewById(R.id.button2);
        final MediaPlayer mp = MediaPlayer.create(this, R.raw.cat);
        miau.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Log.d(msg, "Miauu"); //display the text of button1
                mp.start();
            }
        });

        addKeyListener();
    }

    public void onClick(View v)
    {
        Log.d(msg, "Name");
    }

    public void addKeyListener() {

        // get edittext component
        final EditText edittext = (EditText) findViewById(R.id.editText);

        // add a keylistener to keep track user input
        edittext.setOnKeyListener(new View.OnKeyListener() {
            public boolean onKey(View v, int keyCode, KeyEvent event) {
                if ((event.getAction() == KeyEvent.ACTION_DOWN)
                        && (keyCode == KeyEvent.KEYCODE_ENTER)) {

                    // display a floating message
                    Toast.makeText(Main2Activity.this,
                            edittext.getText(), Toast.LENGTH_LONG).show();
                    Intent intent = getIntent();
                    intent.putExtra("name", "Kot wabi sie  " + edittext.getText());
                    setResult(RESULT_OK, intent);
                    return true;
                }
                return false;
            }


        });
    }
}


