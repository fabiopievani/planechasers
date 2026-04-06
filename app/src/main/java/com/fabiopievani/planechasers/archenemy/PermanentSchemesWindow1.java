package com.fabiopievani.planechasers.archenemy;

import androidx.activity.OnBackPressedCallback;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.content.ContextCompat;
import android.content.Intent;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.view.View;
import android.widget.CheckBox;
import android.widget.ImageView;
import android.annotation.SuppressLint;
import com.fabiopievani.planechasers.R;
import com.fabiopievani.planechasers.utility.OnSwipeTouchListener;
import com.fabiopievani.planechasers.utility.Shortcuts;

public class PermanentSchemesWindow1 extends AppCompatActivity {

    public ImageView scheme1;
    public ImageView scheme2;
    public ImageView scheme3;
    public ImageView scheme4;
    public ImageView scheme5;
    public ImageView scheme6;
    public ImageView SwipeScheme;
    public ImageView SwipePerma2;

    @SuppressLint({"ClickableViewAccessibility"})
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.permanent_schemes_window1);

        this.getWindow().getDecorView().setSystemUiVisibility(
                View.SYSTEM_UI_FLAG_LAYOUT_STABLE
                        | View.SYSTEM_UI_FLAG_LAYOUT_HIDE_NAVIGATION
                        | View.SYSTEM_UI_FLAG_LAYOUT_FULLSCREEN
                        | View.SYSTEM_UI_FLAG_HIDE_NAVIGATION
                        | View.SYSTEM_UI_FLAG_FULLSCREEN
                        | View.SYSTEM_UI_FLAG_IMMERSIVE_STICKY);

        SwipeScheme = findViewById(R.id.swipe_toScheme);
        SwipePerma2= findViewById(R.id.swipe_toPerma2);
        scheme1 = findViewById(R.id.perma1);
        scheme2 = findViewById(R.id.perma4);
        scheme3 = findViewById(R.id.perma2);
        scheme4 = findViewById(R.id.perma5);
        scheme5 = findViewById(R.id.perma3);
        scheme6 = findViewById(R.id.perma6);
        CheckBox tick1 = findViewById(R.id.check1);
        CheckBox tick2 = findViewById(R.id.check2);
        CheckBox tick3 = findViewById(R.id.check3);
        CheckBox tick4 = findViewById(R.id.check4);
        CheckBox tick5 = findViewById(R.id.check5);
        CheckBox tick6 = findViewById(R.id.check6);
        //forSwipePerma = findViewById(R.id.swipe_perma_schemes);

        Drawable s1 = ContextCompat.getDrawable(this,R.drawable.perma1);
        scheme1.setImageDrawable(s1);
        Drawable s2 = ContextCompat.getDrawable(this,R.drawable.perma2);
        scheme2.setImageDrawable(s2);
        Drawable s3 = ContextCompat.getDrawable(this,R.drawable.perma3);
        scheme3.setImageDrawable(s3);
        Drawable s4 = ContextCompat.getDrawable(this,R.drawable.perma4);
        scheme4.setImageDrawable(s4);
        Drawable s5 = ContextCompat.getDrawable(this,R.drawable.perma5);
        scheme5.setImageDrawable(s5);
        Drawable s6 = ContextCompat.getDrawable(this,R.drawable.perma6);
        scheme6.setImageDrawable(s6);


        tick1.setChecked(Shortcuts.CaricamentoBooleano(getApplicationContext(),"tick_perma1"));
        tick2.setChecked(Shortcuts.CaricamentoBooleano(getApplicationContext(),"tick_perma2"));
        tick3.setChecked(Shortcuts.CaricamentoBooleano(getApplicationContext(),"tick_perma3"));
        tick4.setChecked(Shortcuts.CaricamentoBooleano(getApplicationContext(),"tick_perma4"));
        tick5.setChecked(Shortcuts.CaricamentoBooleano(getApplicationContext(),"tick_perma5"));
        tick6.setChecked(Shortcuts.CaricamentoBooleano(getApplicationContext(),"tick_perma6"));

        tick1.setOnCheckedChangeListener((compoundButton, b) -> Shortcuts.SalvataggioBooleano(getApplicationContext(),b,"tick_perma"));
        tick2.setOnCheckedChangeListener((compoundButton, b) -> Shortcuts.SalvataggioBooleano(getApplicationContext(),b,"tick_perma2"));
        tick3.setOnCheckedChangeListener((compoundButton, b) -> Shortcuts.SalvataggioBooleano(getApplicationContext(),b,"tick_perma3"));
        tick4.setOnCheckedChangeListener((compoundButton, b) -> Shortcuts.SalvataggioBooleano(getApplicationContext(),b,"tick_perma4"));
        tick5.setOnCheckedChangeListener((compoundButton, b) -> Shortcuts.SalvataggioBooleano(getApplicationContext(),b,"tick_perma5"));
        tick6.setOnCheckedChangeListener((compoundButton, b) -> Shortcuts.SalvataggioBooleano(getApplicationContext(),b,"tick_perma6"));

        SwipeScheme.setOnTouchListener(new OnSwipeTouchListener(PermanentSchemesWindow1.this) {
            public void onSwipeRight() {
                startActivity(new Intent(PermanentSchemesWindow1.this, Schemes.class));
                overridePendingTransition(R.anim.animation_left_to_right_enter, R.anim.animation_left_to_right_exit);
                finish();
            }
        });

        SwipePerma2.setOnTouchListener(new OnSwipeTouchListener(PermanentSchemesWindow1.this) {
            public void onSwipeLeft() {
                startActivity(new Intent(PermanentSchemesWindow1.this, PermanentSchemesWindow2.class));
                overridePendingTransition(R.anim.animation_right_to_left_enter, R.anim.animation_right_to_left_exit);
                finish();
            }
        });

        getOnBackPressedDispatcher().addCallback(this, new OnBackPressedCallback(true) {
            @Override
            public void handleOnBackPressed() {
                startActivity(new Intent(PermanentSchemesWindow1.this, Schemes.class));
                overridePendingTransition(R.anim.animation_left_to_right_enter, R.anim.animation_left_to_right_exit);
                finish();
            }
        });
    }
}