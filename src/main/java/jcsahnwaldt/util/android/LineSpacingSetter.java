package jcsahnwaldt.util.android;

import android.view.View;
import android.widget.TextView;

public class LineSpacingSetter
extends SubViewModifier
{
  private float add;
  private float mult;

  public LineSpacingSetter(float add, float mult) {
    this(0, add, mult);
  }

  public LineSpacingSetter(int viewId, float add, float mult) {
    super(viewId);
    this.add = add;
    this.mult = mult;
  }

  public void setLineSpacing(float add, float mult) {
    this.add = add;
    this.mult = mult;
  }

  @Override
  public boolean canUse(View view) {
    return findView(view, false) instanceof TextView;
  }

  @Override
  public void modify(View view) {
    ((TextView)findView(view, true)).setLineSpacing(add, mult);
  }
}
