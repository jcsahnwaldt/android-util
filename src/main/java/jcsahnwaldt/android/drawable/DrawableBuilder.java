package jcsahnwaldt.android.drawable;

import android.graphics.drawable.Drawable;

public interface DrawableBuilder {
    public Drawable getDrawable();

    public static Drawable[] getDrawables(DrawableBuilder... builders) {
        Drawable[] drawables = new Drawable[builders.length];
        for (int i = 0; i < builders.length; i++) {
            drawables[i] = builders[i].getDrawable();
        }
        return drawables;
    }
}
