package jcsahnwaldt.android.view;

import android.graphics.Typeface;
import android.view.View;
import android.widget.TextView;

public class TypefaceSetter
extends SubViewModifier
{
  private final Typeface typeface;
  private final int style;

  public TypefaceSetter(Typeface typeface) {
    this(0, typeface, 0);
  }

  public TypefaceSetter(Typeface typeface, int style) {
    this(0, typeface, style);
  }

  public TypefaceSetter(int viewId, Typeface typeface) {
    this(viewId, typeface, 0);
  }

  public TypefaceSetter(int viewId, Typeface typeface, int style) {
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
    ((TextView)findView(view, true)).setTypeface(typeface, style);
  }
}
