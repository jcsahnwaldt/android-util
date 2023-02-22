package jcsahnwaldt.util.android;

import android.view.View;
import android.widget.TextView;

public class ScaledTypefaceSetter
extends SubViewModifier
{
  private final ScaledTypeface typeface;

  public ScaledTypefaceSetter(ScaledTypeface typeface) {
    this(0, typeface);
  }

  public ScaledTypefaceSetter(int viewId, ScaledTypeface typeface) {
    super(viewId);
    this.typeface = typeface;
  }

  @Override
  public boolean canUse(View view) {
    return findView(view, false) instanceof TextView;
  }

  @Override
  public void modify(View view) {
    typeface.set((TextView)findView(view, true));
  }
}
