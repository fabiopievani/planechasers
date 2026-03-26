package com.fabiopievani.planechasers.core;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import android.annotation.SuppressLint;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
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
    List<Integer> myImageListPlanes = Arrays.asList(R.drawable.image1, R.drawable.image2, R.drawable.image3, R.drawable.image4, R.drawable.image5, R.drawable.image6, R.drawable.image7, R.drawable.image8, R.drawable.image9, R.drawable.image10, R.drawable.image11, R.drawable.image12, R.drawable.image13, R.drawable.image14, R.drawable.image15, R.drawable.image16, R.drawable.image17, R.drawable.image18, R.drawable.image19, R.drawable.image20, R.drawable.image21, R.drawable.image22, R.drawable.image23, R.drawable.image24, R.drawable.image25, R.drawable.image26, R.drawable.image27, R.drawable.image28, R.drawable.image29, R.drawable.image30, R.drawable.image31, R.drawable.image32, R.drawable.image33, R.drawable.image34, R.drawable.image35, R.drawable.image36, R.drawable.image37, R.drawable.image38, R.drawable.image39, R.drawable.image40, R.drawable.image41, R.drawable.image42, R.drawable.image43, R.drawable.image44, R.drawable.image45, R.drawable.image46, R.drawable.image47, R.drawable.image48, R.drawable.image49, R.drawable.image50, R.drawable.image51, R.drawable.image52, R.drawable.image53, R.drawable.image54, R.drawable.image55, R.drawable.image56, R.drawable.image57, R.drawable.image58, R.drawable.image59, R.drawable.image60, R.drawable.image61, R.drawable.image62, R.drawable.image63, R.drawable.image64, R.drawable.image65, R.drawable.image66, R.drawable.image67, R.drawable.image68, R.drawable.image69, R.drawable.image70, R.drawable.image71, R.drawable.image72, R.drawable.image73, R.drawable.image74, R.drawable.image75, R.drawable.image76, R.drawable.image77, R.drawable.image78, R.drawable.image79, R.drawable.image80, R.drawable.image81, R.drawable.image82, R.drawable.image83, R.drawable.image84, R.drawable.image85, R.drawable.image86, R.drawable.image87, R.drawable.image88, R.drawable.image89, R.drawable.image90, R.drawable.image91, R.drawable.image92, R.drawable.image93, R.drawable.image94, R.drawable.image95, R.drawable.image96, R.drawable.image97, R.drawable.image98, R.drawable.image99, R.drawable.image100, R.drawable.image101, R.drawable.image102, R.drawable.image103, R.drawable.image104, R.drawable.image105, R.drawable.image106, R.drawable.image107, R.drawable.image108, R.drawable.image109, R.drawable.image110, R.drawable.image111, R.drawable.image112, R.drawable.image113, R.drawable.image114, R.drawable.image115, R.drawable.image116, R.drawable.image117, R.drawable.image118, R.drawable.image119, R.drawable.image120, R.drawable.image121, R.drawable.image122, R.drawable.image123, R.drawable.image124, R.drawable.image125, R.drawable.image126, R.drawable.image127, R.drawable.image128, R.drawable.image129, R.drawable.image130, R.drawable.image131, R.drawable.image132, R.drawable.image133, R.drawable.image134, R.drawable.image135, R.drawable.image136, R.drawable.image137, R.drawable.image138, R.drawable.image139, R.drawable.image140, R.drawable.image141, R.drawable.image142, R.drawable.image143, R.drawable.image144, R.drawable.image145, R.drawable.image146, R.drawable.image147);
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
            myVib.vibrate(5);
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

    }

    public void onBackPressed() {
        AlertDialog.Builder builder1 = new AlertDialog.Builder(Planes.this);

        myVib.vibrate(200);

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

}
