package jcsahnwaldt.util.android;

import java.util.ArrayList;
import java.util.List;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

public class ListItem
{
  private final int type;

  private final int layout;

  private final List<ViewModifier> modifiers;

  public ListItem(int type, int layout) {
    this(type, layout, new ArrayList<ViewModifier>());
  }

  public ListItem(int type, int layout, List<ViewModifier> modifiers) {
    if (modifiers == null) throw new NullPointerException("modifiers");
    this.type = type;
    this.layout = layout;
    this.modifiers = modifiers;
  }

  public int type() {
    return type;
  }

  public void addModifier(ViewModifier modifier) {
    modifiers.add(modifier);
  }

  public void setModifier(int index, ViewModifier modifier) {
    modifiers.set(index, modifier);
  }

  public ViewModifier getModifier(int index) {
    return modifiers.get(index);
  }

  public View getView(View view, ViewGroup parent, LayoutInflater inflater) {
    if (view == null || ! canUse(view)) view = inflater.inflate(layout, parent, false);
    modify(view);
    return view;
  }

  private boolean canUse(View view) {
    for (ViewModifier modifier: modifiers) {
      if (! modifier.canUse(view)) return false;
    }
    return true;
  }

  private void modify(View view) {
    for (ViewModifier modifier: modifiers) {
      modifier.modify(view);
    }
  }

}
