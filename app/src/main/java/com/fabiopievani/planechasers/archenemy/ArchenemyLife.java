package com.fabiopievani.planechasers.archenemy;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import android.annotation.SuppressLint;
import android.content.Intent;
import android.content.SharedPreferences;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.Bundle;
import android.os.Handler;
import android.os.Vibrator;
import android.util.Base64;
import android.view.MotionEvent;
import android.view.View;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.fabiopievani.planechasers.core.Menu;
import com.fabiopievani.planechasers.utility.OnSwipeTouchListener;
import com.fabiopievani.planechasers.core.Planes;
import com.fabiopievani.planechasers.utility.Shortcuts;
import java.io.ByteArrayInputStream;
import java.io.InputStream;
import java.util.Arrays;
import java.util.List;
import java.util.Locale;
import java.util.Objects;
import com.fabiopievani.planechasers.R;

public class ArchenemyLife extends AppCompatActivity {

    private Vibrator myVib;
    private int archenemy_counter1;
    private int archenemy_counter3;

    private int archenemy_com_counter1;
    private int archenemy_com_counter3;

    private int archenemy_pos_counter1;
    private int archenemy_pos_counter3;

    public Button archenemy_piu1_1;
    public Button archenemy_piu1_3;
    public Button archenemy_meno1_1;
    public Button archenemy_meno1_3;


    public Button archenemy_reset;
    public Button archenemy_toPlanes;
    public Button archenemy_toSchemes;

    public Button archenemy_commander_1press;
    public Button archenemy_commander_3press;

    public Button archenemy_poison_1press;
    public Button archenemy_poison_3press;


    public ImageView player_1;
    public ImageView player_2;
    public ImageView player_3;
    public ImageView player_4;
    public ImageView forSwipe;

    List<Integer> myAvatarList = Arrays.asList(R.drawable.z_avatar0,R.drawable.z_avatar1,R.drawable.z_avatar2,R.drawable.z_avatar3,R.drawable.z_avatar4,R.drawable.z_avatar5,R.drawable.z_avatar6,R.drawable.z_avatar7,R.drawable.z_avatar8,R.drawable.z_avatar9,R.drawable.z_avatar10,R.drawable.z_avatar11,R.drawable.z_avatar12,R.drawable.z_avatar13,R.drawable.z_avatar14,R.drawable.z_avatar15,R.drawable.z_avatar16,R.drawable.z_avatar17,R.drawable.z_avatar18,R.drawable.z_avatar19,R.drawable.z_avatar20,R.drawable.z_avatar21,R.drawable.z_avatar22,R.drawable.z_avatar23,R.drawable.z_avatar24,R.drawable.z_avatar25,R.drawable.z_avatar26,R.drawable.z_avatar27,R.drawable.z_avatar28,R.drawable.z_avatar29,R.drawable.z_avatar30,R.drawable.z_avatar31,R.drawable.z_avatar32,R.drawable.z_avatar33,R.drawable.z_avatar34,R.drawable.z_avatar35,R.drawable.z_avatar36,R.drawable.z_avatar37,R.drawable.z_avatar38,R.drawable.z_avatar39,R.drawable.z_avatar40,R.drawable.z_avatar41,R.drawable.z_avatar42,R.drawable.z_avatar43,R.drawable.z_avatar44,R.drawable.z_avatar45,R.drawable.z_avatar46,R.drawable.z_avatar47,R.drawable.z_avatar48,R.drawable.z_avatar49,R.drawable.z_avatar50,R.drawable.z_avatar51,R.drawable.z_avatar52,R.drawable.z_avatar53,R.drawable.z_avatar54,R.drawable.z_avatar55,R.drawable.z_avatar56,R.drawable.z_avatar57,R.drawable.z_avatar58,R.drawable.z_avatar59,R.drawable.z_avatar60,R.drawable.z_avatar61,R.drawable.z_avatar62,R.drawable.z_avatar63,R.drawable.z_avatar64,R.drawable.z_avatar65,R.drawable.z_avatar66,R.drawable.z_avatar67,R.drawable.z_avatar68,R.drawable.z_avatar69,R.drawable.z_avatar70,R.drawable.z_avatar71,R.drawable.z_avatar72,R.drawable.z_avatar73,R.drawable.z_avatar74,R.drawable.z_avatar75,R.drawable.z_avatar76,R.drawable.z_avatar77,R.drawable.z_avatar78,R.drawable.z_avatar79,R.drawable.z_avatar80,R.drawable.z_avatar81,R.drawable.z_avatar82,R.drawable.z_avatar83,R.drawable.z_avatar84,R.drawable.z_avatar85,R.drawable.z_avatar86,R.drawable.z_avatar87,R.drawable.z_avatar88,R.drawable.z_avatar89,R.drawable.z_avatar90,R.drawable.z_avatar91,R.drawable.z_avatar92,R.drawable.z_avatar93,R.drawable.z_avatar94,R.drawable.z_avatar95);

