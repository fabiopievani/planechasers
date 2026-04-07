package com.fabiopievani.planechasers.utility;

import android.content.Context;
import android.content.SharedPreferences;
import android.os.Handler;
import androidx.annotation.NonNull;
import androidx.appcompat.app.AlertDialog;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import java.lang.reflect.Type;
import java.util.Random;


//Classe utilizzata per richiamare vari metodi e rendere più chiaro il codice

public class Shortcuts {

    static SharedPreferences salvataggio;
    static SharedPreferences.Editor editor;
    static String jsonString;

    public static void MessaggioSchermo (Context context, String  msg){
        final Handler handler = new Handler();
        final AlertDialog.Builder builder = new AlertDialog.Builder(context);
        builder.setMessage(msg);
        final AlertDialog dialog = builder.create();
        dialog.show();
        handler.postDelayed(dialog::dismiss, 1000);
    }

    public static void MessaggioSchermoTempo (Context context, String  msg,int tempo){
        final Handler handler = new Handler();
        final AlertDialog.Builder builder = new AlertDialog.Builder(context);
        builder.setMessage(msg);
        final AlertDialog dialog = builder.create();
        dialog.show();
        handler.postDelayed(dialog::dismiss, tempo);
    }

    public static void SalvataggioDummy(Context context, int value, String nome){
        salvataggio = context.getSharedPreferences("planechasers_prefs", Context.MODE_PRIVATE);
        editor = salvataggio.edit();
        editor.putInt(nome, value);
        editor.commit();
    }

    public static void SalvataggioBooleano(Context context, boolean value, String nome){
        salvataggio = context.getSharedPreferences("planechasers_prefs", Context.MODE_PRIVATE);
        editor = salvataggio.edit();
        editor.putBoolean(nome, value);
        editor.commit();
    }

    @NonNull
    public static Boolean CaricamentoBooleano (Context context, String nome){
        salvataggio = context.getSharedPreferences("planechasers_prefs", Context.MODE_PRIVATE);
        return salvataggio.getBoolean(nome,false);
    }

    public static void SalvataggioDummy(Context context, String stringa, String nome){
        salvataggio = context.getSharedPreferences("planechasers_prefs", Context.MODE_PRIVATE);
        editor = salvataggio.edit();
        editor.putString(nome, stringa);
        editor.commit();
    }

    public static void SalvataggioArray (Context context, int[] array){
        Gson gson = new Gson();
        jsonString = gson.toJson(array);
        salvataggio = context.getSharedPreferences("planechasers_prefs", Context.MODE_PRIVATE);
        editor = salvataggio.edit();
        editor.putString("array", jsonString);
        editor.commit();
    }

    public static void SalvataggioArrayPiani (Context context, int[] array){
        Gson gson = new Gson();
        jsonString = gson.toJson(array);
        salvataggio = context.getSharedPreferences("planechasers_prefs", Context.MODE_PRIVATE);
        editor = salvataggio.edit();
        editor.putString("arrayPiani", jsonString);
        editor.commit();
    }

    public static int[] CaricamentoArray (Context context){
        salvataggio = context.getSharedPreferences("planechasers_prefs", Context.MODE_PRIVATE);
        String ritorno = salvataggio.getString("array", "");
        Type type = new TypeToken<int[]>() {}.getType();
        return new Gson().fromJson(ritorno, type);
    }

    public static int[] CaricamentoArrayPiani (Context context){
        salvataggio = context.getSharedPreferences("planechasers_prefs", Context.MODE_PRIVATE);
        String ritorno = salvataggio.getString("arrayPiani", "");
        Type type = new TypeToken<int[]>() {}.getType();
        return new Gson().fromJson(ritorno, type);
    }

    /**
     * This method takes a {@code String}
     * and searches in the DefaultSharedPreferences for a SharedPreference
     * with corresponding name, then returns an int or a String based on the given
     * {@code int} parameter
     *
     * @param nome
     *        Name of the SharedPreference
     * @param indicator
     *        Indicates if the SharedPreferences contains an int (0) or a String (1)
     * @return The preference saved in {@code String}
     */
    public static Object CaricamentoDummy (Context context, String nome, int indicator){
        salvataggio = context.getSharedPreferences("planechasers_prefs", Context.MODE_PRIVATE);
        if(indicator==0){
            return salvataggio.getInt(nome,0);
        }
        if(indicator==1){
            return salvataggio.getString(nome,"");
        }else{
            return salvataggio.getInt(nome,0x00000004);
        }
    }

    public static int CaricamentoDummyVita (Context context, String nome){
        salvataggio = context.getSharedPreferences("planechasers_prefs", Context.MODE_PRIVATE);
            return salvataggio.getInt(nome,40);
    }

    public static int CaricamentoDummyVitaArchenemy (Context context, String nome){
        salvataggio = context.getSharedPreferences("planechasers_prefs", Context.MODE_PRIVATE);
        return salvataggio.getInt(nome,60);
    }

    public static void shuffleArray(int[] array) {
        int index;
        Random random = new Random();
        if(array!=null) {
            for (int i = array.length - 1; i > 0; i--) {
                index = random.nextInt(i + 1);
                if (index != i) {
                    array[index] ^= array[i];
                    array[i] ^= array[index];
                    array[index] ^= array[i];
                }
            }
        }
    }
}
