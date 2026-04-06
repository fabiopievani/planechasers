package com.fabiopievani.planechasers.archenemy;

import androidx.activity.OnBackPressedCallback;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import android.annotation.SuppressLint;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.os.VibrationEffect;
import android.os.Vibrator;
import android.view.View;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.ImageView;

import com.fabiopievani.planechasers.core.Menu;
import com.fabiopievani.planechasers.utility.OnSwipeTouchListener;
import com.fabiopievani.planechasers.utility.Shortcuts;
import com.fabiopievani.planechasers.core.Planes;
import com.fabiopievani.planechasers.R;

import java.util.Arrays;
import java.util.List;

public class Schemes extends AppCompatActivity {

    public static int scheme_get = 0;
    public Button next_scheme;
    public Button toLife;
    public Button toPlanes;
    public Button permanentSchemes;
    public ImageView schema;
    private Vibrator myVib;
    public ImageView forSwipe;
    List<Integer> myImageListArchenemy = Arrays.asList(R.drawable.archenemy0,R.drawable.archenemy1,R.drawable.archenemy2,R.drawable.archenemy3,R.drawable.archenemy4,R.drawable.archenemy5,R.drawable.archenemy6,R.drawable.archenemy7,R.drawable.archenemy8,R.drawable.archenemy9,R.drawable.archenemy10,R.drawable.archenemy11,R.drawable.archenemy12,R.drawable.archenemy13,R.drawable.archenemy14,R.drawable.archenemy15,R.drawable.archenemy16,R.drawable.archenemy17,R.drawable.archenemy18,R.drawable.archenemy19,R.drawable.archenemy20,R.drawable.archenemy21,R.drawable.archenemy22,R.drawable.archenemy23,R.drawable.archenemy24,R.drawable.archenemy25,R.drawable.archenemy26,R.drawable.archenemy27,R.drawable.archenemy28,R.drawable.archenemy29,R.drawable.archenemy30,R.drawable.archenemy31,R.drawable.archenemy32,R.drawable.archenemy33,R.drawable.archenemy34,R.drawable.archenemy35,R.drawable.archenemy36,R.drawable.archenemy37,R.drawable.archenemy38,R.drawable.archenemy39,R.drawable.archenemy40,R.drawable.archenemy41,R.drawable.archenemy42,R.drawable.archenemy43,R.drawable.archenemy44,R.drawable.archenemy45,R.drawable.archenemy46,R.drawable.archenemy47,R.drawable.archenemy48,R.drawable.archenemy49,R.drawable.archenemy50,R.drawable.archenemy51,R.drawable.archenemy52,R.drawable.archenemy53,R.drawable.archenemy54,R.drawable.archenemy55,R.drawable.archenemy56,R.drawable.archenemy57);
    public int[] indici = {0,1,2,3,4,5,6,7,8,9,10,11,12,13,14,15,16,17,18,19,20,21,22,23,24,25,26,27,28,29,30,31,32,33,34,35,36,37,38,39,40,41,42,43,44,45,46,47,48,49,50,51,52,53,54,55,56,57};

