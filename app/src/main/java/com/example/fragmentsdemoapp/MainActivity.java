package com.example.fragmentsdemoapp;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentTransaction;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {
    private boolean hasPhoneFragmentCurrently=true;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_main);


        if (savedInstanceState != null) {
            return;
        }

        SmallScreenWithPhoneFragment t = new SmallScreenWithPhoneFragment();
        getSupportFragmentManager().beginTransaction()
                .add(R.id.fragment_container, t).commit();

        Button button = findViewById(R.id.button_next_fragment);
        if (button != null)
            button.setOnClickListener((v) -> {
                show_other_fragment();
            });
        else{
            getSupportFragmentManager().beginTransaction()
                    .add(R.id.fragment_container2, new SmallScreenWithSpeakerFragment()).commit();

        }

//        button.setOnClickListener((this::show_other_fragment);
    }


//    public void show_other_fragment(View v) {
//        show_other_fragment();
//    }

    public void show_other_fragment() {
        FragmentTransaction transaction = getSupportFragmentManager().beginTransaction();

        if(hasPhoneFragmentCurrently) {
            transaction.replace(R.id.fragment_container,new SmallScreenWithSpeakerFragment()).commit();
            hasPhoneFragmentCurrently=!hasPhoneFragmentCurrently;
        }
        else{
            transaction.replace(R.id.fragment_container,new SmallScreenWithPhoneFragment()).commit();
            hasPhoneFragmentCurrently=!hasPhoneFragmentCurrently;
        }
    }
    }

