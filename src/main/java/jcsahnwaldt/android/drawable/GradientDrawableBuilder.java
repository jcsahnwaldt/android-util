package jcsahnwaldt.android.drawable;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.drawable.GradientDrawable;

import jcsahnwaldt.android.util.PixelConverter;

public class GradientDrawableBuilder implements DrawableBuilder {

    public static GradientDrawableBuilder rectangle(Resources resources, int colorId) {
        return new GradientDrawableBuilder(resources)
        .setShape(GradientDrawable.RECTANGLE)
        .setColor(colorId);
    }

    public static GradientDrawableBuilder rectangle(Context context, int colorId) {
        return rectangle(context.getResources(), colorId);
    }

    private final GradientDrawable drawable;

    private final Resources res;
    private final PixelConverter pc;

    public GradientDrawableBuilder(Resources resources, GradientDrawable drawable) {
        this.drawable = drawable;
        this.res = resources;
        this.pc = new PixelConverter(resources);
    }

    public GradientDrawableBuilder(Resources resources) {
        this(resources, new GradientDrawable());
    }

    public GradientDrawableBuilder(Context context) {
        this(context.getResources());
    }

    @Override
    public GradientDrawable getDrawable() {
        return drawable;
    }

    /** e.g. {@link GradientDrawable#RECTANGLE} */
    public GradientDrawableBuilder setShape(int shape) {
        drawable.setShape(shape);
        return this;
    }

    // set color from res ID
    public GradientDrawableBuilder setColor(int colorId) {
        drawable.setColor(res.getColor(colorId));
        return this;
    }

    // set stroke in dp / color res ID
    public GradientDrawableBuilder setStroke(float width, int colorId) {
        drawable.setStroke(pc.px(width), res.getColor(colorId));
        return this;
    }

    // set corner radii in dp
    public GradientDrawableBuilder setCornerRadii(float... dps) {
        float[] pxs = new float[dps.length];
        for (int i = 0; i < dps.length; i++) pxs[i] = pc.px(dps[i]);
        drawable.setCornerRadii(pxs);
        return this;
    }
}
