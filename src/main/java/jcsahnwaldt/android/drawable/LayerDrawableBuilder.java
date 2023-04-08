package jcsahnwaldt.android.drawable;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.LayerDrawable;

import jcsahnwaldt.android.util.PixelConverter;

public class LayerDrawableBuilder implements DrawableBuilder {

    private final LayerDrawable drawable;
    private final PixelConverter pc;

    public LayerDrawableBuilder(Context context, LayerDrawable drawable) {
        this.drawable = drawable;
        this.pc = new PixelConverter(context);
    }

    public LayerDrawableBuilder(Context context, Drawable... drawables) {
        this(context, new LayerDrawable(drawables));
    }

    public LayerDrawableBuilder(Context context, DrawableBuilder... builders) {
        this(context, new LayerDrawable(DrawableBuilder.getDrawables(builders)));
    }

    @Override
    public LayerDrawable getDrawable() {
        return drawable;
    }

    // set insets in dp
    public LayerDrawableBuilder setLayerInset(int index, float l, float t, float r, float b) {
        drawable.setLayerInset(index, pc.px(l), pc.px(t), pc.px(r), pc.px(b));
        return this;
    }
}
