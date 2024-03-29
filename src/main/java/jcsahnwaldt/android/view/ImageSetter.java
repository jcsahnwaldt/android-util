package jcsahnwaldt.android.view;

import android.view.View;
import android.widget.ImageView;

public class ImageSetter
extends SubViewModifier
{
  private int drawableId;

  public ImageSetter(int drawableId) {
    this(0, drawableId);
  }

  public ImageSetter(int viewId, int drawableId) {
    super(viewId);
    this.drawableId = drawableId;
  }

  public void setDrawableId(int drawableId) {
    this.drawableId = drawableId;
  }

  @Override
  public boolean canUse(View view) {
    return findView(view, false) instanceof ImageView;
  }

  @Override
  public void modify(View view) {
    ImageView imageView = (ImageView)findView(view, true);
    imageView.setImageResource(drawableId);
  }
}
