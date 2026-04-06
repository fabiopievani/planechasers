package com.fabiopievani.planechasers.core;

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

import com.fabiopievani.planechasers.utility.OnSwipeTouchListener;
import com.fabiopievani.planechasers.archenemy.Schemes;
import com.fabiopievani.planechasers.utility.Shortcuts;
import com.fabiopievani.planechasers.archenemy.ArchenemyLife;
import com.fabiopievani.planechasers.R;

import java.util.Arrays;
import java.util.List;


public class Planes extends AppCompatActivity {

    public static int img_get = 0;
    public Button next_plane;
    public Button toLife;
    public Button toSchemes;
    public ImageView piano;
    List<Integer> myImageListPlanes = Arrays.asList(R.drawable.plane1, R.drawable.plane2, R.drawable.plane3, R.drawable.plane4, R.drawable.plane5, R.drawable.plane6, R.drawable.plane7, R.drawable.plane8, R.drawable.plane9, R.drawable.plane10, R.drawable.plane11, R.drawable.plane12, R.drawable.plane13, R.drawable.plane14, R.drawable.plane15, R.drawable.plane16, R.drawable.plane17, R.drawable.plane18, R.drawable.plane19, R.drawable.plane20, R.drawable.plane21, R.drawable.plane22, R.drawable.plane23, R.drawable.plane24, R.drawable.plane25, R.drawable.plane26, R.drawable.plane27, R.drawable.plane28, R.drawable.plane29, R.drawable.plane30, R.drawable.plane31, R.drawable.plane32, R.drawable.plane33, R.drawable.plane34, R.drawable.plane35, R.drawable.plane36, R.drawable.plane37, R.drawable.plane38, R.drawable.plane39, R.drawable.plane40, R.drawable.plane41, R.drawable.plane42, R.drawable.plane43, R.drawable.plane44, R.drawable.plane45, R.drawable.plane46, R.drawable.plane47, R.drawable.plane48, R.drawable.plane49, R.drawable.plane50, R.drawable.plane51, R.drawable.plane52, R.drawable.plane53, R.drawable.plane54, R.drawable.plane55, R.drawable.plane56, R.drawable.plane57, R.drawable.plane58, R.drawable.plane59, R.drawable.plane60, R.drawable.plane61, R.drawable.plane62, R.drawable.plane63, R.drawable.plane64, R.drawable.plane65, R.drawable.plane66, R.drawable.plane67, R.drawable.plane68, R.drawable.plane69, R.drawable.plane70, R.drawable.plane71, R.drawable.plane72, R.drawable.plane73, R.drawable.plane74, R.drawable.plane75, R.drawable.plane76, R.drawable.plane77, R.drawable.plane78, R.drawable.plane79, R.drawable.plane80, R.drawable.plane81, R.drawable.plane82, R.drawable.plane83, R.drawable.plane84, R.drawable.plane85, R.drawable.plane86, R.drawable.plane87, R.drawable.plane88, R.drawable.plane89, R.drawable.plane90, R.drawable.plane91, R.drawable.plane92, R.drawable.plane93, R.drawable.plane94, R.drawable.plane95, R.drawable.plane96, R.drawable.plane97, R.drawable.plane98, R.drawable.plane99, R.drawable.plane100, R.drawable.plane101, R.drawable.plane102, R.drawable.plane103, R.drawable.plane104, R.drawable.plane105, R.drawable.plane106, R.drawable.plane107, R.drawable.plane108, R.drawable.plane109, R.drawable.plane110, R.drawable.plane111, R.drawable.plane112, R.drawable.plane113, R.drawable.plane114, R.drawable.plane115, R.drawable.plane116, R.drawable.plane117, R.drawable.plane118, R.drawable.plane119, R.drawable.plane120, R.drawable.plane121, R.drawable.plane122, R.drawable.plane123, R.drawable.plane124, R.drawable.plane125, R.drawable.plane126, R.drawable.plane127, R.drawable.plane128, R.drawable.plane129, R.drawable.plane130, R.drawable.plane131, R.drawable.plane132, R.drawable.plane133, R.drawable.plane134, R.drawable.plane135, R.drawable.plane136, R.drawable.plane137, R.drawable.plane138, R.drawable.plane139, R.drawable.plane140, R.drawable.plane141, R.drawable.plane142, R.drawable.plane143, R.drawable.plane144, R.drawable.plane145, R.drawable.plane146, R.drawable.plane147);
    public int[] indiciPiani = {0, 1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14, 15, 16, 17, 18, 19, 20, 21, 22, 23, 24, 25, 26, 27, 28, 29, 30, 31, 32, 33, 34, 35, 36, 37, 38, 39, 40, 41, 42, 43, 44, 45, 46, 47, 48, 49, 50, 51, 52, 53, 54, 55, 56, 57, 58, 59, 60, 61, 62, 63, 64, 65, 66, 67, 68, 69, 70, 71, 72, 73, 74, 75, 76, 77, 78, 79, 80, 81, 82, 83, 84, 85, 86, 87, 88, 89, 90, 91, 92, 93, 94, 95, 96, 97, 98, 99, 100, 101, 102, 103, 104, 105, 106, 107, 108, 109, 110, 112, 113, 114, 115, 116, 117, 118, 119, 120, 121, 122, 123, 124, 125, 126, 127, 128, 129, 130, 131, 132, 133, 134, 135, 136, 137, 138, 139, 140, 141, 142, 143, 144, 145, 146};
    private Vibrator myVib;
    public int selector;
    public ImageView forSwipe;

