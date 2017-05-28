package com.xuzhihui.picsart.application;

import android.app.Application;

import com.android.volley.RequestQueue;
import com.android.volley.toolbox.ImageLoader;
import com.android.volley.toolbox.Volley;
import com.xuzhihui.picsart.util.BitmapCache;

import org.android10.gintonic.annotation.DebugTrace;



public class MyApplication extends Application {

    public static ImageLoader mLoader;
    public static RequestQueue mQueue;
    public static BitmapCache mCache;
    @DebugTrace
    @Override
    public void onCreate() {
        super.onCreate();
        mCache = new BitmapCache();
        mQueue = Volley.newRequestQueue(getApplicationContext());
        mLoader = new ImageLoader(mQueue, mCache);
    }
}
