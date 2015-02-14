package no.vestein.oving5;

import java.util.ArrayList;
import java.util.List;

public class Person {
	
	private char gender;
	private String name;
	
	private Person mother;
	private Person father;
	private List<Person> children = new ArrayList<>();
	
	public Person(String name, char gender) {
		this.name = name;
		this.gender = gender;
	}

	public String getName() { return name; }
	
	public char getGender() { return gender; }
	
	public Person getMother() { return mother; }
	
	public Person getFather() { return father; }
	
	public int getChildCount() { return children.size(); }
	
	public Person getChild(int n) { return children.get(n); }
	
	public void setMother(Person mother) {
		if (this.mother == mother) {
			return;
		} else if (mother == null) {
			this.mother = null;
			return;
		} else if (this.father == mother || this == mother) {
			throw new IllegalArgumentException();
		}
		
		if (this.mother != null) { this.mother.removeChild(this); }
		this.mother = mother;
		mother.addChild(this);
	}
	
	public void setFather(Person father) {
		if (this.father == father) {
			return;
		} else if (father == null) {
			this.father = null;
			return;
		} else if (this.mother == father || this == father) {
			throw new IllegalArgumentException();
		}
		
		if (this.father != null) { this.father.removeChild(this); }
		this.father = father;
		father.addChild(this);
	}
	
	public void addChild(Person child) {
		if (children.contains(child)) { return; }
		
		children.add(child);
		if (gender == 'M') {
			child.setFather(this);
		} else {
			child.setMother(this);
		}
	}
	
	public void removeChild(Person child) {
		if (!children.contains(child)) { return; }
		
		this.children.remove(child);
		if (this.gender == 'M') {
			child.setFather(null);
		} else if (this.gender == 'F') {
			child.setMother(null);
		}
	}
	
}
