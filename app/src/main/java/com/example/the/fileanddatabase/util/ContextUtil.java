package com.example.the.fileanddatabase.util;

import android.content.Context;
import android.content.SharedPreferences;

/**
 * Created by the on 2017-09-11.
 */

public class ContextUtil {
    private static String prefName = "FileAndDatabasePref";
    private static String PUSH_CHECK = "PUSH_CHECK";
    private static String AUTO_LOGIN = "AUTO_LOGIN";
    private static String SOUND_USE = "SOUND_USE";
    private static String NAME = "NAME";

    public static boolean getPush(Context context) {
        SharedPreferences pref = context.getSharedPreferences(prefName, Context.MODE_PRIVATE);
        return pref.getBoolean(PUSH_CHECK, false);
    }
    public static void setPush (Context context, boolean isChecked) {
        SharedPreferences pref = context.getSharedPreferences(prefName, Context.MODE_PRIVATE);
        pref.edit().putBoolean(PUSH_CHECK, isChecked).apply();
    }

    public static void setAuto (Context context, boolean isAuto) {
        SharedPreferences pref = context.getSharedPreferences(prefName, Context.MODE_PRIVATE);
        pref.edit().putBoolean(AUTO_LOGIN, isAuto).apply();
    }

    public static boolean getAuto (Context context) {
        SharedPreferences pref = context.getSharedPreferences(prefName, Context.MODE_PRIVATE);
        return  pref.getBoolean(AUTO_LOGIN, false);
    }

    public static void setSound (Context context, boolean isSound) {
        SharedPreferences pref = context.getSharedPreferences(prefName, Context.MODE_PRIVATE);
        pref.edit().putBoolean(SOUND_USE, isSound).apply();
    }

    public static boolean getSound (Context context) {
        SharedPreferences pref = context.getSharedPreferences(prefName, Context.MODE_PRIVATE);
        return pref.getBoolean(SOUND_USE, false);
    }

    public static void setName (Context context, String name) {
        SharedPreferences pref = context.getSharedPreferences(prefName, Context.MODE_PRIVATE);
        pref.edit().putString(NAME, name).apply();
    }

    public static String getName (Context context) {
        SharedPreferences pref = context.getSharedPreferences(prefName, Context.MODE_PRIVATE);
        return pref.getString(NAME, "");
    }
}
