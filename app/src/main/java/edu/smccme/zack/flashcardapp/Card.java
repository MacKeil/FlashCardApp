package edu.smccme.zack.flashcardapp;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.ImageButton;
import android.widget.Toast;


public class Card extends AppCompatActivity {

    private boolean gotCorrect = false;
    ImageButton answer1;
    ImageButton answer2;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_card);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
            }
        });
    }

    public boolean getCorrect(){
        return gotCorrect;
    }

    public void answer1Click(View view){
        gotCorrect = true;
        Intent intent = new Intent();
        Toast toast = new Toast(getApplicationContext()).setText(R.string.correct);
        toast.show();
    }

    public void answer2Click(View view){
        Intent intent = new Intent();
        Toast toast = new Toast(getApplicationContext()).setText(R.string.incorrect);
        toast.show();
    }


}
