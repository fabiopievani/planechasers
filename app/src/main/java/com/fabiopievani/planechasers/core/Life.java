package com.fabiopievani.planechasers.core;


import androidx.activity.OnBackPressedCallback;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import androidx.constraintlayout.widget.ConstraintLayout;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.content.SharedPreferences;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.Bundle;
import android.os.Handler;
import android.os.VibrationEffect;
import android.os.Vibrator;
import android.util.Base64;
import android.view.MotionEvent;
import android.view.View;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import com.fabiopievani.planechasers.utility.OnSwipeTouchListener;
import com.fabiopievani.planechasers.utility.Shortcuts;
import com.fabiopievani.planechasers.R;
import java.io.ByteArrayInputStream;
import java.io.InputStream;
import java.util.Arrays;
import java.util.List;
import java.util.Locale;
import java.util.Objects;


public class Life extends AppCompatActivity {

    private Vibrator myVib;

    private int counter1;
    private int counter2;
    private int counter3;
    private int counter4;

    private int com_counter1;
    private int com_counter2;
    private int com_counter3;
    private int com_counter4;

    private int pos_counter1;
    private int pos_counter2;
    private int pos_counter3;
    private int pos_counter4;

    public Button piu1_1;
    public Button piu1_2;
    public Button piu1_3;
    public Button piu1_4;
    public Button meno1_1;
    public Button meno1_2;
    public Button meno1_3;
    public Button meno1_4;

    public Button reset;
    public Button toPlanes;

    public Button commander_1press;
    public Button commander_2press;
    public Button commander_3press;
    public Button commander_4press;
    public Button poison_1press;
    public Button poison_2press;
    public Button poison_3press;
    public Button poison_4press;

    public ImageView player_1;
    public ImageView player_2;
    public ImageView player_3;
    public ImageView player_4;

    public ImageView forSwipe;

    List<Integer> myAvatarList = Arrays.asList(R.drawable.commander_avatar0,R.drawable.commander_avatar1,R.drawable.commander_avatar2,R.drawable.commander_avatar3,R.drawable.commander_avatar4,R.drawable.commander_avatar5,R.drawable.commander_avatar6,R.drawable.commander_avatar7,R.drawable.commander_avatar8,R.drawable.commander_avatar9,R.drawable.commander_avatar10,R.drawable.commander_avatar11,R.drawable.commander_avatar12,R.drawable.commander_avatar13,R.drawable.commander_avatar14,R.drawable.commander_avatar15,R.drawable.commander_avatar16,R.drawable.commander_avatar17,R.drawable.commander_avatar18,R.drawable.commander_avatar19,R.drawable.commander_avatar20,R.drawable.commander_avatar21,R.drawable.commander_avatar22,R.drawable.commander_avatar23,R.drawable.commander_avatar24,R.drawable.commander_avatar25,R.drawable.commander_avatar26,R.drawable.commander_avatar27,R.drawable.commander_avatar28,R.drawable.commander_avatar29,R.drawable.commander_avatar30,R.drawable.commander_avatar31,R.drawable.commander_avatar32,R.drawable.commander_avatar33,R.drawable.commander_avatar34,R.drawable.commander_avatar35,R.drawable.commander_avatar36,R.drawable.commander_avatar37,R.drawable.commander_avatar38,R.drawable.commander_avatar39,R.drawable.commander_avatar40,R.drawable.commander_avatar41,R.drawable.commander_avatar42,R.drawable.commander_avatar43,R.drawable.commander_avatar44,R.drawable.commander_avatar45,R.drawable.commander_avatar46,R.drawable.commander_avatar47,R.drawable.commander_avatar48,R.drawable.commander_avatar49,R.drawable.commander_avatar50);

