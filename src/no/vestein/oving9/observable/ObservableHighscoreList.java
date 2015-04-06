package no.vestein.oving9.observable;

public class ObservableHighscoreList extends ObservableList {
	
	public ObservableHighscoreList(int max) {
		super(max);
	}
	
	public void addResult(int result) {
		int next = result;
		int pos = 0;
		boolean changed = false;
		try {
			for (int i = 0; i < maxSize; i++) {
				if ((int) getElement(i) > next) {
					if (next == result && !changed) {
						changed = true;
						pos = i;
					}
					next = (int) getElement(i);
					addElement(i, next);
				}
			}
		} catch (IndexOutOfBoundsException e) {
			addElement(next);
			if (!changed) {
				changed = true;
				pos = results.size()-1;
			}
		}
		if (changed) update(pos);
	}
	
//	public void addResult(Object result) {
//		int next = (int) result;
//		for (int i = 0; i < results.size(); i++) {
//			if ((int) results.get(i) > next) {
//				int temp = results.
//			}
//		}
//	}
	
	private void update(int n) {
		for (IObservableListListener listener : listeners) {
			listener.listChanged(this, n);
		}
	}
	
	public boolean acceptsElement(Object object) {
		return object instanceof Integer;
	}
	
}
