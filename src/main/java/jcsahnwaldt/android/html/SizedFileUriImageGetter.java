package jcsahnwaldt.android.html;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.net.Uri;
import static java.lang.Float.*;

public class SizedFileUriImageGetter extends FileUriImageGetter {

    public SizedFileUriImageGetter(Context context, Mapping mapping) {
        super(context, mapping);
    }

    @Override
    public Drawable getDrawable(String source) {
        Uri uri = Uri.parse(source);
        Integer id = getResourceId(uri);
        if (id == null) return null;

        Drawable drawable = getDrawable(id.intValue());
        scaleDrawable(uri, drawable);
        return drawable;
    }

    private void scaleDrawable(Uri uri, Drawable drawable) {
        // do calculations in float, convert to int in the end
        float width = drawable.getIntrinsicWidth();
        float height = drawable.getIntrinsicHeight();

        float wantWidth = px(uri, "width");
        float wantHeight = px(uri, "height");
        if (!isNaN(wantWidth) && !isNaN(wantHeight)) {
            width = wantWidth;
            height = wantHeight;
        }
        else if (!isNaN(wantWidth)) {
            float scale = wantWidth / width;
            width = wantWidth;
            height *= scale;
        }
        else if (!isNaN(wantHeight)) {
            float scale = wantHeight / height;
            height = wantHeight;
            width *= scale;
        }

        drawable.setBounds(0, 0, (int)width, (int)height);
    }

    private float px(Uri uri, String key) {
        String value = uri.getQueryParameter(key);
        if (value == null) return NaN;
        try {
            return px(parseFloat(value));
        }
        catch (NumberFormatException e) {
            throw new IllegalArgumentException("invalid value '"+value+"' for parameter '"+key+"' in URI '"+uri+"'");
        }
    }

    private float px(float dp) {
        return dp * context.getResources().getDisplayMetrics().density;
    }
}
