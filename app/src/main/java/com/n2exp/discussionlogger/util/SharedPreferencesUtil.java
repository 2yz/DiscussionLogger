package com.n2exp.discussionlogger.util;

import android.content.Context;
import android.content.SharedPreferences;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import com.n2exp.discussionlogger.config.Constants;


/**
 * Created by yezersky on 15-2-8.
 */
public class SharedPreferencesUtil {

    public static Integer currentVersionCode = 0;

    // TODO add version code verify
    public static boolean checkIsFirstUse(Context context){
        SharedPreferences preferences=context.getSharedPreferences(Constants.APP_NAME, Context.MODE_PRIVATE );
        return currentVersionCode != preferences.getInt(Constants.VERSION_CODE, 0);
    }

    public static void writeVersionCode(Context context){
        SharedPreferences preferences=context.getSharedPreferences(Constants.APP_NAME, Context.MODE_PRIVATE );
        SharedPreferences.Editor editor=preferences.edit();
        editor.putInt(Constants.VERSION_CODE, currentVersionCode);
        editor.apply();
    }

    public static void setVersionCode(Context context) {
        PackageManager packageManager = context.getPackageManager();
        PackageInfo packInfo = null;
        try {
            packInfo = packageManager.getPackageInfo(context.getPackageName(), 0);
        } catch (PackageManager.NameNotFoundException e) {
            e.printStackTrace();
        }
        if(packInfo!=null)
            currentVersionCode = packInfo.versionCode;
    }
}
