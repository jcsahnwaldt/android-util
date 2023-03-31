package jcsahnwaldt.android.view;

import android.view.View;
import android.widget.Checkable;

public class CheckedSetter
extends SubViewModifier
{
  private final boolean checked;

  public CheckedSetter(boolean checked) {
    this(0, checked);
  }

  public CheckedSetter(int viewId, boolean checked) {
    super(viewId);
    this.checked = checked;
  }

  @Override
  public boolean canUse(View view) {
    return findView(view, false) instanceof Checkable;
  }

  @Override
  public void modify(View view) {
    Checkable checkable = (Checkable)findView(view, true);
    checkable.setChecked(checked);
  }
}
