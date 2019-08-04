package com.jaimegc.constraintlayouts.utils;


import android.app.SharedElementCallback;
import android.content.Context;
import android.content.res.Resources;
import android.util.Log;
import android.util.TypedValue;
import android.view.View;
import android.widget.TextView;
import com.jaimegc.constraintlayouts.R;

import java.util.List;

public class EnterSharedElementCallback extends SharedElementCallback {
    private static final String TAG = "EnterSharedElementCallback";

    private final float mStartTextSize;
    private final float mEndTextSize;
    private final int mStartColor;
    private final int mEndColor;

    public EnterSharedElementCallback(Context context) {
        Resources res = context.getResources();
        mStartTextSize = res.getDimensionPixelSize(R.dimen.small_text_size);
        mEndTextSize = res.getDimensionPixelSize(R.dimen.large_text_size);
        mStartColor = res.getColor(R.color.black);
        mEndColor = res.getColor(R.color.blue);
    }

    @Override
    public void onSharedElementStart(List<String> sharedElementNames, List<View> sharedElements, List<View> sharedElementSnapshots) {
        for (View view : sharedElements) {
            if (view instanceof TextView) {
                TextView textView = (TextView) view;
                textView.setTextSize(TypedValue.COMPLEX_UNIT_PX, mStartTextSize);
                textView.setTextColor(mStartColor);
            }
        }
    }

    @Override
    public void onSharedElementEnd(List<String> sharedElementNames, List<View> sharedElements, List<View> sharedElementSnapshots) {

        for (View view : sharedElements) {
            if (view instanceof TextView) {
                TextView textView = (TextView) view;

                // Record the TextView's old width/height.
                int oldWidth = textView.getMeasuredWidth();
                int oldHeight = textView.getMeasuredHeight();

                // Setup the TextView's end values.
                textView.setTextSize(TypedValue.COMPLEX_UNIT_PX, mEndTextSize);
                textView.setTextColor(mEndColor);

                // Re-measure the TextView (since the text size has changed).
                int widthSpec = View.MeasureSpec.makeMeasureSpec(0, View.MeasureSpec.UNSPECIFIED);
                int heightSpec = View.MeasureSpec.makeMeasureSpec(0, View.MeasureSpec.UNSPECIFIED);
                textView.measure(widthSpec, heightSpec);

                // Record the TextView's new width/height.
                int newWidth = textView.getMeasuredWidth();
                int newHeight = textView.getMeasuredHeight();

                // Layout the TextView in the center of its container, accounting for its new width/height.
                int widthDiff = newWidth - oldWidth;
                int heightDiff = newHeight - oldHeight;
                textView.layout(textView.getLeft() - widthDiff / 2, textView.getTop() - heightDiff / 2,
                        textView.getRight() + widthDiff / 2, textView.getBottom() + heightDiff / 2);
            }
        }
    }
}
