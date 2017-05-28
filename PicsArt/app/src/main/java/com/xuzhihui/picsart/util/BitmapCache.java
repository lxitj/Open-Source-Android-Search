package com.xuzhihui.picsart.util;

import android.graphics.Bitmap;
import android.util.LruCache;

import com.android.volley.toolbox.ImageLoader;

import org.android10.gintonic.annotation.DebugTrace;

/**
 * Created by Jav-Xu on 16/9/4.
 */
public class BitmapCache implements ImageLoader.ImageCache {

    private LruCache<String, Bitmap> mMemoryCache;

    public BitmapCache() {
        long maxSize = Runtime.getRuntime().maxMemory() / 10;
        mMemoryCache = new LruCache<String, Bitmap>((int) maxSize) {
            @Override
            protected int sizeOf(String key, Bitmap bitmap) {
                return bitmap.getByteCount();
            }
        };
    }
    @DebugTrace
    @Override
    public Bitmap getBitmap(String url) {
        return mMemoryCache.get(url);
    }
    @DebugTrace
    @Override
    public void putBitmap(String url, Bitmap bitmap) {
        mMemoryCache.put(url, bitmap);
    }

}