package jcsahnwaldt.android.html;

import java.util.NoSuchElementException;
import android.content.Context;
import android.graphics.drawable.Drawable;
import android.text.Html;

public class MappedImageGetter implements Html.ImageGetter {

    // Function<String, Integer> isn't available on older Android versions
    public interface Mapping {
        Integer apply(String source) throws NoSuchElementException;
    }

    protected final Context context;

    protected final Mapping mapping;

    public MappedImageGetter(Context context, Mapping mapping) {
        this.context = context;
        this.mapping = mapping;
    }

    @Override
    public Drawable getDrawable(String source) {
        Integer id;
        try {
            id = mapping.apply(source);
        }
        catch (NoSuchElementException e) {
            throw (NoSuchElementException)new NoSuchElementException("found no resource ID mapping for image source '"+source+"'").initCause(e);
        }
        if (id == null) return null;

        Drawable drawable = getDrawable(id);
        int width = drawable.getIntrinsicWidth();
        int height = drawable.getIntrinsicHeight();
        drawable.setBounds(0, 0, width, height);
        return drawable;
    }

    protected Drawable getDrawable(Integer id) {
        return context.getResources().getDrawable(id.intValue());
    }
}
