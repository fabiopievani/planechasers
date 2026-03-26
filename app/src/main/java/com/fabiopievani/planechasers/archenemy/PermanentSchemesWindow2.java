package com.fabiopievani.planechasers.archenemy;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.content.ContextCompat;
import android.annotation.SuppressLint;
import android.content.Intent;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.view.View;
import android.widget.CheckBox;
import android.widget.ImageView;

import com.fabiopievani.planechasers.utility.OnSwipeTouchListener;
import com.fabiopievani.planechasers.utility.Shortcuts;
import com.fabiopievani.planechasers.R;

public class PermanentSchemesWindow2 extends AppCompatActivity {

    public ImageView scheme7;
    public ImageView scheme8;
    public ImageView scheme9;
    public ImageView scheme10;
    public ImageView scheme11;
    public ImageView scheme12;
    public ImageView SwipeScheme2;
    public ImageView SwipePerma1;


    @SuppressLint("ClickableViewAccessibility")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.permanent_schemes_window2);

        this.getWindow().getDecorView().setSystemUiVisibility(
                View.SYSTEM_UI_FLAG_LAYOUT_STABLE
                        | View.SYSTEM_UI_FLAG_LAYOUT_HIDE_NAVIGATION
                        | View.SYSTEM_UI_FLAG_LAYOUT_FULLSCREEN
                        | View.SYSTEM_UI_FLAG_HIDE_NAVIGATION
                        | View.SYSTEM_UI_FLAG_FULLSCREEN
                        | View.SYSTEM_UI_FLAG_IMMERSIVE_STICKY);

        SwipeScheme2 = findViewById(R.id.swipe_toScheme2);
        SwipePerma1 = findViewById(R.id.swipe_toPerma1);
        scheme7 = findViewById(R.id.perma7);
        scheme8 = findViewById(R.id.perma8);
        scheme9 = findViewById(R.id.perma9);
        scheme10 = findViewById(R.id.perma10);
        scheme11 = findViewById(R.id.perma11);
        scheme12 = findViewById(R.id.perma12);
        CheckBox tick7 = findViewById(R.id.check7);
        CheckBox tick8 = findViewById(R.id.check8);
        CheckBox tick9 = findViewById(R.id.check9);
        CheckBox tick10 = findViewById(R.id.check10);
        CheckBox tick11 = findViewById(R.id.check11);
        CheckBox tick12 = findViewById(R.id.check12);

        Drawable s1 = ContextCompat.getDrawable(this,R.drawable.perma7);
        scheme7.setImageDrawable(s1);
        Drawable s2 = ContextCompat.getDrawable(this,R.drawable.perma8);
        scheme8.setImageDrawable(s2);
        Drawable s3 = ContextCompat.getDrawable(this,R.drawable.perma9);
        scheme9.setImageDrawable(s3);
        Drawable s4 = ContextCompat.getDrawable(this,R.drawable.perma10);
        scheme10.setImageDrawable(s4);
        Drawable s5 = ContextCompat.getDrawable(this,R.drawable.perma11);
        scheme11.setImageDrawable(s5);
        Drawable s6 = ContextCompat.getDrawable(this,R.drawable.perma12);
        scheme12.setImageDrawable(s6);


        tick7.setChecked(Shortcuts.CaricamentoBooleano(getApplicationContext(), "tick7"));
        tick8.setChecked(Shortcuts.CaricamentoBooleano(getApplicationContext(), "tick8"));
        tick9.setChecked(Shortcuts.CaricamentoBooleano(getApplicationContext(), "tick9"));
        tick10.setChecked(Shortcuts.CaricamentoBooleano(getApplicationContext(), "tick10"));
        tick11.setChecked(Shortcuts.CaricamentoBooleano(getApplicationContext(), "tick11"));
        tick12.setChecked(Shortcuts.CaricamentoBooleano(getApplicationContext(), "tick12"));

        tick7.setOnCheckedChangeListener((compoundButton, b) -> Shortcuts.SalvataggioBooleano(getApplicationContext(), b, "tick7"));
        tick8.setOnCheckedChangeListener((compoundButton, b) -> Shortcuts.SalvataggioBooleano(getApplicationContext(), b, "tick8"));
        tick9.setOnCheckedChangeListener((compoundButton, b) -> Shortcuts.SalvataggioBooleano(getApplicationContext(), b, "tick9"));
        tick10.setOnCheckedChangeListener((compoundButton, b) -> Shortcuts.SalvataggioBooleano(getApplicationContext(), b, "tick10"));
        tick11.setOnCheckedChangeListener((compoundButton, b) -> Shortcuts.SalvataggioBooleano(getApplicationContext(), b, "tick11"));
        tick12.setOnCheckedChangeListener((compoundButton, b) -> Shortcuts.SalvataggioBooleano(getApplicationContext(), b, "tick12"));

        SwipePerma1.setOnTouchListener(new OnSwipeTouchListener(PermanentSchemesWindow2.this) {
            public void onSwipeRight() {
                startActivity(new Intent(PermanentSchemesWindow2.this, PermanentSchemesWindow1.class));
                overridePendingTransition(R.anim.animation_left_to_right_enter, R.anim.animation_left_to_right_exit);
                finish();
            }
        });

        SwipeScheme2.setOnTouchListener(new OnSwipeTouchListener(PermanentSchemesWindow2.this) {
            public void onSwipeLeft() {
                startActivity(new Intent(PermanentSchemesWindow2.this, Schemes.class));
                overridePendingTransition(R.anim.animation_left_to_right_enter, R.anim.animation_left_to_right_exit);
                finish();
            }
        });

    }

    public void onBackPressed() {
        super.onBackPressed();
        startActivity(new Intent(PermanentSchemesWindow2.this, Schemes.class));
        overridePendingTransition(R.anim.animation_left_to_right_enter, R.anim.animation_left_to_right_exit);
        finish();
    }

}
