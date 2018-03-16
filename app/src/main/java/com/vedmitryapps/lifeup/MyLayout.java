package com.vedmitryapps.lifeup;

import android.content.Context;
import android.graphics.Rect;
import android.os.Build;
import android.support.annotation.RequiresApi;
import android.util.AttributeSet;
import android.view.WindowInsets;
import android.widget.RelativeLayout;


public class MyLayout extends RelativeLayout {
    public MyLayout(Context context) {
        super(context);
    }

    public MyLayout(Context context, AttributeSet attrs) {
        super(context, attrs);
    }

    public MyLayout(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }

    @Override
    protected boolean fitSystemWindows(Rect insets) {
        // this is added so we can "consume" the padding which is added because
        // `android:fitsSystemWindows="true"` was added to the XML tag of View.
        if (Build.VERSION.SDK_INT > Build.VERSION_CODES.JELLY_BEAN
                && Build.VERSION.SDK_INT < 20) {
            insets.top = 0;
            // remove height of NavBar so that it does add padding at bottom.
            insets.top = getStatusBarHeight();
        }
        return super.fitSystemWindows(insets);
    }

    @RequiresApi(api = Build.VERSION_CODES.KITKAT_WATCH)
    @Override
    public WindowInsets onApplyWindowInsets(WindowInsets insets) {
        // executed by API >= 20.
        // removes the empty padding at the bottom which equals that of the height of NavBar.
        setPadding(0,getStatusBarHeight(), 0, 0);
        return insets.consumeSystemWindowInsets();
    }

    public int getStatusBarHeight() {
        int result = 0;
        int resourceId = getResources().getIdentifier("status_bar_height", "dimen", "android");
        if (resourceId > 0) {
            result = getResources().getDimensionPixelSize(resourceId);
        }
        return result;
    }

}
