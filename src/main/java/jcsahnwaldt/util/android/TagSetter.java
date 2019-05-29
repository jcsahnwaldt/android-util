package jcsahnwaldt.util.android;

import android.view.View;

public class TagSetter
extends SubViewModifier
{
  protected final Object tag;
  
  public TagSetter(Object tag) {
    this(0, tag);
  }
  
  public TagSetter(int viewId, Object tag) {
    super(viewId);
    this.tag = tag;
  }

  @Override
  public void modify(View view) {
    findView(view, true).setTag(tag);
  }

}
