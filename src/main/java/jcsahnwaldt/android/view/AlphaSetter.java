package jcsahnwaldt.android.view;

import android.os.Build;
import android.view.View;
import android.widget.ImageView;

public class AlphaSetter
extends SubViewModifier
{
  private final int alpha;

  public AlphaSetter(float alpha) {
    this(0, alpha);
  }

  public AlphaSetter(int viewId, float alpha) {
    super(viewId);
    this.alpha = (int)(alpha * 255);
  }

  @Override
  public boolean canUse(View view) {
    return findView(view, false) instanceof ImageView;
  }

  @Override
  @SuppressWarnings("deprecation")
  public void modify(View view) {
    ImageView imageView = (ImageView)findView(view, true);
    if (Build.VERSION.SDK_INT >= 16) imageView.setImageAlpha(alpha);
    else imageView.setAlpha(alpha);
  }
}
