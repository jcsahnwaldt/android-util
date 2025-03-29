package jcsahnwaldt.android.view;

import android.view.View;
import android.widget.TextView;

import jcsahnwaldt.android.ScaledTypeface;

public class ScaledTypefaceSetter
extends SubViewModifier
{
  private final ScaledTypeface typeface;
  private final int style;

  public ScaledTypefaceSetter(ScaledTypeface typeface) {
    this(0, typeface, 0);
  }

  public ScaledTypefaceSetter(ScaledTypeface typeface, int style) {
    this(0, typeface, style);
  }

  public ScaledTypefaceSetter(int viewId, ScaledTypeface typeface) {
    this(viewId, typeface, 0);
  }

  public ScaledTypefaceSetter(int viewId, ScaledTypeface typeface, int style) {
    super(viewId);
    this.typeface = typeface;
    this.style = style;
  }

  @Override
  public boolean canUse(View view) {
    return findView(view, false) instanceof TextView;
  }

  @Override
  public void modify(View view) {
    typeface.set((TextView)findView(view, true), style);
  }
}
