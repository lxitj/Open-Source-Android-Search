package com.oubowu.yinyuetaiplayer.base;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Paint;
import android.graphics.Typeface;
import android.graphics.drawable.Drawable;
import android.support.v4.content.ContextCompat;
import android.support.v4.view.ViewCompat;
import android.support.v7.widget.RecyclerView;
import android.text.util.Linkify;
import android.util.SparseArray;
import android.view.View;
import android.widget.Button;
import android.widget.Checkable;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.RatingBar;
import android.widget.TextView;

import org.android10.gintonic.annotation.DebugTrace;

/**
 * ClassName: <p>
 * Author:oubowu<p>
 * Fuction: RecyclerView通用适配器Holder<p>
 * CreateDate:2016/2/16 23:00<p>
 * UpdateUser:<p>
 * UpdateDate:<p>
 */
public class BaseViewHolder extends RecyclerView.ViewHolder {

    //集合类，layout里包含的View,以view的id作为key，value是view对象
    protected SparseArray<View> mViews;
    //上下文对象
    protected Context mContext;

    public BaseViewHolder(Context context, View itemView) {
        super(itemView);
        mContext = context;
        mViews = new SparseArray<View>();
    }

    @SuppressWarnings("unchecked")
    private <T extends View> T findViewById(int viewId) {
        View view = mViews.get(viewId);
        if (view == null) {
            view = itemView.findViewById(viewId);
            mViews.put(viewId, view);
        }
        return (T) view;
    }
    @DebugTrace
    public View getView(int viewId) {
        return findViewById(viewId);
    }
    @DebugTrace
    public TextView getTextView(int viewId) {
        return (TextView) getView(viewId);
    }
    @DebugTrace
    public Button getButton(int viewId) {
        return (Button) getView(viewId);
    }
    @DebugTrace
    public ImageView getImageView(int viewId) {
        return (ImageView) getView(viewId);
    }
    @DebugTrace
    public ImageButton getImageButton(int viewId) {
        return (ImageButton) getView(viewId);
    }
    @DebugTrace
    public EditText getEditText(int viewId) {
        return (EditText) getView(viewId);
    }

    public BaseViewHolder setBackground(int viewId, int resId) {
        View view = findViewById(viewId);
        view.setBackgroundResource(resId);
        return this;
    }

    /****以下为辅助方法*****/
    @DebugTrace
    public BaseViewHolder setText(int viewId, String text) {
        TextView tv = findViewById(viewId);
        tv.setText(text);
        return this;
    }
    @DebugTrace
    public BaseViewHolder setText(int viewId, CharSequence text) {
        TextView tv = findViewById(viewId);
        tv.setText(text);
        return this;
    }
    @DebugTrace
    public BaseViewHolder setImageResource(int viewId, int resId) {
        ImageView view = findViewById(viewId);
        view.setImageResource(resId);
        return this;
    }
    @DebugTrace
    public BaseViewHolder setImageBitmap(int viewId, Bitmap bitmap) {
        ImageView view = findViewById(viewId);
        view.setImageBitmap(bitmap);
        return this;
    }
    @DebugTrace
    public BaseViewHolder setImageDrawable(int viewId, Drawable drawable) {
        ImageView view = findViewById(viewId);
        view.setImageDrawable(drawable);
        return this;
    }
    @DebugTrace
    public BaseViewHolder setBackgroundColor(int viewId, int color) {
        View view = findViewById(viewId);
        view.setBackgroundColor(color);
        return this;
    }
    @DebugTrace
    public BaseViewHolder setBackgroundRes(int viewId, int backgroundRes) {
        View view = findViewById(viewId);
        view.setBackgroundResource(backgroundRes);
        return this;
    }
    @DebugTrace
    public BaseViewHolder setTextColor(int viewId, int textColor) {
        TextView view = findViewById(viewId);
        view.setTextColor(textColor);
        return this;
    }
    @DebugTrace
    public BaseViewHolder setTextColorRes(int viewId, int textColorRes) {
        TextView view = findViewById(viewId);
        view.setTextColor(ContextCompat.getColor(mContext, textColorRes));
        return this;
    }
    @DebugTrace
    public BaseViewHolder setAlpha(int viewId, float value) {
        ViewCompat.setAlpha(findViewById(viewId), value);
        return this;
    }
    @DebugTrace
    public BaseViewHolder setViewGone(int viewId, boolean gone) {
        View view = findViewById(viewId);
        view.setVisibility(gone ? View.GONE : View.VISIBLE);
        return this;
    }
    @DebugTrace
    public BaseViewHolder setViewInvisible(int viewId, boolean invisible) {
        View view = findViewById(viewId);
        view.setVisibility(invisible ? View.INVISIBLE : View.VISIBLE);
        return this;
    }
    @DebugTrace
    public BaseViewHolder linkify(int viewId) {
        TextView view = findViewById(viewId);
        Linkify.addLinks(view, Linkify.ALL);
        return this;
    }
    @DebugTrace
    public BaseViewHolder setTypeface(Typeface typeface, int... viewIds) {
        for (int viewId : viewIds) {
            TextView view = findViewById(viewId);
            view.setTypeface(typeface);
            view.setPaintFlags(view.getPaintFlags() | Paint.SUBPIXEL_TEXT_FLAG);
        }
        return this;
    }
    @DebugTrace
    public BaseViewHolder setProgress(int viewId, int progress) {
        ProgressBar view = findViewById(viewId);
        view.setProgress(progress);
        return this;
    }
    @DebugTrace
    public BaseViewHolder setProgress(int viewId, int progress, int max) {
        ProgressBar view = findViewById(viewId);
        view.setMax(max);
        view.setProgress(progress);
        return this;
    }
    @DebugTrace
    public BaseViewHolder setMax(int viewId, int max) {
        ProgressBar view = findViewById(viewId);
        view.setMax(max);
        return this;
    }
    @DebugTrace
    public BaseViewHolder setRating(int viewId, float rating) {
        RatingBar view = findViewById(viewId);
        view.setRating(rating);
        return this;
    }
    @DebugTrace
    public BaseViewHolder setRating(int viewId, float rating, int max) {
        RatingBar view = findViewById(viewId);
        view.setMax(max);
        view.setRating(rating);
        return this;
    }
    @DebugTrace
    public BaseViewHolder setTag(int viewId, Object tag) {
        View view = findViewById(viewId);
        view.setTag(tag);
        return this;
    }
    @DebugTrace
    public BaseViewHolder setTag(int viewId, int key, Object tag) {
        View view = findViewById(viewId);
        view.setTag(key, tag);
        return this;
    }
    @DebugTrace
    public BaseViewHolder setChecked(int viewId, boolean checked) {
        Checkable view = (Checkable) findViewById(viewId);
        view.setChecked(checked);
        return this;
    }

    /**
     * 关于事件的
     */
    @DebugTrace
    public BaseViewHolder setOnClickListener(int viewId, View.OnClickListener listener) {
        View view = findViewById(viewId);
        view.setOnClickListener(listener);
        return this;
    }
    @DebugTrace
    public BaseViewHolder setOnTouchListener(int viewId, View.OnTouchListener listener) {
        View view = findViewById(viewId);
        view.setOnTouchListener(listener);
        return this;
    }
    @DebugTrace
    public BaseViewHolder setOnLongClickListener(int viewId, View.OnLongClickListener listener) {
        View view = findViewById(viewId);
        view.setOnLongClickListener(listener);
        return this;
    }

}