    @SuppressLint("ClickableViewAccessibility")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.schemes);

        //Imposta la nodalità immersione (no barra controllo, no barra impostazioni)
        this.getWindow().getDecorView().setSystemUiVisibility(
                View.SYSTEM_UI_FLAG_LAYOUT_STABLE
                        | View.SYSTEM_UI_FLAG_LAYOUT_HIDE_NAVIGATION
                        | View.SYSTEM_UI_FLAG_LAYOUT_FULLSCREEN
                        | View.SYSTEM_UI_FLAG_HIDE_NAVIGATION
                        | View.SYSTEM_UI_FLAG_FULLSCREEN
                        | View.SYSTEM_UI_FLAG_IMMERSIVE_STICKY);

        //Impedisce blocco schermo
        getWindow().addFlags(WindowManager.LayoutParams.FLAG_KEEP_SCREEN_ON);

        schema = findViewById(R.id.schema);
        next_scheme = findViewById(R.id.next_scheme);
        toLife = findViewById(R.id.life_from_schemes);
        toPlanes = findViewById(R.id.planes_from_schemes);
        myVib = (Vibrator) this.getSystemService(VIBRATOR_SERVICE);
        forSwipe = findViewById(R.id.swipe_schemes);
        permanentSchemes = findViewById(R.id.permanent_schemes);

        scheme_get = (int) Shortcuts.CaricamentoDummy(getApplicationContext(), "schema", 0);

        if (scheme_get != 0) {
            indici = Shortcuts.CaricamentoArray(getApplicationContext());
            schema.setImageResource(myImageListArchenemy.get(indici[scheme_get]));
        } else {
            Shortcuts.shuffleArray(indici);
            Shortcuts.SalvataggioArray(getApplicationContext(), indici);
            schema.setImageResource(R.drawable.empty_view);
        }

        next_scheme.setOnClickListener(v -> {
            AlertDialog.Builder builder1 = new AlertDialog.Builder(Schemes.this);
            myVib.vibrate(VibrationEffect.createOneShot(5, VibrationEffect.DEFAULT_AMPLITUDE));
            builder1.setMessage("Go to the next scheme?")
                    .setCancelable(false)
                    .setPositiveButton("Yes", (dialogInterface, i) -> {

                        scheme_get++;
                        schema.setImageResource(myImageListArchenemy.get(indici[scheme_get]));

                        if (scheme_get == 57) {
                            scheme_get = 0;
                            Shortcuts.shuffleArray(indici);
                            Shortcuts.SalvataggioArray(getApplicationContext(), indici);
                            Shortcuts.MessaggioSchermo(Schemes.this, "This is the last scheme, I shuffled!");
                        }
                        Shortcuts.SalvataggioDummy(getApplicationContext(), scheme_get, "schema");

                    })

                    .setNegativeButton("No", (dialogInterface, i) -> dialogInterface.cancel());
            AlertDialog alert = builder1.create();
            alert.setTitle("Warning");
            alert.show();
        });

        toLife.setOnClickListener(v -> {
            startActivity(new Intent(Schemes.this, ArchenemyLife.class));
            overridePendingTransition(R.anim.animation_left_to_right_enter, R.anim.animation_left_to_right_exit);
            finish();
        });

        toPlanes.setOnClickListener(v -> {
            startActivity(new Intent(Schemes.this, Planes.class));
            overridePendingTransition(R.anim.animation_left_to_right_enter, R.anim.animation_left_to_right_exit);
            finish();
        });

        permanentSchemes.setOnClickListener(v -> {
            startActivity(new Intent(Schemes.this, PermanentSchemesWindow1.class));
            overridePendingTransition(R.anim.animation_right_to_left_enter, R.anim.animation_right_to_left_exit);
            finish();
        });

        forSwipe.setOnTouchListener(new OnSwipeTouchListener(Schemes.this) {
            public void onSwipeRight() {
                startActivity(new Intent(Schemes.this, ArchenemyLife.class));
                overridePendingTransition(R.anim.animation_left_to_right_enter, R.anim.animation_left_to_right_exit);
                finish();
            }
        });

        getOnBackPressedDispatcher().addCallback(this, new OnBackPressedCallback(true) {
            @Override
            public void handleOnBackPressed() {
                AlertDialog.Builder builder1 = new AlertDialog.Builder(Schemes.this);

                myVib.vibrate(VibrationEffect.createOneShot(200, VibrationEffect.DEFAULT_AMPLITUDE));

                builder1.setMessage("Go back to main menu, you will lose all preferences?")
                        .setCancelable(false)
                        .setPositiveButton("Yes", (dialogInterface, i) -> {
                            startActivity(new Intent(Schemes.this, Menu.class));
                            SharedPreferences preferences = getSharedPreferences("planechasers_prefs", MODE_PRIVATE);
                            preferences.edit().clear().apply();
                            overridePendingTransition(R.anim.animation_bottom_to_top_enter, R.anim.animation_bottom_to_top_exit);
                            finish();
                        })

                        .setNegativeButton("No", (dialogInterface, i) -> dialogInterface.cancel());
                AlertDialog alert = builder1.create();
                alert.setTitle("Warning");
                alert.show();

            }
        });
    }
}

