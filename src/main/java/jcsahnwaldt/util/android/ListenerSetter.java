package jcsahnwaldt.util.android;

import android.view.View;
import android.view.View.OnClickListener;
import android.view.View.OnLongClickListener;


public class ListenerSetter
extends SubViewModifier
{
  private Object listener;
  
  public ListenerSetter(Object listener) {
    this(0, listener);
  }
  
  public ListenerSetter(int viewId, Object listener) {
    super(viewId);
    if (listener == null) throw new NullPointerException("listener");
    this.listener = listener;
    modify(null, false); // check type
  }

  @Override
  public void modify(View view) {
    view = findView(view, true);
    modify(view, true);
  }
  
  private void modify(View view, boolean go) {
    if (listener instanceof OnClickListener) {
      if (go) view.setOnClickListener((OnClickListener) listener);
    }
    else if (listener instanceof OnLongClickListener) {
      if (go) view.setOnLongClickListener((OnLongClickListener) listener);
    }
    else {
      // inner class names will be ugly, but better than nothing
      throw new IllegalArgumentException("unknown listener type ["+listener.getClass()+"]");
    }
  }

}
