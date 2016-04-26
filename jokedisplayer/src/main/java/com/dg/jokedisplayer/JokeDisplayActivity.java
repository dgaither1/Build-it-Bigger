package com.dg.jokedisplayer;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.widget.TextView;

import com.usaa.jokedisplayer.R;

/**
 * Created by DG on 4/25/16.
 */
public class JokeDisplayActivity extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.joke_display_layout);
        TextView jokeField = (TextView) findViewById(R.id.joke_field);

        Intent intent = getIntent();
        String joke = intent.getStringExtra(getString(R.string.joke_key));

        if(joke != null && !joke.isEmpty()) {
            jokeField.setText(joke);
        }

    }
}
