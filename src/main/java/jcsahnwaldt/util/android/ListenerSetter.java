package jcsahnwaldt.util.android;

import android.view.View;
import android.view.View.OnClickListener;
import android.view.View.OnLongClickListener;


public class ListenerSetter
extends SubViewModifier
{
  private final Object listener;

  public ListenerSetter(Object listener) {
    this(0, listener);
  }

  public ListenerSetter(int viewId, Object listener) {
    super(viewId);
    if (listener == null) throw new NullPointerException("listener");
    this.listener = listener;
    doModify(null); // check listener type
  }

  @Override
  public void modify(View view) {
    doModify(findView(view, true));
  }

  private void doModify(View view) {
    if (listener instanceof OnClickListener) {
      if (view != null) view.setOnClickListener((OnClickListener) listener);
    }
    else if (listener instanceof OnLongClickListener) {
      if (view != null) view.setOnLongClickListener((OnLongClickListener) listener);
    }
    else {
      // inner class names will be ugly, but better than nothing
      throw new IllegalArgumentException("unknown listener type ["+listener.getClass()+"]");
    }
  }

}
