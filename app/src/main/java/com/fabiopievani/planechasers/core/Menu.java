package com.fabiopievani.planechasers.core;

import androidx.activity.OnBackPressedCallback;
import androidx.annotation.NonNull;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import android.content.Intent;
import android.content.SharedPreferences;
import android.graphics.SurfaceTexture;
import android.media.MediaPlayer;
import android.net.Uri;
import android.os.Bundle;
import android.os.Vibrator;
import android.preference.PreferenceManager;
import android.util.DisplayMetrics;
import android.util.Log;
import android.view.Surface;
import android.view.TextureView;
import android.view.View;
import android.widget.Button;
import com.fabiopievani.planechasers.archenemy.ArchenemyLife;
import com.fabiopievani.planechasers.utility.Shortcuts;
import com.fabiopievani.planechasers.R;
import java.io.IOException;

@SuppressWarnings("deprecation")
public class Menu extends AppCompatActivity {

    public Button gallery;
    public Button classic;
    public Button archenemy;

    private Vibrator myVib;
    public int selector;
    MediaPlayer mediaPlayer = new MediaPlayer();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.menu);

        this.getWindow().getDecorView().setSystemUiVisibility(
                View.SYSTEM_UI_FLAG_LAYOUT_STABLE
                        | View.SYSTEM_UI_FLAG_LAYOUT_HIDE_NAVIGATION
                        | View.SYSTEM_UI_FLAG_LAYOUT_FULLSCREEN
                        | View.SYSTEM_UI_FLAG_HIDE_NAVIGATION
                        | View.SYSTEM_UI_FLAG_FULLSCREEN
                        | View.SYSTEM_UI_FLAG_IMMERSIVE_STICKY);

        // Segmento di codice per la riproduzione sul background del video nel menu iniziale
        TextureView textureView = findViewById(R.id.videoBackground);
        DisplayMetrics metrics = new DisplayMetrics();
        getWindowManager().getDefaultDisplay().getRealMetrics(metrics);
        int screenWidth = metrics.widthPixels;
        int screenHeight = metrics.heightPixels;

        textureView.setSurfaceTextureListener(new TextureView.SurfaceTextureListener() {
            @Override
            public void onSurfaceTextureAvailable(@NonNull SurfaceTexture surfaceTexture, int width, int height) {
                try {
                    Surface surface = new Surface(surfaceTexture);
                    mediaPlayer.setSurface(surface);
                    mediaPlayer.setDataSource(Menu.this, Uri.parse("android.resource://" + getPackageName() + "/" + R.raw.menu_background));
                    mediaPlayer.setLooping(true);
                    mediaPlayer.prepare();
                    mediaPlayer.start();

                    int videoWidth = mediaPlayer.getVideoWidth();
                    int videoHeight = mediaPlayer.getVideoHeight();

                    float videoRatio = (float) videoWidth / videoHeight;
                    float screenRatio = (float) screenWidth / screenHeight;

                    float scaleX = 1f, scaleY = 1f;

                    //scala video per riempire lo schermo
                    if(videoRatio > screenRatio){
                        scaleX = videoRatio / screenRatio;
                    } else if(videoRatio < screenRatio){
                        scaleY = screenRatio / videoRatio;
                    }

                    textureView.setScaleX(scaleX);
                    textureView.setScaleY(scaleY);
                    textureView.setPivotX(screenWidth / 2f);
                    textureView.setPivotY(screenHeight / 2f);

                } catch (IOException e) {
                    Log.e("Menu", "Error loading background video", e);

                    // mette sfondo statico
                    findViewById(R.id.videoBackground).setVisibility(View.GONE);
                }
            }

            @Override public void onSurfaceTextureSizeChanged(@NonNull SurfaceTexture surface, int width, int height) {}
            @Override public boolean onSurfaceTextureDestroyed(@NonNull SurfaceTexture surface) { return true; }
            @Override public void onSurfaceTextureUpdated(@NonNull SurfaceTexture surface) {}
        });


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

        getOnBackPressedDispatcher().addCallback(this, new OnBackPressedCallback(true) {
            @Override
            public void handleOnBackPressed() {
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
        });

    }

    @Override
    protected void onPause() {
        super.onPause();
        // mette in pausa il video quando l'activity non è più in primo piano
        if(mediaPlayer.isPlaying()) mediaPlayer.pause();
    }

    @Override
    protected void onResume() {
        super.onResume();
        mediaPlayer.start();
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        mediaPlayer.release();
    }
}
