package jcsahnwaldt.android.html;

import java.util.NoSuchElementException;
import android.content.Context;
import android.graphics.drawable.Drawable;
import android.net.Uri;

public class FileUriImageGetter extends MappedImageGetter {

    public FileUriImageGetter(Context context, Mapping mapping) {
        super(context, mapping);
    }

    @Override
    public Drawable getDrawable(String source) {
        Uri uri = Uri.parse(source);
        Integer id = getResourceId(uri);
        if (id == null) return null;

        Drawable drawable = getDrawable(id.intValue());
        int width = drawable.getIntrinsicWidth();
        int height = drawable.getIntrinsicHeight();
        drawable.setBounds(0, 0, width, height);
        return drawable;
    }

    protected Integer getResourceId(Uri uri) {
        String scheme = uri.getScheme();
        String path = uri.getPath();
        if (scheme != null && !scheme.equals("file") || path == null) {
            throw new IllegalArgumentException("expected a file URI with a path, got '"+uri+"'");
        }

        try {
            return mapping.apply(path);
        }
        catch (NoSuchElementException e) {
            throw (NoSuchElementException)new NoSuchElementException("found no resource ID mapping for path '"+path+"' in URI '"+uri+"'").initCause(e);
        }
    }
}
