package jcsahnwaldt.util.android;

import android.view.View;
import android.widget.TextView;

public class TextColorSetter
extends SubViewModifier
{
  private int color;
  
  public TextColorSetter(int color) {
    this(0, color);
  }
  
  public TextColorSetter(int viewId, int color) {
    super(viewId);
    this.color = color;
  }
  
  public void setTextColor(int color) {
    this.color = color;
  }
  
  @Override
  public boolean canUse(View view) {
    return findView(view, false) instanceof TextView;
  }
  
  @Override
  public void modify(View view) {
    ((TextView)findView(view, true)).setTextColor(color);
  }
}
