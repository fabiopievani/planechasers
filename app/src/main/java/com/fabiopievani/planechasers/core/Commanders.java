package com.fabiopievani.planechasers.core;

import androidx.appcompat.app.AppCompatActivity;
import android.annotation.SuppressLint;
import android.content.Intent;
import android.graphics.Bitmap;
import android.net.Uri;
import android.os.Bundle;
import android.os.Vibrator;
import android.provider.MediaStore;
import android.util.Base64;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;

import com.fabiopievani.planechasers.utility.Shortcuts;
import com.fabiopievani.planechasers.R;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.util.Random;


@SuppressWarnings("deprecation")
public class Commanders extends AppCompatActivity {

    public Button player1;
    public Button player2;
    public Button player3;
    public Button player4;

    public Button RANDOM;
    private Vibrator myVib;
    public int rand_check;

    public ImageView tick_player1;
    public ImageView tick_player2;
    public ImageView tick_player3;
    public ImageView tick_player4;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.commanders);

        this.getWindow().getDecorView().setSystemUiVisibility(
                View.SYSTEM_UI_FLAG_LAYOUT_STABLE
                        | View.SYSTEM_UI_FLAG_LAYOUT_HIDE_NAVIGATION
                        | View.SYSTEM_UI_FLAG_LAYOUT_FULLSCREEN
                        | View.SYSTEM_UI_FLAG_FULLSCREEN
                        | View.SYSTEM_UI_FLAG_IMMERSIVE_STICKY);

        player1 = findViewById(R.id.player1);
        player2 = findViewById(R.id.player2);
        player3 = findViewById(R.id.player3);
        player4 = findViewById(R.id.player4);

        RANDOM = findViewById(R.id.RANDOM);
        myVib = (Vibrator) this.getSystemService(VIBRATOR_SERVICE);

        tick_player1 = findViewById(R.id.tick_player1);
        tick_player2 = findViewById(R.id.tick_player2);
        tick_player3 = findViewById(R.id.tick_player3);
        tick_player4 = findViewById(R.id.tick_player4);

        tick_player1.setVisibility((Integer) Shortcuts.CaricamentoDummy(getApplicationContext(), "tick1", 3));
        tick_player2.setVisibility((Integer) Shortcuts.CaricamentoDummy(getApplicationContext(), "tick2", 3));
        tick_player3.setVisibility((Integer) Shortcuts.CaricamentoDummy(getApplicationContext(), "tick3", 3));
        tick_player4.setVisibility((Integer) Shortcuts.CaricamentoDummy(getApplicationContext(), "tick4", 3));

        player1.setOnClickListener(v -> {
            Intent intent = new Intent(Intent.ACTION_PICK, MediaStore.Images.Media.INTERNAL_CONTENT_URI);
            startActivityForResult(intent, 1);
        });
        player2.setOnClickListener(v -> {
            Intent intent = new Intent(Intent.ACTION_PICK, MediaStore.Images.Media.INTERNAL_CONTENT_URI);
            startActivityForResult(intent, 2);
        });
        player3.setOnClickListener(v -> {
            Intent intent = new Intent(Intent.ACTION_PICK, MediaStore.Images.Media.INTERNAL_CONTENT_URI);
            startActivityForResult(intent, 3);
        });
        player4.setOnClickListener(v -> {
            Intent intent = new Intent(Intent.ACTION_PICK, MediaStore.Images.Media.INTERNAL_CONTENT_URI);
            startActivityForResult(intent, 4);
        });

        RANDOM.setOnClickListener(v -> {
            myVib.vibrate(20);
            rand_check = 1;

            Random rand = new Random();
            int randAvatar1 = rand.nextInt(96);
            int randAvatar2 = rand.nextInt(96);
            while (randAvatar2 == randAvatar1) randAvatar2 = rand.nextInt(96);
            int randAvatar3 = rand.nextInt(96);
            while (randAvatar3 == randAvatar2 || randAvatar3 == randAvatar1)
                randAvatar3 = rand.nextInt(96);
            int randAvatar4 = rand.nextInt(96);
            while (randAvatar4 == randAvatar3 || randAvatar4 == randAvatar2 || randAvatar4 == randAvatar1)
                randAvatar4 = rand.nextInt(96);

            Shortcuts.SalvataggioDummy(getApplicationContext(), rand_check, "rand_check");
            Shortcuts.SalvataggioDummy(getApplicationContext(), randAvatar1, "randAvatar1");
            Shortcuts.SalvataggioDummy(getApplicationContext(), randAvatar2, "randAvatar2");
            Shortcuts.SalvataggioDummy(getApplicationContext(), randAvatar3, "randAvatar3");
            Shortcuts.SalvataggioDummy(getApplicationContext(), randAvatar4, "randAvatar4");

            tick_player1.setVisibility(View.VISIBLE);
            Shortcuts.SalvataggioDummy(getApplicationContext(), View.VISIBLE, "tick1");
            tick_player2.setVisibility(View.VISIBLE);
            Shortcuts.SalvataggioDummy(getApplicationContext(), View.VISIBLE, "tick2");
            tick_player3.setVisibility(View.VISIBLE);
            Shortcuts.SalvataggioDummy(getApplicationContext(), View.VISIBLE, "tick3");
            tick_player4.setVisibility(View.VISIBLE);
            Shortcuts.SalvataggioDummy(getApplicationContext(), View.VISIBLE, "tick4");

            Shortcuts.MessaggioSchermoTempo(Commanders.this, "Random avatars set",500);

        });
    }

    @SuppressLint("ClickableViewAccessibility")
    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (resultCode == RESULT_OK && data != null) {
            if (requestCode == 1) {
                tick_player1.setVisibility(View.VISIBLE);
                Shortcuts.SalvataggioDummy(getApplicationContext(), View.VISIBLE, "tick1");
                Uri immagine_scelta = data.getData();
                String percorso1;
                try {
                    percorso1 = getBase64String(immagine_scelta);
                } catch (IOException e) {
                    throw new RuntimeException(e);
                }
                Shortcuts.SalvataggioDummy(getApplicationContext(), percorso1, "percorso1");
            }
            if (requestCode == 2) {
                tick_player2.setVisibility(View.VISIBLE);
                Shortcuts.SalvataggioDummy(getApplicationContext(), View.VISIBLE, "tick2");
                Uri immagine_scelta = data.getData();
                String percorso2;
                try {
                    percorso2 = getBase64String(immagine_scelta);
                } catch (IOException e) {
                    throw new RuntimeException(e);
                }
                Shortcuts.SalvataggioDummy(getApplicationContext(), percorso2, "percorso2");
            }
            if (requestCode == 3) {
                tick_player3.setVisibility(View.VISIBLE);
                Shortcuts.SalvataggioDummy(getApplicationContext(), View.VISIBLE, "tick3");
                Uri immagine_scelta = data.getData();
                String percorso3;
                try {
                    percorso3 = getBase64String(immagine_scelta);
                } catch (IOException e) {
                    throw new RuntimeException(e);
                }
                Shortcuts.SalvataggioDummy(getApplicationContext(), percorso3, "percorso3");
            }
            if (requestCode == 4) {
                tick_player4.setVisibility(View.VISIBLE);
                Shortcuts.SalvataggioDummy(getApplicationContext(), View.VISIBLE, "tick4");
                Uri immagine_scelta = data.getData();
                String percorso4;
                try {
                    percorso4 = getBase64String(immagine_scelta);
                } catch (IOException e) {
                    throw new RuntimeException(e);
                }
                Shortcuts.SalvataggioDummy(getApplicationContext(), percorso4, "percorso4");
            }
        }

    }

    public void onBackPressed() {
        super.onBackPressed();
        overridePendingTransition(R.anim.animation_left_to_right_enter, R.anim.animation_left_to_right_exit);
        finish();
    }

    private String getBase64String(Uri uri) throws IOException {

        Bitmap bitmap = MediaStore.Images.Media.getBitmap(this.getContentResolver(), uri);
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        // In case you want to compress your image, modify quality
        bitmap.compress(Bitmap.CompressFormat.JPEG, 60, byteArrayOutputStream);
        byte[] byteArray = byteArrayOutputStream.toByteArray();

        return Base64.encodeToString(byteArray, Base64.DEFAULT);
    }

}