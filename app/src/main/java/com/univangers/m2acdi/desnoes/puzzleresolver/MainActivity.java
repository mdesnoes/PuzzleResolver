package com.univangers.m2acdi.desnoes.puzzleresolver;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void openActivityPuzzle1(View v) {
        Intent ActivityPuzzle1 = new Intent(this, Puzzle1Activity.class);
        startActivity(ActivityPuzzle1);
    }

    public void openActivityPuzzle2(View v) {
        Intent ActivityPuzzle2 = new Intent(this, Puzzle2Activity.class);
        startActivity(ActivityPuzzle2);
    }

    public void openActivityPuzzle3(View v) {
        Intent ActivityPuzzle3 = new Intent(this, Puzzle3Activity.class);
        startActivity(ActivityPuzzle3);
    }
}