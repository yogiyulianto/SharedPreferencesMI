package com.example.bal;

import android.content.Context;
import android.content.SharedPreferences;

public class SharedPrefManager2 {
    SharedPreferences sp;
    SharedPreferences.Editor editor;

    private final String SP_NAME = "loginsession";

    public static final String SP_NAMA = "nama";
    public static final String SP_EMAIL = "email";
    public static final String SP_SUDAH_LOGIN = "islogin";

    public SharedPrefManager2(Context context){
        sp = context.getSharedPreferences(SP_NAME,Context.MODE_PRIVATE);
        editor = sp.edit();
    }

    public void saveString(String keySP, String value){
        editor.putString(keySP, value);
        editor.commit();
    }

    public void saveBolean(String keySP, boolean value){
        editor.putBoolean(keySP, value);
        editor.commit();
    }

    public boolean isLogin(){
        return sp.getBoolean(SP_SUDAH_LOGIN, false);
    }

    public String getNama(){
        return sp.getString(SP_NAMA, "");
    }

}
