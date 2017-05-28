package com.oubowu.yinyuetaiplayer.itemdecoration;

import android.content.Context;
import android.graphics.Rect;
import android.support.v7.widget.RecyclerView;
import android.view.View;

import org.android10.gintonic.annotation.DebugTrace;

import static com.oubowu.yinyuetaiplayer.util.MeasureUtil.dip2px;


public class VideoListItemDecoration extends RecyclerView.ItemDecoration {

    private final Context mContext;

    public VideoListItemDecoration(Context context) {
        mContext = context;
    }
    @DebugTrace
    @Override
    public void getItemOffsets(Rect outRect, View view, RecyclerView parent, RecyclerView.State state) {
        int position = parent.getChildLayoutPosition(view);
        if (position < 2) {
            outRect.top = dip2px(mContext, 8);
        } else {
            outRect.top = 0;
        }
        if (position % 2 == 0) {
            outRect.left = dip2px(mContext, 8);
            outRect.right = dip2px(mContext, 4);
        } else {
            outRect.left = dip2px(mContext, 4);
            outRect.right = dip2px(mContext, 8);
        }
        outRect.bottom = dip2px(mContext, 8);
    }
}
