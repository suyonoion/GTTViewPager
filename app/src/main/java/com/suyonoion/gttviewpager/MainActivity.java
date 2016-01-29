package com.suyonoion.gttviewpager;

import android.app.Activity;
import android.os.Bundle;

public class MainActivity extends Activity {
    /* getIdentifier untung menghilangkan id dalam smali */
    public int setResource(String NamaFile, String NamaFolder)
    {
        return getBaseContext().getResources().getIdentifier(NamaFile, NamaFolder, getBaseContext().getPackageName());
    }
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(setResource("activity_main","layout"));
    }
}