    @SuppressLint({"ClickableViewAccessibility"})
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.life_classic);

        this.getWindow().getDecorView().setSystemUiVisibility(
                View.SYSTEM_UI_FLAG_LAYOUT_STABLE
                        | View.SYSTEM_UI_FLAG_LAYOUT_HIDE_NAVIGATION
                        | View.SYSTEM_UI_FLAG_LAYOUT_FULLSCREEN
                        | View.SYSTEM_UI_FLAG_HIDE_NAVIGATION
                        | View.SYSTEM_UI_FLAG_FULLSCREEN
                        | View.SYSTEM_UI_FLAG_IMMERSIVE_STICKY);

        //Impedisce blocco schermo
        getWindow().addFlags(WindowManager.LayoutParams.FLAG_KEEP_SCREEN_ON);

        TextView segna_vita1 = findViewById(R.id.life_counter1);
        TextView segna_vita2 = findViewById(R.id.life_counter2);
        TextView segna_vita3 = findViewById(R.id.life_counter3);
        TextView segna_vita4 = findViewById(R.id.life_counter4);

        TextView commander1 = findViewById(R.id.commander_dmg1);
        TextView poison1 = findViewById(R.id.poison_dmg1);
        TextView commander2 = findViewById(R.id.commander_dmg2);
        TextView poison2 = findViewById(R.id.poison_dmg2);
        TextView commander3 = findViewById(R.id.commander_dmg3);
        TextView poison3 = findViewById(R.id.poison_dmg3);
        TextView commander4 = findViewById(R.id.commander_dmg4);
        TextView poison4 = findViewById(R.id.poison_dmg4);

        piu1_1 = findViewById(R.id.plus_player1);
        piu1_2 = findViewById(R.id.plus_player2);
        piu1_3 = findViewById(R.id.plus_player3);
        piu1_4 = findViewById(R.id.plus_player4);
        meno1_1 = findViewById(R.id.minus_player1);
        meno1_2 = findViewById(R.id.minus_player2);
        meno1_3 = findViewById(R.id.minus_player3);
        meno1_4 = findViewById(R.id.minus_player4);

        reset = findViewById(R.id.reset);
        toPlanes = findViewById(R.id.planes_from_life);

        commander_1press = findViewById(R.id.commander_dmg1_button);
        commander_2press = findViewById(R.id.commander_dmg2_button);
        commander_3press = findViewById(R.id.commander_dmg3_button);
        commander_4press = findViewById(R.id.commander_dmg4_button);
        poison_1press = findViewById(R.id.poison_dmg1_button);
        poison_2press = findViewById(R.id.poison_dmg2_button);
        poison_3press = findViewById(R.id.poison_dmg3_button);
        poison_4press = findViewById(R.id.poison_dmg4_button);

        myVib = (Vibrator) this.getSystemService(VIBRATOR_SERVICE);

        player_1 = findViewById(R.id.bg_player1);
        player_2 = findViewById(R.id.bg_player2);
        player_3 = findViewById(R.id.bg_player3);
        player_4 = findViewById(R.id.bg_player4);

        forSwipe = findViewById(R.id.swipe_life);

        String percorso1 = (String) Shortcuts.CaricamentoDummy(getApplicationContext(), "percorso1", 1);
        String percorso2 = (String) Shortcuts.CaricamentoDummy(getApplicationContext(), "percorso2", 1);
        String percorso3 = (String) Shortcuts.CaricamentoDummy(getApplicationContext(), "percorso3", 1);
        String percorso4 = (String) Shortcuts.CaricamentoDummy(getApplicationContext(), "percorso4", 1);


        //Con random selezionato
        int random_check = Shortcuts.CaricamentoDummyVita(getApplicationContext(), "rand_check");
        if (random_check == 1) {
            ConstraintLayout root = findViewById(R.id.rootLayoutClassic);
            root.setBackgroundResource(R.drawable.background_life_with_images);
            int rndAvatar1 = Shortcuts.CaricamentoDummyVita(getApplicationContext(), "randAvatar1");
            int rndAvatar2 = Shortcuts.CaricamentoDummyVita(getApplicationContext(), "randAvatar2");
            int rndAvatar3 = Shortcuts.CaricamentoDummyVita(getApplicationContext(), "randAvatar3");
            int rndAvatar4 = Shortcuts.CaricamentoDummyVita(getApplicationContext(), "randAvatar4");
            player_1.setImageResource(myAvatarList.get(rndAvatar1));
            player_2.setImageResource(myAvatarList.get(rndAvatar2));
            player_3.setImageResource(myAvatarList.get(rndAvatar3));
            player_4.setImageResource(myAvatarList.get(rndAvatar4));
        }

        //Se ho selezionato manualmente degli avatar (VIENE ESEGUITA DOPO QUINDI HA PRIORITA')
        if (!Objects.equals(percorso1, "")) {
            ConstraintLayout root = findViewById(R.id.rootLayoutClassic);
            root.setBackgroundResource(R.drawable.background_life_with_images);
            decodeBase64AndSetImage(percorso1, player_1);
        }
        if (!Objects.equals(percorso2, "")) {
            ConstraintLayout root = findViewById(R.id.rootLayoutClassic);
            root.setBackgroundResource(R.drawable.background_life_with_images);
            decodeBase64AndSetImage(percorso2, player_2);
        }
        if (!Objects.equals(percorso3, "")) {
            ConstraintLayout root = findViewById(R.id.rootLayoutClassic);
            root.setBackgroundResource(R.drawable.background_life_with_images);
            decodeBase64AndSetImage(percorso3, player_3);
        }
        if (!Objects.equals(percorso4, "")) {
            ConstraintLayout root = findViewById(R.id.rootLayoutClassic);
            root.setBackgroundResource(R.drawable.background_life_with_images);
            decodeBase64AndSetImage(percorso4, player_4);
        }


        counter1 = Shortcuts.CaricamentoDummyVita(getApplicationContext(), "vita1");
        counter2 = Shortcuts.CaricamentoDummyVita(getApplicationContext(), "vita2");
        counter3 = Shortcuts.CaricamentoDummyVita(getApplicationContext(), "vita3");
        counter4 = Shortcuts.CaricamentoDummyVita(getApplicationContext(), "vita4");
        segna_vita1.setText(String.format(Locale.getDefault(), "%d", counter1));
        segna_vita2.setText(String.format(Locale.getDefault(), "%d", counter2));
        segna_vita3.setText(String.format(Locale.getDefault(), "%d", counter3));
        segna_vita4.setText(String.format(Locale.getDefault(), "%d", counter4));

        com_counter1 = (int) Shortcuts.CaricamentoDummy(getApplicationContext(), "com1", 0);
        com_counter2 = (int) Shortcuts.CaricamentoDummy(getApplicationContext(), "com2", 0);
        com_counter3 = (int) Shortcuts.CaricamentoDummy(getApplicationContext(), "com3", 0);
        com_counter4 = (int) Shortcuts.CaricamentoDummy(getApplicationContext(), "com4", 0);
        pos_counter1 = (int) Shortcuts.CaricamentoDummy(getApplicationContext(), "pos1", 0);
        pos_counter2 = (int) Shortcuts.CaricamentoDummy(getApplicationContext(), "pos2", 0);
        pos_counter3 = (int) Shortcuts.CaricamentoDummy(getApplicationContext(), "pos3", 0);
        pos_counter4 = (int) Shortcuts.CaricamentoDummy(getApplicationContext(), "pos4", 0);
        commander1.setText(String.format(Locale.getDefault(), "%d", com_counter1));
        commander2.setText(String.format(Locale.getDefault(), "%d", com_counter2));
        commander3.setText(String.format(Locale.getDefault(), "%d", com_counter3));
        commander4.setText(String.format(Locale.getDefault(), "%d", com_counter4));
        poison1.setText(String.format(Locale.getDefault(), "%d", pos_counter1));
        poison2.setText(String.format(Locale.getDefault(), "%d", pos_counter2));
        poison3.setText(String.format(Locale.getDefault(), "%d", pos_counter3));
        poison4.setText(String.format(Locale.getDefault(), "%d", pos_counter4));

        reset.setOnClickListener(v -> {
            AlertDialog.Builder builder1 = new AlertDialog.Builder(Life.this);

            myVib.vibrate(VibrationEffect.createOneShot(100, VibrationEffect.DEFAULT_AMPLITUDE));
            builder1.setMessage("Reset life and counters?")

                    .setCancelable(false)
                    .setPositiveButton("Yes", (dialogInterface, i) -> {

                        counter1 = 40;
                        counter2 = 40;
                        counter3 = 40;
                        counter4 = 40;
                        com_counter1 = 0;
                        pos_counter1 = 0;
                        com_counter2 = 0;
                        pos_counter2 = 0;
                        com_counter3 = 0;
                        pos_counter3 = 0;
                        com_counter4 = 0;
                        pos_counter4 = 0;

                        segna_vita1.setText(String.format(Locale.getDefault(), "%d", counter1));
                        segna_vita2.setText(String.format(Locale.getDefault(), "%d", counter2));
                        segna_vita3.setText(String.format(Locale.getDefault(), "%d", counter3));
                        segna_vita4.setText(String.format(Locale.getDefault(), "%d", counter4));
                        commander1.setText(String.format(Locale.getDefault(), "%d", com_counter1));
                        commander2.setText(String.format(Locale.getDefault(), "%d", com_counter2));
                        commander3.setText(String.format(Locale.getDefault(), "%d", com_counter3));
                        commander4.setText(String.format(Locale.getDefault(), "%d", com_counter4));
                        poison1.setText(String.format(Locale.getDefault(), "%d", pos_counter1));
                        poison2.setText(String.format(Locale.getDefault(), "%d", pos_counter2));
                        poison3.setText(String.format(Locale.getDefault(), "%d", pos_counter3));
                        poison4.setText(String.format(Locale.getDefault(), "%d", pos_counter4));

                        Shortcuts.SalvataggioDummy(getApplicationContext(), counter1, "vita1");
                        Shortcuts.SalvataggioDummy(getApplicationContext(), counter2, "vita2");
                        Shortcuts.SalvataggioDummy(getApplicationContext(), counter3, "vita3");
                        Shortcuts.SalvataggioDummy(getApplicationContext(), counter4, "vita4");

                        Shortcuts.SalvataggioDummy(getApplicationContext(), com_counter1, "com1");
                        Shortcuts.SalvataggioDummy(getApplicationContext(), com_counter2, "com2");
                        Shortcuts.SalvataggioDummy(getApplicationContext(), com_counter3, "com3");
                        Shortcuts.SalvataggioDummy(getApplicationContext(), com_counter4, "com4");
                        Shortcuts.SalvataggioDummy(getApplicationContext(), pos_counter1, "pos1");
                        Shortcuts.SalvataggioDummy(getApplicationContext(), pos_counter2, "pos2");
                        Shortcuts.SalvataggioDummy(getApplicationContext(), pos_counter3, "pos3");
                        Shortcuts.SalvataggioDummy(getApplicationContext(), pos_counter4, "pos4");
                    })

                    .setNegativeButton("No", (dialogInterface, i) -> dialogInterface.cancel());

            AlertDialog alert = builder1.create();
            alert.setTitle("Warning");
            alert.show();
        });

        commander_1press.setOnClickListener(v -> {
            myVib.vibrate(VibrationEffect.createOneShot(5, VibrationEffect.DEFAULT_AMPLITUDE));
            if (com_counter1 != 21) {
                com_counter1++;
            }
            commander1.setText(String.format(Locale.getDefault(), "%d", com_counter1));
            Shortcuts.SalvataggioDummy(getApplicationContext(), com_counter1, "com1");
        });

        //Pressione prolungata per resettare i counter
        commander_1press.setOnLongClickListener(v -> {
            myVib.vibrate(VibrationEffect.createOneShot(20, VibrationEffect.DEFAULT_AMPLITUDE));
            com_counter1 = 0;
            commander1.setText(String.format(Locale.getDefault(), "%d", com_counter1));
            Shortcuts.SalvataggioDummy(getApplicationContext(), com_counter1, "com1");
            return true;
        });

        poison_1press.setOnClickListener(v -> {
            myVib.vibrate(VibrationEffect.createOneShot(5, VibrationEffect.DEFAULT_AMPLITUDE));
            if (pos_counter1 != 10) {
                pos_counter1++;
            }
            poison1.setText(String.format(Locale.getDefault(), "%d", pos_counter1));
            Shortcuts.SalvataggioDummy(getApplicationContext(), pos_counter1, "pos1");
        });

        //Pressione prolungata per resettare i counter
        poison_1press.setOnLongClickListener(v -> {
            myVib.vibrate(VibrationEffect.createOneShot(20, VibrationEffect.DEFAULT_AMPLITUDE));
            pos_counter1 = 0;
            poison1.setText(String.format(Locale.getDefault(), "%d", pos_counter1));
            Shortcuts.SalvataggioDummy(getApplicationContext(), pos_counter1, "pos1");
            return true;
        });

        commander_2press.setOnClickListener(v -> {
            myVib.vibrate(VibrationEffect.createOneShot(5, VibrationEffect.DEFAULT_AMPLITUDE));
            if (com_counter2 != 21) {
                com_counter2++;
            }
            commander2.setText(String.format(Locale.getDefault(), "%d", com_counter2));
            Shortcuts.SalvataggioDummy(getApplicationContext(), com_counter2, "com2");
        });

        commander_2press.setOnLongClickListener(v -> {
            myVib.vibrate(VibrationEffect.createOneShot(20, VibrationEffect.DEFAULT_AMPLITUDE));
            com_counter2 = 0;
            commander2.setText(String.format(Locale.getDefault(), "%d", com_counter2));
            Shortcuts.SalvataggioDummy(getApplicationContext(), com_counter2, "com2");
            return true;
        });

        poison_2press.setOnClickListener(v -> {
            myVib.vibrate(VibrationEffect.createOneShot(5, VibrationEffect.DEFAULT_AMPLITUDE));
            if (pos_counter2 != 10) {
                pos_counter2++;
            }
            poison2.setText(String.format(Locale.getDefault(), "%d", pos_counter2));
            Shortcuts.SalvataggioDummy(getApplicationContext(), pos_counter2, "pos2");
        });

        poison_2press.setOnLongClickListener(v -> {
            myVib.vibrate(VibrationEffect.createOneShot(20, VibrationEffect.DEFAULT_AMPLITUDE));
            pos_counter2 = 0;
            poison2.setText(String.format(Locale.getDefault(), "%d", pos_counter2));
            Shortcuts.SalvataggioDummy(getApplicationContext(), pos_counter2, "pos2");
            return true;
        });

        commander_3press.setOnClickListener(v -> {
            myVib.vibrate(VibrationEffect.createOneShot(5, VibrationEffect.DEFAULT_AMPLITUDE));
            if (com_counter3 != 21) {
                com_counter3++;
            }
            commander3.setText(String.format(Locale.getDefault(), "%d", com_counter3));
            Shortcuts.SalvataggioDummy(getApplicationContext(), com_counter3, "com3");
        });

        commander_3press.setOnLongClickListener(v -> {
            myVib.vibrate(VibrationEffect.createOneShot(20, VibrationEffect.DEFAULT_AMPLITUDE));
            com_counter3 = 0;
            commander3.setText(String.format(Locale.getDefault(), "%d", com_counter3));
            Shortcuts.SalvataggioDummy(getApplicationContext(), com_counter3, "com3");
            return true;
        });

        poison_3press.setOnClickListener(v -> {
            myVib.vibrate(VibrationEffect.createOneShot(5, VibrationEffect.DEFAULT_AMPLITUDE));
            if (pos_counter3 != 10) {
                pos_counter3++;
            }
            poison3.setText(String.format(Locale.getDefault(), "%d", pos_counter3));
            Shortcuts.SalvataggioDummy(getApplicationContext(), pos_counter3, "pos3");
        });

        poison_3press.setOnLongClickListener(v -> {
            myVib.vibrate(VibrationEffect.createOneShot(20, VibrationEffect.DEFAULT_AMPLITUDE));
            pos_counter3 = 0;
            poison3.setText(String.format(Locale.getDefault(), "%d", pos_counter3));
            Shortcuts.SalvataggioDummy(getApplicationContext(), pos_counter3, "pos3");
            return true;
        });

        commander_4press.setOnClickListener(v -> {
            myVib.vibrate(VibrationEffect.createOneShot(5, VibrationEffect.DEFAULT_AMPLITUDE));
            if (com_counter4 != 21) {
                com_counter4++;
            }
            commander4.setText(String.format(Locale.getDefault(), "%d", com_counter4));
            Shortcuts.SalvataggioDummy(getApplicationContext(), com_counter4, "com4");
        });

        commander_4press.setOnLongClickListener(v -> {
            myVib.vibrate(VibrationEffect.createOneShot(20, VibrationEffect.DEFAULT_AMPLITUDE));
            com_counter4 = 0;
            commander4.setText(String.format(Locale.getDefault(), "%d", com_counter4));
            Shortcuts.SalvataggioDummy(getApplicationContext(), com_counter4, "com4");
            return true;
        });

        poison_4press.setOnClickListener(v -> {
            myVib.vibrate(VibrationEffect.createOneShot(5, VibrationEffect.DEFAULT_AMPLITUDE));
            if (pos_counter4 != 10) {
                pos_counter4++;
            }
            poison4.setText(String.format(Locale.getDefault(), "%d", pos_counter4));
            Shortcuts.SalvataggioDummy(getApplicationContext(), pos_counter4, "pos4");
        });

        poison_4press.setOnLongClickListener(v -> {
            myVib.vibrate(VibrationEffect.createOneShot(20, VibrationEffect.DEFAULT_AMPLITUDE));
            pos_counter4 = 0;
            poison4.setText(String.format(Locale.getDefault(), "%d", pos_counter4));
            Shortcuts.SalvataggioDummy(getApplicationContext(), pos_counter4, "pos4");
            return true;
        });

        piu1_1.setOnTouchListener(new View.OnTouchListener() {
            private Handler mHandler;

            @Override
            public boolean onTouch(View v, MotionEvent event) {
                switch (event.getAction()) {
                    case MotionEvent.ACTION_DOWN:

                        if (mHandler != null) return true;
                        mHandler = new Handler();
                        mHandler.postDelayed(mAction, 500);

                        if (counter1 != 999) {
                            counter1++;
                        }

                        myVib.vibrate(VibrationEffect.createOneShot(5, VibrationEffect.DEFAULT_AMPLITUDE));
                        segna_vita1.setText(String.format(Locale.getDefault(), "%d", counter1));
                        Shortcuts.SalvataggioDummy(getApplicationContext(), counter1, "vita1");

                        break;
                    case MotionEvent.ACTION_UP:
                        if (mHandler == null) return true;
                        mHandler.removeCallbacks(mAction);
                        mHandler = null;
                        break;
                }
                return false;
            }
            //Pressione prolungata per aumentare più velocemente
            final Runnable mAction = new Runnable() {
                @Override
                public void run() {

                    if (counter1 != 999) {
                        counter1++;
                    }
                    myVib.vibrate(VibrationEffect.createOneShot(10, VibrationEffect.DEFAULT_AMPLITUDE));
                    segna_vita1.setText(String.format(Locale.getDefault(), "%d", counter1));
                    Shortcuts.SalvataggioDummy(getApplicationContext(), counter1, "vita1");
                    mHandler.postDelayed(this, 80);


                }

            };

        });


        meno1_1.setOnTouchListener(new View.OnTouchListener() {
            private Handler mHandler;

            @Override
            public boolean onTouch(View v, MotionEvent event) {
                switch (event.getAction()) {
                    case MotionEvent.ACTION_DOWN:

                        if (mHandler != null) return true;
                        mHandler = new Handler();
                        mHandler.postDelayed(mAction, 500);

                        if (counter1 != 0) {
                            counter1--;
                        }

                        myVib.vibrate(VibrationEffect.createOneShot(5, VibrationEffect.DEFAULT_AMPLITUDE));
                        segna_vita1.setText(String.format(Locale.getDefault(), "%d", counter1));
                        Shortcuts.SalvataggioDummy(getApplicationContext(), counter1, "vita1");

                        break;
                    case MotionEvent.ACTION_UP:
                        if (mHandler == null) return true;
                        mHandler.removeCallbacks(mAction);
                        mHandler = null;
                        break;
                }
                return false;
            }

            final Runnable mAction = new Runnable() {
                @Override
                public void run() {

                    if (counter1 != 0) {
                        counter1--;
                    }

                    myVib.vibrate(VibrationEffect.createOneShot(10, VibrationEffect.DEFAULT_AMPLITUDE));
                    segna_vita1.setText(String.format(Locale.getDefault(), "%d", counter1));
                    Shortcuts.SalvataggioDummy(getApplicationContext(), counter1, "vita1");
                    mHandler.postDelayed(this, 80);
                }
            };
        });


        piu1_2.setOnTouchListener(new View.OnTouchListener() {
            private Handler mHandler;

            @Override
            public boolean onTouch(View v, MotionEvent event) {
                switch (event.getAction()) {
                    case MotionEvent.ACTION_DOWN:

                        if (mHandler != null) return true;
                        mHandler = new Handler();
                        mHandler.postDelayed(mAction, 500);

                        if (counter2 != 999) {
                            counter2++;
                        }

                        myVib.vibrate(VibrationEffect.createOneShot(5, VibrationEffect.DEFAULT_AMPLITUDE));
                        segna_vita2.setText(String.format(Locale.getDefault(), "%d", counter2));
                        Shortcuts.SalvataggioDummy(getApplicationContext(), counter2, "vita2");

                        break;
                    case MotionEvent.ACTION_UP:
                        if (mHandler == null) return true;
                        mHandler.removeCallbacks(mAction);
                        mHandler = null;
                        break;
                }
                return false;
            }

            final Runnable mAction = new Runnable() {
                @Override
                public void run() {

                    if (counter2 != 999) {
                        counter2++;
                    }
                    myVib.vibrate(VibrationEffect.createOneShot(10, VibrationEffect.DEFAULT_AMPLITUDE));
                    segna_vita2.setText(String.format(Locale.getDefault(), "%d", counter2));
                    Shortcuts.SalvataggioDummy(getApplicationContext(), counter2, "vita2");
                    mHandler.postDelayed(this, 80);
                }
            };
        });

        meno1_2.setOnTouchListener(new View.OnTouchListener() {
            private Handler mHandler;

            @Override
            public boolean onTouch(View v, MotionEvent event) {
                switch (event.getAction()) {
                    case MotionEvent.ACTION_DOWN:

                        if (mHandler != null) return true;
                        mHandler = new Handler();
                        mHandler.postDelayed(mAction, 500);

                        if (counter2 != 0) {
                            counter2--;
                        }

                        myVib.vibrate(VibrationEffect.createOneShot(5, VibrationEffect.DEFAULT_AMPLITUDE));
                        segna_vita2.setText(String.format(Locale.getDefault(), "%d", counter2));
                        Shortcuts.SalvataggioDummy(getApplicationContext(), counter2, "vita2");

                        break;
                    case MotionEvent.ACTION_UP:
                        if (mHandler == null) return true;
                        mHandler.removeCallbacks(mAction);
                        mHandler = null;
                        break;
                }
                return false;
            }

            final Runnable mAction = new Runnable() {
                @Override
                public void run() {

                    if (counter2 != 0) {
                        counter2--;
                    }

                    myVib.vibrate(VibrationEffect.createOneShot(10, VibrationEffect.DEFAULT_AMPLITUDE));
                    segna_vita2.setText(String.format(Locale.getDefault(), "%d", counter2));
                    Shortcuts.SalvataggioDummy(getApplicationContext(), counter2, "vita2");
                    mHandler.postDelayed(this, 80);
                }
            };
        });


        piu1_3.setOnTouchListener(new View.OnTouchListener() {
            private Handler mHandler;

            @Override
            public boolean onTouch(View v, MotionEvent event) {
                switch (event.getAction()) {
                    case MotionEvent.ACTION_DOWN:

                        if (mHandler != null) return true;
                        mHandler = new Handler();
                        mHandler.postDelayed(mAction, 500);

                        if (counter3 != 999) {
                            counter3++;
                        }

                        myVib.vibrate(VibrationEffect.createOneShot(5, VibrationEffect.DEFAULT_AMPLITUDE));
                        segna_vita3.setText(String.format(Locale.getDefault(), "%d", counter3));
                        Shortcuts.SalvataggioDummy(getApplicationContext(), counter3, "vita3");

                        break;
                    case MotionEvent.ACTION_UP:
                        if (mHandler == null) return true;
                        mHandler.removeCallbacks(mAction);
                        mHandler = null;
                        break;
                }
                return false;
            }

            final Runnable mAction = new Runnable() {
                @Override
                public void run() {

                    if (counter3 != 999) {
                        counter3++;
                    }

                    myVib.vibrate(VibrationEffect.createOneShot(10, VibrationEffect.DEFAULT_AMPLITUDE));
                    segna_vita3.setText(String.format(Locale.getDefault(), "%d", counter3));
                    Shortcuts.SalvataggioDummy(getApplicationContext(), counter3, "vita3");
                    mHandler.postDelayed(this, 80);
                }
            };
        });

        meno1_3.setOnTouchListener(new View.OnTouchListener() {
            private Handler mHandler;

            @Override
            public boolean onTouch(View v, MotionEvent event) {
                switch (event.getAction()) {
                    case MotionEvent.ACTION_DOWN:

                        if (mHandler != null) return true;
                        mHandler = new Handler();
                        mHandler.postDelayed(mAction, 500);

                        if (counter3 != 0) {
                            counter3--;
                        }

                        myVib.vibrate(VibrationEffect.createOneShot(5, VibrationEffect.DEFAULT_AMPLITUDE));
                        segna_vita3.setText(String.format(Locale.getDefault(), "%d", counter3));
                        Shortcuts.SalvataggioDummy(getApplicationContext(), counter3, "vita3");

                        break;
                    case MotionEvent.ACTION_UP:
                        if (mHandler == null) return true;
                        mHandler.removeCallbacks(mAction);
                        mHandler = null;
                        break;
                }
                return false;
            }

            final Runnable mAction = new Runnable() {
                @Override
                public void run() {

                    if (counter3 != 0) {
                        counter3--;
                    }

                    myVib.vibrate(VibrationEffect.createOneShot(10, VibrationEffect.DEFAULT_AMPLITUDE));
                    segna_vita3.setText(String.format(Locale.getDefault(), "%d", counter3));
                    Shortcuts.SalvataggioDummy(getApplicationContext(), counter3, "vita3");
                    mHandler.postDelayed(this, 80);
                }
            };
        });

        piu1_4.setOnTouchListener(new View.OnTouchListener() {
            private Handler mHandler;

            @Override
            public boolean onTouch(View v, MotionEvent event) {
                switch (event.getAction()) {
                    case MotionEvent.ACTION_DOWN:

                        if (mHandler != null) return true;
                        mHandler = new Handler();
                        mHandler.postDelayed(mAction, 500);

                        if (counter4 != 999) {
                            counter4++;
                        }

                        myVib.vibrate(VibrationEffect.createOneShot(5, VibrationEffect.DEFAULT_AMPLITUDE));
                        segna_vita4.setText(String.format(Locale.getDefault(), "%d", counter4));
                        Shortcuts.SalvataggioDummy(getApplicationContext(), counter4, "vita4");

                        break;
                    case MotionEvent.ACTION_UP:
                        if (mHandler == null) return true;
                        mHandler.removeCallbacks(mAction);
                        mHandler = null;
                        break;
                }
                return false;
            }

            final Runnable mAction = new Runnable() {
                @Override
                public void run() {

                    if (counter4 != 999) {
                        counter4++;
                    }

                    myVib.vibrate(VibrationEffect.createOneShot(10, VibrationEffect.DEFAULT_AMPLITUDE));
                    segna_vita4.setText(String.format(Locale.getDefault(), "%d", counter4));
                    Shortcuts.SalvataggioDummy(getApplicationContext(), counter4, "vita4");
                    mHandler.postDelayed(this, 80);
                }
            };
        });

        meno1_4.setOnTouchListener(new View.OnTouchListener() {
            private Handler mHandler;

            @Override
            public boolean onTouch(View v, MotionEvent event) {
                switch (event.getAction()) {
                    case MotionEvent.ACTION_DOWN:

                        if (mHandler != null) return true;
                        mHandler = new Handler();
                        mHandler.postDelayed(mAction, 500);

                        if (counter4 != 0) {
                            counter4--;
                        }

                        myVib.vibrate(VibrationEffect.createOneShot(5, VibrationEffect.DEFAULT_AMPLITUDE));
                        segna_vita4.setText(String.format(Locale.getDefault(), "%d", counter4));
                        Shortcuts.SalvataggioDummy(getApplicationContext(), counter4, "vita4");

                        break;
                    case MotionEvent.ACTION_UP:
                        if (mHandler == null) return true;
                        mHandler.removeCallbacks(mAction);
                        mHandler = null;
                        break;
                }
                return false;
            }

            final Runnable mAction = new Runnable() {
                @Override
                public void run() {

                    if (counter4 != 0) {
                        counter4--;
                    }

                    myVib.vibrate(VibrationEffect.createOneShot(10, VibrationEffect.DEFAULT_AMPLITUDE));
                    segna_vita4.setText(String.format(Locale.getDefault(), "%d", counter4));
                    Shortcuts.SalvataggioDummy(getApplicationContext(), counter4, "vita4");
                    mHandler.postDelayed(this, 80);
                }
            };
        });

        toPlanes.setOnClickListener(v -> {
            startActivity(new Intent(Life.this, Planes.class));
            overridePendingTransition(R.anim.animation_left_to_right_enter, R.anim.animation_left_to_right_exit);
            finish();
        });

        forSwipe.setOnTouchListener(new OnSwipeTouchListener(Life.this) {
            public void onSwipeRight() {
                    startActivity(new Intent(Life.this, Planes.class));
                    overridePendingTransition(R.anim.animation_left_to_right_enter, R.anim.animation_left_to_right_exit);
                    finish();
            }
        });

        getOnBackPressedDispatcher().addCallback(this, new OnBackPressedCallback(true) {
            @Override
            public void handleOnBackPressed() {
                AlertDialog.Builder builder1 = new AlertDialog.Builder(Life.this);

                myVib.vibrate(VibrationEffect.createOneShot(200, VibrationEffect.DEFAULT_AMPLITUDE));

                builder1.setMessage("Go back to main menu, you will lose all preferences?")
                        .setCancelable(false)
                        .setPositiveButton("Yes", (dialogInterface, i) -> {
                            startActivity(new Intent(Life.this, Menu.class));
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

    private void decodeBase64AndSetImage(String completeImageData, ImageView imageView) {

        String imageDataBytes = completeImageData.substring(completeImageData.indexOf(",") + 1);
        InputStream stream = new ByteArrayInputStream(Base64.decode(imageDataBytes.getBytes(), Base64.DEFAULT));
        Bitmap bitmap = BitmapFactory.decodeStream(stream);
        imageView.setImageBitmap(bitmap);
    }
}