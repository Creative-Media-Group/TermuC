package cn.rbc.codeeditor.view.autocomplete;

import java.util.*;

public class ListItem {
    public String label;
	public int kind;
	public Deque<Edit> edits = new ArrayDeque<>();
}
