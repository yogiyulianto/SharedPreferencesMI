package com.example.bal;

import android.content.Context;
import android.content.SharedPreferences;

public class SharedPrefManager {
    private SharedPreferences sp;
    private SharedPreferences.Editor editor;

    private final String SP_NAME = "loginsession";

    public static final String SP_NAMA = "nama" ;
    public static final String SP_EMAIL = "email";
    public static final String SP_SUDAH_LOGIN = "sudah login" ;

    public SharedPrefManager(Context context){
        sp = context.getSharedPreferences(SP_NAME, Context.MODE_PRIVATE);
        editor = sp.edit();
    }

    public void saveSPString(String keySP, String value){
        editor.putString(keySP, value);
        editor.commit();
    }

    public void saveSPInt(String keySP, int value){
        editor.putInt(keySP, value);
        editor.commit();
    }

    public void saveSPBolean(String keySP, boolean value){
        editor.putBoolean(keySP, value);
        editor.commit();
    }

    public void clearKEY(){
        editor.remove(getKeyNama())
                .remove(getKeyEmail())
                .apply();
    }

    public String getKeyNama() {
        return sp.getString(SP_NAMA,"");
    }

    public String getKeyEmail() {
        return sp.getString(SP_EMAIL,"");
    }

    public boolean Login(){
        return sp.getBoolean(SP_SUDAH_LOGIN, false);
    }
}
