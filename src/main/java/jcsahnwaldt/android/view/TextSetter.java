package jcsahnwaldt.android.view;

import android.view.View;
import android.widget.TextView;

public class TextSetter
extends SubViewModifier
{
  private String text;

  public TextSetter(String text) {
    this(0, text);
  }

  public TextSetter(int viewId, String text) {
    super(viewId);
    this.text = text;
  }

  public void setText(String text) {
    this.text = text;
  }

  @Override
  public boolean canUse(View view) {
    return findView(view, false) instanceof TextView;
  }

  @Override
  public void modify(View view) {
    ((TextView)findView(view, true)).setText(text);
  }
}
