package jcsahnwaldt.android.view;

import android.os.Build;
import android.view.View;
import android.widget.ImageView;

public class AlphaSetter
extends SubViewModifier
{
  private final float alpha;

  public AlphaSetter(float alpha) {
    this(0, alpha);
  }

  public AlphaSetter(int viewId, float alpha) {
    super(viewId);
    this.alpha = alpha;
  }

  @Override
  public boolean canUse(View view) {
    return findView(view, false) instanceof ImageView;
  }

  @Override
  @SuppressWarnings("deprecation")
  public void modify(View view) {
    ImageView imageView = (ImageView)findView(view, true);
    if (Build.VERSION.SDK_INT >= 11) imageView.setAlpha(alpha);
    else imageView.setAlpha((int)(alpha * 255));
  }
}
