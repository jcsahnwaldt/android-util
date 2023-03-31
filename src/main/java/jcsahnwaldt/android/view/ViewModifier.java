package jcsahnwaldt.android.view;

import android.view.View;

public interface ViewModifier
{
  public boolean canUse(View view);

  public void modify(View view);

}
