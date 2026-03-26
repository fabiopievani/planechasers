package com.fabiopievani.planechasers.core;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.os.Vibrator;
import android.preference.PreferenceManager;
import android.view.View;
import android.widget.Button;
import com.fabiopievani.planechasers.archenemy.ArchenemyLife;
import com.fabiopievani.planechasers.utility.Shortcuts;
import com.fabiopievani.planechasers.R;

@SuppressWarnings("deprecation")
public class Menu extends AppCompatActivity {

    public Button gallery;
    public Button classic;
    public Button archenemy;

    private Vibrator myVib;
    public int selector;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.menu);

        this.getWindow().getDecorView().setSystemUiVisibility(
                View.SYSTEM_UI_FLAG_LAYOUT_STABLE
                        | View.SYSTEM_UI_FLAG_LAYOUT_HIDE_NAVIGATION
                        | View.SYSTEM_UI_FLAG_LAYOUT_FULLSCREEN
                        | View.SYSTEM_UI_FLAG_FULLSCREEN
                        | View.SYSTEM_UI_FLAG_IMMERSIVE_STICKY);

        myVib = (Vibrator) this.getSystemService(VIBRATOR_SERVICE);
        gallery = findViewById(R.id.gallery);
        classic = findViewById(R.id.classic);
        archenemy = findViewById(R.id.archenemy);

        gallery.setOnClickListener(v -> {
            myVib.vibrate(10);
            startActivity(new Intent(Menu.this, Commanders.class));
            overridePendingTransition(R.anim.animation_right_to_left_enter, R.anim.animation_right_to_left_exit);
        });

        classic.setOnClickListener(v -> {
            myVib.vibrate(10);
            selector=0;
            Shortcuts.SalvataggioDummy(getApplicationContext(),selector,"selettore");
            startActivity(new Intent(Menu.this, Life.class));
            overridePendingTransition(R.anim.animation_top_to_bottom_enter, R.anim.animation_top_to_bottom_exit);
            finish();
        });

        archenemy.setOnClickListener(v -> {
            myVib.vibrate(10);
            selector=1;
            Shortcuts.SalvataggioDummy(getApplicationContext(),selector,"selettore");
            startActivity(new Intent(Menu.this, ArchenemyLife.class));
            overridePendingTransition(R.anim.animation_top_to_bottom_enter, R.anim.animation_top_to_bottom_exit);
            finish();
        });

    }

    public void onBackPressed() {
        AlertDialog.Builder builder1 = new AlertDialog.Builder(Menu.this);

        myVib.vibrate(200);

        builder1.setMessage("You will lose all preferences, quit anyway?")
                .setCancelable(false)
                .setPositiveButton("Yes", (dialogInterface, i) -> {
                    SharedPreferences preferences = PreferenceManager.getDefaultSharedPreferences(Menu.this);
                    preferences.edit().clear().apply();
                    finish();
                })

                .setNegativeButton("No", (dialogInterface, i) -> dialogInterface.cancel());

        AlertDialog alert = builder1.create();
        alert.setTitle("Warning");
        alert.show();
    }
}