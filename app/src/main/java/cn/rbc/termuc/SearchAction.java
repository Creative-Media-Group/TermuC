package cn.rbc.termuc;
import android.view.ActionMode;
import android.view.*;
import android.content.*;
import android.app.*;
import android.widget.*;
import android.text.*;
import cn.rbc.codeeditor.util.*;

public class SearchAction implements ActionMode.Callback, TextWatcher, TextView.OnEditorActionListener {
	private MainActivity ma;
	private EditText e;
	private Document dp;
	private int idx = 0;

	public SearchAction(MainActivity ma) {
		this.ma = ma;
	}

	public void onDestroyActionMode(ActionMode p1) {
		// TODO: Implement this method
	}

	public boolean onPrepareActionMode(ActionMode p1, Menu p2) {
		// TODO: Implement this method
		return false;
	}

	public boolean onCreateActionMode(ActionMode p1, Menu p2) {
		View v = View.inflate(ma, R.layout.search_action, null);
		e = v.findViewById(R.id.search_edit);
		TextEditor ed = ma.getEditor();
		String st = ed.getSelectedText();
		if (!st.isEmpty()) {
			e.setText(st);
			idx = ed.getSelectionStart();
		} else
			idx = 0;
		e.addTextChangedListener(this);
		e.setOnEditorActionListener(this);
		e.requestFocus();
		p1.setCustomView(v);
		dp = ma.getEditor().getText();
		ma.getMenuInflater().inflate(R.menu.search, p2);
		return true;
	}

	public boolean onActionItemClicked(ActionMode p1, MenuItem p2) {
		search(p2.getItemId());
		return false;
	}

	private void search(int id) {
		int i;
		CharSequence ed = e.getText();
		int len = ed.length();
		if (len==0)
			return;
		TextEditor te = ma.getEditor();
		if (id==R.id.menu_last) {
			i = rindexDoc(ed, idx-1);
		} else {
			i = indexDoc(ed, idx+1);
		}
		if (i==-1) {
			HelperUtils.show(Toast.makeText(ma, R.string.find_completed, Toast.LENGTH_SHORT));
			idx = 0;
			te.setSelection(0,0);
		} else {
			te.setSelection(i, len);
			idx = i;
		}
		return;
	}

	public void beforeTextChanged(CharSequence cs, int p1, int p2, int p3) {
	}

	public void onTextChanged(CharSequence cs, int p1, int p2, int p3) {
	}

	public void afterTextChanged(Editable ed) {
		if (ed.length()==0)
			return;
		int i = indexDoc(ed, idx);
		if (i == -1) {
			idx = 0;
		} else {
			idx = i;
			ma.getEditor().setSelection(i, ed.length());
		}
	}

	@Override
	public boolean onEditorAction(TextView p1, int p2, KeyEvent p3) {
		search(R.id.menu_next);
		return true;
	}

	private int indexDoc(CharSequence cs, int idx) {
		int len = cs.length();
		int i, ldp = dp.length()-len;
		for (i=idx; i<ldp; i++) {
			boolean b = true;
			for (int k=0;k<len;k++) {
				if (cs.charAt(k)!=dp.charAt(i+k)) {
					b = false;
					break;
				}
			}
			if (b)
				return i;
		}
		return -1;
	}

	private int rindexDoc(CharSequence cs, int idx) {
		int len = cs.length();
		for (int i=idx; i>=0; i--) {
			boolean b = true;
			for (int k=0;k<len;k++) {
				if (cs.charAt(k)!=dp.charAt(i+k)) {
					b = false;
					break;
				}
			}
			if (b)
				return i;
		}
		return -1;
	}
}
