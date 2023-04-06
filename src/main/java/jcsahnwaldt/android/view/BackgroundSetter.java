package jcsahnwaldt.android.view;

import android.graphics.drawable.Drawable;
import android.os.Build;
import android.view.View;

public class BackgroundSetter
extends SubViewModifier
{
  private final Drawable background;

  public BackgroundSetter(Drawable background) {
    this(0, background);
  }

  public BackgroundSetter(int viewId, Drawable background) {
    super(viewId);
    this.background = background;
  }

  @Override
  @SuppressWarnings("deprecation")
  public void modify(View parent) {
    View view = findView(parent, true);
    if (Build.VERSION.SDK_INT >= 16) view.setBackground(background);
    else view.setBackgroundDrawable(background);
  }
}