    @SuppressLint({"ClickableViewAccessibility"})
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.life_archenemy);

        this.getWindow().getDecorView().setSystemUiVisibility(
                View.SYSTEM_UI_FLAG_LAYOUT_STABLE
                        | View.SYSTEM_UI_FLAG_LAYOUT_HIDE_NAVIGATION
                        | View.SYSTEM_UI_FLAG_LAYOUT_FULLSCREEN
                        | View.SYSTEM_UI_FLAG_HIDE_NAVIGATION
                        | View.SYSTEM_UI_FLAG_FULLSCREEN
                        | View.SYSTEM_UI_FLAG_IMMERSIVE_STICKY);

        //Impedisce blocco schermo
        getWindow().addFlags(WindowManager.LayoutParams.FLAG_KEEP_SCREEN_ON);


        TextView archenemy_segna_vita1 = findViewById(R.id.archenemy_segna_vita1);
        TextView archenemy_segna_vita3 = findViewById(R.id.archenemy_segna_vita3);

        TextView archenemy_commander1 = findViewById(R.id.archenemy_commander_1);
        TextView archenemy_poison1 = findViewById(R.id.archenemy_poison_1);

        TextView archenemy_commander3 = findViewById(R.id.archenemy_commander_3);
        TextView archenemy_poison3 = findViewById(R.id.archenemy_poison_3);


        archenemy_piu1_1 = findViewById(R.id.archenemy_piu1_1);
        archenemy_piu1_3 = findViewById(R.id.archenemy_piu1_3);

        archenemy_meno1_1 = findViewById(R.id.archenemy_meno1_1);
        archenemy_meno1_3 = findViewById(R.id.archenemy_meno1_3);


        archenemy_reset = findViewById(R.id.archenemy_reset);
        archenemy_toPlanes = findViewById(R.id.archenemy_planes_from_life);
        archenemy_toSchemes = findViewById(R.id.archenemy_schemes_from_life);

        archenemy_commander_1press = findViewById(R.id.archenemy_commander_1press);
        archenemy_commander_3press = findViewById(R.id.archenemy_commander_3press);

        archenemy_poison_1press = findViewById(R.id.archenemy_poison_1press);
        archenemy_poison_3press = findViewById(R.id.archenemy_poison_3press);


        myVib = (Vibrator) this.getSystemService(VIBRATOR_SERVICE);

        player_1 = findViewById(R.id.archenemy_bg_player1);
        player_2 = findViewById(R.id.archenemy_bg_player2);
        player_3 = findViewById(R.id.archenemy_bg_player3);
        player_4 = findViewById(R.id.archenemy_bg_player4);

        forSwipe= findViewById(R.id.swipe_archenemy);

        String percorso1 = (String) Shortcuts.CaricamentoDummy(getApplicationContext(),"percorso1",1);
        String percorso2 = (String) Shortcuts.CaricamentoDummy(getApplicationContext(),"percorso2",1);
        String percorso3 = (String) Shortcuts.CaricamentoDummy(getApplicationContext(),"percorso3",1);
        String percorso4 = (String) Shortcuts.CaricamentoDummy(getApplicationContext(),"percorso4",1);
        if(!Objects.equals(percorso1, "") || !Objects.equals(percorso2, "") || !Objects.equals(percorso3, "") || !Objects.equals(percorso4, "")){
            RelativeLayout relative = findViewById(R.id.background_life);
            relative.setBackgroundResource(R.drawable.background_life_with_images);
        }

        //Con random
        int random_check =  Shortcuts.CaricamentoDummyVita(getApplicationContext(),"rand_check");
        if(random_check==1){
            RelativeLayout relative = findViewById(R.id.background_life);
            relative.setBackgroundResource(R.drawable.background_life_with_images);
            int rndAvatar1 = Shortcuts.CaricamentoDummyVita(getApplicationContext(), "randAvatar1");
            int rndAvatar2 = Shortcuts.CaricamentoDummyVita(getApplicationContext(), "randAvatar2");
            int rndAvatar3 = Shortcuts.CaricamentoDummyVita(getApplicationContext(), "randAvatar3");
            int rndAvatar4 = Shortcuts.CaricamentoDummyVita(getApplicationContext(), "randAvatar4");
            player_1.setImageResource(myAvatarList.get(rndAvatar1));
            player_2.setImageResource(myAvatarList.get(rndAvatar2));
            player_3.setImageResource(myAvatarList.get(rndAvatar3));
            player_4.setImageResource(myAvatarList.get(rndAvatar4));
        }


        if(!Objects.equals(percorso1, "")) {
            decodeBase64AndSetImage(percorso1,player_1);
        }
        if (!Objects.equals(percorso2, "")) {
            decodeBase64AndSetImage(percorso2, player_2);
        }
        if(!Objects.equals(percorso3, "")) {
            decodeBase64AndSetImage(percorso3,player_3);
        }
        if (!Objects.equals(percorso4, "")) {
            decodeBase64AndSetImage(percorso4, player_4);
        }

        archenemy_counter1 = Shortcuts.CaricamentoDummyVitaArchenemy(getApplicationContext(), "archenemy_vita1");
        archenemy_counter3 = Shortcuts.CaricamentoDummyVitaArchenemy(getApplicationContext(), "archenemy_vita3");
        archenemy_segna_vita1.setText(String.format(Locale.getDefault(), "%d", archenemy_counter1));
        archenemy_segna_vita3.setText(String.format(Locale.getDefault(), "%d", archenemy_counter3));

        archenemy_com_counter1 = (int) Shortcuts.CaricamentoDummy(getApplicationContext(), "archenemy_com1", 0);
        archenemy_com_counter3 = (int) Shortcuts.CaricamentoDummy(getApplicationContext(), "archenemy_com3", 0);
        archenemy_pos_counter1 = (int) Shortcuts.CaricamentoDummy(getApplicationContext(), "archenemy_pos1", 0);
        archenemy_pos_counter3 = (int) Shortcuts.CaricamentoDummy(getApplicationContext(), "archenemy_pos3", 0);
        archenemy_commander1.setText(String.format(Locale.getDefault(), "%d", archenemy_com_counter1));
        archenemy_commander3.setText(String.format(Locale.getDefault(), "%d", archenemy_com_counter3));
        archenemy_poison1.setText(String.format(Locale.getDefault(), "%d", archenemy_pos_counter1));
        archenemy_poison3.setText(String.format(Locale.getDefault(), "%d", archenemy_pos_counter3));

        archenemy_reset.setOnClickListener(v -> {
            AlertDialog.Builder builder1 = new AlertDialog.Builder(ArchenemyLife.this);

            myVib.vibrate(100);
            builder1.setMessage("Reset life and counters?")

                    .setCancelable(false)
                    .setPositiveButton("Yes", (dialogInterface, i) -> {

                        archenemy_counter1 = 40;
                        archenemy_counter3 = 40;
                        archenemy_com_counter1 = 0;
                        archenemy_pos_counter1 = 0;
                        archenemy_com_counter3 = 0;
                        archenemy_pos_counter3 = 0;

                        archenemy_segna_vita1.setText(String.format(Locale.getDefault(), "%d", archenemy_counter1));
                        archenemy_segna_vita3.setText(String.format(Locale.getDefault(), "%d", archenemy_counter3));
                        archenemy_commander1.setText(String.format(Locale.getDefault(), "%d", archenemy_com_counter1));
                        archenemy_commander3.setText(String.format(Locale.getDefault(), "%d", archenemy_com_counter3));
                        archenemy_poison1.setText(String.format(Locale.getDefault(), "%d", archenemy_pos_counter1));
                        archenemy_poison3.setText(String.format(Locale.getDefault(), "%d", archenemy_pos_counter3));

                        Shortcuts.SalvataggioDummy(getApplicationContext(), archenemy_counter1, "archenemy_vita1");
                        Shortcuts.SalvataggioDummy(getApplicationContext(), archenemy_counter3, "archenemy_vita3");

                        Shortcuts.SalvataggioDummy(getApplicationContext(), archenemy_com_counter1, "archenemy_com1");
                        Shortcuts.SalvataggioDummy(getApplicationContext(), archenemy_com_counter3, "archenemy_com3");
                        Shortcuts.SalvataggioDummy(getApplicationContext(), archenemy_pos_counter1, "archenemy_pos1");
                        Shortcuts.SalvataggioDummy(getApplicationContext(), archenemy_pos_counter3, "archenemy_pos3");

                    })

                    .setNegativeButton("No", (dialogInterface, i) -> dialogInterface.cancel());

            AlertDialog alert = builder1.create();
            alert.setTitle("Warning");
            alert.show();
        });


        archenemy_commander_1press.setOnClickListener(v -> {
            myVib.vibrate(5);
            if(archenemy_com_counter1!=21){
                archenemy_com_counter1++;
            }
            archenemy_commander1.setText(String.format(Locale.getDefault(), "%d", archenemy_com_counter1));
            Shortcuts.SalvataggioDummy(getApplicationContext(), archenemy_com_counter1, "archenemy_com1");
        });

        archenemy_commander_1press.setOnLongClickListener(v -> {
            myVib.vibrate(20);
            archenemy_com_counter1 = 0;
            archenemy_commander1.setText(String.format(Locale.getDefault(), "%d", archenemy_com_counter1));
            Shortcuts.SalvataggioDummy(getApplicationContext(), archenemy_com_counter1, "archenemy_com1");
            return true;
        });

        archenemy_poison_1press.setOnClickListener(v -> {
            myVib.vibrate(5);
            if(archenemy_pos_counter1!=10){
                archenemy_pos_counter1++;
            }
            archenemy_poison1.setText(String.format(Locale.getDefault(), "%d", archenemy_pos_counter1));
            Shortcuts.SalvataggioDummy(getApplicationContext(), archenemy_pos_counter1, "archenemy_pos1");
        });

        archenemy_poison_1press.setOnLongClickListener(v -> {
            myVib.vibrate(20);
            archenemy_pos_counter1 = 0;
            archenemy_poison1.setText(String.format(Locale.getDefault(), "%d", archenemy_pos_counter1));
            Shortcuts.SalvataggioDummy(getApplicationContext(), archenemy_pos_counter1, "archenemy_pos1");
            return true;
        });

        archenemy_commander_3press.setOnClickListener(v -> {
            myVib.vibrate(5);
            if(archenemy_com_counter3!=21){
                archenemy_com_counter3++;
            }
            archenemy_commander3.setText(String.format(Locale.getDefault(), "%d", archenemy_com_counter3));
            Shortcuts.SalvataggioDummy(getApplicationContext(), archenemy_com_counter3, "archenemy_com3");
        });

        archenemy_commander_3press.setOnLongClickListener(v -> {
            myVib.vibrate(20);
            archenemy_com_counter3 = 0;
            archenemy_commander3.setText(String.format(Locale.getDefault(), "%d", archenemy_com_counter3));
            Shortcuts.SalvataggioDummy(getApplicationContext(), archenemy_com_counter3, "archenemy_com3");
            return true;
        });

        archenemy_poison_3press.setOnClickListener(v -> {
            myVib.vibrate(5);
            if(archenemy_pos_counter3!=10){
                archenemy_pos_counter3++;
            }
            archenemy_poison3.setText(String.format(Locale.getDefault(), "%d", archenemy_pos_counter3));
            Shortcuts.SalvataggioDummy(getApplicationContext(), archenemy_pos_counter3, "archenemy_pos3");
        });

        archenemy_poison_3press.setOnLongClickListener(v -> {
            myVib.vibrate(20);
            archenemy_pos_counter3 = 0;
            archenemy_poison3.setText(String.format(Locale.getDefault(), "%d", archenemy_pos_counter3));
            Shortcuts.SalvataggioDummy(getApplicationContext(), archenemy_pos_counter3, "archenemy_pos3");
            return true;
        });

        archenemy_piu1_1.setOnTouchListener(new View.OnTouchListener() {
            private Handler mHandler;

            @Override
            public boolean onTouch(View v, MotionEvent event) {
                switch (event.getAction()) {
                    case MotionEvent.ACTION_DOWN:

                        if (mHandler != null) return true;
                        mHandler = new Handler();
                        mHandler.postDelayed(mAction, 500);

                        if(archenemy_counter1!=999){
                            archenemy_counter1++;
                        }

                        myVib.vibrate(10);
                        archenemy_segna_vita1.setText(String.format(Locale.getDefault(), "%d", archenemy_counter1));
                        Shortcuts.SalvataggioDummy(getApplicationContext(), archenemy_counter1, "archenemy_vita1");

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

                    if(archenemy_counter1!=999){
                        archenemy_counter1++;
                    }

                    myVib.vibrate(5);
                    archenemy_segna_vita1.setText(String.format(Locale.getDefault(), "%d", archenemy_counter1));
                    Shortcuts.SalvataggioDummy(getApplicationContext(), archenemy_counter1, "archenemy_vita1");
                    mHandler.postDelayed(this, 80);
                }
            };
        });


        archenemy_meno1_1.setOnTouchListener(new View.OnTouchListener() {
            private Handler mHandler;

            @Override
            public boolean onTouch(View v, MotionEvent event) {
                switch (event.getAction()) {
                    case MotionEvent.ACTION_DOWN:

                        if (mHandler != null) return true;
                        mHandler = new Handler();
                        mHandler.postDelayed(mAction, 500);

                        if(archenemy_counter1!=0){
                            archenemy_counter1--;
                        }

                        myVib.vibrate(10);
                        archenemy_segna_vita1.setText(String.format(Locale.getDefault(), "%d", archenemy_counter1));
                        Shortcuts.SalvataggioDummy(getApplicationContext(), archenemy_counter1, "archenemy_vita1");

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

                    if(archenemy_counter1!=0){
                        archenemy_counter1--;
                    }

                    myVib.vibrate(5);
                    archenemy_segna_vita1.setText(String.format(Locale.getDefault(), "%d", archenemy_counter1));
                    Shortcuts.SalvataggioDummy(getApplicationContext(), archenemy_counter1, "archenemy_vita1");
                    mHandler.postDelayed(this, 80);
                }
            };
        });

        archenemy_piu1_3.setOnTouchListener(new View.OnTouchListener() {
            private Handler mHandler;

            @Override
            public boolean onTouch(View v, MotionEvent event) {
                switch (event.getAction()) {
                    case MotionEvent.ACTION_DOWN:

                        if (mHandler != null) return true;
                        mHandler = new Handler();
                        mHandler.postDelayed(mAction, 500);

                        if(archenemy_counter3!=999){
                            archenemy_counter3++;
                        }

                        myVib.vibrate(10);
                        archenemy_segna_vita3.setText(String.format(Locale.getDefault(), "%d", archenemy_counter3));
                        Shortcuts.SalvataggioDummy(getApplicationContext(), archenemy_counter3, "archenemy_vita3");

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

                    if(archenemy_counter3!=999){
                        archenemy_counter3++;
                    }

                    myVib.vibrate(5);
                    archenemy_segna_vita3.setText(String.format(Locale.getDefault(), "%d", archenemy_counter3));
                    Shortcuts.SalvataggioDummy(getApplicationContext(), archenemy_counter3, "archenemy_vita3");
                    mHandler.postDelayed(this, 80);
                }
            };
        });

        archenemy_meno1_3.setOnTouchListener(new View.OnTouchListener() {
            private Handler mHandler;

            @Override
            public boolean onTouch(View v, MotionEvent event) {
                switch (event.getAction()) {
                    case MotionEvent.ACTION_DOWN:

                        if (mHandler != null) return true;
                        mHandler = new Handler();
                        mHandler.postDelayed(mAction, 500);

                        if(archenemy_counter3!=0){
                            archenemy_counter3--;
                        }

                        myVib.vibrate(10);
                        archenemy_segna_vita3.setText(String.format(Locale.getDefault(), "%d", archenemy_counter3));
                        Shortcuts.SalvataggioDummy(getApplicationContext(), archenemy_counter3, "archenemy_vita3");

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

                    if(archenemy_counter3!=0){
                        archenemy_counter3--;
                    }

                    myVib.vibrate(5);
                    archenemy_segna_vita3.setText(String.format(Locale.getDefault(), "%d", archenemy_counter3));
                    Shortcuts.SalvataggioDummy(getApplicationContext(), archenemy_counter3, "archenemy_vita3");
                    mHandler.postDelayed(this, 80);
                }
            };
        });

        archenemy_toPlanes.setOnClickListener(v -> {
            startActivity(new Intent(ArchenemyLife.this, Planes.class));
            overridePendingTransition(R.anim.animation_left_to_right_enter, R.anim.animation_left_to_right_exit);
            finish();
        });

        archenemy_toSchemes.setOnClickListener(v -> {
            startActivity(new Intent(ArchenemyLife.this, Schemes.class));
            overridePendingTransition(R.anim.animation_right_to_left_enter, R.anim.animation_right_to_left_exit);
            finish();
        });

        forSwipe.setOnTouchListener(new OnSwipeTouchListener(ArchenemyLife.this) {
            public void onSwipeLeft() {
                startActivity(new Intent(ArchenemyLife.this, Schemes.class));
                overridePendingTransition(R.anim.animation_right_to_left_enter, R.anim.animation_right_to_left_exit);
                finish();
            }
            public void onSwipeRight() {
                startActivity(new Intent(ArchenemyLife.this, Planes.class));
                overridePendingTransition(R.anim.animation_left_to_right_enter, R.anim.animation_left_to_right_exit);
                finish();
            }
        });

    }

    public void onBackPressed() {
        AlertDialog.Builder builder1 = new AlertDialog.Builder(ArchenemyLife.this);

        myVib.vibrate(200);

        builder1.setMessage("Go back to main menu, you will lose all preferences?")
                .setCancelable(false)
                .setPositiveButton("Yes", (dialogInterface, i) -> {
                    startActivity(new Intent(ArchenemyLife.this, Menu.class));

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

    private void decodeBase64AndSetImage(String completeImageData, ImageView imageView) {

        String imageDataBytes = completeImageData.substring(completeImageData.indexOf(",")+1);

        InputStream stream = new ByteArrayInputStream(Base64.decode(imageDataBytes.getBytes(), Base64.DEFAULT));

        Bitmap bitmap = BitmapFactory.decodeStream(stream);

        imageView.setImageBitmap(bitmap);
    }
}
