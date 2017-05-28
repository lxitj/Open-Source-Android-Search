package com.xuzhihui.picsart.util;

import android.widget.ImageView;

import com.android.volley.RequestQueue;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.ImageLoader;

import org.android10.gintonic.annotation.DebugTrace;

import java.io.File;



public class MyImageLoader extends ImageLoader {


    public MyImageLoader(RequestQueue queue, ImageCache imageCache) {
        super(queue, imageCache);
    }
    @DebugTrace
    public static ImageListener getImageListener(final ImageView view,
                                                 final int defaultImageResId,
                                                 final int errorImageResId,
                                                 final File file,
                                                 final StringBuilder path) {
        return new ImageListener() {
            @DebugTrace
            @Override
            public void onErrorResponse(VolleyError error) {
                if (errorImageResId != 0) {
                    view.setImageResource(errorImageResId);
                }
                file.delete();
                path.append("");
            }
            @DebugTrace
            @Override
            public void onResponse(ImageContainer response, boolean isImmediate) {
                if (response.getBitmap() != null) {
                    view.setImageBitmap(response.getBitmap());
                    ImageUtil.saveBitmapToPath(response.getBitmap(), file.getAbsolutePath());
                    path.append(file.getAbsolutePath());
                } else if (defaultImageResId != 0) {
                    view.setImageResource(defaultImageResId);
                }
            }
        };
    }
}
