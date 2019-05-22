package com.example.projecthomemaker;

import android.content.Context;
import android.content.Intent;
import android.media.MediaPlayer;
import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;

public class MainActivity extends AppCompatActivity {
    ImageButton button;
    Context context;
    MediaPlayer mediaPlayer;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        context = this;
        RecipeDbDao.initializeInstance(this);
        button = findViewById(R.id.button_recipelist);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(context, RecipeListActivity.class);
                //plays media sound before going to new intent
                mediaPlayer = MediaPlayer.create(context,R.raw.are_you_kidding);
                mediaPlayer.start();
                mediaPlayer.setLooping(false);
                startActivity(intent);
//                public Recipe(String name, String category, int starRating, int feedPerBatch,int costRating,String ingredientList,String directions)

            }
        });
    }
}
