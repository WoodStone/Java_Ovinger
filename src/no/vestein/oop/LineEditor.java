package no.vestein.oop;

public class LineEditor {

	String text = "";
	int insertionIndex = 0;

	
	@Override
	public String toString() {
		String l = text.substring(0, insertionIndex);
		String r = text.substring(insertionIndex);
		String t = l + "|" + r;
		
		return "LineEditor [text=" + t + ", insertionIndex="
				+ insertionIndex + "]";
	}

	void left() {
		if (insertionIndex == 0) return;
		insertionIndex--;
	}
	
	void right() {
		if (insertionIndex == text.length()) return;
		insertionIndex++;
	}
	
	void insertString(String s) {
		if (insertionIndex == 0) {
			text = s + text;
		} else {
			String l = text.substring(0, insertionIndex);
			String r = text.substring(insertionIndex);
			text = l + s + r;
		}
		insertionIndex += s.length();
		
	}
	
	void deleteLeft() {
		if (insertionIndex - 1 < 0) {
			return;
		}
		String l = text.substring(0, insertionIndex - 1);
		String r = text.substring(insertionIndex);
		text = l + r;
		insertionIndex--;
	}
	
	void deleteRight() {
		if (insertionIndex == 0 && text.length() - 1 > 0) {
			text = text.substring(insertionIndex + 1);
		} else if (insertionIndex + 1 <= text.length()) {
			String l = text.substring(0, insertionIndex);
			String r = text.substring(insertionIndex + 1);
			text = l + r;
		}
	}
	
	public static void main(String[] args) {
		LineEditor test = new LineEditor();
		
		System.out.println(test);
		test.insertString("Potet");
		System.out.println(test);
		test.insertionIndex = 4;
		test.right();
		test.right();
		test.deleteLeft();
		System.out.println(test);
		
	}
	
}
