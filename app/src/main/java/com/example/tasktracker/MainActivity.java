package com.example.tasktracker;

import android.os.Bundle;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;
import androidx.fragment.app.FragmentTransaction;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        TopFragment topFragment = new TopFragment();
        BottomFragment bottomFragment = new BottomFragment();

        FragmentTransaction trans = getSupportFragmentManager().beginTransaction();
        trans.add(R.id.top_frame, topFragment);
        trans.add(R.id.bottom_frame, bottomFragment);
        trans.commit();
    }
}