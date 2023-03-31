package jcsahnwaldt.android.view;

import android.graphics.Typeface;
import android.view.View;
import android.widget.TextView;

public class TypefaceSetter
extends SubViewModifier
{
  private final Typeface typeface;

  public TypefaceSetter(Typeface typeface) {
    this(0, typeface);
  }

  public TypefaceSetter(int viewId, Typeface typeface) {
    super(viewId);
    this.typeface = typeface;
  }

  @Override
  public boolean canUse(View view) {
    return findView(view, false) instanceof TextView;
  }

  @Override
  public void modify(View view) {
    ((TextView)findView(view, true)).setTypeface(typeface);
  }
}
