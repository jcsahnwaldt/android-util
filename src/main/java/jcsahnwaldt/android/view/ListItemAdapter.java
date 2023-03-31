package jcsahnwaldt.android.view;

import java.util.ArrayList;
import java.util.List;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;

/**
 * TODO: extending ArrayAdapter may be a bit brittle.
 */
public class ListItemAdapter
extends ArrayAdapter<ListItem>
{
  private final int viewTypeCount;

  public ListItemAdapter(Context context, List<ListItem> items, int viewTypeCount) {
    super(context, 0, items);
    this.viewTypeCount = viewTypeCount;
  }

  public ListItemAdapter(Context context, int viewTypeCount) {
    this(context, new ArrayList<>(), viewTypeCount);
  }

  @Override
  public int getViewTypeCount() {
    return viewTypeCount;
  }

  @Override
  public int getItemViewType(int position) {
    return getItem(position).type();
  }

  @Override
  public View getView(int position, View view, ViewGroup parent) {
    LayoutInflater inflater = LayoutInflater.from(getContext());
    return getItem(position).getView(view, parent, inflater);
  }

}
