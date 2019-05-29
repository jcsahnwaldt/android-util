package jcsahnwaldt.util.android;

import android.view.View;

public interface ViewModifier
{
  public boolean canUse(View view);
  
  public void modify(View view);
  
}
