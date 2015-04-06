package no.vestein.oving9.observable;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public abstract class ObservableList {
	
	protected int maxSize;
	protected Map<Integer, Object> results = new HashMap<>();
	protected List<IObservableListListener> listeners = new ArrayList<>();
	
	@Override
	public String toString() {
		return results + "";
	}

	public ObservableList(int maxSize) {
		this.maxSize = maxSize;
	}
	
	public ObservableList() {
		maxSize = Integer.MAX_VALUE;
	}
	
	public int size() {
		return results.size();
	}
	
	public Object getElement(int n) {
		return results.get(n);
	}
	
	protected void addElement(int n, Object object) {
		if (!acceptsElement(object)) {
			throw new IllegalArgumentException();
		} else if (n < 0 || n > maxSize - 1) {
			throw new IndexOutOfBoundsException();
		} else {
			Object temp = results.put(n, object);
			update(n);
			while (temp != null) {
				n++;
				temp = results.put(n, temp);
			}
		}
	}
	
	protected void addElement(Object object) {
		if (!acceptsElement(object)) throw new IllegalArgumentException();
		results.put(results.size(), object);
		update(results.size()-1);
	}
	
	protected void removeElement(int n) {
		if (n < 0 || n >= maxSize) throw new IndexOutOfBoundsException();
		results.remove(n);
	}
	
	public void addObservableListListener(IObservableListListener listener) {
		listeners.add(listener);
	}
	
	public void removeObservableListListener(IObservableListListener listener) {
		listeners.remove(listener);
	}
	
	private void update(int n) {
		for (IObservableListListener listener : listeners) {
			listener.listChanged(this, n);
		}
	}
	
	public abstract boolean acceptsElement(Object object);

}
