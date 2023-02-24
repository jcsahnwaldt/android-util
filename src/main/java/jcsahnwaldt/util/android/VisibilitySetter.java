package jcsahnwaldt.util.android;

import android.view.View;

public class VisibilitySetter
extends SubViewModifier
{
  private final int visibility;

  public VisibilitySetter(int visibility) {
    this(0, visibility);
  }

  public VisibilitySetter(int viewId, int visibility) {
    super(viewId);
    this.visibility = visibility;
  }

  @Override
  public void modify(View view) {
    findView(view, true).setVisibility(visibility);
  }
}
