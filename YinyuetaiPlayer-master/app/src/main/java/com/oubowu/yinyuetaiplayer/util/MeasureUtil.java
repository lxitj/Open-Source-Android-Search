package com.oubowu.yinyuetaiplayer.util;

import android.content.Context;

import org.android10.gintonic.annotation.DebugTrace;

/**
 * Created by Oubowu on 2016/12/27 17:41.
 */
public class MeasureUtil {
    @DebugTrace
    public static int dip2px(Context context,float dpValue) {
        final float scale = context.getResources().getDisplayMetrics().density;
        return (int) (dpValue * scale + 0.5f);
    }

}
