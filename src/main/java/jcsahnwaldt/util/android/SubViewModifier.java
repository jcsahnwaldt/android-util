package jcsahnwaldt.util.android;

import android.view.View;

public abstract class SubViewModifier
implements ViewModifier
{
  protected final int viewId;

  public SubViewModifier(int viewId) {
    this.viewId = viewId;
  }

  @Override
  public boolean canUse(View view) {
    return findView(view, false) != null;
  }

  protected View findView(View view, boolean required) {
    if (viewId == 0) return view;
    view = view.findViewById(viewId);
    if (view == null && required) throw new IllegalArgumentException("no view found for id 0x"+Integer.toHexString(viewId));
    return view;
  }
}
