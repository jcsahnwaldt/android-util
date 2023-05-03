package jcsahnwaldt.android;

import android.content.res.AssetManager;
import android.graphics.Typeface;
import android.util.TypedValue;
import android.widget.TextView;

public class ScaledTypeface {

  public static ScaledTypeface createFromAsset(AssetManager mgr, String file, float factor, int tagKey) {
    if (file == null) return new ScaledTypeface(Typeface.DEFAULT, factor, tagKey);
    else return new ScaledTypeface(Typeface.createFromAsset(mgr, file), factor, tagKey);
  }

  private final Typeface typeface;

  private final float factor;

  /**
   * @see <a href="http://developer.android.com/guide/topics/resources/more-resources.html#Id">Id</a>
   * @see android.view.View#setTag(int, Object)
   */
  private final int tagKey;

  public ScaledTypeface(Typeface typeface, float factor, int tagKey) {
    if (typeface == null) throw new NullPointerException("typeface");
    if (factor <= 0.0f) throw new IllegalArgumentException("need positive factor, got "+factor);
    // same check as in View.setTag(int, Object)
    if ((tagKey >>> 24) < 2) throw new IllegalArgumentException("tag key must be application-specific resource id, got 0x"+Integer.toHexString(tagKey));

    this.typeface = typeface;
    this.factor = factor;
    this.tagKey = tagKey;
  }

  public void set(TextView textView) {
    textView.setTypeface(typeface);
    Float size = (Float)textView.getTag(tagKey);
    if (size == null) {
      size = textView.getTextSize();
      textView.setTag(tagKey, size);
    }
    textView.setTextSize(TypedValue.COMPLEX_UNIT_PX, size*factor);
  }
}