    @SuppressLint("ClickableViewAccessibility")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.planes);

        this.getWindow().getDecorView().setSystemUiVisibility(
                View.SYSTEM_UI_FLAG_LAYOUT_STABLE
                        | View.SYSTEM_UI_FLAG_LAYOUT_HIDE_NAVIGATION
                        | View.SYSTEM_UI_FLAG_LAYOUT_FULLSCREEN
                        | View.SYSTEM_UI_FLAG_HIDE_NAVIGATION
                        | View.SYSTEM_UI_FLAG_FULLSCREEN
                        | View.SYSTEM_UI_FLAG_IMMERSIVE_STICKY);

        //Impedisce blocco schermo
        getWindow().addFlags(WindowManager.LayoutParams.FLAG_KEEP_SCREEN_ON);

        myVib = (Vibrator) this.getSystemService(VIBRATOR_SERVICE);
        next_plane = findViewById(R.id.next_plane);
        toLife = findViewById(R.id.life_from_planes);
        toSchemes = findViewById(R.id.schemes_from_planes);
        piano = findViewById(R.id.piano);
        forSwipe = findViewById(R.id.swipe_planes);

        img_get = (int) Shortcuts.CaricamentoDummy(getApplicationContext(), "piano", 0);
        selector = (int) Shortcuts.CaricamentoDummy(getApplicationContext(), "selettore", 0);

        if (selector == 0) {
            toSchemes.setVisibility(View.GONE);
        }

        if (img_get != 0) {
            indiciPiani = Shortcuts.CaricamentoArrayPiani(getApplicationContext());
            piano.setImageResource(myImageListPlanes.get(indiciPiani[img_get]));
        } else {
            Shortcuts.shuffleArray(indiciPiani);
            Shortcuts.SalvataggioArrayPiani(getApplicationContext(), indiciPiani);
            piano.setImageResource(R.drawable.empty_view);
        }

        next_plane.setOnClickListener(v -> {
            AlertDialog.Builder builder1 = new AlertDialog.Builder(Planes.this);
            myVib.vibrate(VibrationEffect.createOneShot(200, VibrationEffect.DEFAULT_AMPLITUDE));
            builder1.setMessage("Go to the next plane?")

                    .setCancelable(false)
                    .setPositiveButton("Yes", (dialogInterface, i) -> {

                        img_get++;
                        piano.setImageResource(myImageListPlanes.get(indiciPiani[img_get]));

                        if (img_get == 146) {
                            img_get = 0;
                            Shortcuts.shuffleArray(indiciPiani);
                            Shortcuts.SalvataggioArrayPiani(getApplicationContext(), indiciPiani);
                            Shortcuts.MessaggioSchermo(Planes.this, "This is the last plane, I shuffled!");
                        }

                        Shortcuts.SalvataggioDummy(getApplicationContext(), img_get, "piano");

                    })

                    .setNegativeButton("No", (dialogInterface, i) -> dialogInterface.cancel());

            AlertDialog alert = builder1.create();
            alert.setTitle("Warning");
            alert.show();
        });

        toLife.setOnClickListener(v -> {
            if (selector == 1) {
                startActivity(new Intent(Planes.this, ArchenemyLife.class));
                overridePendingTransition(R.anim.animation_right_to_left_enter, R.anim.animation_right_to_left_exit);
            } else {
                startActivity(new Intent(Planes.this, Life.class));
                overridePendingTransition(R.anim.animation_right_to_left_enter, R.anim.animation_right_to_left_exit);
            }
            finish();
        });

        toSchemes.setOnClickListener(v -> {
            startActivity(new Intent(Planes.this, Schemes.class));
            overridePendingTransition(R.anim.animation_right_to_left_enter, R.anim.animation_right_to_left_exit);
            finish();
        });

        forSwipe.setOnTouchListener(new OnSwipeTouchListener(Planes.this) {
            public void onSwipeLeft() {
                if (selector == 1) {
                    startActivity(new Intent(Planes.this, ArchenemyLife.class));
                    overridePendingTransition(R.anim.animation_right_to_left_enter, R.anim.animation_right_to_left_exit);
                } else {
                    startActivity(new Intent(Planes.this, Life.class));
                    overridePendingTransition(R.anim.animation_right_to_left_enter, R.anim.animation_right_to_left_exit);
                }
                finish();
            }
        });

        getOnBackPressedDispatcher().addCallback(this, new OnBackPressedCallback(true) {
            @Override
            public void handleOnBackPressed() {
                AlertDialog.Builder builder1 = new AlertDialog.Builder(Planes.this);

                myVib.vibrate(VibrationEffect.createOneShot(200, VibrationEffect.DEFAULT_AMPLITUDE));

                builder1.setMessage("Go back to main menu, you will lose all preferences?")
                        .setCancelable(false)
                        .setPositiveButton("Yes", (dialogInterface, i) -> {
                            startActivity(new Intent(Planes.this, Menu.class));
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
