package jcsahnwaldt.android.util;

import android.content.Context;
import android.content.res.Resources;
import android.util.DisplayMetrics;

public class PixelConverter {

    private final DisplayMetrics metrics;

    public PixelConverter(DisplayMetrics metrics) {
        this.metrics = metrics;
    }

    public PixelConverter(Resources resources) {
        this(resources.getDisplayMetrics());
    }

    public PixelConverter(Context context) {
        this(context.getResources());
    }

    public int px(float dp) {
        return (int)(dp * metrics.density);
    }

    public float dp(int px) {
        return px / metrics.density;
    }
}
