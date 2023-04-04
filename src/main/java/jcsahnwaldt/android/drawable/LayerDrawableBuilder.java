package jcsahnwaldt.android.drawable;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.LayerDrawable;

import jcsahnwaldt.android.util.PixelConverter;

public class LayerDrawableBuilder {

    public final LayerDrawable drawable;
    private final PixelConverter pc;

    public LayerDrawableBuilder(Context context, LayerDrawable drawable) {
        this.drawable = drawable;
        this.pc = new PixelConverter(context);
    }

    public LayerDrawableBuilder(Context context, Drawable... drawables) {
        this(context, new LayerDrawable(drawables));
    }

    // set insets in dp
    public LayerDrawableBuilder setLayerInset(int index, float l, float t, float r, float b) {
        drawable.setLayerInset(index, pc.px(l), pc.px(t), pc.px(r), pc.px(b));
        return this;
    }
}
